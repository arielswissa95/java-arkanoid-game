import biuoop.DrawSurface;

import java.awt.*;

public class ScoreIndicator implements Sprite{
    private Counter score;

    public ScoreIndicator(Counter score){
        this.score=score;

    }
    @Override
    public void drawOn(DrawSurface d){
        d.setColor(Color.white);
        d.drawText(25, 40, "Score: " + score.getValue(), 16);
    }
    @Override
    public void timePassed(){

    }
}
