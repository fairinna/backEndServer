/**
 * Created by Inna on 12/9/2018.
 */
public class QwizWord {
    static String stringTocheck;
    public String currenWord;
     char currentChar;
    String word;
    Game_Server_Side_info game_server_side_info;


    public static void wordIn(Game_Server_Side_info game_server_side_info){
        if(stringTocheck == null)
            stringTocheck = game_server_side_info.getHollWord();

    }
    public String compareStrings(String stringCHar){
        StringBuilder sb = new StringBuilder();
        char[] arrString = new char[stringTocheck.toCharArray().length];
        arrString = stringTocheck.toLowerCase().toCharArray();
       char charIn = stringCHar.trim().charAt(0);
        for (int i = 0; i <arrString.length ; i++) {
            if(arrString[i] != charIn){
                String h = "-";
                sb.append(arrString[i] = (char) h.indexOf(0));
            }
            sb.append(arrString[i] = charIn);

        }
        currenWord = new String(sb);
       return currenWord;


    }


    public void isACharIn(Game_Server_Side_info game_server_side_info){

    }



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Game_Server_Side_info getGame_server_side_info() {
        return game_server_side_info;
    }

    public void setGame_server_side_info(Game_Server_Side_info game_server_side_info) {
        this.game_server_side_info = game_server_side_info;
    }
}
