import java.io.*;
import java.net.Socket;

public class Emulator extends Equipment {
    public static void main(String[] args) {
        Thread t = new Thread(new Client());
        t.start();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }
}
