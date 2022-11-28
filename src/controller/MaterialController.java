/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static view.TelaAdicionar.*;
import model.dao.MaterialDAO;
import model.vo.Material;

/**
 *
 * @author ADMIN
 */
public class MaterialController {
    private MaterialDAO materialDAO;
    
    public MaterialController(){
        materialDAO = new MaterialDAO();
    }
    
    public boolean inserir(int codigo, String nome, String marca, float taxaDiaria , int codigoCategoria){
        Material material = new Material(codigo, codigoCategoria, marca, nome, taxaDiaria);
        return materialDAO.inserir(material);
    }
    
    
    
    public boolean remover(int codigo){
        return materialDAO.remover(new Material(codigo, 0, "", "", 0.0f));
    }
    
}
