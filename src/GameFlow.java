import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private GUI gui;
    private Counter score;

    public GameFlow(AnimationRunner runner, KeyboardSensor keyboard, GUI gui) {
        this.runner = runner;
        this.keyboard = keyboard;
        this.gui = gui;
        this.score = new Counter();
    }

    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, runner, keyboard, score);
            level.initialize();
            level.run();


            if (level.noBallsLeft()) {
                runner.run(new KeyPressStoppableAnimation(
                        keyboard,
                        KeyboardSensor.SPACE_KEY,
                        new GameOverScreen(score)
                ));
                gui.close();
                return;
            }
        }

        runner.run(new KeyPressStoppableAnimation(
                keyboard,
                KeyboardSensor.SPACE_KEY,
                new YouWinScreen(score)
        ));
        gui.close();
    }
}

