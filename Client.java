import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable {

    Socket socket = null;
    Thread t = null;
    String[] receiveDataArr;

    public Client() {
    }

    public void run() {
        String echo = null;
        while (true) {
            try {
                socket = new Socket("127.0.0.1", 3001);

                InputStream input = socket.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

                echo = bufferedReader.readLine();

                receiveDataArr = echo.replace("[", "").replace("]", "").split(", ");


                printInfo();

                bufferedReader.close();
                socket.close();
            } catch (IOException e) {
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void printInfo() {
        for (int i = 0; i < receiveDataArr.length; i++) {
            System.out.print(receiveDataArr[i] + " ");
        }

        System.out.println();
    }
}