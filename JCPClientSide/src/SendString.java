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
        assert socketStuff.isStaticsInitialized();
        this.output = socketStuff.printWriterStrm;

    }

    @Override
    public synchronized void run() {

        System.out.println("run method of SendString.java is running"); //todo : delete
        output.print(Command);
        output.flush();
        System.out.println("thread sending : " + Command + "is exiting" );

    }

    @Override
    public synchronized void start() {
        System.out.println("thread sending : " + Command + "is starting" );
        t = new Thread(this);
        t.start();
    }
}