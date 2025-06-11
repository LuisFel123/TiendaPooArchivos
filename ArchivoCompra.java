import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;

/**
 * Write a description of class ArchivoCompra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArchivoCompra
{
    
    public void escribirOAgregarVenta(String nombreArchivo, Compra compra) {
    try {
        File archivo = new File(nombreArchivo);
        boolean existe = archivo.exists();

        // Crea el archivo si no existe
        if (!existe) {
            archivo.createNewFile();
        }

        FileOutputStream fileOut = new FileOutputStream(archivo, true);
        ObjectOutputStream out;

        if (archivo.length() > 0) {
            out = new AppendableObjectOutputStream(fileOut); // clase personalizada para evitar cabecera duplicada
        } else {
            out = new ObjectOutputStream(fileOut);
        }

        out.writeObject(compra);
        out.close();

        System.out.println("Compra registrada: ID " + compra.getId());

    } catch (IOException e) {
        System.out.println("Error al escribir/agregar la compra.");
        e.printStackTrace();
    }
}

    
public void escribirCompraSiNoExiste(String nombreArchivo, Compra nuevaCompra) {
    List<Compra> comprasExistentes = listarCompras(nombreArchivo);

    for (Compra c : comprasExistentes) {
        if (c.getId() == nuevaCompra.getId()) {
            System.out.println("Ya existe una compra con ID " + nuevaCompra.getId() + ". No se agregará.");
            return;
        }
    }

    // Si no existe, la agregamos
    escribirOAgregarVenta(nombreArchivo, nuevaCompra);
}



public List<Compra> listarCompras(String nombreArchivo) {
    List<Compra> lista = new ArrayList<>();
    
    File archivo = new File(nombreArchivo);
    if (!archivo.exists()) {
        return lista; // archivo aún no existe
    }

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
        while (true) {
            Compra c = (Compra) in.readObject();
            lista.add(c);
        }
    } catch (EOFException e) {
        // Fin del archivo, se ignora
    } catch (Exception e) {
        System.out.println("Error al leer compras:");
        e.printStackTrace();
    }

    return lista;
}


public Compra buscarCompraPorId(String nombreArchivo, int idBuscado) {
    List<Compra> lista = listarCompras(nombreArchivo);

    for (Compra c : lista) {
        if (c.getId() == idBuscado) {
            return c;
        }
    }
    return null; // No se encontró
}


}