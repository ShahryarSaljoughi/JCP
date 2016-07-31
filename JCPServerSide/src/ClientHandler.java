import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by panizava on 30/07/2016.
 */
public class ClientHandler extends Thread {
    private Socket clientSocket = null;
    private InputStream InStrm;
    private OutputStream OutStrm;
    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        InStrm = clientSocket.getInputStream();
        OutStrm = clientSocket.getOutputStream();
    }

}
