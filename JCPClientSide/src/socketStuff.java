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
    public static Scanner inScanner = null;
    public static PrintWriter printWriterStrm = null;
    public static boolean StaticsInitialized = false;

    public static boolean isStaticsInitialized() {
        return StaticsInitialized;
    }

    public static void setStaticsInitialized
            (boolean areStaticsInitialized) {
        StaticsInitialized = areStaticsInitialized;
    }

    public static void main(String args[]) throws IOException {

        Socket clientSendSocket = new Socket("localhost",5001);
        Socket clientRecvSocket = new Socket ("localhost",5000);
        InputStream inStrm = clientRecvSocket.getInputStream();
        OutputStream outStrm = clientSendSocket.getOutputStream();
        printWriterStrm = new PrintWriter(outStrm);
        inScanner = new Scanner(inStrm);
        setStaticsInitialized(true);

        /*
        printWriterStrm.print(profile.me.getPhoneNumber());       //I want to send the phonenumber , just after each connection !
        printWriterStrm.flush();                                  // So that an onlineClient could be formed on the server side .
        */
        SendString ssOut = new SendString(profile.me.getPhoneNumber());
        ssOut.start();


        /*
        Message message = new Message("09127401672","09142850025","salam . merC babate lotfi ke kardi :) ");
        RequestSender.sendTextMessage(message);
        */
        RequestSender.sendText("sigar , gahve , hooman , darya!!");

       while(true){

        }
    }

}
