public class Velocity {
    private double dx;
    private double dy;
    // constructor
    public Velocity(double dx, double dy){
        this.dx=dx;
        this.dy=dy;
    }


    public static Velocity fromAngleAndSpeed(double angle, double speed) {
//        double radAngle=Math.toRadians(angle);
//        double dx = Math.cos(radAngle)*speed;
//        double dy = -Math.sin(radAngle)*speed;
//
//        return new Velocity(dx, dy);



        double rad = Math.toRadians(angle);
        double dx = speed * Math.sin(rad);
        double dy = -speed * Math.cos(rad);
        return new Velocity(dx, dy);
    }


    public double getDx(){
        return this.dx;
    }
    public double getDy(){
        return this.dy;
    }

    public void setDx(double x){
        this.dx=x;
    }
    public void setDy(double y){
        this.dy=y;
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p){
        return new Point(p.getX()+dx,p.getY()+dy);

    }
}
