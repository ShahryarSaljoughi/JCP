import java.util.Scanner;

/**
 * Created by shahryar_slg on 01/08/2016.
 */
public class RecvString extends Thread {
    private Scanner input;
    private String data = "" ;
    private Thread t;
    private boolean isDataReceived = false;

    //constructor :
    public RecvString() {  //parameter : Scanner input

        this.input = socketStuff.inScanner;
    }

    public String getData() {
        return data;
    }

    public boolean isDataReceived() {
        return isDataReceived;
    }



    @Override
    public synchronized void run() {

        boolean hasnext = input.hasNext();
        if(hasnext){
            String nextToken = input.next();
            while(!nextToken.contains("$EOR$")){
                data = data.concat(nextToken);
                data = data.concat(" ");
                nextToken=input.next();
            }
            data = data.concat(nextToken);
        }

        System.out.println("received : " + data);
        isDataReceived = true;

        /*

        while (input.hasNext()){

            String nextToken = input.next();
            if(nextToken.contains("$SOR$")){
                data = "";
            }
            if (!nextToken.contains("$EOR$")) { // i want to hava the whole string together ! not splited !! so ...
                data =  data.concat(nextToken);
                data = data.concat(" ");
            }

            else{
                data.concat(nextToken);
                System.out.println("reached end of the request!");
                break;
            }
        }
        */

    }

    @Override
    public synchronized void start() {
        Thread t= new Thread(this);
        t.start();
    }
}
