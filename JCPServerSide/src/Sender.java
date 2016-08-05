/**
 * Created by shahryar_slg on 05/08/2016.
 */

import java.io.PrintWriter;

/**
 * maybe there wan no need to make this class !
 * but i just wanted to make sure that all the stuff sent to clients are congruent with the protocol !
 */


public class Sender {

    // there is no need to include the name of the receiver in the sent string !
    //constructor :
    public static void sendMessage(Message message, PrintWriter out){
        String command="$SOR$ "
                +"ReceivedMessage "
                +"sender: "
                +message.getSender()
                +" $COTM$ "
                +message.getContent()
                +" $EOR$ ";



        SendString ss = new SendString(command,out);
        ss.start();
        try {
            ss.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
