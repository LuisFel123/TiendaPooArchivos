public class Bicicleta extends Juguete{
    private int numRuedas;
    private int tamaño;
    private int velocidades;
    public Bicicleta(int numRuedas,int tamaño,int velocidades,String nombre,String color, int precio,String marca,int existencia){
        super(nombre,color,precio,marca,existencia);
        this.numRuedas=numRuedas;
        this.tamaño=velocidades;
        this.velocidades=velocidades;
    }
    public void setNumRuedas(int tamaño){
        this.numRuedas=numRuedas;
    }
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;    
    }
    public void setVelocidades(int velocidades){
        this.velocidades=velocidades;
    }
    public int getNumRuedas(){
        return this.numRuedas;
    }
    public int getTamaño(){
        return this.tamaño;    
    }
    public int velocidades(){
        return this.velocidades;
    }
}