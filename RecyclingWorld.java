import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)
import java.util.*;

public class RecyclingWorld extends MyWorld {
    private int score;
    private int lives;
    private int level;
    private int wasteCount;
    private int timer;
    private int timeLimit;
    private Player player;
    private String characterImage;
    private List<String> recyclingFacts;
    private int factIndex;
    private GreenfootSound backgroundMusic;
    private List<ArrayList> achievements;

    public RecyclingWorld(String characterImage) {    
        super(800, 600, 1);  
        this.characterImage = characterImage; 
        score = 0;
        lives = 3;
        level = 1;
        wasteCount = 3; 
        factIndex = 0;
        setLevelParameters();
        initializeFacts();
        prepare();
        showText("Score: " + score, 50, 50);
        showText("Lives: " + lives, 750, 50); 
        showText("Level: " + level, 400, 50);
        showText("Time: " + timer / 60, 400, 100);
        showText(recyclingFacts.get(factIndex), 400, 550);
        factIndex++;
        backgroundMusic= new GreenfootSound("background.wav");
        backgroundMusic.playLoop();
        
        
        }
    


    private void setLevelParameters() {
        switch(level) {
            case 1:
                setBackground("recyclingCenter.jpg");
                timeLimit = 600;
                break;
            case 2:
                setBackground("recyclingCenter2.jpg");
                timeLimit = 500;
                break;
            case 3:
                setBackground("recyclingCenter3.jpg");
                timeLimit = 400;
                break;
            default:
                setBackground("recyclingCenter.jpg");
                timeLimit = 600;
                break;
        }
        timer = timeLimit;
    }

    private void prepare() {
        player = new Player(characterImage);
        addObject(player, 400, 300);
        addBins();
        addObstacles();
        addEnemies();
        spawnWaste(wasteCount);
        spawnPowerUps();
    }

    private void addBins() {
        addObject(new RecyclingBin("paper"), 150, 500);
        addObject(new RecyclingBin("plastic"), 400, 500);
        addObject(new RecyclingBin("glass"), 650, 500);
    }

    private void addObstacles() {
        for (int i = 0; i < level + 2; i++) {
            addObject(new Obstacle(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }

    private void addEnemies() {
        for (int i = 0; i < level; i++) {
            addObject(new Enemy(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }

    private void spawnWaste(int count) {
        for (int i = 0; i < count; i++) {
            int type = Greenfoot.getRandomNumber(3);
            switch(type) {
                case 0: addObject(new Waste("paper"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
                case 1: addObject(new Waste("plastic"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
                case 2: addObject(new Waste("glass"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
                
            }
           
        }
    }
    

    private void spawnPowerUps() {
        int powerUpCount = Greenfoot.getRandomNumber(3) + 1;
        for (int i = 0; i < powerUpCount; i++) {
            int type = Greenfoot.getRandomNumber(2);
            switch(type) {
                case 0: addObject(new PowerUp("speed"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600)); break;
                case 1: addObject(new PowerUp("score"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600)); break;
            }
        }
    }

    public void addScore(int points) {
        score += points;
        showText("Score: " + score, 50, 50);
        if (score >= level * 50) { 
            level++;
            wasteCount++;
            showText("Level: " + level, 400, 50);
            if (level <= 3) {
                setLevelParameters();
                Greenfoot.setWorld(new TipScreen(this));
            } else {
                gameOver();
            }
        }
    }

    public void loseLife() {
        lives--;
        showText("Lives: " + lives, 750, 50);
        if (lives <= 0) {
            gameOver();
        }
    }

    private void gameOver() {
        showText("Game Over! Final Score: " + score, 400, 300);
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(score);
        Greenfoot.setWorld(leaderboard);
    }

    public void addLife() {
        lives++;
        showText("Lives: " + lives, 750, 50);
    }

    public void act() {
        if (timer > 0) {
            timer--;
            showText("Time: " + timer / 60, 400, 100);
            if (timer % 300 == 0 && factIndex < recyclingFacts.size()) {
                showText(recyclingFacts.get(factIndex), 400, 550);
                factIndex++;
            }
            if (timer % 600 == 0) {
                String question = "What can be recycled?";
                String[] options = {"Plastic", "Glass", "Paper", "All of the above"};
                Greenfoot.setWorld(new QuizScreen(this, question, options, 3));
            }
            spawnTimedBonus();
            
        } else {
            loseLife();
            timer = timeLimit;
        }
    }
    
    private void spawnTimedBonus() {
    if (Greenfoot.getRandomNumber(1000) < 1) { // 0.1% chance each act cycle
        addObject(new TimedBonus(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
}

    public void spawnNewWaste() {
        int type = Greenfoot.getRandomNumber(3);
        switch(type) {
            case 0: addObject(new Waste("paper"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
            case 1: addObject(new Waste("plastic"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
            case 2: addObject(new Waste("glass"), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400)); break;
        }
    }

    private void initializeFacts() {
        recyclingFacts = new ArrayList<>();
        recyclingFacts.add("Recycling one ton of paper saves 17 trees.");
        recyclingFacts.add("Plastic bottles take 450 years to decompose.");
        recyclingFacts.add("Recycling one glass bottle saves enough energy to power a light bulb for 4 hours.");
        recyclingFacts.add("Aluminum cans can be recycled indefinitely.");
        recyclingFacts.add("Recycling a single aluminum can saves enough energy to power a TV for 3 hours.");
        recyclingFacts.add("The first recycling program was introduced in 1690 in the United States.");
        recyclingFacts.add("Recycling helps reduce greenhouse gas emissions.");
        recyclingFacts.add("Recycling conserves natural resources such as timber, water, and minerals.");
        recyclingFacts.add("Recycling reduces the need for new landfills and incinerators.");
        recyclingFacts.add("Recycling helps protect the environment and wildlife.");
    }
}
