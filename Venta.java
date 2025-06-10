import java.io.Serializable;
public class Venta{
    private int id;
    private Vendedor vendedor;
    private Cliente cliente;
    private DetalleVenta [] ventas;
    public Venta(int id, Vendedor vendedor, Cliente cliente,DetalleVenta[]ventas){
        this.id=id;
        this.vendedor=vendedor;
        this.cliente=cliente;
        this.ventas=ventas;
        
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setVendedor(Vendedor vendedor){
        this.vendedor=vendedor;
    }
    public Vendedor getVendedor(){
        return this.vendedor;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public void setDetalleVenta(DetalleVenta[] ventas){
        this.ventas=ventas;
    }
    public DetalleVenta[] getVentas(){
        return this.ventas;
    }
    public int getLength(){
        return ventas.length;
    }
}