public class ListaCliente{
    private int indicador;
    private int capacidad;
    private Cliente[] clientes;
    private int iBuscador;
    public ListaCliente(int capacidad){
        this.indicador=-1;
        this.capacidad=capacidad;
        this.clientes= new Cliente[this.capacidad];
        this.iBuscador=0;
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
    public void setClientes(Cliente[] clientes){
        this.clientes=clientes;
    }
    public Cliente[] getClientes(){
        return this.clientes;
    }
    public void setIBuscador(int iBuscador){
        this.iBuscador=iBuscador;
    }
    public int getIBuscador(){
        return this.iBuscador;
    }
    public boolean estaLleno(){
        if(this.indicador==this.capacidad)
        return true;
        else
        return false;
    }
    public boolean estaVacio(){
        if (this.indicador ==-1)
        return true;
        else
        return false;
    }
    public void agregarClientes(Cliente cliente){
        if(estaLleno()==false){
            this.indicador++;
            this.clientes[this.indicador]=cliente;
        }
    }
    public Cliente eliminarClientes(){
        if(estaVacio()==false){
            Cliente aux=this.clientes[this.indicador];
            this.indicador--;
            return aux;
        }else{
            return null;
        }
    }
    
    public Cliente buscarCliente(String nombre)throws ObjetoNoEncontradoException{
 
            for(int i=0;i<=this.indicador;i++){
                if(this.clientes[i].getNombre().equalsIgnoreCase(nombre)){
                    this.iBuscador+=i;
                    return clientes[i];
                }
            }
            throw new ObjetoNoEncontradoException("Dulce no encontrado");
     
    }
    public void listarCliente(){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                System.out.println("Nombre del cliente");
                System.out.println(clientes[i].getNombre());
                System.out.println("Edad del cliente");
                System.out.println(clientes[i].getEdad());
            }
        } else
            System.out.println("¿Seguro?");
    }
    public void mostrarInformacionCli(){
        System.out.println("Nombre del cliente:");
        System.out.println(clientes[this.iBuscador].getNombre());
        System.out.println("Edad del cliente:");
        System.out.println(clientes[this.iBuscador].getEdad());
        this.iBuscador=0;
    }
}