import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

/**
 * Created by Inna on 12/4/2018.
 */
public class ServerFor_ClientThread extends Thread {

    public static final int SIGNUP = 202;
    public static final int LOGIN = 201;
    public static final int QUIT = 203;
    public static final int OK = 200;
    public static final int FAILURE = 500;
    public static final int NOLOGIN = 205;

    private Socket socket_client;
private InputStream inputStream;
private OutputStream outputStream;
private Map<String, Server_User_backend> mapOfUsersName;

public ServerFor_ClientThread(Socket socket, Map<String, Server_User_backend> mapOfUsersName){
    this.socket_client = socket;
    this.mapOfUsersName = mapOfUsersName;
}
    @Override
    public void run() {
        try {
            inputStream = socket_client.getInputStream();
            outputStream = socket_client.getOutputStream();
            int actionFromClient = inputStream.read();
            System.out.println(actionFromClient + "actionFromClient");

            switch (actionFromClient){
                case LOGIN:
                    loginCurrentUser();
                    break;
                case SIGNUP:
                    signUpNewUser();
                    break;
                case QUIT:
                    //quitFromSocket();
                    break;



            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void signUpNewUser() throws IOException {
        Server_User_backend newUser = new Server_User_backend(inputStream);
        boolean success = false;
        synchronized (mapOfUsersName){
            if(!mapOfUsersName.containsKey(newUser.getUserName())){
                mapOfUsersName.put(newUser.getUserName(), newUser);
                success = true;
            }
        }
        outputStream.write(success? OK : FAILURE);


    }

    private void loginCurrentUser() throws IOException {
    Server_User_backend serverUser = new Server_User_backend(inputStream);
    outputStream.write(checkUser(serverUser)? OK : NOLOGIN);

    }

    private boolean checkUser(Server_User_backend user_forCheck){
Server_User_backend isExisted = mapOfUsersName.get(user_forCheck.getUserName());
if(isExisted != null){
    if(user_forCheck.getPassword().equals(isExisted.getPassword())){
        return  true;
    }

}

        return false;
    }
}
