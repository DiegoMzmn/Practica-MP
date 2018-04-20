package prac2;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Serpiente {
    
    private LinkedList<Punto> lista;
    
    public Serpiente(){
        this.lista = new LinkedList<Punto>();
        this.lista.add(new Punto(30,30));
    }

    public LinkedList<Punto> getLista() {
        return lista;
    }
    
    public boolean contains(Punto p){
        return this.lista.contains(p);
    }
    
    public void crecer(Punto p){
        for(int i=0;i<5;i++){
            this.lista.addLast(p);
        }
    }
    
    public void pintar(JPanel[][] matriz){
        Border white = BorderFactory.createLineBorder(Color.white,1,false); 
        for(Punto p:this.lista){
            matriz[p.getX()][p.getY()].setBackground(Color.red);
            matriz[p.getX()][p.getY()].setBorder(white);
        }
    }
    
    public Punto getFirst(){
        return this.lista.getFirst();
    }
    
    public void addFirst(Punto p){
        this.lista.addFirst(p);
    }
    
    public Punto removeLast(){
        return this.lista.removeLast();
    }
    
    public void removeAll(){
        this.lista.clear();
    }
}
