package game;

public class Level1 extends UserLevel{
    public Level1(FFUser ffUser) {
        super(ffUser);
    }

    @Override
    public void addPoint(int point) {
        ffUser.setTotalPoints(ffUser.getTotalPoints() + point);
        checkForUpgrade();
    }

    @Override
    public String getLevel() {
        return "Level 1";
    }

    @Override
    public void checkForUpgrade() {
        if(ffUser.getTotalPoints() > 10) {
            ffUser.setUserLevel(new Level2(ffUser));
            ffUser.setTotalPoints(ffUser.getTotalPoints());
        }
    }
}
