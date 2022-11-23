package utilitario;
import java.awt.*;


/**
 *
 * @author Fabricio
 */
public class ComponentPlacer {
    //Sinceras desculpas pela incosistencia de lingua, (sera organizado em futuros projetos)
    
    
    public static final int TOP = -1, BOTTOM = 1, RIGHT = 1, LEFT = -1, MIDDLE = 0;
    
    public static void centralizar(Container container, Component component){
       int W1 = container.getWidth();
       int H1 = container.getHeight();
       
     
       int W2 = component.getWidth();
       int H2 = component.getHeight();
       
       int X2 =(W1 - W2)/2;
       int Y2 =(H1 - H2)/2;
       component.setBounds(X2, Y2, W2, H2);
       
       container.add(component);
    }
    
    public static void superiorEsquerdo(Container container, Component component, int offsetX, int offsetY){
        
        int W2 = component.getWidth();
        int H2 = component.getHeight();
        int X2 = offsetX;
        int Y2 = offsetY;
        component.setBounds(X2, Y2, W2, H2);
        container.add(component);
    }


    
    public static void superiorEsquerdo(Container container, Component component){
       superiorEsquerdo(container, component, 0, 0);
    }

    
    public static void superiorDireito(Container container, Component component, int offsetX, int offsetY){
        int X1 = container.getX();
        int Y1 = container.getY();
        int W1 = container.getWidth();
        
        int W2 = component.getWidth();
        int H2 = component.getHeight();
        
        int X2 = X1 + (W1 - W2) - offsetX;
        int Y2 = Y1 + offsetY;
        component.setBounds(X2, Y2, W2, H2);
        container.add(component);
    }
    
    public static void superiorDireito(Container container, Component component){
        superiorDireito(container, component, 0, 0);
    }
    
    public static void inferiorEsquerdo(Container container, Component component, int offsetX, int offsetY){
       int X1 = container.getX();
       int Y1 = container.getY();
       int H1 = container.getHeight();
       
       int W2 = component.getWidth();
       int H2 = component.getHeight();
       
       int X2 = X1 + offsetX;
       int Y2 = Y1 + (H1 - H2) - offsetY;
       component.setBounds(X2, Y2, W2, H2);
       container.add(component);
    }
    
    public static void inferiorEsquerdo(Container container, Component component){
        inferiorEsquerdo(container, component, 0, 0);
    }
    
    public static void inferiorDireito(Container container, Component component, int offsetX, int offsetY){
       int X1 = container.getX();
       int Y1 = container.getY();
       int W1 = container.getWidth();
       int H1 = container.getHeight();
       
       int W2 = component.getWidth();
       int H2 = component.getHeight();
       
       int X2 = X1 + (W1 - W2) - offsetX;
       int Y2 = Y1 + (H1 - H2) - offsetY;
       component.setBounds(X2, Y2, W2, H2);
       
       container.add(component);
    }
     
    public static void inferiorDireito(Container container, Component component){
        inferiorDireito(container, component, 0, 0);
    }
    
    public static void abaixo(Container container, Component refComponent, Component newComponent, int offset){
       int X1 = refComponent.getX();
       int Y1 = refComponent.getY();
       int H1 = refComponent.getHeight();
       
       int W2 = newComponent.getWidth();
       int H2 = newComponent.getHeight();
       
       int X2 = X1;
       int Y2 = Y1 + H1 + offset;
       
       newComponent.setBounds(X2, Y2, W2, H2);
       container.add(newComponent);
    }
    
    public static void abaixo(Container container, Component refComponent, Component newComponent){
        abaixo(container, refComponent, newComponent, 0);
    }
    
    
    public static void acima(Container container, Component refComponent, Component newComponent, int offset){
       int X1 = refComponent.getX();
       int Y1 = refComponent.getY();
       
       int W2 = newComponent.getWidth();
       int H2 = newComponent.getHeight();
       
       int X2 = X1;
       int Y2 = Y1 - H2 - offset;
       
       newComponent.setBounds(X2, Y2, W2, H2);
       container.add(newComponent);
    }
    
    public static void acima(Container container, Component refComponent, Component newComponent){
        acima(container, refComponent, newComponent, 0);
    }
    
    public static void esquerda(Container container, Component refComponent, Component newComponent, int offset){
       int X1 = refComponent.getX();
       int Y1 = refComponent.getY();
       
       int W2 = newComponent.getWidth();
       int H2 = newComponent.getHeight();
       
       
       int X2 = X1 - W2 - offset;
       int Y2 = Y1;
       
       newComponent.setBounds(X2, Y2, W2, H2);
       container.add(newComponent);
    }
      
    public static void esquerda(Container container, Component refComponent, Component newComponent){
        esquerda(container, refComponent, newComponent, 0);
    }
      
    public static void direita(Container container, Component refComponent, Component newComponent, int offset){
       int X1 = refComponent.getX();
       int Y1 = refComponent.getY();
       int W1 = refComponent.getWidth();
       
       int W2 = newComponent.getWidth();
       int H2 = newComponent.getHeight();
       
       int X2 = X1 + W1 + offset;
       int Y2 = Y1;
       
       newComponent.setBounds(X2, Y2, W2, H2);
       container.add(newComponent);
    }
    
    public static void direita(Container container, Component refComponent, Component newComponent){
        direita(container, refComponent, newComponent, 0);
    } 
    
    public static void colocarEm(Container container, Component component, int HPOS, int VPOS){
        
        if(HPOS >= -1 && HPOS <= 1 && VPOS >= -1 && VPOS <= 1){
            int maxDx = container.getWidth() - component.getWidth();
            int maxDy = container.getHeight()- component.getHeight();
            
            
            int X2 =  maxDx*(HPOS + 1)/2;
            int Y2 = maxDy*(VPOS + 1)/2;
            component.setLocation(X2, Y2);
            container.add(component);
        
        }
    }
    
    public static void offset(Component component, int offsetX, int offsetY){
        int X1 = component.getX() + offsetX;
        int Y1 = component.getY() + offsetY;
        component.setBounds(X1, Y1, component.getWidth(), component.getHeight());
    }
    
}
