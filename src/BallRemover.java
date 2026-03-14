public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBall;

    public BallRemover(GameLevel gameLevel, Counter remainingBall) {
        this.remainingBall=remainingBall;
        this.gameLevel = gameLevel;

    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
//        beingHit.removeFromGame(this.game);
//        beingHit.removeHitListener(this);
//        remainingBall.decrease(1);
//
        hitter.removeFromGame(this.gameLevel);
        hitter.removeHitListener(this);
        remainingBall.decrease(1);


    }
}
