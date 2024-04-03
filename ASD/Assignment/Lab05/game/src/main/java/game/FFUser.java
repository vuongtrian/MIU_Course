package game;

import java.util.Random;

public class FFUser {
    private int totalPoints;
    private UserLevel userLevel;

    public FFUser(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void play() {
        Random random = new Random();
        getUserLevel().addPoint(random.nextInt(7));
        System.out.println("points="+getTotalPoints()+" level="+getUserLevel().getLevel());
    }
}
