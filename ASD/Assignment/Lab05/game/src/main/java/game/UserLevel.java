package game;

public abstract class UserLevel {
    protected final FFUser ffUser;

    public UserLevel(FFUser ffUser) {
        this.ffUser = ffUser;
    }

    public abstract void addPoint(int point);

    public abstract String getLevel();

    public abstract void checkForUpgrade();
}
