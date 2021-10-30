package sources;

public class Bots {
    public static class Bot {

        public final String username;
        public final String password;
        public final String url;

        public Bot(String username, String password, String url) {
            this.username = username;
            this.password = password;
            this.url = url;
        }
    }

    public static final Bot number1 = new Bot("TechoBot1", "TechnoPolis19", "https://ok.ru/profile/574152517460");
    public static final Bot number2 = new Bot("TechoBot3", "TechnoPolis19", "https://ok.ru/profile/577417727448");
}
