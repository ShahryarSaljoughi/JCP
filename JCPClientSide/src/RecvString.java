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
    public RecvString(Scanner input) {

        this.input = socketStuff.inScanner;
    }

    public String getData() {
        return data;
    }

    public boolean isDataReceived() {
        return isDataReceived;
    }

    @Override
    public void run() {
        while (input.hasNext()){
            String nextToken = input.next().toLowerCase();
            if (nextToken!= "endofdata") { // i want to hava the whole string together ! not splited !! so ...
                data =  data.concat(nextToken);
                data = data.concat(" ");
            }
            else{
                break;
            }
        }
        isDataReceived = true;
    }

    @Override
    public synchronized void start() {
        Thread t= new Thread(this);
        t.start();
    }
}
