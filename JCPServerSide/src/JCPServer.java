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
    private Socket ClientSendSocket;
    private Socket ClientRecvSocket;
    private String phonenumber;

    public ClientAccessor(Socket clientSendSocket,Socket clientRecvSocket, String phonenumber) {
        this.ClientRecvSocket = clientRecvSocket;
        this.ClientSendSocket = clientSendSocket;
        this.phonenumber = phonenumber;
    }

    public Socket getClientSendSocket() {
        return ClientSendSocket;
    }

    public void setClientSendSocket(Socket clientSendSocket) {
        ClientSendSocket = clientSendSocket;
    }

    public Socket getClientRecvSocket() {
        return ClientRecvSocket;
    }

    public void setClientRecvSocket(Socket clientRecvSocket) {
        ClientRecvSocket = clientRecvSocket;
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

    public static void main (String args[]) throws IOException {
        System.out.println(onlineClients.size());
        int LocalPort_SendSocket;
        int LocalPort_RecvSocket;
        ServerSocket ServerSendSocket = null;
        ServerSocket ServerRecvSocket = null;

        try {
            ServerSendSocket = new ServerSocket(5000);
        }
        catch (IOException e) {
            System.out.println("impossible to listen on ports 5000 ");
            try {
                ServerSendSocket = new ServerSocket(0);
            } catch (IOException e1) {
                System.out.println("sorry i can't set up the network");
                System.exit(0);
            }
        }

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
        System.out.println("the server's send socket is waiting on port "+
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

            if (in.hasNext()){
                onlineClients.add(
                        new ClientAccessor(
                                acceptSendSocket,acceptRecvSocket,in.next()));

            }else{
                System.out.println("client has not send any phonenumber!");
                System.exit(1);
            }

            System.out.println(onlineClients.size());

            System.out.println("connection was made ... ");
            System.out.println(
                    "connected from this inetAddress : "+acceptSendSocket.getInetAddress()
                            +" ,"+acceptSendSocket.getPort());


            /*ClientHandler CH = new ClientHandler(acceptSocket);
            Thread t = new Thread(CH);
            t.start();*/
        }


    }
}
