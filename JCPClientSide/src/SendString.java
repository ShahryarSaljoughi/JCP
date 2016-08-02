import java.io.PrintWriter;


/**
 * Created by shahryar_slg on 01/08/2016.
 */
public class  SendString extends Thread {
    private Thread t = null;
    private PrintWriter output;
    private String Command;


    public SendString(String command) {

        Command = command;
        this.output = socketStuff.printWriterStrm;
    }

    @Override
    public void run() {
        output.print(Command);
        output.flush();
    }

    @Override
    public synchronized void start() {
        t = new Thread(this);
        t.start();
    }
}