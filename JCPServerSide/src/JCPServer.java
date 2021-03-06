/**
 * Created by shahryar_slg on 28/07/2016.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class ClientAccessor{
    private Scanner in;
    private PrintWriter out;
    private String phonenumber;

    public ClientAccessor(Scanner in,PrintWriter out, String phonenumber) {
        this.in = in;
        this.out = out;
        this.phonenumber = phonenumber;
    }

    public Scanner getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

public class JCPServer {

    private static ArrayList<ClientAccessor> onlineClients = new ArrayList<>();

    public static ArrayList<ClientAccessor> getOnlineClients() {
        return onlineClients;
    }


    public static void main (String args[]) throws IOException {
        System.out.println(onlineClients.size());
        int LocalPort_SendSocket;
        int LocalPort_RecvSocket;
        ServerSocket ServerSendSocket = null;
        ServerSocket ServerRecvSocket = null;
        //send socket is listennig on port 5000
        try {
            ServerSendSocket = new ServerSocket(5000);
        }
        catch (IOException e) {
            System.out.println("impossible to listen on ports 5000 ");
            try {
                ServerSendSocket = new ServerSocket(0);
            } catch (IOException e1) {
                System.out.println("we got a problem !");
                System.exit(0);
            }
        }

        // the socket for receiving data is listaning on port 5001
        try {
            ServerRecvSocket = new ServerSocket(5001);
        }
        catch (IOException e) {
            System.out.println("impossible to listen on ports  5001");
            try {
                ServerRecvSocket = new ServerSocket(0);
            }
            catch (IOException e1) {
                System.out.println("sorry i can't set up the network");
                System.exit(0);
            }
        }

        LocalPort_RecvSocket = ServerRecvSocket.getLocalPort();
        LocalPort_SendSocket = ServerSendSocket.getLocalPort();
        System.out.println("the server's send socket is waiting on port "+
                                                LocalPort_SendSocket);
        System.out.println("the server's receive socket is waiting on port "+
                LocalPort_RecvSocket);

        while (true){

            Socket acceptSendSocket= null;
            Socket acceptRecvSocket = null;
            try {
                acceptSendSocket = ServerSendSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                acceptRecvSocket = ServerRecvSocket.accept();
            }catch(IOException e){
                e.printStackTrace();
            }

            Scanner in = new Scanner(acceptRecvSocket.getInputStream());
            PrintWriter out = new PrintWriter(acceptSendSocket.getOutputStream());
            ClientAccessor clientAccessor = null;
            if (in.hasNext()){
                String phonenumber = in.next();
                clientAccessor = new ClientAccessor(in,out,phonenumber);
                System.out.println("the phone number added to list is : "+phonenumber);
                onlineClients.add(clientAccessor);
            } else{
                System.out.println("client has not send any phonenumber!");
                System.exit(1);
            }


            System.out.println("connection was made ... ");
            assert acceptSendSocket != null ;
            System.out.println(
                    "connected from this inetAddress : "+acceptSendSocket.getInetAddress()
                            +" ,"+acceptSendSocket.getPort());

            System.out.print("there are online clients :");
            System.out.println(onlineClients.size());
            ClientHandler CH = new ClientHandler(clientAccessor);
            Thread t = new Thread(CH);
            t.start();
        }


    }
}
