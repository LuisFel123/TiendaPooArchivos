import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * Write a description of class ArchivoVenta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArchivoVenta
{
        public void escribirOAgregarVenta(String nombreArchivo, Venta venta) {
    try {
        File archivo = new File(nombreArchivo);
        boolean existe = archivo.exists();

        FileOutputStream fileOut = new FileOutputStream(archivo, true);
        ObjectOutputStream out;

        if (existe && archivo.length() > 0) {
            out = new AppendableObjectOutputStream(fileOut);
        } else {
            out = new ObjectOutputStream(fileOut);
        }

        out.writeObject(venta);
        out.close();

        System.out.println("Venta registrada: ID " + venta.getId());

    } catch (IOException e) {
        System.out.println("Error al escribir/agregar la venta.");
        e.printStackTrace();
    }
}
}