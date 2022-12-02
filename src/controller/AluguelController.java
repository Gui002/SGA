/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Enumeracoes.EstadoDeConservacao;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.AluguelDAO;
import model.vo.Aluguel;
import model.vo.Unidade;
import utilitarios.Coleccoes;


/**
 *
 * @author Fabricio
 */
public class AluguelController {
    private AluguelDAO aluguelDAO;
    private static List<Aluguel> alugueis;
    private static List<Map<String, Object>> codigos;
    private static long count = 0;
    private static AluguelController instance;
    
    private AluguelController(){
        aluguelDAO = new AluguelDAO();
        count = 1;
        atualizarLista();
    }
    
    public static AluguelController getInstance(){
        if(instance == null){instance = new AluguelController();}
        return instance;
    }
    
    private void atualizarLista(){
        if(count > 0){
            alugueis = aluguelDAO.selecionar();
            codigos = new ArrayList();
            alugueis.forEach((aluguel) -> {
               Map<String, Object> map = new HashMap();
               map.put("codigo_empregado", aluguel.getCodigoEmpregado());
               map.put("codigo_cliente", aluguel.getCodigoCliente());
               map.put("codigo_unidade", aluguel.getCodigoUnidade());
               codigos.add(map);
            });
            
        }
    }
    
    public Map<String, Object> getAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        atualizarLista();
        Map<String, Object> result = new HashMap();
        
        Aluguel aluguel = Coleccoes.achar(alugueis, (Aluguel a) -> {
            return a.getCodigoCliente().equalsIgnoreCase(codigoCliente) &&
                    a.getCodigoEmpregado().equalsIgnoreCase(codigoEmpregado) &&
                    a.getCodigoUnidade() == codigoUnidade;
        });
        
        result.put("codigo_cliente",     (aluguel == null)? "":aluguel.getCodigoCliente());
        result.put("codigo_empregado",   (aluguel == null)? "":aluguel.getCodigoEmpregado());
        result.put("codigo_unidade",     (aluguel == null)? "":aluguel.getCodigoUnidade());
        result.put("data_inicio",        (aluguel == null)? "":aluguel.getData_aluguel());
        result.put("data_devolucao",     (aluguel == null)? "":aluguel.getData_devolucao());
        result.put("estado_conservacao", (aluguel == null)? "":aluguel.getEstado_conservacao());
        
        return result;
    }
    
    
    private boolean novoAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        count++;
        Aluguel aluguel = new Aluguel(
                codigoUnidade, 
                codigoCliente, 
                codigoEmpregado, 
                new Date(System.currentTimeMillis()), 
                null, 
                null
        );
        return aluguelDAO.inserir(aluguel);
    }
    
    private boolean _novoAluguel(int codigoMaterial, String codigoEmpregado, String codigoCliente){
        UnidadeController unidadeController = UnidadeController.getInstance();
        
        
        Unidade unidade = Coleccoes.achar(unidadeController.getUnidadesDisponiveis(), (Unidade u) -> {
            return u.getCodigoMaterial() == codigoMaterial;
        });
        
        if(unidade == null) return false;
        
        if(novoAluguel(codigoCliente, codigoEmpregado, unidade.getCodigo())){
            
            unidade.setDisponibilidade(Enumeracoes.Disponibilidade.INDISPONIVEL);
            unidadeController.atualizar(unidade);
            unidadeController.alocarNaListaDevida(unidade);
            
            return true;
        }
        
        return false;
    }
    
    public boolean novoAluguel(int CodigoMaterial, String codigoEmpregado, String nomeCliente, String telefoneCliente, String endereco){
       ClienteController clienteController =  ClienteController.getInstance();
       String codigoCliente = nomeCliente.length() +"_" +telefoneCliente;
       if(!clienteController.existe(codigoCliente)){
           clienteController.inserir(codigoCliente, nomeCliente, telefoneCliente, endereco);
       }
       return _novoAluguel(CodigoMaterial, codigoEmpregado, codigoCliente);
    }
    
    private boolean adicionarDevolucao(Aluguel aluguel, Date data_devolucao, EstadoDeConservacao estadoDeConservacao){
        return aluguelDAO.atualizarAluguel(aluguel , data_devolucao, estadoDeConservacao);
    }
    
    public boolean registrarDevolucao(String codigoCliente, String codigoEmpregado, int CodigoUnidade, Date dataDevolucao, EstadoDeConservacao estadoConservacao){
        //Manutencao do Aluguel
        atualizarLista();
        Aluguel aluguel = Coleccoes.achar(alugueis, (Aluguel a) -> {
            return a.getCodigoCliente().equalsIgnoreCase(codigoCliente) 
                    && a.getCodigoEmpregado().equalsIgnoreCase(codigoEmpregado)
                    && a.getCodigoUnidade() == CodigoUnidade;
        });
        
        if(aluguel != null){
            aluguel.setData_aluguel(dataDevolucao);
            aluguel.setEstado_conservacao(estadoConservacao);
            
            if(adicionarDevolucao(aluguel, dataDevolucao, estadoConservacao)){
                //Manutencao dos dados da unidade a ser retornada
                UnidadeController unidadeController = UnidadeController.getInstance();
                Unidade unidade = unidadeController.pGetUnidade(CodigoUnidade);
                unidade.setDisponibilidade(Enumeracoes.Disponibilidade.DISPONIVEL);
                unidadeController.alocarNaListaDevida(unidade);
                unidade.setEstadoConservacao(estadoConservacao);
               
                //Manutencao do cliente (pendente)

                //Manutencao dos dados do empregado (nenhuma)
                return true;
            }    
        }
        
        return false;
    }
    
    public boolean removerAluguel(String codigoCliente, String codigoEmpregado, int codigoUnidade){
        Aluguel aluguel = new Aluguel(codigoUnidade, codigoCliente, codigoEmpregado, null, null, EstadoDeConservacao.CONSERVADO);
        return aluguelDAO.remover(aluguel);
    }
    
     public void gerarRelatorioInicial(String nomeCliente, String codigoCliente, String nomeMaterial, float taxaDiaria, Date dataAluguel, String caminhoFicheiro, String caminhoImagem) throws IOException, DocumentException{
        Document document = new Document(new Rectangle(400, 400));
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(caminhoFicheiro));
        document.open();
        Paragraph nomeEmpresa = new Paragraph();
        nomeEmpresa.add(Image.getInstance(caminhoImagem));
        nomeEmpresa.add(new Chunk("Ferragens Panguana, LTD - Matola"));
        

        PdfPTable table = new PdfPTable(2);

        table.addCell("Nome do Cliente");
        table.addCell(nomeCliente);
        table.addCell("Codigo do cliente");
        table.addCell(codigoCliente);
        table.addCell("Material Alugado");
        table.addCell(nomeMaterial);
        table.addCell("Data de aluguel");
        table.addCell(dataAluguel.toString());
        table.addCell("Preco diario");
        table.addCell(taxaDiaria + "");
        document.add(new Chunk("RECECIBO"));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(nomeEmpresa);
        document.add(new Paragraph(new Date(System.currentTimeMillis()).toString()));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(table);
        
        document.close();
        
        Desktop desktop = null;
        if(Desktop.isDesktopSupported()){
            desktop = Desktop.getDesktop();
            desktop.open(new File(caminhoFicheiro));
        }
    }
    
     public  void gerarRelatorioAluguel(String nomeCliente, String codigoCliente, String nomeMaterial, float taxaDiaria, Date dataAluguel, Date dataDevolucao, String caminhoFicheiro, String caminhoImagem) throws IOException, DocumentException{
        Document document = new Document(new Rectangle(400, 400));
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(caminhoFicheiro));
        document.open();
        Paragraph nomeEmpresa = new Paragraph();
        nomeEmpresa.add(Image.getInstance(caminhoImagem));
        nomeEmpresa.add(new Chunk("Ferragens Panguana, LTD - Matola"));
        

        PdfPTable table = new PdfPTable(2);

        int diasDecoridosMili = (int) (dataDevolucao.getTime() - dataAluguel.getTime());
        int diasDecorridos =(int) (diasDecoridosMili /86400000);
        
        
        float precoTotal = diasDecorridos * taxaDiaria;
        float desconto = 0f;
        
        table.addCell("Nome do Cliente");
        table.addCell(nomeCliente);
        table.addCell("Codigo do cliente");
        table.addCell(codigoCliente);
        table.addCell("Material Alugado");
        table.addCell(nomeMaterial);
        table.addCell("Data de aluguel");
        table.addCell(dataAluguel.toString());
        table.addCell("Data de devolucao");
        table.addCell(dataDevolucao.toString());
        table.addCell("Preco diario");
        table.addCell(taxaDiaria + "");
        table.addCell("Preco total(MZN)");
        table.addCell(precoTotal + "");
        table.addCell("Desconto(MZN)");
        table.addCell(desconto + "");
        document.add(new Chunk("RECECIBO"));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(nomeEmpresa);
        document.add(new Paragraph(new Date(System.currentTimeMillis()).toString()));
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(table);
        
        document.close();
        
        Desktop desktop = null;
        if(Desktop.isDesktopSupported()){
            desktop = Desktop.getDesktop();
            desktop.open(new File(caminhoFicheiro));
        }
    }
     public ArrayList<Aluguel> _getAluguel() {
        ArrayList<Aluguel> aluguer = (ArrayList<Aluguel>) aluguelDAO.selecionar();
        return aluguer;
    }
}
