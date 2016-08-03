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

    private PrintWriter PWOut = null;

    private java.util.Scanner ScnrIn = null;



    public ClientHandler(ClientAccessor client) throws IOException {

        System.out.println("client handler's constructor is running . "); // todo : delete this !

        PWOut = client.getOut();

        ScnrIn = client.getIn();

    }


    @Override
    public  void run() {

        String receivedString="" ;
        while (true){

            boolean hasnext = ScnrIn.hasNext();
            System.out.println(hasnext);
            if (hasnext ){
                System.out.println("if is running ");//todo : delete
                String nextToken = ScnrIn.next();
                System.out.println("this is the first received token : "+nextToken);

                while (!nextToken.contains("&EOR&")){

                    receivedString = receivedString.concat(nextToken);
                    receivedString = receivedString.concat(" ");
                    System.out.println(nextToken);  //todo : delete
                    nextToken = ScnrIn.next();
                }
                receivedString=receivedString.concat(nextToken);
                System.out.println("exited the loop of reading !");
                respond(receivedString);  // TODO: 02/08/2016  : implenet method respond !
                receivedString="";
            }
        }
    }

    @Override
    public synchronized void start() {
        System.out.println("start is running"); // todo : delete this !
        super.start();

    }

    private void respond(String request){

        System.out.println("responding to request : ");
        System.out.println(request);
    }
}
