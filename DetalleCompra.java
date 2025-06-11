import java.io.Serializable;
public class DetalleCompra implements Serializable{
    private int cantidad;
    private Juguete juguetes;
    public DetalleCompra(int cantidad, Juguete juguetes){
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
}