import greenfoot.*;

public class RecyclingBin extends Actor {
    private String type;
    private int speed;

    public RecyclingBin(String type) {
        this.type = type;
        this.speed = Greenfoot.getRandomNumber(3) + 1; // Random speed between 1 and 3
        setImage(type + "Bin.jpg");  // Assuming you have images named paperBin.jpg, plasticBin.jpg, glassBin.jpg
        
    }

    public void act() {
        move();
    }

    private void move() {
        int x = getX() + speed;
        if (x > getWorld().getWidth() - 1 || x < 1) {
            speed = -speed; // Reverse direction
        }
        setLocation(x, getY());
    }

    public String getType() {
        return type;
    }
}
