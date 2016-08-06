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

    /**
     * @param n n can have three values : 0,1 and 2 . 0 means there is no user with that phone number . if 1 is passed to the method , it is understood that the password doesnot match phone numver . 2 : indicates that every thing for loging in is OK.
     */
    public static void RespondIUVTLI(int n,PrintWriter out){
        String command = "";
        switch (n){
            case 0 :
                command = "$SOR$ IUVTLIResponse notSignedUpYet $EOR$";
                break;
            case 1 :
                command = "$SOR$ IUVTLIResponse IncorrectPassword $EOR$";
                break;
            case 2 :
                command = "$SOR$ IUVTLIResponse OK $EOR$";
                break;
        }
        SendString ss = new SendString(command,out);
        ss.start();

    }
}
