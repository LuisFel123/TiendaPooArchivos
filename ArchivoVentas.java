import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoVenta
{
     public void escribirOAgregar(String nombreArchivo, Venta empleado) {
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

            out.writeObject(empleado);
            out.close();

            System.out.println("Objeto guardado: " + empleado.getNombre());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Empleado> listarObjetos(String nombreArchivo) {
        List<Empleado> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Empleado empleado = (Empleado) in.readObject();
                    lista.add(empleado);
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
    
    


        public void sobrescribirArchivo(String nombreArchivo, List<Empleado> empleado) {
            try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        
                for (Empleado j : empleado) {
                    out.writeObject(j);
                }
        
            } catch (IOException e) {
                System.out.println("Error al sobrescribir el archivo.");
                e.printStackTrace();
            }
        }


        public void eliminarUltimoEmpleado(String nombreArchivo) {
            List<Empleado> listaEmpleados = listarObjetos(nombreArchivo);
        
            if (listaEmpleados.isEmpty()) {
                System.out.println("No hay productos para eliminar.");
                return;
            }
        
            Empleado eliminado = listaEmpleados.remove(listaEmpleados.size() - 1); // eliminar el último
            sobrescribirArchivo(nombreArchivo, listaEmpleados);
            
            System.out.println("Empleado eliminado:");
            System.out.println("Edad: " + eliminado.getEdad());
            System.out.println("Nombre: " + eliminado.getNombre());
            System.out.println("Edad: " + eliminado.getNumEmpleado());
            System.out.println("Edad: " + eliminado.getCorreo());
        }
        
        
        
        public List<Empleado> buscarEmpleadoPorNombre(String nombreArchivo, String nombreBuscado) {
            List<Empleado> lista = listarObjetos(nombreArchivo);
            List<Empleado> encontrados = new ArrayList<>();
        
            for (Empleado j : lista) {
                if (j.getNombre().equalsIgnoreCase(nombreBuscado)) {
                    encontrados.add(j);
                }
            }
        
            return encontrados;
        }


}