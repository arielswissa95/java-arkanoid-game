import biuoop.DrawSurface;

public class GameOverScreen implements Animation {
    private Counter score;

    public GameOverScreen(Counter score) {
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(200, 300, "Game Over. Your score is " + score.getValue(), 32);
        d.drawText(200, 350, "Press SPACE to exit", 28);
    }

    @Override
    public boolean shouldStop() {
        return false; // עוצרים עם KeyPressStoppableAnimation
    }
}
