import greenfoot.*;

public class Enemy extends Actor {

    public Enemy() {
        setImage("enemy.jpg");
    }

    public void act() {
        if (getWorld() != null) {
            followPlayer();
            checkForCollision();
        }
    }

    private void followPlayer() {
        Player player = (Player) getWorld().getObjects(Player.class).get(0);
        if (player != null) {
            turnTowards(player.getX(), player.getY());
            move(2);
        }
    }

    private void checkForCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            RecyclingWorld world = (RecyclingWorld) getWorld();
            world.loseLife();
            world.removeObject(this);
            Greenfoot.playSound("collision.wav"); // Play sound when enemy collides with player
        }
    }
}
