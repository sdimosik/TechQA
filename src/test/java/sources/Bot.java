package sources;

public class Bot {
    public final String username;
    public final String password;
    public final String profileUrl;
    public final String notesUrl;

    public Bot(String username, String password, String profileUrl) {
        this.username = username;
        this.password = password;
        this.profileUrl = profileUrl;
        this.notesUrl = profileUrl + "/statuses";
    }
}
