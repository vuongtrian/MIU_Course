package game;

public class Level3 extends UserLevel{

    private final int bonus = 2;

    public Level3(FFUser ffUser) {
        super(ffUser);
    }

    @Override
    public void addPoint(int point) {
        ffUser.setTotalPoints(ffUser.getTotalPoints() + (point*3) + bonus);
        checkForUpgrade();
    }

    @Override
    public String getLevel() {
        return "Level 3";
    }

    @Override
    public void checkForUpgrade() {
        if(ffUser.getTotalPoints() > 30) {
            ffUser.setTotalPoints(ffUser.getTotalPoints());
        }
    }
}
