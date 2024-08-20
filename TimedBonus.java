import greenfoot.*;

public class TimedBonus extends Actor {
    public TimedBonus() {
        setImage("bonus.png");
    }

    public void act() {
        checkForPickup();
    }

    private void checkForPickup() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            RecyclingWorld world = (RecyclingWorld) getWorld();
            world.addScore(50);
            world.addLife();
            getWorld().removeObject(this);
        }
    }
}
