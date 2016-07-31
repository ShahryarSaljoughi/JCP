import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by panizava on 28/07/2016.
 */


class ClientAccessor{
    private Socket ClientSocket;
    private String phonenumber;

    public ClientAccessor(Socket clientSocket, String phonenumber) {
        ClientSocket = clientSocket;
        this.phonenumber = phonenumber;
    }
    public Socket getClientSocket() {
        return ClientSocket;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setClientSocket(Socket clientSocket) {
        ClientSocket = clientSocket;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

public class JCPServer {

    private static ArrayList<ClientAccessor> onlineClients = new ArrayList<>();

    public static void main (String args[]) throws IOException {
        System.out.println(onlineClients.size());
        int LocalPort;
        ServerSocket ss = null;

        try {
            ss = new ServerSocket(3573);
        } catch (IOException e) {
            System.out.println("impossible to listen on port 3571");
            try {
                ss = new ServerSocket(0);
            } catch (IOException e1) {
                System.out.println("sorry i can't set up the network");
                System.exit(0);
            }

        }
        LocalPort = ss.getLocalPort();
        System.out.println("the server is waiting on port "+LocalPort);

        while (true){

            Socket acceptSocket= null;// this will be used to communicate with the client
            try {
                acceptSocket = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner in = new Scanner(acceptSocket.getInputStream());


            if (in.hasNext()){
                onlineClients.add(
                        new ClientAccessor(
                                acceptSocket,in.next()));

            }else{
                System.out.println("client has not send any phonenumber!");
                System.exit(1);
            }

            System.out.println(onlineClients.size());

            System.out.println("connection was made ... ");
            System.out.println(
                    "connected from this inetAddress : "+acceptSocket.getInetAddress()
                            +" ,"+acceptSocket.getPort());


            /*ClientHandler CH = new ClientHandler(acceptSocket);
            Thread t = new Thread(CH);
            t.start();*/
        }


    }
}
