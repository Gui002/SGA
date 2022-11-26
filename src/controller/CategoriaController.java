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

/**
 *
 * @author Fabricio
 */
public class CategoriaController {
    CategoriaDAO categoriaDAO;
    
    public CategoriaController(){
        categoriaDAO = new CategoriaDAO();
    }
    
    public boolean inserir(String nome){
        Categoria categoria = new Categoria(0, nome); //O codigo zero nao interessa a o codigo vai ser autogerado no banco de dados
        return categoriaDAO.inserir(categoria);
    }
    
    public boolean remover(int codigo){
        return categoriaDAO.remover(new Categoria(codigo, ""));
    }
    
    public List<String> obterCategorias(){
        ArrayList<String> categorias = new ArrayList();
        categoriaDAO.selecionar().forEach((categoria) -> {
            categorias.add(categoria.getNome());
        }); 
        return categorias;
    }
    
    public Map<String, Integer> MapaNomeCodigo(){
        Map<String, Integer> codigos = new HashMap(); 
        
        categoriaDAO.selecionar().forEach((categoria) -> {
            codigos.put(categoria.getNome(), categoria.getCodigo());
        });
        
        return codigos;
    }
}
