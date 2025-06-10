public class Rompecabeza extends Juguete {
    private int numPiezas;
    public Rompecabeza(int numPiezas,String nombre,String color, int precio,String marca,int existencia){
        super(nombre,color,precio,marca,existencia);
        this.numPiezas=numPiezas;
    }
    public void setNumPiezas(){
        this.numPiezas=numPiezas;
    }
    public int getNumPiezas(){
        return this.numPiezas;
    }
} 