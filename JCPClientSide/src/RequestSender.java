/*
* this class will */

import java.util.List;

/**
 * Created by shahryar_slg on 02/08/2016.
 */
public class RequestSender {

    /*public static List<USER> getFriends(){}
    public static List<USER> getOnlineFriends(){}*/
    public static void sendTextMessage(Message message){
        /**
         * SOR  : stands for "start of request"
         * TextMessaage : helps the server to find out that this is a request for sending text message!
         * COTM : stands for "content of text message"
         * EOR : stands for "end of request"
         * */

        String command = " $SOR$ TextMessage "+
                message.getReceiver()+" "+
                message.getSender()+" "+
                "$COTM$"+" "+
                message.getContent()+" "+"$EOR$  ";

        SendString out = new SendString(command);
        out.start();
        try {
            out.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sendText(String text){
        String formattedText = " $SOR$ "+text+" $EOR$ ";
        SendString out = new SendString(text);
        out.start();
        try {
            out.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
