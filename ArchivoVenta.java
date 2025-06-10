import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoVenta
{
     public void escribirOAgregar(String nombreArchivo, Venta venta) {
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

            out.writeObject(venta);
            out.close();

            System.out.println("Objeto guardado: " + venta.getVendedor());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Venta> listarObjetos(String nombreArchivo) {
        List<Venta> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Venta venta = (Venta) in.readObject();
                    lista.add(venta);
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
    
    


        public void sobrescribirArchivo(String nombreArchivo, List<Venta> venta) {
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        
                for (Venta j : venta) {
                    out.writeObject(j);
                }
        
            } catch (IOException e) {
                System.out.println("Error al sobrescribir el archivo.");
                e.printStackTrace();
            }
        }


        public void eliminarUltimaVenta(String nombreArchivo) {
            List<Venta> lista = listarObjetos(nombreArchivo);
        
            if (lista.isEmpty()) {
                System.out.println("No hay productos para eliminar.");
                return;
            }
        
            Venta eliminado = lista.remove(lista.size() - 1); // eliminar el último
            sobrescribirArchivo(nombreArchivo, lista);
            
            System.out.println("Empleado eliminado:");
            System.out.println("Edad: " + eliminado.getId());
            System.out.println("Nombre: " + eliminado.getVendedor());
            System.out.println("Edad: " + eliminado.getCliente());
            System.out.println("Edad: " + eliminado.getVentas());
        }
        
        
        
        public List<Venta> buscarVentaPorId(String nombreArchivo, String nombreBuscado) {
            List<Venta> lista = listarObjetos(nombreArchivo);
            List<Venta> encontrados = new ArrayList<>();
        
            for (Venta j : lista) {
                if (j.getId().equalsIgnoreCase(nombreBuscado)) {
                    encontrados.add(j);
                }
            }
        
            return encontrados;
        }


}