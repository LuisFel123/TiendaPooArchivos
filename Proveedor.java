import java.io.Serializable;
public class Proveedor{
    private String nombre;
    private String distrito;
    public Proveedor(String nombre,String distrito){
        this.nombre=nombre;
        this.distrito=distrito;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setDistrito(){
        this.distrito=distrito;
    }
    public String getDistrito(){
        return this.distrito;
    }
}
