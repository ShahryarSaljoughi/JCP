import java.io.IOException;
import java.net.Socket;

/**
 * Created by panizava on 27/07/2016.
 */
public class socketStuff {
    public static void main(String args[]) throws IOException {
        Socket cliSocket = new Socket("localhost",3571);
        System.out.println(cliSocket.getPort());
        System.out.println(cliSocket.getLocalPort());
        System.out.println(cliSocket.getInetAddress());
        /*while ( true ){
        }*/
    }

}
