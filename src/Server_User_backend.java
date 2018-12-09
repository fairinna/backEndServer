import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Inna on 12/4/2018.
 */
public class Server_User_backend {

    private String userName, password;










    public Server_User_backend(InputStream inputStream) throws IOException {
        int userNameLength = inputStream.read();
        byte[] userNamebytes = new byte[userNameLength];
        int actualyRead;
        actualyRead = inputStream.read(userNamebytes);
        if(actualyRead != userNameLength)
            throw new IOException("InnaEx: Server_User_backend if(actualyRead != userNameLength)");
            this.userName = new String(userNamebytes);
         int userPasswordLength = inputStream.read();
         byte[] passwordsbytes = new byte[userPasswordLength];
         actualyRead = inputStream.read(passwordsbytes);
         if(actualyRead !=userPasswordLength) throw new IOException("InnaEx: Server_User_backend if(actualyRead !=userNameLength)");
            this.password = new String(passwordsbytes);

    }

    public Server_User_backend(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
