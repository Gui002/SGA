/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.MaterialDAO;
import model.vo.Material;
import static view.TelaAdicionar.*;

/**
 *
 * @author ADMIN
 */
public class Controller {

    MaterialDAO materialDao;

    public Controller() {
        materialDao = new MaterialDAO();
    }

    public void adicionaMaterial() {
        int codigo_categoria = categorias.getSelectedIndex()+1;
        String Marca = marca.getText();
        String Nome = nome.getText();
        float taxa_diaria = Float.parseFloat(campoTaxa.getText());

        Material material = new Material(codigo_categoria, Marca, Nome, taxa_diaria);
        materialDao.inserir(material);

    }

}
