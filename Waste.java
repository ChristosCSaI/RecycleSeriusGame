import greenfoot.*;

public class Waste extends Actor {
    private String type;
    private boolean isSpecial;

    public Waste(String type) {
        this(type, false);
    }

    public Waste(String type, boolean isSpecial) {
        this.type = type;
        this.isSpecial = isSpecial;
        if (isSpecial) {
            setImage(type + "Special.jpg");
        } else {
            setImage(type + ".jpg");
        }
    }

    public void act() {
        checkCorrectBin();
    }

    public String getType() {
        return type;
    }

    private void checkCorrectBin() {
        RecyclingWorld world = (RecyclingWorld) getWorld();
        RecyclingBin bin = (RecyclingBin) getOneIntersectingObject(RecyclingBin.class);
        
        if (bin != null && bin.getType().equals(type)) {
            if (isSpecial) {
                world.addScore(20);
                world.addLife();
                Greenfoot.playSound("correct.wav");
            } else {
                world.addScore(10);
                Greenfoot.playSound("correct.wav");
            }
            getWorld().removeObject(this);
            world.spawnNewWaste();
        } else if (bin != null) {
            world.addScore(-5);
            world.loseLife();
            Greenfoot.playSound("incorrect.wav");
            getWorld().removeObject(this);
            world.spawnNewWaste();
        }
    }
}
