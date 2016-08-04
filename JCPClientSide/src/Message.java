/**
 * Created by sahryar_slg on 30/07/2016.
 */

public class Message {
    private String sender;
    private String receiver ; // phonenumber will be saved in these two variables
    private String content ;
    private boolean seen ;
    private boolean sent;


    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.seen = false;
        this.sent=false;
    }


    //getter and setter :
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSeen() {
        return seen;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public boolean isSent() {
        return sent;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                ", seen=" + seen +
                ", sent=" + sent +
                '}';
    }
}
