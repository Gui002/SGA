/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Fabricio
 */
public class Sizer {
    /**
     * Determina um novo tamanho para um componente, escalando as dimensoes de um outro existente
     * @param comp eh o componente para o qual se define o tamanho
     * @param ref eh o componente que serve de referencia para se obter as novas dimensos
     * @param widthScale fator pelo qual se escala o comprimento de ref para obter o comprimento de comp
     * @param heightSclae fator pelo qual se escala a altura do ref para se obter a altura de ref
     */
    public static void resizeRelativeTo(Component comp, Component ref, float widthScale, float heightSclae){
        int w = (int) (widthScale * ref.getWidth());
        int h = (int) (heightSclae * ref.getHeight());
        
        comp.setSize(w, h);
    }
    
    /**
     * @return  (X - n * Y)/(n+1)
    */
    public static int offsets(int n, int X, int Y){
        return (X- n * Y)/(n+1);
    }
    
    /**
     * @return  (X - n * Y - (n-1) * offset)/2
    */
    public static int offsets(int n, int X, int Y, int offset){
        return (X - n * (Y + offset) + offset) / 2;
    }
    
}
