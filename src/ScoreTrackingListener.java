public class ScoreTrackingListener implements HitListener{
    private Counter currentScore;

    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
       System.out.println("the score is"+this.currentScore.getValue()+"");
    }
}
