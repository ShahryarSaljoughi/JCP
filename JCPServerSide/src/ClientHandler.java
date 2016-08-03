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

        System.out.println("client handler's constructor is running . "); // todo : delete this !

        clientSendSocket = client.getClientSendSocket();

        clientRecvSocket = client.getClientRecvSocket();

        InStrm = clientRecvSocket.getInputStream();

        OutStrm = clientSendSocket.getOutputStream();

        PWOut = new PrintWriter(OutStrm);

        ScnrIn = new Scanner(InStrm);

    }


    @Override
    public void run() {
        System.out.println("run method of ClientHandler is running ! "); // todo : delete this !
        String receivedString="" ;
        while (true){
            //System.out.print("ClinetHandler>  run() > ScnrIn.hasNext>  ");
            boolean hasnext = ScnrIn.hasNext();
            System.out.println(hasnext);
            if (hasnext){
                System.out.println("if is running ");//todo : delete
                //the code below will receiv the entire request!:
                assert (ScnrIn.next()=="$SOR$");
                while (ScnrIn.hasNext()){
                    System.out.println("inner while is running "); // todo : delete
                    String nextToken = ScnrIn.next();
                    receivedString = receivedString.concat(nextToken);
                    receivedString =receivedString.concat(" ");
                    System.out.println(receivedString);//todo : delete
                    if (nextToken == "$EOR$"){
                        System.out.println("reached end of request! ");
                        break;
                    }
                }
                respond(receivedString);  // TODO: 02/08/2016  : implenet method respond !
            }
        }
    }

    @Override
    public synchronized void start() {
        System.out.println("start is running"); // todo : delete this !
        super.start();

    }

    private void respond(String request){
        System.out.println("responding to request ");
        System.out.println(request);
    }
}
