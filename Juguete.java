import java.io.Serializable;
public abstract class Juguete implements Serializable {
    private String nombre;
    private String color;
    private int precio;
    private String marca;
    private int existencia; 
    public Juguete(String nombre,String color, int precio,String marca,int existencia) {
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.existencia = existencia;
        this.marca = marca;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setPrecio(int precio){
        this.precio=precio;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public void setExistencia(int existencia){
        this.existencia=existencia;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getColor(){
        return this.color;
    }
    public int getPrecio(){
        return this.precio;
    }
    public String getMarca(){
        return this.marca;
    }
    public int getExistencia(){
        return this.existencia;
    }
    

    
   
}