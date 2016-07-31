/**
 * Created by shahryar_slg on 27/07/2016.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class socketStuff {
    public static void main(String args[]) throws IOException {

        Socket clientSendSocket = new Socket("localhost",5001);
        Socket clientRecvSocket = new Socket ("localhost",5000);
        InputStream inStrm = clientRecvSocket.getInputStream();
        OutputStream outStrm = clientSendSocket.getOutputStream();
        PrintWriter printWriterStrm = new PrintWriter(outStrm);
        Scanner inScanner = new Scanner(inStrm);

        printWriterStrm.print(profile.me.getPhoneNumber());       //I want to send the phonenumber , just after each connection !
        printWriterStrm.flush();                                  // So that an onlineClient could be formed on the server side .

        while(true){
            
        }
    }

}
