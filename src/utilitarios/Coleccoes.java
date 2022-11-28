/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.Collection;

/**
 *
 * @author Fabricio
 */
public class Coleccoes{
    public static interface Condicao<T>{ boolean checar(T a);}
    public static<T> T achar(Collection<T> col, Condicao<T> c){
        for(T elemento : col){
            if(c.checar(elemento)){
                return elemento;
            }
        }
        return null;
    }
}
