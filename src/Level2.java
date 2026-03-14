import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Level2 implements LevelInformation{
    private List<Block> blocks;

    public Level2() {
        blocks = new ArrayList<>();

        int tall = 100;
        int w;

        w = 720;
        for (int i = 0; i < 12; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.orange));
            w -= 60;
        }

        tall += 30;
        w = 720;
        for (int i = 0; i < 11; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.cyan));
            w -= 60;
        }

        tall += 30;
        w = 720;
        for (int i = 0; i < 10; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.green));
            w -= 60;
        }

        tall += 30;
        w = 720;
        for (int i = 0; i < 9; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.magenta));
            w -= 60;
        }

        tall += 30;
        w = 720;
        for (int i = 0; i < 8; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.red));
            w -= 60;
        }
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(4, 4));
        v.add(new Velocity(-4, 4));
        v.add(new Velocity(0, 5));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 9;
    }

    @Override
    public int paddleWidth() {
        return 140;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return new Background(new Color(20, 20, 60)); // כחול כהה
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks.size();
    }
}
