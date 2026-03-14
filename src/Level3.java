import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level3 implements LevelInformation{
    private List<Block> blocks;

    public Level3() {
        blocks = new ArrayList<>();

        int blockW = 50;
        int blockH = 25;

        int startX = 650;   // ימין
        int startY = 120;

        Color[] colors = new Color[] {
                Color.yellow, Color.cyan, Color.green, Color.magenta, Color.red
        };

        for (int row = 0; row < 5; row++) {
            int y = startY + row * blockH;
            int x = startX;
            for (int col = 0; col < 10; col++) {
                Rectangle r = new Rectangle(new Point(x, y), blockW, blockH);
                blocks.add(new Block(r, colors[row]));
                x -= blockW;
            }
        }
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(5, 4));
        v.add(new Velocity(-5, 4));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 11;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    @Override
    public Sprite getBackground() {
        return new Background(new Color(30, 0, 30)); // סגול כהה
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
