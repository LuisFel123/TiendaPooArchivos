public class Plantilla{
    private int indicador;
    private int capacidad;
    private Empleado[] empleados;
    private int iBuscadorH;
    public Plantilla(int capacidad){
        this.indicador=-1;
        this.capacidad=capacidad;
        this.empleados=new Empleado[this.capacidad];
        this.iBuscadorH=0;
    }
    public void setIndicador(int indicador){
        this.indicador=-1;
    }
    public int getIndicador(){
        return this.indicador;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    public void setEmpleados(Empleado[] empleados){
        this.empleados=empleados;
    }
    public Empleado[] getEmpleados(){
        return this.empleados;
    }
    public void setIBuscadorH(int iBuscador){
        this.iBuscadorH=iBuscador;
    }
    public int getIBuscadorH(){
        return this.iBuscadorH;
    }
    public boolean estaLleno(){
        if(this.indicador==this.capacidad-1)
            return true;
        else
            return false;
    }
    public boolean estaVacio(){
        if(this.indicador==-1)
            return true;
        else
            return false;
    }
    public void agregarEmpleado(Empleado chambeador){
        if(estaLleno()==false){
            this.indicador++;
            this.empleados[this.indicador]=chambeador;
        }
    }
    public Empleado eliminarEmpleado(){
        if(estaVacio()==false){
            Empleado aux=this.empleados[this.indicador];
            this.indicador--;
            return aux;
        } else
        return null;
    }
    public int contarVendedores(){
        int contadorV=0;
        for(int i=0; i<=indicador;i++){
            if(this.empleados[i]instanceof Vendedor){
                contadorV++;
            }
            
        }
        return contadorV;
    }
    public int contarAlmacen(){
        int contadorA=0;
        for(int i=0; i<=indicador;i++){
            if(this.empleados[i]instanceof EmpleadoAlmacen){
                contadorA++;
            }
            
        }
        return contadorA;
    }
    public int contarDesarrolladores(){
        int contadorD=0;
        for(int i=0; i<=indicador;i++){
            if(this.empleados[i]instanceof Desarrollador){
                contadorD++;
            }
            
        }
        return contadorD;
    }
    public double totalSueldos(){
        double sueldos=0;
        for(int i=0;i<=this.indicador;i++){
            sueldos=sueldos+this.empleados[i].calcularSueldo();
        }
        return sueldos;
    }
    public void listarEmpleados(){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                System.out.println("Nombre del empleado");
                System.out.println(empleados[i].getNombre());
                System.out.println("Edad");
                System.out.println(empleados[i].getEdad());
                System.out.println("Número del empleado");
                System.out.println(empleados[i].getNumEmpleado());
                if(empleados[i]instanceof Publicidad){
                    System.out.println("Puesto en la empresa: Publicidad");
                    System.out.println("Sueldo: $"+empleados[i].calcularSueldo());
                }else if(empleados[i]instanceof Vendedor){
                    System.out.println("Puesto en la empresa: Vendedor");
                    System.out.println("Sueldo: $"+empleados[i].calcularSueldo());
                }else if(empleados[i]instanceof EmpleadoAlmacen){
                    System.out.println("Puesto en la empresa: Empleado de EmpleadoAlmacen");
                    System.out.println("Sueldo: $"+empleados[i].calcularSueldo());
                }else if(empleados[i]instanceof RecursosHumanos){
                    System.out.println("Puesto en la empresa: Recursos Humanos");
                    System.out.println("Sueldo: $"+empleados[i].calcularSueldo());
                }else if(empleados[i]instanceof Desarrollador){
                    System.out.println("Puesto en la empresa: Developer");
                    System.out.println("Sueldo: $"+empleados[i].calcularSueldo());
                }
            }
        } else
            System.out.println("No hay empleados");
    }
    public Empleado buscarEmpleado(String nombre)throws ObjetoNoEncontradoException{
 
            for(int i=0;i<=this.indicador;i++){
                if(this.empleados[i].getNombre().equalsIgnoreCase(nombre)){
                    this.iBuscadorH+=i;
                    return empleados[i];
                }
            }
            throw new ObjetoNoEncontradoException("No se pudo encontrar al empleado");
     
    }
    public void mostrarInformacionEmp(){
        System.out.println("Nombre del empleado:");
        System.out.println(empleados[this.iBuscadorH].getNombre());
        System.out.println("Edad del empleado:");
        System.out.println(empleados[this.iBuscadorH].getEdad());
        System.out.println("Número de empleado:");
        System.out.println(empleados[this.iBuscadorH].getNumEmpleado());
        System.out.println("Sueldo: $"+empleados[iBuscadorH].calcularSueldo());
        this.iBuscadorH=0;
    }
}