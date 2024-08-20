import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class InitialScreen extends MyWorld {
    
    private GreenfootSound backgroundMusic;
    public InitialScreen() {    
        super(800, 600, 1); 
        showText("Welcome to the Recycling Game!", 400, 200);
        showText("Instructions: Drag and drop the waste items into the correct recycling bins.", 400, 250);
        showText("Paper to the Paper Bin, Plastic to the Plastic Bin, and Glass to the Glass Bin.", 400, 300);
        showText("Click 'Start' to begin.", 400, 350);
        addObject(new StartButton(), 400, 400);
        
        backgroundMusic=new GreenfootSound("background.wav");
        backgroundMusic.playLoop();
        
        InstructionButton instructionsButton = new InstructionButton();
        addObject(instructionsButton, getWidth() - 100, getHeight() - 50); // Position the button at an appropriate location
    }
    
}

class StartButton extends Actor {
    public StartButton() {
        setImage("startButton.jpg");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CharacterSelectionScreen());
        }
    }
}
