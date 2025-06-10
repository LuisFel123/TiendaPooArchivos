public class DetalleVenta{
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
}