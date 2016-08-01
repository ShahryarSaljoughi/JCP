import java.util.Scanner;

/**
 * Created by shahryar_slg on 01/08/2016.
 */
public class RecvString implements Runnable {
    private Scanner input;
    private String data = null ;
    private boolean isDataReceived = false;
    public RecvString(Scanner input) {
        this.input = input;
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
                data =  data.concat(input.next().toLowerCase());
            }
            else{
                break;
            }
        }
        isDataReceived = true;
    }


}
