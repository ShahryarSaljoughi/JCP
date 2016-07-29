import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by panizava on 28/07/2016.
 */
public class socketStuff {
    public static void main (String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(3571);
        Socket acceptSocket= ss.accept();// this will be used to communicate with the client
        System.out.println("connection was made ... ");
        System.out.println("conncted to this inetAddress : "+acceptSocket.getInetAddress()
                                        +" ,"+acceptSocket.getPort());
    }
}
