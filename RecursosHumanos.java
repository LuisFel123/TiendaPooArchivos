public class RecursosHumanos extends Empleado{
    private double sueldoPorDia;
    private int diasTrabajados;
    private boolean titulo;
    public RecursosHumanos(double sueldoPorDia, int diasTrabajados,boolean titulo, int edad, String nombre, int numEmpleado,String correo){
        super(edad, nombre, numEmpleado,correo);
        this.sueldoPorDia=sueldoPorDia;
        this.diasTrabajados=diasTrabajados;
        this.titulo=titulo;
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
    public void setTitulo(boolean titulo){
        this.titulo=titulo;
    }
    public boolean getTitulo(){
        return this.titulo;
    }
    @Override
    public double calcularSueldo(){
        double sueldo=0;
            sueldo= this.diasTrabajados * this.sueldoPorDia;
            return sueldo;
    }
}