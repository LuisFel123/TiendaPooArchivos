
/**
 * Write a description of class Archivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo
{
     public void escribirOAgregar(String nombreArchivo, Juguete juguete) {
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

            out.writeObject(juguete);
            out.close();

            System.out.println("Objeto guardado: " + juguete.getNombre());

        } catch (IOException e) {
            System.out.println("Error al escribir/agregar el objeto.");
            e.printStackTrace();
        }
    }
    
    
    
    
    public List<Juguete> listarObjetos(String nombreArchivo) {
        List<Juguete> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Juguete juguete = (Juguete) in.readObject();
                    lista.add(juguete);
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
    
    
    
    
    public void editarProductoPorMarca(String nombreArchivo, String marcaBuscada, Scanner sc) {
    List<Juguete> lista = listarObjetos(nombreArchivo);

    if (lista.isEmpty()) {
        System.out.println("No hay productos en el archivo.");
        return;
    }

    boolean encontrado = false;

    for (Juguete j : lista) {
        if (j.getMarca().equalsIgnoreCase(marcaBuscada)) {
            encontrado = true;

            System.out.println("\nProducto encontrado:");
            System.out.println("Nombre: " + j.getNombre());
            System.out.println("Marca: " + j.getMarca());
            System.out.println("Color: " + j.getColor());
            System.out.println("Precio: " + j.getPrecio());
            System.out.println("Existencia: " + j.getExistencia());

            int opcion = 0;
            do {
                try {
                    System.out.println("\n¿Qué deseas editar?");
                    System.out.println("1. Marca");
                    System.out.println("2. Color");
                    System.out.println("3. Precio");
                    System.out.println("4. Existencia");
                    System.out.println("5. Salir");
                    System.out.print("Opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); // limpiar salto de línea

                    switch (opcion) {
                        case 1:
                            System.out.print("Nueva marca: ");
                            j.setMarca(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nuevo color: ");
                            j.setColor(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Nuevo precio: ");
                            j.setPrecio(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 4:
                            System.out.print("Nueva existencia: ");
                            j.setExistencia(sc.nextInt());
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.println("Saliendo de la edición.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Intenta de nuevo.");
                    sc.nextLine(); // limpiar búfer
                }
            } while (opcion != 5);

            break; // solo editar el primer producto con esa marca
        }
    }

    if (encontrado) {
        sobrescribirArchivo(nombreArchivo, lista);
        System.out.println("Producto editado correctamente.");
    } else {
        System.out.println("No se encontró un producto con esa marca.");
    }
}


public void actualizarProductoExistenciaPorNombre(String nombreArchivo, Juguete productoActualizado) {
    List<Juguete> lista = listarObjetos(nombreArchivo);

    if (lista.isEmpty()) {
        System.out.println("No hay productos en el archivo.");
        return;
    }

    boolean actualizado = false;

    // Buscar por nombre y reemplazar el último que coincida
    for (int i = lista.size() - 1; i >= 0; i--) {
        Juguete j = lista.get(i);
        if (j.getNombre().equalsIgnoreCase(productoActualizado.getNombre())) {
            lista.set(i, productoActualizado); // reemplaza por el nuevo objeto con existencia modificada
            actualizado = true;
            break;
        }
    }

    if (actualizado) {
        sobrescribirArchivo(nombreArchivo, lista);
        System.out.println("Existencia actualizada correctamente en archivo.");
    } else {
        System.out.println("No se encontró un producto con ese nombre.");
    }
}


public void sobrescribirArchivo(String nombreArchivo, List<Juguete> juguetes) {
    try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

        for (Juguete j : juguetes) {
            out.writeObject(j);
        }

    } catch (IOException e) {
        System.out.println("Error al sobrescribir el archivo.");
        e.printStackTrace();
    }
}


public void eliminarUltimoProducto(String nombreArchivo) {
    List<Juguete> lista = listarObjetos(nombreArchivo);

    if (lista.isEmpty()) {
        System.out.println("No hay productos para eliminar.");
        return;
    }

    Juguete eliminado = lista.remove(lista.size() - 1); // eliminar el último
    sobrescribirArchivo(nombreArchivo, lista);

    System.out.println("Producto eliminado:");
    System.out.println("Nombre: " + eliminado.getNombre());
    System.out.println("Marca: " + eliminado.getMarca());
}



public List<Juguete> buscarProductosPorNombre(String nombreArchivo, String nombreBuscado) {
    List<Juguete> lista = listarObjetos(nombreArchivo);
    List<Juguete> encontrados = new ArrayList<>();

    for (Juguete j : lista) {
        if (j.getNombre().equalsIgnoreCase(nombreBuscado)) {
            encontrados.add(j);
        }
    }

    return encontrados;
}




public void actualizarProductoSumandoExistenciaDOS(String nombreArchivo, Juguete productoActualizado, int cantidadASumar) {
    List<Juguete> lista = listarObjetos(nombreArchivo);

    if (lista.isEmpty()) {
        System.out.println("No hay productos en el archivo.");
        return;
    }

    boolean actualizado = false;

    for (int i = lista.size() - 1; i >= 0; i--) {
        Juguete j = lista.get(i);
        if (j.getNombre().equalsIgnoreCase(productoActualizado.getNombre())) {
            j.setExistencia(j.getExistencia() + cantidadASumar);  // ✅ aquí se suma la existencia
            lista.set(i, j);
            actualizado = true;
            break;
        }
    }

    if (actualizado) {
        sobrescribirArchivo(nombreArchivo, lista);
        System.out.println("Existencia sumada correctamente en archivo.");
    } else {
        System.out.println("No se encontró un producto con ese nombre.");
    }
}


}