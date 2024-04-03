package game;

public class Level2 extends UserLevel{

    private final int bonus = 1;

    public Level2(FFUser ffUser) {
        super(ffUser);
    }

    @Override
    public void addPoint(int point) {
        ffUser.setTotalPoints(ffUser.getTotalPoints() + (point*2) + bonus);
        checkForUpgrade();
    }

    @Override
    public String getLevel() {
        return "Level 2";
    }

    @Override
    public void checkForUpgrade() {
        if(ffUser.getTotalPoints() > 15) {
            ffUser.setUserLevel(new Level2_5(ffUser));
            ffUser.setTotalPoints(ffUser.getTotalPoints());
        }
    }
}
