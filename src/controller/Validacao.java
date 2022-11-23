/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Fabricio
 */
public class Validacao  {
    
    public boolean checarIntervalo(Number val, Number min, Number max){
        return val.doubleValue() >= min.doubleValue() && val.doubleValue() <= max.doubleValue();
    }
    
   public boolean checarMinimo(Number val, Number min){
       return val.doubleValue() >= min.doubleValue();
   }
   
   public  boolean validarString(String s, int min, int max){
       return checarIntervalo(s.length(), min, max);
   }
   
   public  boolean validarString(String s, int min){
       return checarMinimo(s.length(), min);
   }
    
}
