/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projpoo2;
import com.itextpdf.text.DocumentException;
import controller.AluguelController;
import controller.Enumeracoes;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Date;
import javax.swing.*;
import view.*;
import utilitario.*;

/**
 *
 * @author Fabricio
 */
public class ProjPOO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DocumentException, IOException{

        //new TelaPrincipal(); 
//        new TelaLogin();

       // new TelaPrincipal(); 
        new TelaLogin();

        
        
        //System.out.println(AluguelController.getInstance().novoAluguel(2, "1", "Fabricio", "8493453453", "Khongolote"));
        
//        AluguelController.gerarRelatorioAluguel( //Exemplo rapido
//                "Fabricio Nhantumbo",
//                "18_87323213", 
//                "Empilhadeira",
//                250.0f
//                , Date.valueOf("2022-11-20")
//                , Date.valueOf("2022-11-29"),
//                "recibo.pdf",
//                "plcHolder.png"
//        );
//    }
    
}}
