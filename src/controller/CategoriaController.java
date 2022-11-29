/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.CategoriaDAO;
import model.vo.Categoria;
import utilitarios.Coleccoes;

/**
 *
 * @author Fabricio
 */
public class CategoriaController {
    private CategoriaDAO categoriaDAO;
    private long count = 0;
    private List<Categoria> categorias;
    private static CategoriaController instance;
    
    private CategoriaController(){
        categoriaDAO = new CategoriaDAO();
        count = 1;
        atualizarLista();
    }
    
    public static CategoriaController getInstance(){
        if(instance == null){instance = new CategoriaController();}
        return instance;
    }
    
    private void atualizarLista(){
        if(count > 0){
            categorias = getCategorias();
            count ++;
        }
    }
    
    public boolean inserir(String nome){
        count ++;
        Categoria categoria = new Categoria(0, nome); //O codigo zero nao interessa a o codigo vai ser autogerado no banco de dados
        return categoriaDAO.inserir(categoria);
    }
    
    public boolean remover(int codigo){
        count++;
        return categoriaDAO.remover(new Categoria(codigo, ""));
    }
    
    public List<Categoria> getCategorias(){
        return categoriaDAO.selecionar();
    }
    
    public Map<String, Object> getCategoria(int codigo){
        atualizarLista();
        Map<String, Object> result = new HashMap();
        
        Categoria categoria = Coleccoes.achar(categorias, (Categoria c)->{
            return c.getCodigo() == codigo;
        });
        
        result.put("codigo", (categoria == null)? "": categoria.getCodigo());
        result.put("nome", (categoria == null)? "": categoria.getNome());
        
        return result;
    }
    
    public List<Integer> getCodigos(){
        List<Integer> codigos = new ArrayList();
        
        categorias.forEach((c) -> {
            codigos.add(c.getCodigo());
        });
        codigos.sort((a, b) -> {return  a - b;});
        return codigos;
    }
}
