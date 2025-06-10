public class ListaCompra{
    private int indicador;
    private int capacidad;
    private Compra[] compras;
    private int iBuscadorE;
    public ListaCompra(int capacidad){
        this.indicador=-1;
        this.capacidad=capacidad;
        this.compras=new Compra[this.capacidad];
        this.iBuscadorE=0;
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
    public void setCompras(Compra[] compras){
        this.compras=compras;
    }
    public Compra[] getCompras(){
        return this.compras;
    }
    public void setIBuscadorE(int iBuscador){
        this.iBuscadorE=iBuscador;
    }
    public int getIBuscadorE(){
        return this.iBuscadorE;
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
    public void agregarCompra(Compra noise){
        if(estaLleno()==false){
            this.indicador++;
            this.compras[this.indicador]=noise;
        }
    }
    public Compra eliminarCompra(){
        if(estaVacio()==false){
            Compra aux=this.compras[this.indicador];
            this.indicador--;
            return aux;
        }else{
            return null;
        }
    } 
    public void listarCompra(){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                System.out.println("Detalles de la Compra");
                for(int VJ=0;VJ<compras[i].goat();VJ++){
                    DetalleCompra[] Figo=compras[i].getCompras();
                    System.out.println("Marca del dulce"+"es"+Figo[VJ].getJuguetes().getMarca());
                    System.out.println("Cantidad del dulce"+"es"+Figo[VJ].getCantidad());
                }
                System.out.println("Proveedor de la compra");
                System.out.println(compras[i].getProveedor().getNombre());
                System.out.println("empleado a cargo de la compra");
                System.out.println(compras[i].getProveedor().getNombre());
                System.out.println("Id de la compra");
                System.out.println(compras[i].getId());
            } 
        
        }else
            System.out.println("Error");
    }
    public Compra buscarCompra(int id){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                if(this.compras[i].getId()==id){
                    System.out.println("Compra encontrada");
                    this.iBuscadorE+=i;
                    return compras[i];
                }
            }
            return null;
        }else 
        System.out.println("No hay compras");
        return null;
    }
    public void mostrarInformacionCom(){
        System.out.println("Id de compra buscada:");
        System.out.println(compras[this.iBuscadorE].getId());
        System.out.println("Detalles de la compra:");
        System.out.println(compras[this.iBuscadorE].getCompras());
        System.out.println("Proveedor al que se le compró:");
        System.out.println(compras[this.iBuscadorE].getProveedor());
        System.out.println("Monto gastado:");
        this.iBuscadorE=0;
    }
}