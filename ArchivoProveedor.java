import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoProveedor
{
     public void escribirOAgregar(String nombreArchivo, Proveedor proveedor) {
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

            out.writeObject(proveedor);
            out.close();

            System.out.println("Objeto guardado: " + proveedor.getNombre());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Proveedor> listarObjetos(String nombreArchivo) {
    List<Proveedor> lista = new ArrayList<>();

    try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
         ObjectInputStream in = new ObjectInputStream(fileIn)) {

        while (true) {
            try {
                Proveedor proveedor = (Proveedor) in.readObject();
                lista.add(proveedor);
            } catch (EOFException eof) {
                // Fin del archivo → salimos del while
                break;
            }
        }

    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al leer los objetos del archivo.");
        e.printStackTrace();
    }

    return lista;
}
    
    


    public void sobrescribirArchivo(String nombreArchivo, List<Proveedor> proveedor) {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
    
            for (Proveedor j : proveedor) {
                out.writeObject(j);
            }
    
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo.");
            e.printStackTrace();
        }
    }
    
    
    public void eliminarUltimoProveedor(String nombreArchivo) {
        List<Proveedor> lista = listarObjetos(nombreArchivo);
    
        if (lista.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }
    
        Proveedor eliminado = lista.remove(lista.size() - 1); // eliminar el último
        sobrescribirArchivo(nombreArchivo, lista);
    
        System.out.println("Producto eliminado:");
        System.out.println("Nombre: " + eliminado.getNombre());
        System.out.println("Marca: " + eliminado.getDistrito());
    }
    
    

    public List<Proveedor> buscarProveedoresPorNombre(String nombreArchivo, String nombreBuscado) {
        List<Proveedor> lista = listarObjetos(nombreArchivo);
        List<Proveedor> encontrados = new ArrayList<>();
    
        for (Proveedor j : lista) {
            if (j.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrados.add(j);
            }
        }
    
        return encontrados;
    } 
      
    
    }