public class ListaVenta{
    private int indicador;
    private int capacidad;
    private Venta[] ventas;
    private int iBuscadorVen;
    public ListaVenta(int capacidad){
        this.indicador=-1;
        this.capacidad=capacidad;
        this.ventas= new Venta[this.capacidad];
        this.iBuscadorVen=0;
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
    public void setVentas(Venta[] ventas){
        this.ventas=ventas;
    }
    public Venta[] getVentas(){
        return this.ventas;
    }
    public void setIBuscadorV(int iBuscador){
        this.iBuscadorVen=iBuscador;
    }
    public int getIBuscador(){
        return this.iBuscadorVen;
    }
    public boolean estaLleno(){
        if(this.indicador==this.capacidad-1)
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
    public void agregarVenta(Venta money){
        if(estaLleno()==false){
            this.indicador++;
            this.ventas[this.indicador]=money;
        }
    }
    public Venta eliminarVenta(){
        if(estaVacio()==false){
            Venta aux=this.ventas[this.indicador];
            this.indicador--;
            return aux;
        }else{
            return null;
        }
    }
    public void listarVenta(){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                System.out.println("----------------------------------------------------");
                System.out.println("Id de la venta");
                System.out.println(ventas[i].getId());
                System.out.println("Vendedor acargo de la venta");
                System.out.println(ventas[i].getVendedor().getNombre());
                System.out.println("Cliente al que se le realizó la venta");
                System.out.println(ventas[i].getCliente().getNombre());
                System.out.println("Detalle de la venta");
                for(int v=0;v<ventas[i].getLength();v++){
                    DetalleVenta[] test=ventas[i].getVentas();
                    System.out.println("la marca del dulce es: "+ test[v].getJuguetes().getMarca());
                    System.out.println("la cantidad de compras es: "+test[v].getCantidad());
                }
            } 
        
        }else
            System.out.println("fallo");
    }
    public Venta buscarVentas(int id){
        if(estaVacio()==false){
            for(int i=0;i<=this.indicador;i++){
                if(this.ventas[i].getId()==id){
                    System.out.println("se ha localizado la venta");
                    this.iBuscadorVen+=i;
                    return ventas[i];
                }
            }
            return null;
        }else 
        System.out.println("No existe ninnguna venta");
        return null;
    }
    
    public void mostrarInformacionV(){
        System.out.println("Id de la venta:");
        System.out.println(ventas[this.iBuscadorVen].getId());
        System.out.println("Vendedor que realizó a venta:");
        System.out.println(ventas[this.iBuscadorVen].getVendedor());
        System.out.println("Cliente al que se le realizó la venta:");
        System.out.println(ventas[this.iBuscadorVen].getCliente());
        System.out.println("Detalles de la venta:");
        System.out.println(ventas[this.iBuscadorVen].getVentas());
        this.iBuscadorVen=0;
    }
}