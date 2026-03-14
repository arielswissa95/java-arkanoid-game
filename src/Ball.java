import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball implements Sprite, HitNotifier {
    private int size;
    private Color color;
    private Point location;
    private Velocity speed;
    private GameEnvironment gEv;
    private List<HitListener> hitListeners=new ArrayList<>();


    // constructor
    public Ball(Point center, int r, java.awt.Color color){
        this.location=center;
        this.size=r;
        this.color =color;
       // this.speed=speed;
    }
    public Ball(Point center, int r, java.awt.Color color,GameEnvironment v){
        this.location=center;
        this.size=r;
        this.color =color;
        this.gEv=v;
        // this.speed=speed;
    }

    public Ball(double x,double y, int r, java.awt.Color color){
        this.location=new Point(x,y);
        this.size=r;
        this.color =color;
       // this.speed=speed;
    }


    @Override
    public void addHitListener(HitListener hl){
        this.hitListeners.add(hl);
    }
    @Override
    public void removeHitListener(HitListener hl){
        this.hitListeners.remove(hl);
    }

        // accessors
    public int getX(){
        return (int)location.getX();
    }
    public int getY(){
        return (int)location.getY();
    }
    public int getSize(){
        return size;
    }
    public java.awt.Color getColor(){
        return color;
    }

    public void setGameE(GameEnvironment g){
        this.gEv=g;
    }

    @Override
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface){
        surface.setColor(this.color);
        surface.fillCircle((int)location.getX(),(int)location.getY(),size);

    }

    @Override
    public void timePassed(){
        moveOneStep();

    }



    public void setVelocity(Velocity v){
        this.speed=v;
    }
    public void setVelocity(double dx, double dy){
       this.speed=new Velocity(dx,dy);
    }
    public Velocity getVelocity(){
        if(speed!=null)
            return speed;
        return null;
    }

    //לשנות
    public void moveOneStep(int height,int width) {

        if(this.location.getX()+this.size>=width)
            this.speed.setDx(-Math.abs(this.speed.getDx()));
       else if(this.location.getX()-this.size<=0){
            this.speed.setDx(Math.abs(this.speed.getDx()) );
       }
        if (this.location.getY()+this.size>=height)
            this.speed.setDy(-Math.abs(this.speed.getDy()));
       else if(this.location.getY()-this.size<=0){
            this.speed.setDy(Math.abs(this.speed.getDy()));
       }
        this.location = this.getVelocity().applyToPoint(this.location);





    }
    //לשנות
    public void moveOneStep(int xStart,int yStart,int xEnd,int yEnd ) {

        if(this.location.getX()+this.size>=xEnd)
            this.speed.setDx(-Math.abs(this.speed.getDx()));
        else if(this.location.getX()-this.size<=xStart){
            this.speed.setDx(Math.abs(this.speed.getDx()) );
        }
        if (this.location.getY()+this.size>=yEnd)
            this.speed.setDy(-Math.abs(this.speed.getDy()));
        else if(this.location.getY()-this.size<=yStart){
            this.speed.setDy(Math.abs(this.speed.getDy()));
        }


        this.location = this.getVelocity().applyToPoint(this.location);



    }



//        public void moveOneStep() {
//            if (this.speed == null) {
//                return;
//            }
//
//              Point end=this.speed.applyToPoint(this.location);
////            Point end=new Point(
////                    this.location.getX()+speed.getDx()+Math.signum(speed.getDx())*size,
////                    this.location.getY()+speed.getDy()+Math.signum(speed.getDy())*size
////                    ) ;
//
//            Line l=new Line(this.location,end);
//
//            if(gEv!=null) {
//                CollisionInfo c = gEv.getClosestCollision(l);
//
//
//                if (c == null) {
//                    this.location = end;
//
//                    return;
//                }
//
//                Point boom = c.collisionPoint();
//
//                //מנרמלים את וקטור המהירות
////            double normaV=Math.sqrt(speed.getDx()*speed.getDx()+speed.getDy()*speed.getDy());
////            double normalX=this.speed.getDx()/normaV;
////            double normalY=this.speed.getDy()/normaV;
//
//
////            double newX= boom.getX()-normalX*this.size;
////            double newY=boom.getY()-normalY*this.size;
//                double newX = boom.getX() - speed.getDx() * 0.0001;
//                double newY = boom.getY() - speed.getDy() * 0.0001;
//
//
//                this.location = new Point(newX, newY);
//
//                this.setVelocity(c.collisionObject().hit(boom, this.speed));
//            }
//            else {
//            this.location = this.getVelocity().applyToPoint(this.location);
//            }
//
//
//
//
//
//
//        }


//    public void moveOneStep() {
//        if (this.speed == null) {
//            return;
//        }
//
//        //Point end=this.speed.applyToPoint(this.location);
//        Point end = this.speed.applyToPoint(this.location);
//        Line l = new Line(this.location, end);
//
//       // Line l=new Line(this.location,end);
//
//        if(gEv!=null) {
//           // CollisionInfo c = gEv.getClosestCollision(l);
//            CollisionInfo c = gEv.getClosestCollision(l);
//
//
//            if (c == null) {
//                this.location = end;
//
//                return;
//            }
//
//            Point boom = c.collisionPoint();
//
//            //מנרמלים את וקטור המהירות
////            double normaV=Math.sqrt(speed.getDx()*speed.getDx()+speed.getDy()*speed.getDy());
////            double normalX=this.speed.getDx()/normaV;
////            double normalY=this.speed.getDy()/normaV;
//
//
////            double newX= boom.getX()-normalX*this.size;
////            double newY=boom.getY()-normalY*this.size;
//            double newX = boom.getX() - speed.getDx() * 0.0001;
//            double newY = boom.getY() - speed.getDy() * 0.0001;
//
//
//            this.location = new Point(newX, newY);
//
//            this.setVelocity(c.collisionObject().hit(boom, this.speed));
//        }
//        else {
//            this.location = this.getVelocity().applyToPoint(this.location);
//        }
//
//
//
//
//
//
//    }


    public void moveOneStep() {
        if (this.speed == null) {
            return;
        }

        double dx = this.speed.getDx();
        double dy = this.speed.getDy();

        if (this.gEv != null) {

            double len = Math.sqrt(dx * dx + dy * dy);
            if (len == 0) {
                return;
            }

            double nx = dx / len;
            double ny = dy / len;


            Point end = new Point(
                    this.location.getX() + dx + nx * this.size,
                    this.location.getY() + dy + ny * this.size
            );

            Line trajectory = new Line(this.location, end);
            CollisionInfo c = gEv.getClosestCollision(trajectory);

            if (c == null) {
                this.location = this.speed.applyToPoint(this.location);
                return;
            }

            Point boom = c.collisionPoint();


            double epsilon = 0.001;
            double newX = boom.getX() - nx * (this.size + epsilon);
            double newY = boom.getY() - ny * (this.size + epsilon);

            this.location = new Point(newX, newY);

            this.setVelocity(c.collisionObject().hit(this,boom, this.speed));
            if(boom.getY()==580)
                this.notifyHit((Block) c.collisionObject());

        } else {
            this.location = this.speed.applyToPoint(this.location);
        }
    }
    private void notifyHit(Block hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(hitter, this);
        }
    }
    public void removeFromGame(GameLevel gameLevel){
        gameLevel.removeSprite(this);
       // game.removeCollidable(this);
    }

    public void addToGame(GameLevel g){
        g.addSprite(this);
      }
}
