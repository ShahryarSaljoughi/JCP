import java.io.PrintWriter;


/**
 * Created by shahryar_slg on 01/08/2016.
 */
public class SendString extends Thread {
    private Thread t = null;
    private PrintWriter output;
    private String Command;

    public SendString(PrintWriter output, String command) {

        Command = command;
    }

    @Override
    public void run() {
        output.print(Command);

    }

    @Override
    public synchronized void start() {
        t = new Thread(this);
        t.start();

    }
}
