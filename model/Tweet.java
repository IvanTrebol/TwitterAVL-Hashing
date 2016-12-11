package model;

public class Tweet {
    long id;
    String text;
    User user;

    @Override
    public String toString() {
        return "@" + user.screen_name + " - " + text;
    }
}
