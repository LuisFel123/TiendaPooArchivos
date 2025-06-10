import java.io.Serializable;
public abstract class Empleado implements Serializable{
    private int edad;
    private String nombre;
    private long numEmpleado;
    private String correo;
    public Empleado(int edad, String nombre, long numEmpleado, String correo){
        this.edad=edad;
        this.nombre=nombre;
        this.numEmpleado=numEmpleado;
        this.correo=correo;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setNumEmpleado(long numEmpleado){
        this.numEmpleado=numEmpleado;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getNombre(){
        return this.nombre;
    }
    public long getNumEmpleado(){
        return this.numEmpleado;
    }
    public void SetCorreo(String correo){
        this.correo=correo;
    }
    public String getCorreo(){
        return this.correo;
    }
    public abstract double calcularSueldo();
    @Override

    public String toString() {
    return "Empleado{" +
           "nombre='" + nombre + '\'' +
           ", edad=" + edad +
           ", numEmpleado=" + numEmpleado +
           ", correo='" + correo + '\'' +
           '}';
}
}