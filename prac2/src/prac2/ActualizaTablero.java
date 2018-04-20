package prac2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Clase para actualizar la posicion */
class ActualizaTablero extends Thread {
    private TestFrame f;
    private int tamaño;
    
    private int x;
    private int y;
    private int velocidad;
    
    private boolean dirIzd;
    private boolean dirDch;
    private boolean dirArr;
    private boolean dirAb;
    
    private boolean iniciado;
    private boolean pause;
    
    private boolean choque;
   
    private JPanel[][] matriz;
   
    private Serpiente serpiente;
    private Comida comida;
    private boolean pulsado;
    
   
    
    public ActualizaTablero(JPanel[][] matriz){
       // this.f = new TestFrame();
        this.matriz = matriz; 
        this.tamaño = 1;
        this.serpiente = new Serpiente();

        this.comida = new Comida(this.serpiente);

        pulsado = false;
        
        x=30;
        y=30;
        velocidad=325;
        dirIzd=true;
        dirDch=false;
        dirArr=false;
        dirAb=false;
        
        iniciado=false;
        choque=false;

    }    

    @Override
    public void run(){
        // Itera mientras no se indique el fin
        pintar();
        pintarComida();

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
    
    public void restart(){
        this.comida = new Comida(this.serpiente);
        pintarComida();
        pulsado = false;
        
        x=30;
        y=30;
        velocidad=325;
        dirIzd=true;
        dirDch=false;
        dirArr=false;
        dirAb=false;
        
        iniciado=false;
        choque=false;
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
   
    
    public int getTamaño(){
        return tamaño;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(int v){
        this.velocidad=v;
    }
    
    public boolean getChoque(){
        return choque;
    }
    
    public void setChoque(boolean c){
        this.choque=c;
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
   
    public int getX(){
        return x;
    }
   
    public int getY(){
        return y;
    }

    public boolean getPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
    
    public void aumentarX(){
        x+=1;
    }
    
    public void aumentarY(){
        y+=1;
    }
    
    public void disminuirY(){
        y-=1;
    }
    
    public void disminuirX(){
        x-=1;
    }
  
   
   public void cambiarColor (int i, int j, Color color){
       matriz[i][j].setBackground(color);
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


    public void pintarComida(){
        int x=comida.getComida().getX();
        int y=comida.getComida().getY();
        matriz[x][y].setBackground(Color.blue);
        Border blackline = BorderFactory.createLineBorder(Color.black,2,false);
        matriz[x][y].setBorder(blackline);

    }

    public boolean esComido(){
        return (this.comida.getComida().equals(this.serpiente.getFirst()));
    }

    public void crecer(Punto p){
        this.serpiente.crecer(p);
    }

    public void pintar(){
        Border white = BorderFactory.createLineBorder(Color.white,1,false); 
        Punto p=this.serpiente.getLista().getFirst();
            this.matriz[p.getX()][p.getY()].setBackground(Color.red);
            this.matriz[p.getX()][p.getY()].setBorder(white);
        
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
    
   public void despintarComida(Comida comida){
        Border white = BorderFactory.createLineBorder(Color.white,2,false);    
                matriz[comida.getComida().getX()][comida.getComida().getY()].setBorder(white);
                matriz[comida.getComida().getX()][comida.getComida().getY()].setBackground(Color.white);
            }
   
   public void despintarSerpiente(Serpiente serp){
            LinkedList<Punto> list = serp.getLista();
                for (Punto p: list){
                    if (p.getX()<=59 && p.getX()>=0 && p.getY()<=59 && p.getY()>=0){
                        Border white = BorderFactory.createLineBorder(Color.white,1,false); 
                        matriz[p.getX()][p.getY()].setBackground(Color.white);
                        matriz[p.getX()][p.getY()].setBorder(white);
                    }
                }
    }
    
    public void actualizaPosicion(){ 
        try{
            Punto p1=serpiente.getFirst();
            Punto siguiente = null;
            if (dirDch){
                siguiente = new Punto(p1.getX(),p1.getY()+1);
            }
            if (dirAb){
                siguiente = new Punto(p1.getX()+1,p1.getY());
            }
            if (dirIzd){
                siguiente = new Punto(p1.getX(),p1.getY()-1);
            }
            if (dirArr){  
                siguiente = new Punto(p1.getX()-1,p1.getY());
            }
           if (serpiente.contains(siguiente)){
                this.finDelJuego();  
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
            this.finDelJuego();         
            
        }
    }
    public void finDelJuego(){
            int opcion = JOptionPane.showConfirmDialog(null, "Fin del juego. ¿Quieres reiniciar?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (opcion == 1){
                
                JOptionPane.showMessageDialog(null, "FIN DEL JUEGO");
                System.exit(0);

            }
            if (opcion == 0){
                despintarComida(comida);
                despintarSerpiente(serpiente);
                serpiente.getLista().clear();
                Punto inicio= new Punto (30,30);
                serpiente.addFirst(inicio);
                restart();
            }
            
        }
  
} 
            
            
            
