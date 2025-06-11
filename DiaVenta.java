import java.util.Scanner;
import java.util.InputMismatchException;    
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class DiaVenta{
    public static void main(String[]args) throws Exception, ObjetoNoEncontradoException {
        int opcion=0;
        Scanner sc=new Scanner(System.in);
        Exhibidor mostrador=new Exhibidor(100);
        ListaProveedor distribuidor=new ListaProveedor(100);
        ListaCliente clientes=new ListaCliente(100);
        ListaVenta listaDeVentas=new ListaVenta(100);
        ListaCompra lasCompras=new ListaCompra(100);
        Plantilla empleados=new Plantilla(100);
        Archivo archivo = new Archivo();
        ArchivoClientes archivoClientes = new ArchivoClientes();
        ArchivoEmpleados archivoEmpleados = new ArchivoEmpleados();
        ArchivoProveedor archivoProveedor = new ArchivoProveedor(); 
        ArchivoVenta archivoVenta =  new ArchivoVenta();
        //ArchivoVenta archivoVenta = new ArchivoVenta();
        ArchivoCompra archivoCompra = new ArchivoCompra();  
        do{
            try{
            System.out.println("Bienvenido a Jugueteria Coco");
            System.out.println("Selecciona una opción: ");
            System.out.println("1.- Menú de Admin.");
            System.out.println("2.- Menú de Vendedor.");
            System.out.println("3.- Menú de EmpleadoAlmacen.");
            System.out.println("4.- Salir.");
            opcion=sc.nextInt();
        }catch(Exception exception){
            System.out.println("Error,no pude ingresar palabras, intentelo de nuevo");
            exception.printStackTrace();
            sc.nextLine();
        }
                switch(opcion){
                    case 1:
                        System.out.println("Haz seleccionado el menú de Admin.");
                        int opcionAdmin=0;
                        do{
                            try{
                                System.out.println("Visualizando el Menú de Admin");
                                System.out.println("1.-Menú de Productos.\n2.-Menú de Clientes.\n3.-Menú de Proveedores.\n4.-Menú de Ventas.\n5.-Menú de Compras.\n6.-Menú de Empleados.\n7.-Regresar.");
                                opcionAdmin=sc.nextInt();
                            }catch(Exception exception){
                                System.out.println("Error,no puede ingresar letras, intentelo de nuevo");
                                exception.printStackTrace();
                                sc.nextLine();
                            } 
                            switch(opcionAdmin){
                                case 1:
                                    System.out.println("Seleccionaste Menú de Producto.");
                                    int opcionMenuProductoAdmin=0;
                                    do{
                                    try{    
                                        System.out.println("Mostrando el Menú de Productos,¿Que quieres hacer?");
                                        System.out.println("1.-Listar Productos.\n2.-Buscar Productos.\n3.-agregar Producto.\n4.-eliminar Producto.\n5.-Editar Producto.\n6.-Regresar");
                                        opcionMenuProductoAdmin=sc.nextInt();
                                    }catch(Exception exception){
                                        System.out.println("no puede ingresar letras por favor intentelo de nuevo");   
                                        exception.printStackTrace();
                                        sc.nextLine();
                                    }
                                    switch(opcionMenuProductoAdmin){
                                        case 1:
                                            System.out.println("Seleccionaste Listar Productos.");
                                            List<Juguete> juguetes = archivo.listarObjetos("productos.dat");

                                            if(juguetes.isEmpty()){
                                                System.out.println("No hay productos que listar");
                                            }else
                                                
                                                System.out.println("Mostrando la lista de los productos");
                                                 for (Juguete j : juguetes) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Existencia: " + j.getExistencia() +
                                                           ", Marca: " + j.getMarca() +
                                                           ", Precio: " + j.getPrecio()+", Color: " + j.getColor());
                                                    }
                                                //mostrador.listarJuguete();

                                            break;
                                        case 2:
                                                   try {
                                                        System.out.println("----------Seleccionaste buscar Producto.----------");
                                                        
                                                    
                                                        System.out.println("Mostrando requisitos para buscar");
                                                        sc.nextLine(); // limpiar buffer
                                                        System.out.println("Ingrese el nombre del producto que desea buscar:");
                                                        String buscarPro = sc.nextLine();
                                                    
                                                        if (buscarPro.length() < 3) {
                                                            throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                        }
                                                    
                                                        List<Juguete> resultados = archivo.buscarProductosPorNombre("productos.dat", buscarPro);
                                                    
                                                        if (!resultados.isEmpty()) {
                                                            System.out.println("—— Productos encontrados ——");
                                                            for (Juguete j : resultados) {
                                                                System.out.println("Nombre: " + j.getNombre());
                                                                System.out.println("Marca: " + j.getMarca());
                                                                System.out.println("Color: " + j.getColor());
                                                                System.out.println("Precio: " + j.getPrecio());
                                                                System.out.println("Existencia: " + j.getExistencia());
                                                                System.out.println("----------------------------");
                                                            }
                                                        } else {
                                                            System.out.println("No se encontró ningún producto con ese nombre.");
                                                        }
                                                    
                                                    } catch (ACMilanException menorT) {
                                                        System.out.println("Nombre menor a tres letras.");
                                                        menorT.printStackTrace();
                                                        sc.nextLine(); // limpiar buffer
                                                    }

                                                break;

                                        case 3:
                                            System.out.println("Seleccionaste agregar Producto.");
                                            int dulces=0;
                                            do{
                                                try{
                                                System.out.println("----------Mostrando tipos de productos----------");
                                                System.out.println("1.- Pelota. \n2.- Canica. \n3.- Rompecabeza. \n4.- Bicicleta. \n5.- Peluche. \n6.- Regresar");
                                                dulces=sc.nextInt();
                                            }catch(Exception exception){
                                                System.out.println("Error no puede ingresar letras, por favor intentelo de nuevo"); 
                                                exception.printStackTrace();
                                                sc.nextLine();
                                                }
                                            switch(dulces){
                                                case 1:
                                                   try{
                                                       System.out.println("Seleccionaste agregar Pelota.");
                                                      System.out.println("Mostrando requisitos para agregar Pelota");
                                                      System.out.println("¿Cuántas pelotas deseas agregar?");
                                                    }catch(Exception exception){
                                                        System.out.println("ingresa un numero entero");
                                                        exception.printStackTrace();
                                                        sc.nextLine();
                                                        }
                                                    int nPrime=sc.nextInt();
                                                    for(int i=0;i<nPrime;i++){
                                                        try{
                                                          sc.nextLine();
                                                          System.out.println("Ingresa el nombre de tu pelota"); 
                                                          String nombre=sc.nextLine();
                                                          System.out.println("Nombre que se ingreso: "+nombre);
                                                          System.out.println("Ingresa el tamaño o número de tu pelota");
                                                          int tamaño=sc.nextInt();
                                                          sc.nextLine();
                                                          System.out.println("¿tu pelota es para deportes?");
                                                          String freezed=sc.next();
                                                          boolean deporte=false;
                                                          if(freezed.equalsIgnoreCase("si"))
                                                            deporte=true;
                                                        sc.nextLine();
                                                          System.out.println("Ingresa la marca de tu pelota");
                                                          String marca=sc.nextLine();
                                                          
                                                          System.out.println("Ingresa el color de tu pelota");
                                                          String color=sc.nextLine();
                                                          System.out.println("Ingresa el material de tu pelota");
                                                          String material=sc.nextLine();
                                                          System.out.println("Ingresa el precio de tu pelota");
                                                          int precio=sc.nextInt();
                                                          sc.nextLine();
                                                          System.out.println("Ingresa las Existencia de tu Pelota número");
                                                          int existencia=sc.nextInt();
                                                          sc.nextLine();
                                                         Pelota prime = new Pelota(deporte, material, tamaño, nombre, color, precio, marca, existencia);
                                                          //mostrador.agregarJuguete(prime);
                                                          archivo.escribirOAgregar("productos.dat",prime);
                                                          }catch(Exception exception){
                                                            System.out.println("usted puso un numero o letra donde no debia, intente de nuevo");
                                                            exception.printStackTrace();
                                                            sc.nextLine();
                                                           }
                                                    }
                                                    
                                                    

                                                    System.out.println("----------Pelota se han agregado con exito----------");
                                                    System.out.println("Regresando");
                                                    break;
                                                case 2:
                                                    try{
                                                          System.out.println("----------Seleccionaste agregar Canica.----------");
                                                        System.out.println("Requisitos para agregar una bolsa de canicas");
                                                        System.out.println("¿Cuántos bolsas quieres agregar?");
                                                        int nChicles=sc.nextInt();
                                                    
                                                        for(int i=0;i<nChicles;i++){
                                                          sc.nextLine();
                                                          System.out.println("Ingresa la cantidad de canicas en la bolsa");
                                                          int cantidadB=sc.nextInt();
                                                          sc.nextLine();
                                                          System.out.println("Ingresa el nombre de la bolsa de canicas");
                                                          String nombre=sc.nextLine();
                                                          System.out.println("Ingresa el tamaño de la canica");
                                                          int tamaño=sc.nextInt();
                                                          sc.nextLine();
                                                          System.out.println("Ingresa la marca de la canica");
                                                          String marca=sc.nextLine();
                                                          System.out.println("Ingresa el color de tus canicas");
                                                          String color=sc.nextLine();
                                                          System.out.println("Ingresa el precio de bolsa de canicas");
                                                          int precio=sc.nextInt();
                                                          sc.nextLine();
                                                          System.out.println("Ingresa las existencias de tu bolsa de canicas");
                                                          int existencia=sc.nextInt();
                                                          sc.nextLine();
                                                          Canica chicle=new Canica(cantidadB,tamaño,nombre,color,precio,marca,existencia);
                                                          mostrador.agregarJuguete(chicle);
                                                          archivo.escribirOAgregar("productos.dat",chicle);
                                                        }
                                                        System.out.println("----------La bolsa de canicas ha sido agregada con exito----------");
                                                        System.out.println("Regresando");
                                                         }catch(Exception exception){
                                                        System.out.println("error intentalo de nuevo");
                                                        exception.printStackTrace();
                                                        sc.nextLine();
                                                    }
                                                    break;
                                                case 3:
                                                    try{
                                                    System.out.println("----------Seleccionaste agregar Rompecabeza.----------");
                                                    System.out.println("Mostrando requisitos para agregar rompecabeza");
                                                    System.out.println("¿Cuántos rompecabezas deseas agregar?");
                                                    int nChocolate=sc.nextInt();
                                                    for(int i=0;i<nChocolate;i++){
                                                        sc.nextLine();
                                                        System.out.println("Ingresa el número de piezas del rompecabeza");
                                                        int numPiezas=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa el nombre de tu rompecabeza");
                                                        String nombre=sc.nextLine();
                                                        System.out.println("Ingresa el color de tu rompecabeza");
                                                        String color=sc.nextLine();
                                                        System.out.println("Ingresa la marca de tu rompecabeza");
                                                        String marca=sc.nextLine();
                                                        System.out.println("Ingresa el precio de tu rompecabeza");
                                                        int precio=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa las Existencias de tu rompecabeza");
                                                        int existencia=sc.nextInt(); 
                                                        sc.nextLine();
                                                        Rompecabeza chocolate= new Rompecabeza(numPiezas,nombre,color,precio, marca,existencia);
                                                        mostrador.agregarJuguete(chocolate); 
                                                        archivo.escribirOAgregar("productos.dat",chocolate);
                                                    }
                                                    System.out.println("El rompecabeza se han agregado con exito");
                                                    System.out.println("Regresando");
                                                }catch(Exception exception){
                                                    System.out.println("Error intentalo de nuevo");
                                                    exception.printStackTrace();
                                                    sc.nextLine();
                                                    }
                                                    break;
                                                case 4:
                                                    try{
                                                    System.out.println("----------Seleccionaste agregar Bicicleta----------");
                                                    System.out.println("Mostrando requisitos para agregar Bicicleta");
                                                    System.out.println("¿Cuántas bicicletas deseas agregar?");
                                                    int nCookies=sc.nextInt();
                                                    for(int i=0;i<nCookies;i++){
                                                        sc.nextLine();
                                                        System.out.println("Ingrese el número de ruedas de su bicicleta");
                                                        int numRuedas=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingrese el tamaño o altura de su bicicleta");
                                                        int tamaño=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingrese el número de velocidades de su bicleta(Si no tiene velocidades coloque 0)");
                                                        int velocidades=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa la marca de la bicicleta");
                                                        String marca=sc.nextLine();
                                                        System.out.println("Ingresa el nombre de la bicicleta");
                                                        String nombre=sc.nextLine();
                                                        System.out.println("Ingresa el color de la bicicleta");
                                                        String color=sc.nextLine();
                                                        System.out.println("Ingresa el precio de la bicicleta");
                                                        int precio=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa las Existencias de la bicicleta");
                                                        int Existencia=sc.nextInt();
                                                        sc.nextLine();
                                                        Bicicleta cookie= new Bicicleta(numRuedas,tamaño,velocidades,nombre,color,precio, marca,Existencia);
                                                        mostrador.agregarJuguete(cookie); 
                                                        archivo.escribirOAgregar("productos.dat",cookie);
                                                    }
                                                    System.out.println("----------La Bicicleta se ha agregado con exito----------");
                                                    System.out.println("Regresando");
                                                    
                                                }catch(Exception exception){
                                                     System.out.println("Error intenta otra vez");
                                                     exception.printStackTrace();
                                                     sc.nextLine();
                                                    }
                                                    break;
                                                case 5:
                                                    try{
                                                    System.out.println("----------Seleccionaste agregar Peluche----------");
                                                    System.out.println("Mostrando requisitos para agregar Peluche");
                                                    System.out.println("¿Cuántos Peluches deseas agregar?");
                                                    int nPicos=sc.nextInt();
                                                    for(int i=0;i<nPicos;i++){
                                                        sc.nextLine();
                                                        System.out.println("Ingresa el material del que esta hecho tu peluche");
                                                        String tipoM=sc.nextLine();
                                                        System.out.println("Ingresa el tamaño de tu peluche");
                                                        int tamaño=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa la marca de tu peluche");
                                                        String marca=sc.nextLine();
                                                        System.out.println("Ingresa el nombre de tu peluche número");
                                                        String nombre=sc.nextLine();
                                                        System.out.println("Ingresa la forma de tu peluche");
                                                        String forma=sc.nextLine();
                                                        System.out.println("Ingresa el color del peluche");
                                                        String color=sc.nextLine();
                                                        System.out.println("Ingresa el precio del peluche");
                                                        int precio=sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.println("Ingresa las Existencia de tu peluche");
                                                        int existencia=sc.nextInt();
                                                        sc.nextLine();
                                                        Peluche picos= new Peluche(tipoM,tamaño,forma,nombre,color,precio, marca,existencia);
                                                        mostrador.agregarJuguete(picos); 
                                                        archivo.escribirOAgregar("productos.dat",picos);
                                                    }
                                                    System.out.println("----------El peluche se ha agregado con exito----------");
                                                    System.out.println("Regresando");
                                                    break; 
                                                }catch(Exception exception){
                                                    System.out.println("Error intenta otra vez");
                                                    exception.printStackTrace();
                                                    sc.nextLine();
                                                    }
                                                case 6:
                                                
                                                    System.out.println("Seleccionaste Regresar.");
                                                    System.out.println("Regresando al Menú anterior");
                                                    opcionMenuProductoAdmin=6;
                                                
                                                    break;
                                                             
                                                 default:
                                                    System.out.println("Intenta de nuevo.");
                                                    break;
                                                 }
                                            
                                            
                                                 
                                                
                                         }
                                         while(dulces!=6);
                                        break;
                                    case 4:
                                        
                                        System.out.println("Seleccionaste eliminar último Producto Agregado.");
                                        archivo.eliminarUltimoProducto("productos.dat");

                                        break;
                                    case 5:
                                        System.out.println("Seleccionaste Editar");
                                        List<Juguete> juguetes2 = archivo.listarObjetos("productos.dat");
                                        if(!juguetes2.isEmpty()){
                                            sc.nextLine();
                                            System.out.println("Productos tipo pelota que pueden ser editados");
                                            

                                            if(juguetes2.isEmpty()){
                                                System.out.println("No hay productos que listar");
                                            }else{
                                                
                                                System.out.println("Mostrando la lista de los productos");
                                                 for (Juguete j : juguetes2) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Existencia: " + j.getExistencia() +
                                                           ", Marca: " + j.getMarca() +
                                                           ", Precio: " + j.getPrecio()+", Color: " + j.getColor());
                                            }
                                            }
    
                                            System.out.println("Ingresa la marca del producto :");
                                            String nombreEditado=sc.nextLine();
                                            
                                            archivo.editarProductoPorMarca("productos.dat", nombreEditado, sc);

                                            
                                        }else
                                            System.out.println("No hay Productos que editar");
                                        
                                        break;
                                    case 6:
                                        System.out.println("Seleccionaste Regresar.");
                                        System.out.println("Regresando");
                                        break;
                                        
                                        
                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                    }
                                }while(opcionMenuProductoAdmin!=6);    
                                    break;
                                case 2:
                                    System.out.println("----------Seleccionaste Menú Cliente.----------");
                                    int judas=0;
                                    do{
                                        try{
                                          System.out.println("----------Mostrando el Menú de Cliente----------");
                                          System.out.println("1.- Listar Clientes. \n2.- Buscar Clientes.\n3.- agregar Cliente.\n4.-eliminar cliente.\n5.- Regresar.");
                                          judas=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("por favor ingresa un número entero");
                                            exception.printStackTrace();
                                            sc.nextLine();
                                          } 
                                            switch(judas){
                                                case 1:
                                                   System.out.println("----------Seleccionaste Listr Clientes.----------");
                                                    List<Cliente> juguetes = archivoClientes.listarObjetos("clientes.data");

                                                    if(juguetes.isEmpty()){
                                                    System.out.println("No hay productos que listar");
                                                }else{
                                                
                                                    System.out.println("Mostrando la lista de los Clientes");
                                                     for (Cliente j : juguetes) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Edad: " + j.getEdad() );
                                                        }  
                                                    }
                                                    break;
                                                case 2:
                                                    try {
                                                            System.out.println("----------Seleccionaste buscar Clientes.----------");
                                                            if (archivoClientes.listarObjetos("clientes.data").isEmpty()) {
                                                                System.out.println("No existen clientes disponibles");
                                                            } else {
                                                                System.out.println("Mostrando requisitos para buscar un Cliente");
                                                                sc.nextLine();
                                                                System.out.println("Por favor ingresa el nombre del cliente que deseas buscar:");
                                                                String buscadorC = sc.nextLine();
                                                                List<Cliente> listaClientes  = new ArrayList<>();
                                                                
                                                                listaClientes=archivoClientes.buscarClientePorNombre("clientes.data",buscadorC);
                                                                
                                                                
                                                                
                                                                for(Cliente cliente: listaClientes){
                                                                    System.out.println("---Datos del cliente---");
                                                                    System.out.println(cliente.getNombre());
                                                                    System.out.println(cliente.getEdad());
                                                                }
                                                                
                                                                if (buscadorC.length() < 3) {
                                                                    throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                                }
                                                        
                                                                
                                                            }
                                                        } catch (ACMilanException menorT) {
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                        }
                                                        break;
                                                case 3:
                                                    int cliMem;
                                                    System.out.println("Seleccionaste agregar Cliente.");        
                                                                try{
                                                                System.out.println("Elegiste agregar cliente.");
                                                                System.out.println("Mostrando requisitos para agregar Cliente ");
                                                                try{
                                                                System.out.println("Ingresa la cantidad de Cliente que quieres agregar:");
                                                                 cliMem=sc.nextInt();
                                                                sc.nextLine();
                                                            }catch(Exception ex){
                                                                System.out.println("La cantidad debe ser un número entero");
                                                                cliMem=-1;
                                                            }
                                                                for(int q=0;q<cliMem;q++){
                                                                  System.out.println("Ingrese el nombre del Cliente");
                                                                  String nombre=sc.nextLine();
                                                                  if(nombre.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                    
                                                                  System.out.println("Ingrese la edad del Cliente "+(q+1)+".");
                                                                  int edad=sc.nextInt();
                                                                  
                                                                  if(edad<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                        break;
                                                                    }
                                                                  sc.nextLine();
                                                                  System.out.println("Ingresa el correo del cliente");
                                                                  String correo=sc.nextLine();
                                                                  if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                  Cliente clienteMem=new Cliente (nombre, edad);
                                                                  //clientes.agregarClientes(clienteMem);
                                                                  archivoClientes.escribirOAgregar("clientes.data",clienteMem);
                                                                }
                                                             }catch(ACMilanException menorT){
                                                                System.out.println("nombre menor a tres letras");
                                                                menorT.printStackTrace();
                                                                sc.nextLine();
                                                            }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }
                                                    break;
                                                case 4:
                                                    System.out.println("Seleccionaste eliminar último Cliente Agregado.");
                                                    archivoClientes.eliminarUltimoProducto("clientes.data");

                                                    break;
                                                case 5:
                                                    System.out.println("Seleccionaste Regresar.");
                                                    System.out.println("Regresando");
                                                    break;
                                                default:
                                                    System.out.println("Intenta de nuevo.");
                                                    break;
                                            }
                                        }while(judas!=5);
                                    break;
                                case 3:
                                    System.out.println("Seleccionaste Menú Proveedor.");
                                    int rayo=0;
                                    do{
                                        try{
                                          System.out.println("Mostrando el Menú de proveedor...");
                                          System.out.println("1.-Listar Proveedores. \n2.-Buscar Proveedores.\n3.-agregar Proveedor.\n4.-eliminar último Proveedor. \n5.- Regresar.");
                                          rayo=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("ingrese un número entero");
                                            exception.printStackTrace();
                                            sc.nextLine();
                                        }    
                                        switch(rayo){
                                                case 1:
                                                    try{
                                                    System.out.println("Seleccionaste Listar Proveedores.");
                                                    List <Proveedor> proveedores =  new ArrayList<>();
                                                    proveedores=archivoProveedor.listarObjetos("proveedor.data");
                                                    if(proveedores.isEmpty()){
                                                    System.out.println("No se encuentra ningun proveedor");
                                                    }else{
                                                        for(Proveedor proveedor: proveedores){
                                                        System.out.println("-----Mostrando proveedor----");
                                                        System.out.println("Nombre: "+proveedor.getNombre());
                                                        System.out.println("Distrito: "+proveedor.getDistrito());
                                                        }
                                                    }
                                                    }catch(Exception ex){
                                                        System.out.println(ex);
                                                    }
                                                    break;
                                                case 2:
                                                       sc.nextLine();
                                                       try {
                                                        System.out.println("----------Seleccionaste buscar Proveedores.----------");
                                                        if (archivoProveedor.listarObjetos("proveedor.data").isEmpty()) {
                                                            System.out.println("No existen proveedores disponibles");
                                                        } else {
                                                            System.out.println("Mostrando requisitos para buscar un Proveedor");
                                                            System.out.println("Por favor ingresa el nombre del proveedor que deseas buscar:");
                                                    
                                                            String buscadorC = sc.nextLine();
                                                    
                                                            if (buscadorC.length() < 3) {
                                                                throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                            }
                                                    
                                                            List<Proveedor> listaProveedores = archivoProveedor.buscarProveedoresPorNombre("proveedor.data", buscadorC);
                                                    
                                                            if (listaProveedores.isEmpty()) {
                                                                System.out.println("No se encontraron proveedores con ese nombre.");
                                                            } else {
                                                                for (Proveedor proveedor : listaProveedores) {
                                                                    System.out.println("---Datos del Proveedor---");
                                                                    System.out.println("Nombre: " + proveedor.getNombre());
                                                                    System.out.println("Distrito: " + proveedor.getDistrito());
                                                                }
                                                            }
                                                        }
                                                    } catch (ACMilanException menorT) {
                                                        System.out.println(menorT.getMessage());
                                                        sc.nextLine(); // limpiar buffer si se lanza la excepción
                                                    }
                                                    break;


                                                case 3:
                                                    try{
                                                    System.out.println("----------Seleccionaste agregar un proveedor----------");
                                                    System.out.println("Mostrando requisitos para agregar proveedor");
                                                    System.out.println("¿Cuántos Proveedores deseas agregar?");
                                                    int numProvee=sc.nextInt();
                                                    sc.nextLine();
                                                    for(int r=0;r<numProvee;r++){
                                                        System.out.println("Ingrese el nombre de tu Proveedor");
                                                        String nombre=sc.nextLine();
                                                        if(nombre.length()<3){
                                                            throw new ACMilanException("");
                                                         }
                                                        System.out.println("Ingrese el distrito de tu Proveedor");
                                                        String distrito=sc.nextLine();
                                                        Proveedor patiwis=new Proveedor(nombre,distrito);
                                                        distribuidor.agregarProveedor(patiwis);
                                                        archivoProveedor.escribirOAgregar("proveedor.data",patiwis); 
                                                    }
                                                    System.out.println("El o los proveedores han sido añadidos exitosamente.");
                                                    System.out.println("Regresando");
                                                }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                }
                                                    break;
                                                case 4:
                                                    System.out.println("Seleccionaste eliminar último Proveedor Agregado.");
                                                    archivoProveedor.eliminarUltimoProveedor("proveedor.data");
                                                    break;
                                                case 5:
                                                    break;
                                            }
                                    }while(rayo!=5);
                                    break;
                                case 4:
                                    System.out.println("Seleccionaste Menú de Ventas");
                                    int opcionVentas=0;
                                    do{
                                        try{
                                          System.out.println("----------Mostrando el Menú de Ventas----------");
                                          System.out.println("1.-Listar ventas.\n2.-Buscar una venta.\n3.-Regresar.");
                                          opcionVentas=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("favor de ingresar un numero entero");
                                            exception.printStackTrace();
                                            sc.nextLine();                                       
                                        }
                                        switch(opcionVentas){
                                            case 1:
                                                System.out.println("----------Seleccionaste listar Ventas.----------");

                                                    List<Venta> listaVentas = archivoVenta.listarObjetos("ventas.data");
                                                    
                                                    if (listaVentas.isEmpty()) {
                                                        System.out.println("No hay ventas registradas.");
                                                    } else {
                                                        for (Venta venta : listaVentas) {
                                                            System.out.println("----- Venta -----");
                                                            System.out.println("ID: " + venta.getId());
                                                            System.out.println("Vendedor: " + venta.getVendedor().getNombre());
                                                            System.out.println("Cliente: " + venta.getCliente().getNombre());
                                                    
                                                            System.out.println("Detalles de venta:");
                                                            for (DetalleVenta detalle : venta.getVentas()) {
                                                                Juguete producto = detalle.getJuguetes();
                                                                System.out.println("  Producto: " + producto.getNombre());
                                                                System.out.println("  Cantidad: " + detalle.getCantidad());
                                                                System.out.println("  Marca: " + producto.getMarca());
                                                                System.out.println("  Precio: " + producto.getPrecio());
                                                                System.out.println("-------------------------");
                                                            }
                                                    
                                                            System.out.println("============================");
                                                        }
                                                    }

                                                break;
                                            case 2:
                                                try {
                                                        System.out.println("Seleccionaste Buscar Venta.");
                                                        List<Venta> ventas = archivoVenta.listarObjetos("ventas.data");
                                                    
                                                        if (!ventas.isEmpty()) {
                                                            System.out.println("Ingresa el ID de la venta que deseas buscar:");
                                                            int idBusqueda = sc.nextInt();
                                                    
                                                            Venta ventaEncontrada = archivoVenta.buscarVentaPorId("ventas.data", idBusqueda);
                                                    
                                                            if (ventaEncontrada != null) {
                                                                System.out.println("----- Venta Encontrada -----");
                                                                System.out.println("ID: " + ventaEncontrada.getId());
                                                                System.out.println("Vendedor: " + ventaEncontrada.getVendedor().getNombre());
                                                                System.out.println("Cliente: " + ventaEncontrada.getCliente().getNombre());
                                                    
                                                                System.out.println("Detalles de venta:");
                                                                for (DetalleVenta detalle : ventaEncontrada.getVentas()) {
                                                                    Juguete producto = detalle.getJuguetes();
                                                                    System.out.println("  Producto: " + producto.getNombre());
                                                                    System.out.println("  Cantidad: " + detalle.getCantidad());
                                                                    System.out.println("  Marca: " + producto.getMarca());
                                                                    System.out.println("  Precio: " + producto.getPrecio());
                                                                    System.out.println("-------------------------");
                                                                }
                                                    
                                                            } else {
                                                                System.out.println("No se encontró ninguna venta con ese ID.");
                                                            }
                                                        } else {
                                                            System.out.println("No hay ventas registradas.");
                                                        }
                                                    
                                                    } catch (Exception e) {
                                                        System.out.println("Error al buscar la venta.");
                                                        e.printStackTrace();
                                                        sc.nextLine(); 
                                                    }
                                                    break;
                                            case 3:
                                                System.out.println("Seleccionaste Regresar");
                                                break;
                                            default:
                                                System.out.println("Intenta de nuevo");
                                                break;
                                        }
                                    }while(opcionVentas!=3);
                                    break;
                                case 5:
                                    System.out.println("Seleccionaste Menú de Compras.");
                                    int opcionMenuCompras=0;
                                    do{
                                        try{
                                            System.out.println("----------Mostrando el Menú de Compras----------");
                                            System.out.println("1.-Listar compras.\n2.-Buscar una compra.\n3.-Regresar.");
                                            opcionMenuCompras=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("no puede ingresar ese caracter, por favor ingresar un numero entero");
                                            exception.printStackTrace();
                                            sc.nextLine();
                                        }
                                        switch(opcionMenuCompras){
                                                case 1:
                                                        System.out.println("----------Seleccionaste listar Compras.----------");
                                                        List<Compra> listaCompra = archivoCompra.listarCompras("compra.data");
                                                        
                                                        if (listaCompra.isEmpty()) {
                                                            System.out.println("No hay compras registradas.");
                                                        } else {
                                                            for (Compra compra : listaCompra) {
                                                                System.out.println("----- Compra -----");
                                                                System.out.println("ID: " + compra.getId());
                                                                System.out.println("Proveedor: " + compra.getProveedor().getNombre());
                                                                System.out.println("Empleado Almacén: " + compra.getEmpAlma().getNombre());
                                                        
                                                                System.out.println("Detalles de compra:");
                                                                for (DetalleCompra detalle : compra.getCompras()) {
                                                                    Juguete producto = detalle.getJuguetes();
                                                                    System.out.println("  Producto: " + producto.getNombre());
                                                                    System.out.println("  Cantidad: " + detalle.getCantidad());
                                                                    System.out.println("  Marca: " + producto.getMarca());
                                                                    System.out.println("  Precio: " + producto.getPrecio());
                                                                    System.out.println("-------------------------");
                                                                }
                                                                System.out.println("============================");
                                                            }
                                                        }
                                                    
                                                    break;
                                                case 2:
                                                    try {
                                                        System.out.println("Seleccionaste Buscar Compra.");
                                                        List<Compra> compras = archivoCompra.listarCompras("compra.data");
                                                    
                                                        if (!compras.isEmpty()) {
                                                            System.out.println("Mostrando los requisitos para buscar compra");
                                                            System.out.println("Por favor ingrese el id de su compra:");
                                                            int chocomint = sc.nextInt();
                                                    
                                                            Compra encontrada = archivoCompra.buscarCompraPorId("compra.data", chocomint);
                                                    
                                                            if (encontrada != null) {
                                                                System.out.println("Compra encontrada:");
                                                                System.out.println("ID: " + encontrada.getId());
                                                                System.out.println("Proveedor: " + encontrada.getProveedor().getNombre());
                                                                System.out.println("Empleado Almacén: " + encontrada.getEmpAlma().getNombre());
                                                    
                                                                System.out.println("Detalles de compra:");
                                                                for (DetalleCompra detalle : encontrada.getCompras()) {
                                                                    Juguete juguete = detalle.getJuguetes();
                                                                    System.out.println("  Producto: " + juguete.getNombre());
                                                                    System.out.println("  Marca: " + juguete.getMarca());
                                                                    System.out.println("  Precio: " + juguete.getPrecio());
                                                                    System.out.println("  Cantidad: " + detalle.getCantidad());
                                                                }
                                                    
                                                            } else {
                                                                System.out.println("No se ha podido encontrar la compra con ese ID.");
                                                            }
                                                    
                                                        } else {
                                                            System.out.println("Parece que no hay compras registradas.");
                                                        }
                                                    
                                                    } catch (Exception exception) {
                                                        System.out.println("Error");
                                                        exception.printStackTrace();
                                                        sc.nextLine();
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Seleccionaste Regresar.");
                                                    System.out.println("Regresando");
                                                    break;
                                            }
                                        
                                    }while(opcionMenuCompras!=3);
                                    break;
                                case 6:
                                    System.out.println("Seleccionaste Menú de Empleados");
                                    int opcionEmpleado=0;
                                    do{
                                        try{
                                            System.out.println("----------Ingresando al Menú empleados----------");
                                            System.out.println("1.-Listar Empleados.\n2.-Buscar Empleados.\n3.-Agregar Empleado.\n4.-Eliminar empleado.\n5.-Regresar.");
                                            opcionEmpleado=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("ingresar un numero entero");
                                            exception.printStackTrace();
                                            sc.nextLine();
                                         }
                                        switch(opcionEmpleado){
                                            case 1:
                                               System.out.println("Seleccionaste: Listar Empleados");
                                                System.out.println("Mostrando la lista de Empleados");
                                                
                                                List<Empleado> empleadosDos = archivoEmpleados.listarObjetos("empleado.data");
                                                
                                                if (!empleadosDos.isEmpty()) {
                                                    for (Empleado empleado : empleadosDos) {
                                                        System.out.println("=================================");
                                                        System.out.println("Nombre: " + empleado.getNombre());
                                                        System.out.println("Edad: " + empleado.getEdad());
                                                        System.out.println("Número de Empleado: " + empleado.getNumEmpleado());
                                                        System.out.println("Correo: " + empleado.getCorreo());
                                                
                                                        // Mostrar tipo específico de empleado
                                                        if (empleado instanceof Vendedor) {
                                                            Vendedor v = (Vendedor) empleado;
                                                            System.out.println("Tipo: Vendedor");
                                                            System.out.println("Caja: " + v.getNumCaja());
                                                            System.out.println("Sueldo por día: " + v.getSueldoPorDia());
                                                            System.out.println("Días trabajados: " + v.getDiasTrabajados());
                                                
                                                        } else if (empleado instanceof EmpleadoAlmacen) {
                                                            System.out.println("Tipo: Empleado de Almacén");
                                                
                                                        } else if (empleado instanceof RecursosHumanos) {
                                                            System.out.println("Tipo: Recursos Humanos");
                                                
                                                        } else if (empleado instanceof Desarrollador) {
                                                            System.out.println("Tipo: Desarrollador");
                                                
                                                        } else if (empleado instanceof Publicidad) {
                                                            System.out.println("Tipo: Publicidad");
                                                
                                                        } else {
                                                            System.out.println("Tipo: Empleado general");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("No existen empleados registrados.");
                                                }
                                                break;
                                            case 2:
                                                try {
                                                    sc.nextLine();
                                                    System.out.println("---------Seleccionaste: Buscar Empleados----------");
                                                
                                                    List<Empleado> lista = archivoEmpleados.listarObjetos("empleado.data");
                                                
                                                    if (!lista.isEmpty()) {
                                                        System.out.println("Ingresa el nombre del empleado que deseas buscar:");
                                                        String empleadoB = sc.nextLine();
                                                
                                                        if (empleadoB.length() < 3) {
                                                            throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                        }
                                                
                                                        List<Empleado> encontrados = archivoEmpleados.buscarEmpleadoPorNombre("empleado.data", empleadoB);
                                                
                                                        if (!encontrados.isEmpty()) {
                                                            System.out.println("Empleados encontrados:");
                                                            for (Empleado e : encontrados) {
                                                                System.out.println("==========================");
                                                                System.out.println("Nombre: " + e.getNombre());
                                                                System.out.println("Edad: " + e.getEdad());
                                                                System.out.println("Número de Empleado: " + e.getNumEmpleado());
                                                                System.out.println("Correo: " + e.getCorreo());
                                                            }
                                                        } else {
                                                            System.out.println("No se pudo encontrar al empleado.");
                                                        }
                                                    } else {
                                                        System.out.println("No hay empleados.");
                                                    }
                                                
                                                } catch (ACMilanException menorT) {
                                                    System.out.println("Nombre menor a tres letras.");
                                                    menorT.printStackTrace();
                                                    sc.nextLine();
                                                }

                                                break;
                                            case 3:
                                                System.out.println("Seleccionaste: agregar un empleado");
                                                int opcionagregar=0;
                                                do{
                                                    try{
                                                        System.out.println("----------Ingresando al menú de agregar empleado----------");
                                                        System.out.println("Por favor seleccione el tipo de empleado que desea agregar:");
                                                        System.out.println("1.-Empleado de Publicidad.\n2.-Empleado de Recursos Humanos.\n3.-Empleado Vendedor");
                                                        System.out.println("4.-Empleado de Almacen.\n5.-Desarrollador.\n6.-Salir");
                                                        opcionagregar=sc.nextInt();
                                                    }catch(Exception exception){
                                                        System.out.println("ingresar un numero entero"); 
                                                        exception.printStackTrace();
                                                        sc.nextLine();
                                                      }
                                                    switch(opcionagregar){
                                                        case 1:
                                                            try{
                                                            System.out.println("----------Seleccionaste: Empleado de Publicidad----------");
                                                            System.out.println("Mostrando los requisitos para agregar");
                                                            System.out.println("Ingresa la cantidad de empleados de Publicidad que quieres agregar:");
                                                            int empM=sc.nextInt();
                                                            for(int m=0;m<empM;m++){
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el nombre del empleado");
                                                                String nombrePubli=sc.nextLine();
                                                                if(nombrePubli.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                System.out.println("Ingresa la edad del empleado");
                                                                int edadPublicidad=sc.nextInt();
                                                                if(edadPublicidad<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                        break;
                                                                    }
                                                                System.out.println("Ingresa los años de experiencia del empleado");
                                                                int xpPublicidad=sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el suledo del empleado");
                                                                double sueldoPublicidad=sc.nextDouble();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa los días que trabajará el empleado");
                                                                int diasPublicidad=sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el número de empleado");
                                                                long numEmpMark=sc.nextLong();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el correo del empleado");
                                                                String correo=sc.nextLine();
                                                                if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                Empleado empPublicidad=new Publicidad(sueldoPublicidad,diasPublicidad,xpPublicidad,edadPublicidad,nombrePubli,numEmpMark,correo);
                                                                //empleados.agregarEmpleado(empPublicidad);
                                                                archivoEmpleados.escribirOAgregar("empleado.data",empPublicidad);
                                                            }  
                                                        }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                            }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }
                                                            break;
                                                        case 2:
                                                            try{
                                                            System.out.println("Seleccionaste: Empleado de Recursos Humanos.");
                                                            System.out.println("Mostrando los requisitos para agregar");
                                                            System.out.println("Ingresa la cantidad de empleados de Recursos Humanos que quieres agregar:");
                                                            int empRH=sc.nextInt();
                                                            for(int m=0;m<empRH;m++){
                                                                sc.nextLine();
                                                                System.out.println("----------Ingresa el nombre del empleado----------");
                                                                String nombreRecursos=sc.nextLine();
                                                                if(nombreRecursos.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                System.out.println("Ingresa la edad del empleado");
                                                                int edadRecursos=sc.nextInt();
                                                                if(edadRecursos<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                        break;
                                                                    }
                                                                System.out.println("Ingresa si tiene o no título(si/no)");
                                                                String titulo=sc.next();
                                                                boolean tieneTitulo=false;
                                                                if(titulo.equalsIgnoreCase("si"))
                                                                    tieneTitulo=true;
                                                                System.out.println("Ingresa el suledo por día del empleado");
                                                                double sueldoRH=sc.nextDouble();
                                                                System.out.println("Ingresa los días que trabajará el empleado");
                                                                int diasRH=sc.nextInt();
                                                                System.out.println("Ingresa el número de empleado"+(m+1)+".");
                                                                long numEmpRH=sc.nextLong();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el nombre del empleado"+(m+1)+".");
                                                                String correo=sc.nextLine();
                                                                if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                Empleado empleadoR=new RecursosHumanos(sueldoRH,diasRH,tieneTitulo,edadRecursos,nombreRecursos,numEmpRH,correo);
                                                                //empleados.agregarEmpleado(empleadoR);
                                                                archivoEmpleados.escribirOAgregar("empleado.data",empleadoR);
                                                            }
                                                        }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                        }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }
                                                            break;
                                                        case 3:
                                                            try{
                                                            System.out.println("----------Seleccionaste: Empleado Vendedor----------");
                                                            System.out.println("Mostrando los requisitos para agregar");
                                                            System.out.println("Ingresa la cantidad de Vendedores que deseas agregar:");
                                                            int empVendedor=sc.nextInt();
                                                            for(int m=0;m<empVendedor;m++){
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el nombre del empleado"+(m+1)+".");
                                                                String nombreVenta=sc.nextLine();
                                                                if(nombreVenta.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                System.out.println("Ingresa la edad del empleado"+(m+1)+".");
                                                                int edadVendedor=sc.nextInt();
                                                                if(edadVendedor<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                        break;
                                                                    }
                                                                System.out.println("Ingresa el número de caja del empleado"+(m+1)+".");
                                                                int numeroCaja=sc.nextInt();                                                  
                                                                System.out.println("Ingresa el suledo por día del empleado"+(m+1)+".");
                                                                double sueldoVen=sc.nextDouble();
                                                                System.out.println("Ingresa los días que trabajará el empleado"+(m+1)+".");
                                                                int diasVen=sc.nextInt();
                                                                System.out.println("Ingresa el número de empleado"+(m+1)+".");
                                                                long numeroEmpVen=sc.nextLong();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el correo del empleado"+(m+1)+".");
                                                                String correo=sc.nextLine();
                                                                if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                Empleado empGinko=new Vendedor(sueldoVen,diasVen,numeroCaja,edadVendedor,nombreVenta,numeroEmpVen,correo);
                                                                //empleados.agregarEmpleado(empGinko);
                                                                archivoEmpleados.escribirOAgregar("empleado.data",empGinko);
                                                            }
                                                        
                                                        }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                        }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }catch(Exception ex){
                                                            System.err.println(ex);
                                                            }
                                                            break;
                                                        case 4:
                                                            try{
                                                            System.out.println("----------Seleccionaste: Empleado de Almacen----------");
                                                            System.out.println("Mostrando los requisitos para agregar empleado Almacen");
                                                            System.out.println("Ingresa la cantidad de empleados de Almacen que desea agregar:");
                                                            int empAlmacen=sc.nextInt();
                                                            for(int mex=0;mex<empAlmacen;mex++){
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el nombre del empleado");
                                                                String nombreAlma=sc.nextLine();
                                                                if(nombreAlma.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                System.out.println("Ingresa la edad del empleado");
                                                                int edadAlmacen=sc.nextInt();
                                                                if(edadAlmacen<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                        break;
                                                                    }
                                                                System.out.println("Ingresa si el empleado maneja Monta Carga");
                                                                String montaMonta=sc.next();
                                                                boolean montaCarga=false;
                                                                if(montaMonta.equalsIgnoreCase("si"))
                                                                    montaCarga=true;
                                                                System.out.println("Ingresa el suledo por día del empleado");
                                                                double sueldoAlma=sc.nextDouble();
                                                                System.out.println("Ingresa los días que trabajará el empleado");
                                                                int diasAlma=sc.nextInt();
                                                                System.out.println("Ingresa el número de empleado");
                                                                long numEmpAlma=sc.nextLong();
                                                                sc.nextLine();
                                                                System.out.println("Ingresa el correo del empleado");
                                                                String correo=sc.nextLine();
                                                                if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                Empleado empAl=new EmpleadoAlmacen(sueldoAlma,diasAlma,montaCarga,edadAlmacen,nombreAlma,numEmpAlma,correo);
                                                               // empleados.agregarEmpleado(empAl);
                                                                archivoEmpleados.escribirOAgregar("empleado.data",empAl);
                                                            }
                                                        }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                        }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }
                                                            break;
                                                        case 5:
                                                            try{
                                                                System.out.println("----------Seleccionaste: Empleado Desarrollador----------");
                                                                System.out.println("Mostrando los requisitos para agregar empleado Desarollador");
                                                                System.out.println("Ingresa la cantidad de empleados Desarrollador que desea agregar:");
                                                                int madrid=sc.nextInt();
                                                                for(int Desa=0;Desa<madrid;Desa++){
                                                                    sc.nextLine();
                                                                    System.out.println("Ingresa el nombre del empleado");
                                                                    String nombreDesa=sc.nextLine();
                                                                    if(nombreDesa.length()<3){
                                                                        throw new ACMilanException("");
                                                                    }
                                                                    System.out.println("Ingresa la edad del empleado");
                                                                    int edadDesarrollador=sc.nextInt();
                                                                    if(edadDesarrollador<18){
                                                                        System.out.println("La edad debe ser igual o mayor a 18");
                                                                    }
                                                                    System.out.println("Ingresa la cantidad de lenguajes que domina el empleado");
                                                                    int languages=sc.nextInt();                                                  
                                                                    System.out.println("Ingresa el suledo por día del empleado");
                                                                    double sueldoDev=sc.nextDouble();
                                                                    System.out.println("Ingresa los días que trabajará el empleado");
                                                                    int diasDev=sc.nextInt();
                                                                    System.out.println("Ingresa el número de empleado");
                                                                    long numEmpDev=sc.nextLong();
                                                                    sc.nextLine();
                                                                    System.out.println("Ingresa el correo del empleado");
                                                                    String correo=sc.nextLine();
                                                                    if(!correo.contains("@")||!correo.contains(".com"))
                                                                    throw new ErrorCorreoException("Error corre invalido, intente de nuevo");
                                                                    Empleado goku=new Desarrollador(sueldoDev,diasDev,languages,edadDesarrollador,nombreDesa,numEmpDev,correo);
                                                                    //empleados.agregarEmpleado(goku);
                                                                    archivoEmpleados.escribirOAgregar("empleado.data",goku);
                                                                }
                                                            }catch(ACMilanException menorT){
                                                                System.out.println("nombre menor a tres letras");
                                                                menorT.printStackTrace();
                                                                sc.nextLine();
                                                            }catch(ErrorCorreoException correo){
                                                                System.out.println("olvido agregar un @ o un .com a su correo");
                                                            }
                                                            break;
                                                        case 6:
                                                            System.out.println("Seleccionaste: Regresar.");
                                                            System.out.println("Regresando");
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }while(opcionagregar!=6);
                                                break;
                                            case 4:
                                                System.out.println("Seleccionaste eliminar último Empleado Agregado.");
                                                archivoEmpleados.eliminarUltimoEmpleado("empleado.data");
                                                break;
                                            case 5:
                                                System.out.println("haz seleccionado: Regresar.");
                                                System.out.println("Regresando");
                                                break;
                                            default:
                                                System.out.println("Opcion invalida.Intentalo de nuevo");
                                                break;
                                                    }
                                    }while(opcionEmpleado!=5);
                                    break;
                                case 7:
                                    System.out.println("Regresando a la selección de Menú.");
                                    break;
                                default:
                                    System.out.println("Intentalo de nuevo");
                                    break;
                            }
                        }while(opcionAdmin!=7);
                        break;
                    case 2:
                        System.out.println("Seleccionaste Menú de Vendedor.");
                        int megatronusPrime=0;
                        do{
                            try{
                                System.out.println("Mostrando el Menú de Vendedor");
                                System.out.println("1.- Menú de productos. \n2.- Menú Clientes. \n3.- Realizar una venta. \n4.- Regresar.");
                                megatronusPrime=sc.nextInt();
                            }catch(Exception exception){
                                System.out.println("ingresar un numero entero");
                                exception.printStackTrace();
                                sc.nextLine();
                            }    
                            switch(megatronusPrime){
                                    case 1:
                                        System.out.println("Seleccionaste Menú de productos.");
                                        int menuProducto=0;
                                        do{
                                            try{
                                              System.out.println("Mostrando el Menú de productos");
                                              System.out.println("1.-Lista de Productos. \n2.-Buscar productos. \n3.- Regresar.");
                                              menuProducto=sc.nextInt();
                                            }catch(Exception exception){
                                                System.out.println("ingrese un numero entero");
                                                exception.printStackTrace();
                                                sc.nextLine();                                           
                                            }
                                            switch(menuProducto){
                                                case 1:
                                            System.out.println("Seleccionaste Listar Productos.");
                                            List<Juguete> juguetes = archivo.listarObjetos("productos.dat");

                                            if(juguetes.isEmpty()){
                                                System.out.println("No hay productos que listar");
                                            }else
                                                
                                                System.out.println("Mostrando la lista de los productos");
                                                 for (Juguete j : juguetes) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Existencia: " + j.getExistencia() +
                                                           ", Marca: " + j.getMarca() +
                                                           ", Precio: " + j.getPrecio()+", Color: " + j.getColor());
                                                    }
                                                //mostrador.listarJuguete();

                                            break;
                                        case 2:
                                                   try {
                                                        System.out.println("----------Seleccionaste buscar Producto.----------");
                                                        
                                                    
                                                        System.out.println("Mostrando requisitos para buscar");
                                                        sc.nextLine(); // limpiar buffer
                                                        System.out.println("Ingrese el nombre del producto que desea buscar:");
                                                        String buscarPro = sc.nextLine();
                                                    
                                                        if (buscarPro.length() < 3) {
                                                            throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                        }
                                                    
                                                        List<Juguete> resultados = archivo.buscarProductosPorNombre("productos.dat", buscarPro);
                                                    
                                                        if (!resultados.isEmpty()) {
                                                            System.out.println("—— Productos encontrados ——");
                                                            for (Juguete j : resultados) {
                                                                System.out.println("Nombre: " + j.getNombre());
                                                                System.out.println("Marca: " + j.getMarca());
                                                                System.out.println("Color: " + j.getColor());
                                                                System.out.println("Precio: " + j.getPrecio());
                                                                System.out.println("Existencia: " + j.getExistencia());
                                                                System.out.println("----------------------------");
                                                            }
                                                        } else {
                                                            System.out.println("No se encontró ningún producto con ese nombre.");
                                                        }
                                                    
                                                    } catch (ACMilanException menorT) {
                                                        System.out.println("Nombre menor a tres letras.");
                                                        menorT.printStackTrace();
                                                        sc.nextLine(); // limpiar buffer
                                                    }

                                                break;
                                                case 3:
                                                    System.out.println("Seleccionaste Regresar.");
                                                    System.out.println("Regresando");
                                                    break;
                                                default:
                                                    System.out.println("Intentalo de nuevo.");
                                                    break;
                                            }
                                            
                                        }while(menuProducto!=3);
                                        break;
                                    case 2:
                                        System.out.println("Seleccionaste Menú de Clientes.");
                                        int alex=0;
                                        do{
                                            try{
                                                System.out.println("Mostrando el Menú de Clientes");
                                                System.out.println("1.-Lista de Clientes. \n2.-Buscar Clientes. \n3.- Regresar.");
                                                alex=sc.nextInt();
                                            }catch(Exception exception){
                                                System.out.println("ingrese un numero entero");
                                                exception.printStackTrace();
                                                sc.nextLine();
                                            }
                                            switch(alex){
                                                case 1:
                                                   System.out.println("----------Seleccionaste Listr Clientes.----------");
                                                    List<Cliente> juguetes = archivoClientes.listarObjetos("clientes.data");

                                                    if(juguetes.isEmpty()){
                                                    System.out.println("No hay productos que listar");
                                                }else{
                                                
                                                    System.out.println("Mostrando la lista de los Clientes");
                                                     for (Cliente j : juguetes) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Edad: " + j.getEdad() );
                                                        }  
                                                    }
                                                    break;
                                                case 2:
                                                    try {
                                                            System.out.println("----------Seleccionaste buscar Clientes.----------");
                                                            if (archivoClientes.listarObjetos("clientes.data").isEmpty()) {
                                                                System.out.println("No existen clientes disponibles");
                                                            } else {
                                                                System.out.println("Mostrando requisitos para buscar un Cliente");
                                                                sc.nextLine();
                                                                System.out.println("Por favor ingresa el nombre del cliente que deseas buscar:");
                                                                String buscadorC = sc.nextLine();
                                                                List<Cliente> listaClientes  = new ArrayList<>();
                                                                
                                                                listaClientes=archivoClientes.buscarClientePorNombre("clientes.data",buscadorC);
                                                                
                                                                
                                                                
                                                                for(Cliente cliente: listaClientes){
                                                                    System.out.println("---Datos del cliente---");
                                                                    System.out.println(cliente.getNombre());
                                                                    System.out.println(cliente.getEdad());
                                                                }
                                                                
                                                                if (buscadorC.length() < 3) {
                                                                    throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                                }
                                                        
                                                                
                                                            }
                                                        } catch (ACMilanException menorT) {
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                        }
                                                        break;
                                                case 3:
                                                    System.out.println("Seleccionaste Regresar.");
                                                    System.out.println("Regresando");
                                                    break;
                                                default:
                                                    System.out.println("Intenta de nuevo.");
                                                    break;
                                            }
                                            
                                        }while(alex!=3);
                                        break;
                                    case 3:
                                            try {
                                                System.out.println("Seleccionaste Realizar venta.");
                                                System.out.println("Mostrando requisitos para Realizar una venta");
                                            
                                                System.out.println("Ingresa el id de venta:");
                                                int id = sc.nextInt();
                                                sc.nextLine();
                                            
                                                System.out.println("Ingresa el nombre del Vendedor:");
                                                String nombreVen = sc.nextLine();
                                                if (nombreVen.length() < 3) {
                                                    throw new ACMilanException("Nombre de vendedor demasiado corto");
                                                }
                                            
                                                List<Empleado> coincidencias = archivoEmpleados.buscarEmpleadoPorNombre("empleado.data", nombreVen);
                                                if (coincidencias.isEmpty()) {
                                                    throw new Exception("No se encontró ningún empleado con ese nombre");
                                                }
                                            
                                                Empleado empleado = coincidencias.get(0);
                                                if (!(empleado instanceof Vendedor)) {
                                                    throw new Exception("El empleado encontrado no es un Vendedor");
                                                }
                                                Vendedor seller = (Vendedor) empleado;
                                            
                                                System.out.println("Ingresa el nombre del Cliente:");
                                                String nombreCli = sc.nextLine();
                                                if (nombreCli.length() < 3) {
                                                    throw new ACMilanException("Nombre de cliente demasiado corto");
                                                }
                                            
                                                List<Cliente> encontrados = archivoClientes.buscarClientePorNombre("clientes.data", nombreCli);
                                                if (encontrados.isEmpty()) {
                                                    throw new Exception("No se encontró ningún cliente con ese nombre");
                                                }
                                                Cliente comprador = encontrados.get(encontrados.size() - 1);
                                            
                                                // Verificar si ya existe una venta con ese ID
                                                List<Venta> ventasExistentes = archivoVenta.listarObjetos("ventas.data");
                                                for (Venta v : ventasExistentes) {
                                                    if (v.getId() == id) {
                                                        System.out.println("Ya existe una venta con ID " + id + ". No se agregará.");
                                                        return;
                                                    }
                                                }
                                            
                                                System.out.println("¿Cuántos productos se vendieron?");
                                                int cantidadDulcesitos = sc.nextInt();
                                                DetalleVenta[] detalleVenta = new DetalleVenta[cantidadDulcesitos];
                                            
                                                for (int i = 0; i < cantidadDulcesitos; i++) {
                                                    sc.nextLine();
                                                    System.out.println("Ingrese el nombre del producto " + (i + 1) + ":");
                                                    String duls = sc.nextLine();
                                            
                                                    List<Juguete> encontradosdos = archivo.buscarProductosPorNombre("productos.dat", duls);
                                                    if (encontradosdos.isEmpty()) {
                                                        throw new Exception("No se encontró ningún producto con ese nombre");
                                                    }
                                            
                                                    Juguete ultimo = encontradosdos.get(encontradosdos.size() - 1);
                                            
                                                    System.out.println("Ingrese la cantidad vendida:");
                                                    int cantidadDul = sc.nextInt();
                                                    if (cantidadDul < 1) {
                                                        throw new Exception("Cantidad negativa no válida");
                                                    }
                                                    if (ultimo.getExistencia() < cantidadDul) {
                                                        throw new Exception("Existencia insuficiente");
                                                    }
                                            
                                                    // Crear detalle y actualizar existencia
                                                    DetalleVenta details = new DetalleVenta(cantidadDul, ultimo);
                                                    detalleVenta[i] = details;
                                            
                                                    ultimo.setExistencia(ultimo.getExistencia() - cantidadDul);
                                                    archivo.actualizarProductoExistenciaPorNombre("productos.dat", ultimo);
                                                }
                                            
                                                
                                                Venta ventita = new Venta(id, seller, comprador, detalleVenta);
                                                listaDeVentas.agregarVenta(ventita);
                                                archivoVenta.escribirOAgregarVenta("ventas.data", ventita);
                                                System.out.println("Venta registrada correctamente.");
                                            
                                            } catch (ACMilanException menorT) {
                                                System.out.println("nombre menor a tres letras");
                                                menorT.printStackTrace();
                                                sc.nextLine();
                                            } catch (Exception exception) {
                                                System.out.println("Error, intente de nuevo");
                                                exception.printStackTrace();
                                            }
                                        break;
                                    case 4:
                                        System.out.println("Seleccionaste Regresar.");
                                        System.out.println("Regresando");
                                        break;
                                    default:
                                        System.out.println("Intentalo de nuevo.");
                                        break;
                                }
                        }while(megatronusPrime!=4);
                        break;
                    case 3:
                        System.out.println("Seleccionaste Menú de EmpleadoAlmacen.");
                        int menuAlmacen=0;
                        do{
                            try{
                              System.out.println("Mostrando el Menú de EmpleadoAlmacen...");
                              System.out.println("1.- Menú Productos. \n2.- Menú Proveedores. \n3.- Realizar una compra. \n4.- Regresar.");
                              menuAlmacen=sc.nextInt();
                            }catch(Exception exception){
                                System.out.println("ingrese un número entero");
                                exception.printStackTrace();
                                sc.nextLine();
                            }
                            switch(menuAlmacen){
                                case 1:
                                    System.out.println("Seleccionaste Menú Productos.");
                                    int opcionAlmacen=0;
                                    do{
                                    try{    
                                      System.out.println("Mostrando el Menú de Producto.");
                                      System.out.println("1.-Listar Productos.\n2.-Buscar Productos.\n3.-Regresar.");
                                      opcionAlmacen=sc.nextInt();
                                    }catch(Exception exception){
                                        System.out.println("ingrese un numero entero");
                                        exception.printStackTrace();
                                        sc.nextLine();
                                    }
                                    switch(opcionAlmacen){
                                          case 1:
                                            System.out.println("Seleccionaste Listar Productos.");
                                            List<Juguete> juguetes = archivo.listarObjetos("productos.dat");

                                            if(juguetes.isEmpty()){
                                                System.out.println("No hay productos que listar");
                                            }else
                                                
                                                System.out.println("Mostrando la lista de los productos");
                                                 for (Juguete j : juguetes) {
                                                        System.out.println("Nombre: "+ j.getNombre()
                                                        +",Existencia: " + j.getExistencia() +
                                                           ", Marca: " + j.getMarca() +
                                                           ", Precio: " + j.getPrecio()+", Color: " + j.getColor());
                                                    }
                                                //mostrador.listarJuguete();

                                            break;
                                        case 2:
                                                   try {
                                                        System.out.println("----------Seleccionaste buscar Producto.----------");
                                                        
                                                    
                                                        System.out.println("Mostrando requisitos para buscar");
                                                        sc.nextLine(); // limpiar buffer
                                                        System.out.println("Ingrese el nombre del producto que desea buscar:");
                                                        String buscarPro = sc.nextLine();
                                                    
                                                        if (buscarPro.length() < 3) {
                                                            throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                        }
                                                    
                                                        List<Juguete> resultados = archivo.buscarProductosPorNombre("productos.dat", buscarPro);
                                                    
                                                        if (!resultados.isEmpty()) {
                                                            System.out.println("—— Productos encontrados ——");
                                                            for (Juguete j : resultados) {
                                                                System.out.println("Nombre: " + j.getNombre());
                                                                System.out.println("Marca: " + j.getMarca());
                                                                System.out.println("Color: " + j.getColor());
                                                                System.out.println("Precio: " + j.getPrecio());
                                                                System.out.println("Existencia: " + j.getExistencia());
                                                                System.out.println("----------------------------");
                                                            }
                                                        } else {
                                                            System.out.println("No se encontró ningún producto con ese nombre.");
                                                        }
                                                    
                                                    } catch (ACMilanException menorT) {
                                                        System.out.println("Nombre menor a tres letras.");
                                                        menorT.printStackTrace();
                                                        sc.nextLine(); // limpiar buffer
                                                    }

                                                break;
                                        
                                        case 3:
                                            System.out.println("Seleccionaste Regresar.");
                                            System.out.println("Regresando");
                                            break;
                                        default:
                                            System.out.println("Opcion invalida");
                                            break;
                                    }
                                }while(opcionAlmacen!=3);    
                                    break;
                                case 2:
                                    System.out.println("Seleccionaste Menú de Proveedores.");
                                    int bonieFacio=0;
                                    do{
                                            try{
                                            System.out.println("-------Mostrando el Menú de proveedor--------");
                                            System.out.println("1.-Listar Proveedores. \n2.-Buscar Proveedores.\n3.-agregar Proveedor.\n4.-eliminar Proveedor. \n5.- Regresar.");
                                            bonieFacio=sc.nextInt();
                                        }catch(Exception exception){
                                            System.out.println("EE");
                                            exception.printStackTrace();
                                            sc.nextLine();
                                        }
                                            switch(bonieFacio){
                                                case 1:
                                                    try{
                                                    System.out.println("Seleccionaste Listar Proveedores.");
                                                    List <Proveedor> proveedores =  new ArrayList<>();
                                                    proveedores=archivoProveedor.listarObjetos("proveedor.data");
                                                    if(proveedores.isEmpty()){
                                                    System.out.println("No se encuentra ningun proveedor");
                                                    }else{
                                                        for(Proveedor proveedor: proveedores){
                                                        System.out.println("-----Mostrando proveedor----");
                                                        System.out.println("Nombre: "+proveedor.getNombre());
                                                        System.out.println("Distrito: "+proveedor.getDistrito());
                                                        }
                                                    }
                                                    }catch(Exception ex){
                                                        System.out.println(ex);
                                                    }
                                                    break;
                                                case 2:
                                                    try {
                                                        System.out.println("----------Seleccionaste buscar Proveedores.----------");
                                                        if (archivoProveedor.listarObjetos("proveedor.data").isEmpty()) {
                                                            System.out.println("No existen proveedores disponibles");
                                                        } else {
                                                            System.out.println("Mostrando requisitos para buscar un Proveedor");
                                                            System.out.println("Por favor ingresa el nombre del proveedor que deseas buscar:");
                                                            String buscadorC = sc.nextLine();
                                                    
                                                            if (buscadorC.length() < 3) {
                                                                throw new ACMilanException("El nombre debe tener al menos 3 letras.");
                                                            }
                                                    
                                                            List<Proveedor> listaProveedores = archivoProveedor.buscarProveedoresPorNombre("proveedor.data", buscadorC);
                                                    
                                                            if (listaProveedores.isEmpty()) {
                                                                System.out.println("No se encontraron proveedores con ese nombre.");
                                                            } else {
                                                                for (Proveedor proveedor : listaProveedores) {
                                                                    System.out.println("---Datos del Proveedor---");
                                                                    System.out.println("Nombre: " + proveedor.getNombre());
                                                                    System.out.println("Distrito: " + proveedor.getDistrito());
                                                                }
                                                            }
                                                        }
                                                    } catch (ACMilanException menorT) {
                                                        System.out.println("nombre menor a tres letras");
                                                        menorT.printStackTrace();
                                                        sc.nextLine();
                                                    }
                                                    break;

                                                case 3:
                                                    try{
                                                    System.out.println("----------Seleccionaste agregar un proveedor----------");
                                                    System.out.println("Mostrando requisitos para agregar proveedor");
                                                    System.out.println("¿Cuántos Proveedores deseas agregar?");
                                                    int numProvee=sc.nextInt();
                                                    sc.nextLine();
                                                    for(int r=0;r<numProvee;r++){
                                                        System.out.println("Ingrese el nombre de tu Proveedor");
                                                        String nombre=sc.nextLine();
                                                        if(nombre.length()<3){
                                                            throw new ACMilanException("");
                                                         }
                                                        System.out.println("Ingrese el distrito de tu Proveedor");
                                                        String distrito=sc.nextLine();
                                                        Proveedor patiwis=new Proveedor(nombre,distrito);
                                                        distribuidor.agregarProveedor(patiwis);
                                                        archivoProveedor.escribirOAgregar("proveedor.data",patiwis); 
                                                    }
                                                    System.out.println("El o los proveedores han sido añadidos exitosamente.");
                                                    System.out.println("Regresando");
                                                }catch(ACMilanException menorT){
                                                            System.out.println("nombre menor a tres letras");
                                                            menorT.printStackTrace();
                                                            sc.nextLine();
                                                }
                                                    break;
                                                case 4:
                                                    System.out.println("Seleccionaste eliminar último Proveedor Agregado.");
                                                    archivoProveedor.eliminarUltimoProveedor("proveedor.data");
                                                    break;
                                                case 5:
                                                    break;
                                            }
                                    }while(bonieFacio!=5);
                                    break;
                                case 3:
                                    
                                    try {
                                            System.out.println("----------Seleccionaste Realizar una compra----------");
                                            System.out.println("Mostrando requisitos para Realizar una compra");
                                        
                                            System.out.println("Ingresa el id de la compra:");
                                            int idComparsa = sc.nextInt();
                                            sc.nextLine();
                                            int cantidad=0;
                                            Juguete producto=null;
                                        
                                            System.out.println("Ingresa el nombre del Proveedor:");
                                            String nombreProve = sc.nextLine();
                                            if (nombreProve.length() < 3) {
                                                throw new ACMilanException("Nombre de proveedor demasiado corto");
                                            }
                                            List<Proveedor> coincidencias = archivoProveedor.buscarProveedoresPorNombre("proveedor.data", nombreProve);
                                            if (coincidencias.isEmpty()) {
                                                throw new Exception("No se encontró ningún proveedor con ese nombre");
                                            }
                                            Proveedor seller = coincidencias.get(coincidencias.size() - 1);
                                        
                                            System.out.println("Ingresa el nombre del Empleado Almacén:");
                                            String MSN = sc.nextLine();
                                            if (MSN.length() < 3) {
                                                throw new ACMilanException("Nombre de empleado demasiado corto");
                                            }
                                            List<Empleado> coincidenciasDos = archivoEmpleados.buscarEmpleadoPorNombre("empleado.data", MSN);
                                            if (coincidenciasDos.isEmpty()) {
                                                throw new Exception("No se encontró ningún empleado con ese nombre");
                                            }
                                            Empleado empleado = coincidenciasDos.get(coincidenciasDos.size() - 1);
                                            if (!(empleado instanceof EmpleadoAlmacen)) {
                                                throw new Exception("El empleado encontrado no es un Empleado de almacén");
                                            }
                                            EmpleadoAlmacen sellerDos = (EmpleadoAlmacen) empleado;
                                        
                                            System.out.println("Ingresa la cantidad de productos que desea comprar:");
                                            int productos = sc.nextInt();
                                            if (productos < 1 || productos > 10) {
                                                throw new Exception("Debe comprar al menos 1 y como máximo 10 productos.");
                                            }
                                            DetalleCompra[] detallesCompras = new DetalleCompra[productos];
                                        
                                            for (int i = 0; i < productos; i++) {
                                                sc.nextLine();
                                                System.out.println("Ingrese el nombre del producto #" + (i + 1) + ":");
                                                String nombreProducto = sc.nextLine();
                                        
                                                List<Juguete> encontrados = archivo.buscarProductosPorNombre("productos.dat", nombreProducto);
                                                if (encontrados.isEmpty()) {
                                                    System.out.println("No se encontró ningún producto con ese nombre.");
                                                    i--;
                                                    continue;
                                                }
                                        
                                                producto = encontrados.get(encontrados.size() - 1);
                                                System.out.println("Producto encontrado: " + producto.getNombre() + " (Existencia actual: " + producto.getExistencia() + ")");
                                                System.out.println("Ingrese cuántas unidades desea comprar:");
                                                cantidad = sc.nextInt();
                                        
                                                if (cantidad < 1) {
                                                    System.out.println("Cantidad inválida. Intente de nuevo.");
                                                    i--;
                                                    continue;
                                                }
                                        
                                                

                                        
                                                detallesCompras[i] = new DetalleCompra(cantidad, producto);
                                            }
                                        
                                            Compra compra = new Compra(idComparsa, seller, detallesCompras, sellerDos);
                                            archivoCompra.escribirCompraSiNoExiste("compra.data", compra);      
                                            // Aumentar existencia
                                            archivo.actualizarProductoSumandoExistenciaDOS("productos.dat", producto, cantidad);
                                        } catch (ACMilanException e) {
                                            System.out.println("Error de validación: " + e.getMessage());
                                            e.printStackTrace();
                                        } catch (Exception e) {
                                            System.out.println("Error general: " + e.getMessage());
                                            e.printStackTrace();
                                        }   
                                    break;
                                case 4:
                                    System.out.println("Seleccionaste Regresar.");
                                    System.out.println("Regresando");
                                default:
                                    System.out.println("Intenta de nuevo.");
                            }
                        }while(menuAlmacen!=4);
                        break;
                    case 4:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Intenta de nuevo.");
                        break;
                }
        }while(opcion !=4);
    }
}