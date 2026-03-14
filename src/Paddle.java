import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

public class Paddle  implements Sprite, Collidable{
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectanglePaddke;
    private Color c;
    private double speed;
    private int screenWidth;



    public Paddle(biuoop.KeyboardSensor k,Rectangle rectanglePaddke,Color c,double speed,int screenWidth){
        this.keyboard=k;
        this.rectanglePaddke=rectanglePaddke;
        this.speed=speed;
        this.c=c;
        this.screenWidth=screenWidth;
    }

    public Paddle(Rectangle rectanglePaddke,Color c,double speed,int screenWidth){
        this.rectanglePaddke=rectanglePaddke;
        this.speed=speed;
        this.c=c;
        this.screenWidth=screenWidth;
    }

    public void setKeyboard(biuoop.KeyboardSensor k){
        this.keyboard=k;
    }

    public void moveLeft(){
        double newX=rectanglePaddke.getUpperLeft().getX()-speed;

        if(newX+rectanglePaddke.getWidth()<=0){
            newX=screenWidth;
        }
        rectanglePaddke=new Rectangle(new Point(newX,rectanglePaddke.getUpperLeft().getY()),rectanglePaddke.getWidth(),rectanglePaddke.getHeight());


    }
    public void moveRight(){
        double newX=rectanglePaddke.getUpperLeft().getX()+speed;
        if(newX>=screenWidth){
            newX=-rectanglePaddke.getWidth();
        }
        rectanglePaddke=new Rectangle(new Point(newX,rectanglePaddke.getUpperLeft().getY()),rectanglePaddke.getWidth(),rectanglePaddke.getHeight());

    }




    // Sprite
    @Override
    public void timePassed(){
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }



    }
    @Override

    public void drawOn(DrawSurface d){
        d.setColor(c);
        //   surface.fillRectangle((int)rect.getHeight(),(int)rect.getWidth(),(int)rect.getHeight(),(int)rect.getWidth());
        d.fillRectangle((int)rectanglePaddke.getUpperLeft().getX(),(int)rectanglePaddke.getUpperLeft().getY(),(int)rectanglePaddke.getWidth(),(int)rectanglePaddke.getHeight());

    }

    // Collidable
    @Override

    public Rectangle getCollisionRectangle(){
        return rectanglePaddke;
    }
    @Override
    public Velocity hit(Ball hitter,Point collisionPoint, Velocity currentVelocity){

        double leftX, topY, rightX, bottomY;
        leftX=rectanglePaddke.getUpperLeft().getX();
        topY= rectanglePaddke.getUpperLeft().getY();
        bottomY=topY+rectanglePaddke.getHeight();
        rightX=leftX+rectanglePaddke.getWidth();
        System.out.println("v: (" + currentVelocity.getDx() + ", " + currentVelocity.getDy() + ")");

        Velocity v=new Velocity(currentVelocity.getDx() ,currentVelocity.getDy());
        double part=rectanglePaddke.getWidth()/5.0;
        if(Math.abs(collisionPoint.getY()-topY)<0.0001){
          double xByPadel=collisionPoint.getX()- rectanglePaddke.getUpperLeft().getX();
          int region = (int) Math.ceil(xByPadel / part);
          if(region<1)
              region =1;
          if(region>5)
              region=5;


          double norma=Math.sqrt(currentVelocity.getDx()* currentVelocity.getDx()+currentVelocity.getDy()*currentVelocity.getDy());
          int angle=0;

          switch (region){
              case 1:
                  angle=300;
                  break;
              case 2:
                  angle=330;
                  break;

              case 3:
                  angle=0;
                  break;

              case 4:
                  angle=30;
                  break;

              case 5:
                  angle=60;
                  break;


          }

          return  Velocity.fromAngleAndSpeed(angle,norma);


        }

        if(Math.abs(collisionPoint.getX()-leftX)<0.0001){
            v.setDx( -(currentVelocity.getDx()) );
        }
        else if (Math.abs(collisionPoint.getX()-rightX)<0.0001) {
            v.setDx(-(currentVelocity.getDx() ));
        }

        else if(Math.abs(collisionPoint.getY()-bottomY)<0.0001){

            v.setDy( -(currentVelocity.getDy()));
        }
        System.out.println("v: (" + v.getDx() + ", " + v.getDy() + ")");

        return v;
    }

    // Add this paddle to the game.
    public void addToGame(GameLevel g){
        g.addSprite(this);
        g.addCollidable(this);

    }
}
