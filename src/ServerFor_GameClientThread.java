import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Inna on 12/6/2018.
 */
public class ServerFor_GameClientThread extends Thread {
    public static final int OK = 200;
    public static final int FAILURE = 500;
    public static final int NOLOGIN = 205;
    public static final int NEW_GAME = 104;
    public static final int SHOW_ACTIVE_PLAYERS = 105;
    public static final int JOIN_TO_CURRENT_GAME = 106;

    private Socket socket_client;
    private InputStream inputStream;
    private OutputStream outputStream;



    @Override
    public void run() {
        try {
            inputStream = socket_client.getInputStream();
            outputStream = socket_client.getOutputStream();
            int action = inputStream.read();
            switch (action){
                case NEW_GAME:
                    starNewGame();
                    //new game
                    break;
                case SHOW_ACTIVE_PLAYERS:
showActivePlayers();
                    break;
                case JOIN_TO_CURRENT_GAME:
                    break;


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showActivePlayers() {
        System.out.println("show active plaers");
    }


    private void starNewGame() {
        System.out.println("Enter new game");

    }
}
