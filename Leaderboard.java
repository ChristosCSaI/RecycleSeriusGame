import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)
import java.util.*;

public class Leaderboard extends MyWorld {
    private List<Integer> highScores;

    public Leaderboard() {    
        
        highScores = new ArrayList<>();
        addObject(new StartButton(), 400, 550);
    }

    public void addScore(int score) {
        highScores.add(score);
        Collections.sort(highScores, Collections.reverseOrder());
        if (highScores.size() > 5) {
            highScores.remove(5);
        }
        showScores();
    }

    private void showScores() {
        showText("Leaderboard", 400, 50);
        for (int i = 0; i < highScores.size(); i++) {
            showText((i + 1) + ": " + highScores.get(i), 400, 100 + i * 50);
        }
    }
}
