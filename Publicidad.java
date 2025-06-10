public class Publicidad extends Empleado{
    private double sueldoPorDia;
    private int diasTrabajados;
    private int años;
    public Publicidad(double sueldoPorDia, int diasTrabajados,int añosXP, int edad, String nombre, long numEmpleado,String correo){
        super(edad, nombre, numEmpleado,correo);
        this.sueldoPorDia=sueldoPorDia;
        this.diasTrabajados=diasTrabajados;
        this.años=años;
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
    public void setAñosXP(int años){
        this.años=años;
    }
    public int getAños(){
        return this.años;
    }
    @Override
    public double calcularSueldo(){
        double sueldo=0;
            sueldo= this.diasTrabajados * this.sueldoPorDia;
            return sueldo;
    }
}