package game;

public class Level2_5 extends UserLevel{

    private final int bonus = 1;

    public Level2_5(FFUser ffUser) {
        super(ffUser);
    }

    @Override
    public void addPoint(int point) {
        ffUser.setTotalPoints(ffUser.getTotalPoints() + point + bonus);
        checkForUpgrade();
    }

    @Override
    public String getLevel() {
        return "Level 2_5";
    }

    @Override
    public void checkForUpgrade() {
        if(ffUser.getTotalPoints() > 20) {
            ffUser.setUserLevel(new Level3(ffUser));
            ffUser.setTotalPoints(ffUser.getTotalPoints());
        }
    }
}
