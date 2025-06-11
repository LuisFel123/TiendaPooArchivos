import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.util.List;

/**
 * Write a description of class ArchivoVenta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArchivoVenta
{
public void escribirOAgregarVenta(String nombreArchivo, Venta nuevaVenta) {
    try {
        List<Venta> ventasExistentes = listarObjetos(nombreArchivo);
        for (Venta v : ventasExistentes) {
            if (v.getId() == nuevaVenta.getId()) {
                System.out.println("Ya existe una venta con ID " + nuevaVenta.getId() + ". No se agregará.");
                return;
            }
        }

        File archivo = new File(nombreArchivo);
        boolean existe = archivo.exists();

        FileOutputStream fileOut = new FileOutputStream(archivo, true);
        ObjectOutputStream out;

        if (existe && archivo.length() > 0) {
            out = new AppendableObjectOutputStream(fileOut);
        } else {
            out = new ObjectOutputStream(fileOut);
        }

        out.writeObject(nuevaVenta);
        out.close();

        System.out.println("Venta registrada: ID " + nuevaVenta.getId());

    } catch (IOException e) {
        System.out.println("Error al escribir/agregar la venta.");
        e.printStackTrace();
    }
}




public List<Venta> listarObjetos(String nombreArchivo) {
        List<Venta> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Venta juguete = (Venta) in.readObject();
                    lista.add(juguete);
                } catch (EOFException eof) {
                    break; 
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los objetos del archivo.");
            e.printStackTrace();
        }

        return lista;
    }

    public Venta buscarVentaPorId(String nombreArchivo, int idBuscado) {
    List<Venta> listaVentas = listarObjetos(nombreArchivo); 

    for (Venta v : listaVentas) {
        if (v.getId() == idBuscado) {
            return v;
        }
    }

    return null; 
}
    
    
}

