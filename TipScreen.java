import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class TipScreen extends MyWorld {
    private RecyclingWorld nextLevel;

    public TipScreen(RecyclingWorld nextLevel) {    
        super(800, 600, 1); 
        this.nextLevel = nextLevel;
        showText("Did you know?", 400, 200);
        showText("Recycling one ton of paper saves 17 trees!", 400, 250);
        showText("Click to continue.", 400, 300);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(nextLevel);
        }
    }
}
