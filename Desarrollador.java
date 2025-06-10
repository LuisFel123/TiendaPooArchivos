public class Desarrollador extends Empleado{
    private double sueldoPorDia;
    private int diasTrabajados;
    private int lenguajes;
    public Desarrollador(double sueldoPorDia, int diasTrabajados, int lenguajes, int edad, String nombre, int numEmpleado,String correo){
        super(edad, nombre, numEmpleado,correo);
        this.sueldoPorDia=sueldoPorDia;
        this.diasTrabajados=diasTrabajados;
        this.lenguajes=lenguajes;
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
    public void setLegnuajes(int lenguajes){
        this.lenguajes=lenguajes;
    }
    public int getLenguajes(){
        return this.lenguajes;
    }
    @Override
    public double calcularSueldo(){
        double sueldo=0;
            sueldo= this.diasTrabajados * this.sueldoPorDia;
            return sueldo;
    }
}