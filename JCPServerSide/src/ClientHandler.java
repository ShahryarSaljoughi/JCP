/**
 * Created by shahryar_slg on 30/07/2016.
 */

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.MemoryType;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * har lahze momkene behesh ettela'at biad !
 * vali dar mavaghe moshakhas ettela'at mifreste !
 * */

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

                String nextToken = ScnrIn.next();
                while (!nextToken.contains("$EOR$")){

                    receivedString = receivedString.concat(nextToken);
                    receivedString = receivedString.concat(" ");
                    System.out.println(nextToken);  //todo : delete
                    nextToken = ScnrIn.next();
                }
                receivedString=receivedString.concat(nextToken);
                System.out.println("exited the loop of reading !");
                respond(receivedString);
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

        Pattern textMessagePattern = Pattern.compile("\\$SOR\\$(.*?)\\$EOR\\$");
        Matcher m = textMessagePattern.matcher(request);
        System.out.println(m.matches());
        boolean congruentWithProtocol = m.matches(); //request.matches("\\$SOR\\$ TextMessage \\d{11} \\d{11} \\$COTM\\$.*?\\$EOR\\$");
        if (!congruentWithProtocol){
            System.out.println("the received request violates our protocol"); //todo : an exception should be thrown later
        }

        //recognize text message :
        if (request.matches("^ *\\$SOR\\$ TextMessage.*\\$COTM\\$.*\\$EOR\\$ *")){
            sendMessage(request);
        }

        //recognize if the received command is asking for login validation:
        if (request.matches(" *\\$SOR\\$ IUVTLI \\d{11} .*? *\\$EOR\\$")){
            loginValidation(request);
        }

    }

    private void loginValidation(String request) {
        Pattern pattern = Pattern.compile(" *\\$SOR\\$ IUVTLI \\d{11} (.*?)\\$EOR\\$");
        Matcher matcher = pattern.matcher(request);
        String phonenumber = null;
        String password = null;

        if(matcher.matches()){
            phonenumber = matcher.group(1);
            password = matcher.group(2);
        }
        boolean userexists = true;
        try {
            userexists = DatabaseDriver.userExists(phonenumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(userexists){



        }
        else{
            Sender.RespondIUVTLI(0,PWOut);
        }


    }

    public void sendMessage(String request){
        System.out.println("send message is running");
        Pattern pattern = Pattern.compile("\\$SOR\\$ TextMessage (\\d{11}) (\\d{11}) \\$COTM\\$(.*?)\\$EOR\\$");
        Matcher phoneNumbers = pattern.matcher(request);

        String sender = null;
        String receiver = null;
        String data = null ;
        boolean phoneNumbersFound = phoneNumbers.matches();
        if (phoneNumbersFound){
            receiver = phoneNumbers.group(1);
            sender = phoneNumbers.group(2);
            data = phoneNumbers.group(3);
        }
        Message message = new Message(sender,receiver,data);
        try {
            DatabaseDriver.addMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //now let's check if the receiver is online . if this is the case , i will forward the message to him;:
        List<ClientAccessor> onlineClients = JCPServer.getOnlineClients();
        ClientAccessor receiverCA = null;
        for (ClientAccessor ca : onlineClients){
            if(ca.getPhonenumber().trim().equals(receiver.trim())){
                receiverCA = ca;
                break;
            }
        }
        if(receiverCA!=null){
            Sender.sendMessage(message,receiverCA.getOut());
        }

    }
}
