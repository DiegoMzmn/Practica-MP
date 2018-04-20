package prac2;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class Modelo implements Observer{
    
    private Serpiente serpiente;
    private Comida comida;
    private Controlador miObservador;

    public Modelo(Controlador miObservador) {
        this.serpiente = new Serpiente();
        this.comida = new Comida(this.serpiente);
        this.miObservador=miObservador;
    }

    public boolean esComido(){
        return (this.comida.getComida().equals(this.serpiente.getFirst()));
    }

    public void crecer(Punto p){
        this.serpiente.crecer(p);
    }
    
    private  void matarSerpiente(){
        this.serpiente.removeAll();
        JOptionPane.showMessageDialog(null, "FIN DEL JUEGO");
    }
    
    @Override
    public void update(Observable o, Object arg) {
        try{
            String args = (String) arg;
            Punto p1=serpiente.getFirst();
            Punto siguiente = null;
            if (args.equals("DER")){
                siguiente = new Punto(p1.getX(),p1.getY()+1);
            }
            if (args.equals("ABAJO")){
                siguiente = new Punto(p1.getX()+1,p1.getY());
            }
            if (args.equals("IZQ")){
                siguiente = new Punto(p1.getX(),p1.getY()-1);
            }
            if (args.equals("ARRIBA")){  
                siguiente = new Punto(p1.getX()-1,p1.getY());
            }
            if (serpiente.contains(siguiente)){
                this.matarSerpiente();
            }
            serpiente.addFirst(siguiente);
            Punto pultimo=serpiente.removeLast();
            matriz[pultimo.getX()][pultimo.getY()].setBackground(Color.white);
            pintar();
            if (esComido()){
                comida=new Comida(serpiente);
                pintarComida();
                crecer(pultimo);
            }  
        }catch (ArrayIndexOutOfBoundsException e){
            this.matarSerpiente();
        }
    }
}
