public class Canica extends Juguete {
    private int cantidadB;
    private int tamaño;
    public Canica(int cantidadB,int tamaño,String nombre,String color, int precio,String marca,int existencia){
        super(nombre,color,precio,marca,cantidadB);
        this.cantidadB=cantidadB;
    }
    public void setCantidadB(int cantidadB){
        this.cantidadB=cantidadB;
    }
    public int getCantidadB(){
        return this.cantidadB;
    }
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }
    public int getTamaño(){
        return this.tamaño;
    }
} 