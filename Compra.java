import java.io.Serializable;
public class Compra implements Serializable{
    private int id;
    private Proveedor proveedor;
    private DetalleCompra[] compras;
    private EmpleadoAlmacen empAlma;
    public Compra(int id, Proveedor proveedor, DetalleCompra[] compras,EmpleadoAlmacen empAlma){
        this.id=id;
        this.proveedor=proveedor;
        this.compras=compras;
        this.empAlma=empAlma;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setProveedor(Proveedor proveedor){
        this.proveedor=proveedor;
    }
    public Proveedor getProveedor(){
        return this.proveedor;
    }
    public void setCompras(DetalleCompra[] lol){
        this.compras=lol;
    }
    public DetalleCompra[] getCompras(){
        return this.compras;
    }
    public void setEmpleadoAlmacen(EmpleadoAlmacen empAlma){
        this.empAlma=empAlma;
    }
    public EmpleadoAlmacen getEmpAlma(){
        return this.empAlma;
    }
    public int goat(){
        return compras.length;
    }
}