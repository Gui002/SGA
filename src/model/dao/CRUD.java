/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CRUD <E>{
    boolean inserir(E e);
    boolean remover(E e);
    List<E> selecionar();
}
