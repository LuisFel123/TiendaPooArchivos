public class ListaProveedor{
    private int indicador;
    private int capacidad;
    private Proveedor[]proveedores;
    private int iBuscadorD;
    public ListaProveedor(int capacidad){
        this.indicador=-1;
        this.capacidad=capacidad;
        this.proveedores= new Proveedor[this.capacidad];
        this.iBuscadorD=0;
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
    public void setProovedores(Proveedor[] proveedores){
        this.proveedores=proveedores;
    }
    public Proveedor[] getProveedores(){
        return this.proveedores;
    }
    public void setIBuscadorD(int iBuscador){
        this.iBuscadorD=iBuscador;
    }
    public int getIBuscadorD(){
        return this.iBuscadorD;
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
    public void agregarProveedor(Proveedor vanilla){
        if(estaLleno()==false){
            this.indicador++;
            this.proveedores[this.indicador]=vanilla;
        }
    }
    public Proveedor eliminarProveedor(){
        if(estaVacio()==false){
            Proveedor aux=this.proveedores[this.indicador];
            this.indicador--;
            return aux;
        }else{
            return null;
        }
    }
    public void listarProveedor(){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                System.out.println("Nombre del proveedor "+(i+1)+":");
                System.out.println(proveedores[i].getNombre());
                System.out.println("Distrito del proveedor");
                System.out.println(proveedores[i].getDistrito());
            }
        } else
            System.out.println("Tu lista de proveedores esta vacia");
    }
    public Proveedor buscarProveedor(String nombre)throws ObjetoNoEncontradoException{
 
            for(int i=0;i<=this.indicador;i++){
                if(this.proveedores[i].getNombre().equalsIgnoreCase(nombre)){
                    this.iBuscadorD+=i;
                    return proveedores[i];
                }
            }
            throw new ObjetoNoEncontradoException("objeto no encontrado");
     
    }
    public void mostrarInformacionP(){
        System.out.println("Nombre del proveedor:");
        System.out.println(proveedores[this.iBuscadorD].getNombre());
        System.out.println("Distrito del proveedor:");
        System.out.println(proveedores[this.iBuscadorD].getDistrito());
        this.iBuscadorD=0;
    }
}