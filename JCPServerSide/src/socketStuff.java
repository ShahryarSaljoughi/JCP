import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 * Created by panizava on 28/07/2016.
 */
public class socketStuff {
    private InputStream inStrm ;
    private OutputStream outStrm ;
    private ServerSocket ss;
    private Socket acceptSocket;
    public static void main (String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(3571);
        Socket acceptSocket= ss.accept();// this will be used to communicate with the client
        System.out.println("connection was made ... ");
        System.out.println(
                "connected to this inetAddress : "+acceptSocket.getInetAddress()
                                        +" ,"+acceptSocket.getPort());

    }
}
