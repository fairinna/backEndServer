import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Inna on 12/2/2018.
 */
public class Main_Server {
    public static final int PORT =7777;

    public static void main(String[] args) {


        ServerSocket serverSocket_Main_Server = null;

        try {
            serverSocket_Main_Server = new ServerSocket(PORT);
            System.out.println("serverSocket_Main_Server start at PORT: "+ PORT);
            Map<String, Server_User_backend> mapOfUsersName = new HashMap<>();
            ArrayList<String> wordFromClient = new ArrayList<String >();

            System.out.println( mapOfUsersName.isEmpty()+ "Before");
           readMapOfUsers(mapOfUsersName);


            while (true){
                Socket soket_server_side = serverSocket_Main_Server.accept();
                new ServerFor_ClientThread(soket_server_side, mapOfUsersName ).start();
                System.out.println("new server socket tread is start");
                readMapOfUsers(mapOfUsersName);
                System.out.println(mapOfUsersName.isEmpty()+"After");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
             if (serverSocket_Main_Server != null) {
                 try {
                     serverSocket_Main_Server.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }



    }
    private static void readMapOfUsers(Map<String, Server_User_backend> mapOfUsersName ){
        for( Map.Entry<String, Server_User_backend> map : mapOfUsersName.entrySet()){
            System.out.println(map.getKey()+": "+ map.getValue().getUserName()+ "pass: "+ map.getValue().getPassword());
        }
    }
    private  static void usersInLine(Map<String, Server_User_backend> mapOfUsersName){
        Set<String> keys = mapOfUsersName.keySet();


    }
}
