import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class QuizScreen extends MyWorld {
    private RecyclingWorld recyclingWorld;
    private String question;
    private String[] options;
    private int correctAnswer;

    public QuizScreen(RecyclingWorld recyclingWorld, String question, String[] options, int correctAnswer) {    
        super(800, 600, 1); 
        this.recyclingWorld = recyclingWorld;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        prepare();
    }

    private void prepare() {
        showText(question, 400, 200);
        for (int i = 0; i < options.length; i++) {
            addObject(new OptionButton(options[i], i == correctAnswer, recyclingWorld), 400, 300 + i * 50);
        }
    }
}

class OptionButton extends Actor {
    private String optionText;
    private boolean isCorrect;
    private RecyclingWorld recyclingWorld;

    public OptionButton(String optionText, boolean isCorrect, RecyclingWorld recyclingWorld) {
        this.optionText = optionText;
        this.isCorrect = isCorrect;
        this.recyclingWorld = recyclingWorld;
        setImage(new GreenfootImage(optionText, 24, Color.BLACK, Color.WHITE));
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (isCorrect) {
                recyclingWorld.addScore(20);
                recyclingWorld.addLife();
            } else {
                recyclingWorld.loseLife();
            }
            Greenfoot.setWorld(recyclingWorld);
        }
    }
}

