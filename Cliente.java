import java.io.Serializable;
public class Cliente implements Serializable{
    private String nombre;
    private int edad; 
        public Cliente(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
public String toString() {
    return "Cliente{" +
           "nombre='" + nombre + '\'' +
           ", edad=" + edad +
           '}';
}
}