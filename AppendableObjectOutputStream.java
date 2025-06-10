import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// Evita que se escriba una nueva cabecera al agregar objetos
// Evita escribir la cabecera de nuevo si el archivo ya existe
public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset(); // omite la cabecera del stream
    }
}
