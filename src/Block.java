import biuoop.DrawSurface;
//import com.sun.jndi.toolkit.ctx.StringHeadTail;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Block implements Collidable, Sprite, HitNotifier{
    private Rectangle rect;
    private Color c=Color.BLACK;
    private List<HitListener> hitListeners=new ArrayList<>();


    public Block(Rectangle r, Color c){
        this.rect=r;
        this.c=c;
    }

//    public Block(Rectangle r){
//        this.rect=r;
//    }
    // Return the "collision shape" of the object.
    public Rectangle getCollisionRectangle(){
        return this.rect;
    }

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
//    public Velocity hit(Point collisionPoint, Velocity currentVelocity){
//        double leftX, topY, rightX, bottomY;
//        leftX=rect.getUpperLeft().getX();
//        topY= rect.getUpperLeft().getY();
//        bottomY=topY+rect.getHeight();
//        rightX=leftX+rect.getWidth();
//        System.out.println("v: (" + currentVelocity.getDx() + ", " + currentVelocity.getDy() + ")");
//
//        Velocity v=new Velocity(currentVelocity.getDx() ,currentVelocity.getDy());
//
//        if(Math.abs(collisionPoint.getX()-leftX)<0.0001){
//           v.setDx( -(currentVelocity.getDx()) );
//        }
//        else if (Math.abs(collisionPoint.getX()-rightX)<0.0001) {
//            v.setDx(-(currentVelocity.getDx() ));
//        }
//        if(Math.abs(collisionPoint.getY()-topY)<0.0001){
//            v.setDy( -(currentVelocity.getDy()));
//        }
//        else if(Math.abs(collisionPoint.getY()-bottomY)<0.0001){
//
//            v.setDy( -(currentVelocity.getDy()));
//        }
//        System.out.println("v: (" + v.getDx() + ", " + v.getDy() + ")");
//
//        return v;
//
//    }

    public Rectangle getRect(){
        return this.rect;
    }


    @Override
    public void drawOn(DrawSurface surface){
        surface.setColor(this.c);
        //   surface.fillRectangle((int)rect.getHeight(),(int)rect.getWidth(),(int)rect.getHeight(),(int)rect.getWidth());
        surface.fillRectangle((int)this.rect.getUpperLeft().getX(),(int)this.rect.getUpperLeft().getY(),(int)this.rect.getWidth(),(int)this.rect.getHeight());
        surface.setColor(Color.BLACK);

        surface.drawRectangle((int)this.rect.getUpperLeft().getX(),(int)this.rect.getUpperLeft().getY(),(int)this.rect.getWidth(),(int)this.rect.getHeight());

    }
    @Override
    public void timePassed(){

    }
    public void addToGame(GameLevel g){
        g.addSprite(this);
        g.addCollidable(this);
    }

    public void removeFromGame(GameLevel gameLevel){
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    // Notice that we changed the hit method to include a "Ball hitter" parameter -- update the
    // Collidable interface accordingly.
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double leftX, topY, rightX, bottomY;
        leftX=rect.getUpperLeft().getX();
        topY= rect.getUpperLeft().getY();
        bottomY=topY+rect.getHeight();
        rightX=leftX+rect.getWidth();
        System.out.println("v: (" + currentVelocity.getDx() + ", " + currentVelocity.getDy() + ")");

        Velocity v=new Velocity(currentVelocity.getDx() ,currentVelocity.getDy());

        if(Math.abs(collisionPoint.getX()-leftX)<0.0001){
            v.setDx( -(currentVelocity.getDx()) );
        }
        else if (Math.abs(collisionPoint.getX()-rightX)<0.0001) {
            v.setDx(-(currentVelocity.getDx() ));
        }
        if(Math.abs(collisionPoint.getY()-topY)<0.0001){
            v.setDy( -(currentVelocity.getDy()));
        }
        else if(Math.abs(collisionPoint.getY()-bottomY)<0.0001){

            v.setDy( -(currentVelocity.getDy()));
        }
        System.out.println("v: (" + v.getDx() + ", " + v.getDy() + ")");


        this.notifyHit(hitter);

        return v;
    }

    @Override
    public void addHitListener(HitListener hl){
        this.hitListeners.add(hl);
    }
    @Override
    public void removeHitListener(HitListener hl){
        this.hitListeners.remove(hl);
    }


}
