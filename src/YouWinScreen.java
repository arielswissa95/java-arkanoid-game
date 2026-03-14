import biuoop.DrawSurface;

public class YouWinScreen implements Animation{
    private Counter score;

    public YouWinScreen(Counter score) {
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(220, 300, "You Win! Your score is " + score.getValue(), 32);
        d.drawText(200, 350, "Press SPACE to exit", 28);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
