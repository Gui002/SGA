/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static view.TelaAdicionar.*;
import model.dao.MaterialDAO;
import model.vo.Material;
import utilitarios.*;

/**
 *
 * @author ADMIN
 */
public class MaterialController {
    private MaterialDAO materialDAO;
    private List<Material> materiais;
    private long count = 0;
    
    
    public MaterialController(){
        materialDAO = new MaterialDAO();
        materiais = getMateriais();
    }
    
    private void atualizar(){
        if(count > 0){
            materiais = getMateriais();
            count = 0;
        }
    }
    
    public boolean inserir(int codigo, String nome, String marca, float taxaDiaria , int codigoCategoria){
        Material material = new Material(codigo, codigoCategoria, marca, nome, taxaDiaria);
        count++;
        return materialDAO.inserir(material);
    }
    
    public boolean remover(int codigo){
        count ++;
        return materialDAO.remover(new Material(codigo, 0, "", "", 0.0f));
    }
    
    private List<Material> getMateriais(){
        return materialDAO.selecionar();
    }
    
    public Map<String, String> getMaterial(int codigo, int codigoCategoria){
        atualizar();
        Map<String, String> result = new HashMap();
        
        Material material = Coleccoes.achar(materiais, (Material m) -> {
            return m.getCodigo() == codigo && m.getCodigoCategoria() == codigoCategoria;
        });
        
        result.put("codigo", (material==null) ? "":material.getCodigo() + "");
        result.put("codigo_categoria", (material==null) ? "":material.getCodigoCategoria()+ "");
        result.put("marca", (material==null) ? "":material.getMarca());
        result.put("nome", (material==null) ? "":material.getNome());
        result.put("taxa_diaria", (material==null) ? "":material.getTaxaDiaria() + "");
        
        return result;
    } 
    
}
