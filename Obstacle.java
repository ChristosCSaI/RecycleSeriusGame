import greenfoot.*;

public class Obstacle extends Actor {
    public Obstacle() {
        setImage("obstacle.jpg");  // Assuming you have an image named obstacle.jpg
        
    }

    public void act() {
        move();
    }

    private void move() {
        int y = getY() + 2; // Move downwards
        if (y >= getWorld().getHeight()) {
            y = 0; // Reset to the top
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), y);
        } else {
            setLocation(getX(), y);
        }
    }
}
