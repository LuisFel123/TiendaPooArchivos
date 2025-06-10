public class EmpleadoAlmacen extends Empleado{
    private double sueldoPorDia;
    private int diasTrabajados;
    private boolean montaCargas;
    public EmpleadoAlmacen(double sueldoPorDia, int diasTrabajados,boolean montaCargas, int edad, String nombre, int numEmpleado,String correo){
        super(edad, nombre, numEmpleado,correo);
        this.sueldoPorDia=sueldoPorDia;
        this.diasTrabajados=diasTrabajados;
        this.montaCargas=montaCargas;
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
    public void setMontacargas(boolean montaCargas){
        this.montaCargas=montaCargas;
    }
    public boolean getMontaCargas(){
        return this.montaCargas;
    }
    @Override
    public double calcularSueldo(){
        double sueldo=0;
            sueldo= this.diasTrabajados * this.sueldoPorDia;
            return sueldo;
    }
}
