public class Pelota extends Juguete{
    private boolean deporte;
    private String material;
    private int tamaño;
    public Pelota(boolean deporte,String material,int tamaño,String nombre,String color, int precio,String marca,int existencia){
        super(nombre,color,precio,marca,existencia);
        this.deporte=deporte;
        this.material=material;
        this.tamaño=tamaño;
    }
    
    
    public void setDeporte(boolean deporte){
        this.deporte=deporte; 
    }
    public void setMaterial(String material){
        this.material=material;
    }
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }
    public boolean getDeporte(){
        return this.deporte;
    }
    public String getMaterial(){
        return this.material;
    }
    public int getTamaño(){
        return this.tamaño;
    }
} 
