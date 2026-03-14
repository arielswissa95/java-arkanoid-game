import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level4 implements LevelInformation     {
    private List<Block> blocks;

    public Level4() {
        blocks = new ArrayList<>();

        int tall = 90;
        int w;

        Color[] rowColors = new Color[] {
                Color.gray, Color.cyan, Color.green, Color.yellow, Color.orange, Color.red
        };

        // 6 שורות, בכל שורה 12 בלוקים כמו Level1 (רוחב 60, גובה 30)
        for (int row = 0; row < 6; row++) {
            w = 720;
            for (int i = 0; i < 12; i++) {
                Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
                blocks.add(new Block(r, rowColors[row]));
                w -= 60;
            }
            tall += 30;
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
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 160;
    }

    @Override
    public String levelName() {
        return "Final Level";
    }

    @Override
    public Sprite getBackground() {
        return new Background(new Color(0, 40, 0)); // ירוק כהה
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
