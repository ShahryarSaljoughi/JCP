/**
 * Created by panizava on 30/07/2016.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 * har lahze momkene behesh ettela'at biad !
 * vali dar mavaghe moshakhas ettela'at mifreste ! */

public class ClientHandler extends Thread {
    private Socket clientSendSocket = null ;
    private Socket clientRecvSocket = null ;
    private InputStream InStrm = null;
    private OutputStream OutStrm = null;
    private PrintWriter PWOut = null;
    private java.util.Scanner ScnrIn = null;

    public ClientHandler(ClientAccessor client) throws IOException {
        //clientSendSocket = client.getClientSendSocket();
        //clientRecvSocket = client.getClientRecvSocket();
        //InStrm = clientRecvSocket.getInputStream();
        //OutStrm = clientSendSocket.getOutputStream();
        PWOut = client.getOut();
        ScnrIn = client.getIn();
    }

    @Override
    public void run() {
        String receivedString="" ;
        while (true){

            if (ScnrIn.hasNext()){

                //the code below will receiv the entire request!:
                assert (ScnrIn.next()=="$SOR$");
                while (ScnrIn.hasNext()){
                    String nextToken = ScnrIn.next();
                    receivedString = receivedString.concat(nextToken);
                    receivedString =receivedString.concat(" ");
                    if (nextToken == "$EOR$"){
                        break;
                    }
                    
                }
                //respond(receivedString);  // TODO: 02/08/2016  : implenet method respond ! 


            }
        }
    }
}
