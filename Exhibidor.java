public class Exhibidor {
    private int capacidad;
    private int indicador;
    private Juguete[] juguetes;
    private int iBuscadorP;
    public Exhibidor(int capacidad){
        this.capacidad=capacidad;
        this.indicador=-1;
        this.juguetes=new Juguete[this.capacidad];
        this.iBuscadorP=0;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public int getCapacidad(){
        return this.capacidad;
    }
    public void setIndicador(int indicador){
        this.indicador=indicador;
    }
    public int getIndicador(){
        return this.indicador;
    }
    public void setIBuscadorP(int indicador){
        this.iBuscadorP=indicador;
    }
    public int getIBuscadorP(){
        return this.iBuscadorP;
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
    public void agregarJuguete(Juguete juguetes){
        if(estaLleno()==false){
            this.indicador++;
            this.juguetes[this.indicador]=juguetes; 
        }
    }
    public Juguete eliminarJuguete(){
        if(estaVacio()==false){
            Juguete aux=this.juguetes[this.indicador];
            this.indicador--;
            return aux;
        }else{
            return null;
        }
    }
    public int contarPelotas(){
        int contadorA=0;
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i]instanceof Pelota){
                contadorA++;
            }
            
        }
        return contadorA;
    }
    public int contarCanicas(){
        int contadorB=0;
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i]instanceof Canica){
                contadorB++;
            }
            
        }
        return contadorB;
    }
    public int contarRompecabezas(){
        int contadorC=0;
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i]instanceof Rompecabeza){
                contadorC++;
            }
            
        }
        return contadorC;
    }
    public int contarBicicletas(){
        int contadorD=0;
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i]instanceof Bicicleta){
                contadorD++;
            }
            
        }
        return contadorD;
    }
    public int contarPeluches(){
        int contadorE=0;
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i]instanceof Peluche){
                contadorE++;
            }
            
        }
        return contadorE;
    }
    public void contarExistencia(){
        for(int i=0; i<=indicador;i++){
            if(this.juguetes[i].getExistencia()==0)
                System.out.println("No se encontro existencias del producto"+this.juguetes[i].getMarca()+"nombre"+this.juguetes[i].getNombre());
            else if(this.juguetes[i].getExistencia()<=5)
                System.out.println("Te quedan menos de 5 existencias del producto "+this.juguetes[i].getMarca()+"nombre"+this.juguetes[i].getNombre());
        }
    }
    public int totalPelotas(){
        int auxA=0;
        for(int i=0; i<=indicador; i++){
            if(this.juguetes[i]instanceof Pelota){
                auxA=this.juguetes[i].getExistencia()+auxA;
            }
        }
        return auxA;
    }
    public int totalCanicas(){
        int auxB=0;
        for(int i=0; i<=indicador; i++){
            if(this.juguetes[i]instanceof Canica){
                auxB=this.juguetes[i].getExistencia()+auxB;
            }
        }
        return auxB;
    }
    public int totalRompecabezas(){
        int auxC=0;
        for(int i=0; i<=indicador; i++){
            if(this.juguetes[i]instanceof Rompecabeza){
                auxC=this.juguetes[i].getExistencia()+auxC;
            }
        }
        return auxC;
    }
    public int totalBicicletas(){
        int auxD=0;
        for(int i=0; i<=indicador; i++){
            if(this.juguetes[i]instanceof Bicicleta){
                auxD=this.juguetes[i].getExistencia()+auxD;
            }
        }
        return auxD;
    }
    public int totalPeluches(){
        int auxE=0;
        for(int i=0; i<=indicador; i++){
            if(this.juguetes[i]instanceof Peluche){
                auxE=this.juguetes[i].getExistencia()+auxE;
            }
        }
        return auxE;
    }
    public void mostrarInformacionJuguete(){
        System.out.println("Marca del juguete:");
        System.out.println(juguetes[this.iBuscadorP].getMarca());
        System.out.println("Tipo de juguete:");
        if(juguetes[this.iBuscadorP]instanceof Pelota)
            System.out.println("juguete de tipo pelota");
        else if(juguetes[this.iBuscadorP]instanceof Canica)
            System.out.println("juguete de tipo canica");
        else if(juguetes[this.iBuscadorP]instanceof Bicicleta)
            System.out.println("juguete de tipo rompecabeza");
        else if(juguetes[this.iBuscadorP]instanceof Rompecabeza)
            System.out.println("juguete de tipo peluche");
        else if(juguetes[this.iBuscadorP]instanceof Peluche)
            System.out.println("juguete de tipo peluche");    
        System.out.println("nombre del juguete:");
        System.out.println(juguetes[this.iBuscadorP].getNombre());
        this.iBuscadorP=0;
    }
    public Juguete buscar(String nombre)throws ObjetoNoEncontradoException{
            for(int i=0;i<=this.indicador;i++){
                if(this.juguetes[i].getMarca().equalsIgnoreCase(nombre)){
                    this.iBuscadorP+=i;
                    return juguetes[i];
                }
            }
            throw new ObjetoNoEncontradoException("juguete no encontrado");
     
    }
    
    
    public Juguete buscarDos(String nombre, int posicion) {
    int posicionDos = posicion; // porque el usuario cuenta desde 1

    if (posicionDos < 0 || posicionDos > this.indicador) {
        System.out.println("La posición no se encuentra disponible.");
        return null;
    }

    Juguete juguete = this.juguetes[posicionDos];

    if (juguete.getNombre().equalsIgnoreCase(nombre)) {
        System.out.println("Sí encontró en la posición " + posicionDos);
        this.iBuscadorP += posicionDos;
        return juguete;
    }

    System.out.println("No coincide el nombre con el de esa posición.");
    return null;
}
    public void listarJuguete(){
    for(int i=0;i<=this.indicador;i++){
        System.out.println("Marca del juguete");
        System.out.println(juguetes[i].getMarca());
        System.out.println("Tipo del juguete");
        if(juguetes[i]instanceof Pelota){
            System.out.println("juguete de tipo pelota");
            System.out.println("Caractertisticas de la pelota: "+juguetes[i].getColor());
            System.out.println("Existencias de pelotas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Canica){
            System.out.println("juguete de tipo canica");
            System.out.println("Existencias de canicas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Rompecabeza){
            System.out.println("juguete de tipo rompecabeza");
            System.out.println("Existencias de rompecabezas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Bicicleta){
            System.out.println("juguete de tipo bicicleta");
            System.out.println("Existencias de bicicletas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Peluche){
            System.out.println("juguete de tipo peluche");
            System.out.println("Existencias de peluche: "+juguetes[i].getExistencia());
        }
        System.out.println("Precio del juguete");
        System.out.println(juguetes[i].getPrecio());
        }
    }
    
    public void listarJugueteDos(){
    for(int i=0;i<=this.indicador;i++){
        
        System.out.println("Numero de producto "+(i+1));
        System.out.println("Marca del producto: "+juguetes[i].getMarca());
        System.out.println("Tipo de producto");
        
        if(juguetes[i]instanceof Pelota){
            
            System.out.println("juguete de tipo pelota");
            System.out.println("Caractertisticas de la pelota: "+juguetes[i].getColor());
            System.out.println("Existencias de pelotas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Canica){
            System.out.println("juguete de tipo canica");
            System.out.println("Existencias de canicas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Rompecabeza){
            System.out.println("juguete de tipo rompecabeza");
            System.out.println("Existencias de rompecabezas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Bicicleta){
            System.out.println("juguete de tipo bicicleta");
            System.out.println("Existencias de bicicletas: "+juguetes[i].getExistencia());
        }else if(juguetes[i]instanceof Peluche){
            System.out.println("juguete de tipo peluche");
            System.out.println("Existencias de peluche: "+juguetes[i].getExistencia());
        }
        System.out.println("Precio del juguete");
        System.out.println(juguetes[i].getPrecio());
        }
    }
}