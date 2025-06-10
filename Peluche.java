public class Peluche extends Juguete{
    private String tipoM;
    private int tamaño;
    private String forma;
    public Peluche(String tipoM,int tamaño,String forma,String nombre,String color, int precio,String marca,int existencia){
        super(nombre,color,precio,marca,existencia);
        this.tipoM=tipoM;
        this.tamaño=tamaño;
        this.forma=forma;
    }
    public void setTipoM(String tipoM){
        this.tipoM=tipoM;
    }
    public void setTamaño(int tamaño){
        this.tamaño=tamaño;
    }
    public void setForma(String forma){
        this.forma=forma;
    }
    public String getTipoM(){
        return this.tipoM; 
    }
    public int getTamaño(){
        return this.tamaño;
    }
    public String getForma(){
        return this.forma;
    }
}