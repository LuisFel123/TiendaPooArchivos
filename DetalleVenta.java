import java.io.Serializable;

public class DetalleVenta implements Serializable{
    private int cantidad;
    private Juguete juguetes;
    public DetalleVenta(int cantidad, Juguete juguetes){
        this.cantidad=cantidad;
        this.juguetes=juguetes;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public void setJuguetes(Juguete juguetes){
        this.juguetes=juguetes;
    }
    public Juguete getJuguetes(){
        return this.juguetes;
    }
    
    @Override
public String toString() {
    return "DetalleVenta{" +
           "cantidad=" + cantidad +
           ", juguete=" + juguetes +
           '}';
}
}