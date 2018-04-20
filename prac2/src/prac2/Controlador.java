package prac2;

import java.awt.Color;
import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Clase para actualizar la posicion */
class Controlador extends Thread implements Observable {
    private int velocidad;
    
    private boolean dirIzd;
    private boolean dirDch;
    private boolean dirArr;
    private boolean dirAb;
    
    private boolean iniciado;
    private boolean pause;
   
    private JPanel[][] matriz;
   
    private boolean pulsado;
    
    public Controlador(JPanel[][] matriz){
        this.matriz = matriz; 
        
        pulsado = false;

        velocidad=325;
        dirIzd=true;
        dirDch=false;
        dirArr=false;
        dirAb=false;
        
        iniciado=false;
    }    

    @Override
    public void run(){
        // Itera mientras no se indique el fin
        
        while (!Thread.interrupted()) {   
            try {
                Thread.sleep(velocidad);
                while (pause){
                    Thread.sleep(100);
                }
            }catch (InterruptedException ex) {
                System.err.println("Error en ActualizaTablero");
            }
            pulsado = false;
            actualizaPosicion();
        }
    }
    
    public boolean getIniciado(){
        return iniciado;    
    }
    
    public void setIniciado(boolean b){
        this.iniciado=b;
        
    }
    
    public void setDirIzd(boolean b){
        this.dirIzd=b;
    }
    public void setDirDch(boolean b){
        this.dirDch=b;
    }
    public void setDirArr(boolean b){
        this.dirArr=b;
    }
    public void setDirAb(boolean b){
        this.dirAb=b;
    }

    public int getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(int v){
        this.velocidad=v;
    }
    
    public JPanel[][] getMatriz(){
        return matriz;
    }
    
    public boolean getDirIzd(){
        return dirIzd;
    }
   
    public boolean getDirDch(){
        return dirDch;
    }
   
    public boolean getDirArr(){
        return dirArr;
    }
   
    public boolean getDirAb(){
        return dirAb;
    }

    public boolean getPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
   
    public boolean getPulsado(){
        return pulsado;
    }
    public void setPulsado(boolean b){
        pulsado=b;
    }

    public int queDireccion(){
        int d=0;
        if (dirAb){
           d=3;
        }
        if (dirDch){
            d=2;
        }
        if (dirArr){
            d=1;
        }
        if (dirIzd){
            d=4;
        }
        return d;
    }

    public void cambiarDireccion(boolean arr,boolean ab, boolean dch, boolean izd){
        dirAb=ab;
        dirArr=arr;
        dirDch=dch;
        dirIzd=izd;        
    }

    public void aumentarVelocidad(){
        if (velocidad>40){
            velocidad=(velocidad/2);
            
        }
    }

    public void disminuirVelocidad(){
        if (velocidad<500){
            velocidad=(velocidad*2);
          
        }
    }

    public void ponerPause(){
        pause=!pause;
    }
    
    public void actualizaPosicion(){
        //TODO
    }

    @Override
    public void addListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener il) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}