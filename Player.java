import greenfoot.*;

public class Player extends Actor {
    private Waste carriedWaste;
    private int speed;
    private int speedBoostTimer;

    public Player(String characterImage) {
        setImage(characterImage);
        speed = 10;
        speedBoostTimer = 0;
    }

    public void act() {
        movePlayer();
        checkForWaste();
        dropWaste();
        updateSpeedBoost();
        
        }
    

    private void movePlayer() {
        int dx = 0;
        int dy = 0;
        
        if (Greenfoot.isKeyDown("left")) {
            dx -= speed;
        }
        if (Greenfoot.isKeyDown("right")) {
            dx += speed;
        }
        if (Greenfoot.isKeyDown("up")) {
            dy -= speed;
        }
        if (Greenfoot.isKeyDown("down")) {
            dy += speed;
        }

        if (dx != 0 || dy != 0) {
            moveIfNoObstacle(dx, dy);
        }
    }

    private void moveIfNoObstacle(int dx, int dy) {
        int oldX = getX();
        int oldY = getY();
        setLocation(oldX + dx, oldY + dy);
        
        if (isTouching(Obstacle.class)) {
            setLocation(oldX, oldY); 
        }
    }

    public void increaseSpeed() {
        speed = 20;
        speedBoostTimer = 200; 
        Greenfoot.playSound("power_up.wav");
    }

    private void updateSpeedBoost() {
        if (speedBoostTimer > 0) {
            speedBoostTimer--;
            if (speedBoostTimer == 0) {
                speed = 10; 
            }
        }
    }

    private void checkForWaste() {
        if (carriedWaste == null) {
            Waste waste = (Waste) getOneObjectAtOffset(0, 0, Waste.class);
            if (waste != null && Greenfoot.isKeyDown("space")) {
                carriedWaste = waste;
                getWorld().removeObject(waste);
                Greenfoot.playSound("pickup.wav");
            }
        }
    }

    private void dropWaste() {
        if (carriedWaste != null && Greenfoot.isKeyDown("d")) {
            RecyclingWorld world = (RecyclingWorld) getWorld();
            world.addObject(carriedWaste, getX(), getY());
            carriedWaste = null;
            Greenfoot.playSound("drop.wav");
        }
    }
}
