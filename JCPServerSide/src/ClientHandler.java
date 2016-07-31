import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by panizava on 30/07/2016.
 */
public class ClientHandler extends Thread {
    private Socket clientSocket = null;
    private InputStream InStrm;
    private OutputStream OutStrm;
    private PrintWriter PWOut;
    private java.util.Scanner ScnrIn;
    public ClientHandler(ClientAccessor client) throws IOException {

        /*his.clientSocket = client;
        InStrm = clientSocket.getInputStream();
        OutStrm = clientSocket.getOutputStream();
        PWOut = new PrintWriter(OutStrm);
        ScnrIn = new Scanner(InStrm);
        */
    }



}
