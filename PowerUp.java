import greenfoot.*;

public class PowerUp extends Actor {
    private String type;

    public PowerUp(String type) {
        this.type = type;
        setImage(type + "PowerUp.jpg");
    }

    public void act() {
        checkForPickup();
    }

    private void checkForPickup() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            applyEffect(player);
            getWorld().removeObject(this);
            Greenfoot.playSound("power_up.wav");
        }
    }

    private void applyEffect(Player player) {
        RecyclingWorld world = (RecyclingWorld) getWorld();
        if (type.equals("speed")) {
            player.increaseSpeed();
        } else if (type.equals("score")) {
            world.addScore(40);
        }
    }
}
