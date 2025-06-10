import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoClientes
{
     public void escribirOAgregar(String nombreArchivo, Cliente cliente) {
        try {
            File archivo = new File(nombreArchivo);
            boolean existe = archivo.exists();

            FileOutputStream fileOut = new FileOutputStream(archivo, true);
            ObjectOutputStream out;

            if (existe && archivo.length() > 0) {
                // Si el archivo existe y tiene contenido, no escribimos cabecera
                out = new AppendableObjectOutputStream(fileOut);
            } else {
                // Archivo nuevo o vacío: se escribe cabecera
                out = new ObjectOutputStream(fileOut);
            }

            out.writeObject(cliente);
            out.close();

            System.out.println("Objeto guardado: " + cliente.getNombre());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Cliente> listarObjetos(String nombreArchivo) {
        List<Cliente> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Cliente cliente = (Cliente) in.readObject();
                    lista.add(cliente);
                } catch (EOFException eof) {
                    break; // fin del archivo
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los objetos del archivo.");
            e.printStackTrace();
        }

        return lista;
    }
    
    
    
     public List<Cliente> buscarClientePorNombre(String nombreArchivo, String nombreBuscado) {
        List<Cliente> lista = listarObjetos(nombreArchivo);
        List<Cliente> encontrados = new ArrayList<>();
    
        for (Cliente j : lista) {
            if (j.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrados.add(j);
            }
        }
           
        return encontrados;
    }
    

   
    public void sobrescribirArchivo(String nombreArchivo, List<Cliente> cliente) {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
    
            for (Cliente j : cliente) {
                out.writeObject(j);
            }
    
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo.");
            e.printStackTrace();
        }
    }


    public void eliminarUltimoProducto(String nombreArchivo) {
        List<Cliente> lista = listarObjetos(nombreArchivo);
    
        if (lista.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }
    
        Cliente eliminado = lista.remove(lista.size() - 1); // eliminar el último
        sobrescribirArchivo(nombreArchivo, lista);
    
        System.out.println("Cliente eliminado:");
        
        System.out.println("Nombre: " + eliminado.getNombre());
        
        System.out.println("Edad: " + eliminado.getEdad());
    }



}