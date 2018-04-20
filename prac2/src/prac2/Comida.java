
package prac2;

public class Comida {
    private Punto comida;
    
    public Comida(Serpiente s){
        do{
            int x = (int) Math.floor(Math.random()*59);
            int y = (int) Math.floor(Math.random()*59);
            this.comida=new Punto(x,y);
        }while(s.contains(this.comida));
    }

    public Punto getComida() {
        return comida;
    }

    public void setComida(Punto comida) {
        this.comida = comida;
    }
           
    
}
