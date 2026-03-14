import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level1 implements LevelInformation{
    private List<Block> blocks;

    public Level1() {
        blocks = new ArrayList<>();

        int tall = 100;
        int w = 720;

        for (int i = 0; i < 12; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.yellow));
            w -= 60;
        }

        w = 720;
        tall += 30;
        for (int i = 0; i < 11; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.cyan));
            w -= 60;
        }

        w = 720;
        tall += 30;
        for (int i = 0; i < 10; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.green));
            w -= 60;
        }

        w = 720;
        tall += 30;
        for (int i = 0; i < 9; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.magenta));
            w -= 60;
        }

        w = 720;
        tall += 30;
        for (int i = 0; i < 8; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.red));
            w -= 60;
        }

        w = 720;
        tall += 30;
        for (int i = 0; i < 7; i++) {
            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
            blocks.add(new Block(r, Color.blue));
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
        v.add(new Velocity(3, 4));
        v.add(new Velocity(5, 2));
        v.add(new Velocity(4, 3));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.BLACK);
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
