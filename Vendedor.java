public class Vendedor extends Empleado{
    private double sueldoPorDia;
    private int diasTrabajados;
    private int numCaja;
    public Vendedor(double sueldoPorDia, int diasTrabajados,int numCaja, int edad, String nombre, long numEmpleado,String correo){
        super(edad, nombre, numEmpleado,correo);
        this.sueldoPorDia=sueldoPorDia;
        this.diasTrabajados=diasTrabajados;
        this.numCaja=numCaja;
    }
    public void setSueldoPorDia(double sueldoPorDia){
        this.sueldoPorDia=sueldoPorDia;
    }
    public double getSueldoPorDia(){
        return this.sueldoPorDia;
    }
    public void setDiasTrabajados(int diasTrabajados){
        this.diasTrabajados=diasTrabajados;
    }
    public int getDiasTrabajados(){
        return this.diasTrabajados;
    }
    public void setNumCaja(int cajita){
        this.numCaja=cajita;
    }
    public int getNumCaja(){
        return this.numCaja;
    }
    @Override
    public double calcularSueldo(){
        double sueldo=0;
            sueldo= this.diasTrabajados * this.sueldoPorDia;
            return sueldo;
    }
    
    @Override
public String toString() {
    return "Vendedor{" +
           "nombre='" + getNombre() + '\'' +
           ", edad=" + getEdad() +
           ", numEmpleado=" + getNumEmpleado() +
           ", correo='" + getCorreo() + '\'' +
           ", sueldoPorDia=" + sueldoPorDia +
           ", diasTrabajados=" + diasTrabajados +
           ", numCaja=" + numCaja +
           ", sueldoTotal=" + calcularSueldo() +
           '}';
}

}