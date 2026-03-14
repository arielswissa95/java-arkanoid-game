import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

 public class GameLevel implements Animation{
    private SpriteCollection sprites=new SpriteCollection();
    private GameEnvironment environment=new GameEnvironment();
    private Paddle paddle;

    private GUI gui;
    private Sleeper sleeper;
    private KeyboardSensor keyboard;

    private int framesPerSecond = 60;

    private int width = 800;
    private int height = 600;
    private Counter remainingBlocks=new Counter();
    private Counter remainingBalls=new Counter();
    private Counter score=new Counter();

     private AnimationRunner runner;
     private boolean running;

     private LevelInformation levelInfo;




     public GameLevel(LevelInformation levelInfo,
                      AnimationRunner runner,
                      KeyboardSensor keyboard,
                      Counter score) {
         this.levelInfo = levelInfo;
         this.runner = runner;
         this.keyboard = keyboard;
         this.score = score;

         this.sprites = new SpriteCollection();
         this.environment = new GameEnvironment();

         this.remainingBlocks = new Counter();
         this.remainingBalls = new Counter();

         this.running = false;
     }

//     public GameLevel() {
//        this.sprites = new SpriteCollection();
//        this.environment = new GameEnvironment();
//
////        this.gui = new GUI("play screen", width, height);
////        this.keyboard = gui.getKeyboardSensor();
////        this.sleeper = new Sleeper();
////        this.runner=new AnimationRunner(this.gui,this.framesPerSecond,this.sleeper);
//
//    }


    public void addCollidable(Collidable c){
        if(environment==null){
            environment=new GameEnvironment();
        }
        environment.addCollidable(c);

    }
    public void addSprite(Sprite s){
        if(sprites==null){
            sprites=new SpriteCollection();
        }
        sprites.addSprite(s);

    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
//    public void initialize() {
//
//
//        Rectangle paddleRect = new Rectangle(new Point(350, 500), 100, 20);
//        this.paddle = new Paddle(
//                this.keyboard,
//                paddleRect,
//                Color.lightGray,
//                7,      // מהירות הפדל
//                this.width     // רוחב המסך
//        );
//
//        paddle.addToGame(this);
//
//        this.remainingBalls.increase(3);
//        BallRemover ballRemover=new BallRemover(this,remainingBalls);
//
//
//        Ball ball = new Ball(300, 300, 10, Color.WHITE);
//        ball.setVelocity(3, 4);
//        ball.setGameE(environment);
//        ball.addToGame(this);
//        ball.addHitListener(ballRemover);
//
//
//        Ball ball2 = new Ball(200, 200, 10, Color.red);
//        ball2.setVelocity(5, 2);
//        ball2.setGameE(environment);
//        ball2.addToGame(this);
//        ball2.addHitListener(ballRemover);
//
//
//        Ball ball3 = new Ball(450, 300, 10, Color.pink);
//        ball3.setVelocity(4, 3);
//        ball3.setGameE(environment);
//        ball3.addToGame(this);
//        ball3.addHitListener(ballRemover);
//
//
//
//        List<Block> blocks = new ArrayList<>();
//
//        int tall = 100;
//        int w = 720;
//        for (int i = 0; i < 12; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.yellow);
//           // block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//        w = 720;
//        tall = tall + 30;
//        for (int i = 0; i < 11; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.cyan);
//            // block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//        w = 720;
//        tall = tall + 30;
//
//        for (int i = 0; i < 10; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.green);
//           // block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//        w = 720;
//        tall = tall + 30;
//        for (int i = 0; i < 9; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.magenta);
//          //  block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//        w = 720;
//        tall = tall + 30;
//        for (int i = 0; i < 8; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.red);
//            //block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//        w = 720;
//        tall = tall + 30;
//        for (int i = 0; i < 7; i++) {
//
//            Rectangle r = new Rectangle(new Point(w, tall), 60, 30);
//            Block block = new Block(r, Color.blue);
//            //block.addToGame(this);
//            blocks.add(block);
//            w = w - 60;
//        }
//
//
//        Rectangle r = new Rectangle(new Point(0, 0), 800, 20);
//        Block b1 = new Block(r, Color.gray);
//        b1.addToGame(this);
//
//        Rectangle r1 = new Rectangle(new Point(0, 600 - 20), 800, 20);
//        Block b2 = new Block(r1, Color.blue);
//        b2.addToGame(this);
//
//        Rectangle r2 = new Rectangle(new Point(800 - 20, 20), 20, 600);
//        Block b3 = new Block(r2, Color.gray);
//        b3.addToGame(this);
//
//        Rectangle r3 = new Rectangle(new Point(0, 20), 20, 600);
//        Block b4 = new Block(r3, Color.gray);
//        b4.addToGame(this);
//
//
//        PrintingHitListener printer = new PrintingHitListener();
//
//        this.remainingBlocks.increase(blocks.size());
//        BlockRemover blockRemover=new BlockRemover(this,remainingBlocks);
//
//        ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.score);
//
//
//
//        for (Block block : blocks) {
//            block.addHitListener(blockRemover);
//            block.addToGame(this);
//            block.addHitListener(scoreListener);
//
//
//        }
//        System.out.println(blocks.size());
//        this.addSprite(new ScoreIndicator(this.score));
//
//
//
//    }

     public void initialize() {

         this.addSprite(levelInfo.getBackground());

         Block top = new Block(new Rectangle(new Point(0, 0), width, 20), Color.gray);
         top.addToGame(this);

         Block left = new Block(new Rectangle(new Point(0, 20), 20, height), Color.gray);
         left.addToGame(this);

         Block right = new Block(new Rectangle(new Point(width - 20, 20), 20, height), Color.gray);
         right.addToGame(this);

         // 2) Death region (bottom) - הבלוק שמפיל כדורים
         BallRemover ballRemover = new BallRemover(this, remainingBalls);
         Block deathRegion = new Block(
                 new Rectangle(new Point(0, height - 20), width, 20),
                 Color.blue
         );
         deathRegion.addHitListener(ballRemover);
         deathRegion.addToGame(this);

         // 3) Paddle לפי LevelInformation
         Rectangle paddleRect = new Rectangle(
                 new Point((width - levelInfo.paddleWidth()) / 2.0, 500),
                 levelInfo.paddleWidth(),
                 20
         );

         this.paddle = new Paddle(
                 this.keyboard,
                 paddleRect,
                 Color.lightGray,
                 levelInfo.paddleSpeed(),
                 this.width
         );
         paddle.addToGame(this);

         // 4) Balls לפי LevelInformation
         List<Velocity> vels = levelInfo.initialBallVelocities();
         this.remainingBalls.increase(levelInfo.numberOfBalls());

         for (int i = 0; i < levelInfo.numberOfBalls(); i++) {
             Ball ball = new Ball(400, 300, 10, Color.WHITE);
             if (i < vels.size()) {
                 ball.setVelocity(vels.get(i));
             } else {
                 ball.setVelocity(3, 4); // fallback
             }
             ball.setGameE(environment);
             ball.addToGame(this);

             // חשוב: לא לשים BallRemover על הכדורים!
             // ball.addHitListener(ballRemover);  <-- להסיר!
         }

         // 5) Blocks מה־LevelInformation
         List<Block> blocks = levelInfo.blocks();

         this.remainingBlocks.increase(blocks.size());
          BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
         ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.score);

         for (Block block : blocks) {
             block.addHitListener(blockRemover);
             block.addHitListener(scoreListener);
             block.addToGame(this);
         }

         // 6) Score indicator
         this.addSprite(new ScoreIndicator(this.score));
     }

     public boolean noBallsLeft() {
         return remainingBalls.getValue() == 0;
     }

     public boolean noBlocksLeft() {
         return remainingBlocks.getValue() == 0;
     }




     // Run the game -- start the animation loop.
//    public void run(){
//
////        GUI gui = new GUI("play screeen",800,600);
////        Sleeper sleeper = new Sleeper();
////        paddle.setKeyboard(gui.getKeyboardSensor());
//
//
//        int framesPerSecond = 60;
//        int millisecondsPerFrame = 1000 / framesPerSecond;
//        while (remainingBlocks.getValue() > 0 && remainingBalls.getValue() > 0) {
//            long startTime = System.currentTimeMillis(); // timing
//
//            DrawSurface d = gui.getDrawSurface();
//
//
//
//            d.setColor(Color.black);
//            d.fillRectangle(0, 0, width, height);
//            this.sprites.notifyAllTimePassed();
//            this.sprites.drawAllOn(d);
//            gui.show(d);
//
//
//            // timing
//            long usedTime = System.currentTimeMillis() - startTime;
//            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
//            if (milliSecondLeftToSleep > 0) {
//                sleeper.sleepFor(milliSecondLeftToSleep);
//
////                if(this.remainingBlocks.getValue()==0 || this.remainingBalls.getValue()==0)
////                    gui.close();
//            }
//        }
//
//        if(remainingBlocks.getValue()==0){
//            score.increase(100);
//            DrawSurface d = gui.getDrawSurface();
//            d.setColor(Color.blue);
//            d.fillRectangle(0, 0, width, height);
//
//            d.setColor(Color.WHITE);
//            d.drawText(300, 300, "you win", 60);
//            d.drawText(290, 400, this.score.getValue()+" points", 60);
//
//
//            gui.show(d);
//
//            Sleeper sleeper = new Sleeper();
//            sleeper.sleepFor(5000);
//        }
//
//
//
//        gui.close();
//
//    }

     public void run() {
//         this.createBallsOnTopOfPaddle(); // or a similar method
//         this.runner.run(new CountdownAnimation(...)); // countdown before turn starts.

         running = true;
         runner.run(this);
     }


     public void delay(int milliseconds) {
         Sleeper sleeper = new Sleeper();
         sleeper.sleepFor(milliseconds);
     }

   public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
   }
    public void removeSprite(Sprite s){
        sprites.removeSprite(s);
    }

    @Override
     public void doOneFrame(DrawSurface d){
         //  sprites.drawAllOn(d);

         d.setColor(Color.black);
         d.fillRectangle(0, 0, width, height);
         this.sprites.notifyAllTimePassed();
         this.sprites.drawAllOn(d);

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }

//         if (keyboard.isPressed("p")) {
//             runner.run(new KeyPressStoppableAnimation(
//                     keyboard, KeyboardSensor.SPACE_KEY,
//                     new PauseScreen(keyboard)));
//         }

        if(this.remainingBlocks.getValue()==0 || this.remainingBalls.getValue()==0)
            running=false;
     }


     @Override
     public boolean shouldStop(){
         return !running;

     }
}

