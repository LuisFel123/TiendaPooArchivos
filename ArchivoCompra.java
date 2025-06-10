import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoCompra
{
     public void escribirOAgregar(String nombreArchivo, Compra compra) {
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

            out.writeObject(compra);
            out.close();

            System.out.println("Objeto guardado: " + compra.getId());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Compra> listarObjetos(String nombreArchivo) {
        List<Compra> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Compra compra = (Compra) in.readObject();
                    lista.add(compra);
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
    
    


        public void sobrescribirArchivo(String nombreArchivo, List<Compra> compra) {
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        
                for (Compra j : compra) {
                    out.writeObject(j);
                }
        
            } catch (IOException e) {
                System.out.println("Error al sobrescribir el archivo.");
                e.printStackTrace();
            }
        }


        public void eliminarUltimaCompra(String nombreArchivo) {
            List<Compra> lista = listarObjetos(nombreArchivo);
        
            if (lista.isEmpty()) {
                System.out.println("No hay productos para eliminar.");
                return;
            }
        
            Compra eliminado = lista.remove(lista.size() - 1); // eliminar el último
            sobrescribirArchivo(nombreArchivo, lista);
            
            System.out.println("Empleado eliminado:");
            System.out.println("Edad: " + eliminado.getId());
            System.out.println("Nombre: " + eliminado.getProveedor());
            System.out.println("Edad: " + eliminado.getCompras());
            System.out.println("Edad: " + eliminado.getEmpAlma());   
        }
          
        
        
        public List<Compra> buscarCompraPorId(String nombreArchivo, String nombreBuscado) {
            List<Compra> lista = listarObjetos(nombreArchivo);
            List<Compra> encontrados = new ArrayList<>();
        
            for (Compra j : lista) {
                if (j.getId().equalsIgnoreCase(nombreBuscado)) {
                    encontrados.add(j);
                }
            }
        
            return encontrados;
        }


}