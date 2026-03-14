import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.Objects;

public class Line {
    private Point start;
    private Point end;
    private Double slope;
    private Double B;

    // constructors
    public Line(Point start, Point end) {
        this.start=start;
        this.end=end;

        if(start.getX()==end.getX()){
            this.slope=null;
            this.B=null;
        }
        else {
            this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double myXM=this.slope*this.start.getX();
            this.B=this.start.getY()-myXM;
        }



    }
    public Line(double x1, double y1, double x2, double y2) {
        this.start=new Point(x1,y1);
        this.end=new Point(x2,y2);

        if(start.getX()==end.getX()){
            this.slope=null;
            this.B=null;
        }
        else {
            this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double myXM=this.slope*this.start.getX();
            this.B=this.start.getY()-myXM;
        }


    }

    // Return the length of the line
    public double length() {
      return this.start.distance(this.end);
    }

    // Returns the middle point of the line
    public Point middle() {
        return new Point((this.start.getX()+this.end.getX())/2 , (this.start.getY()+this.end.getY())/2);
    }

    // Returns the start point of the line
    public Point start() {
        return this.start;
    }

    // Returns the end point of the line
    public Point end() {
        return this.end;
    }
    public Double slope(){
       return this.slope;
    }

    public Double B(){
       return this.B;

    }

    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        if(this.equals(other))
            return true;

        if(Objects.equals(this.slope,other.slope()))
        return false;

        double intersectX,intersectY;
        if(this.slope==null ){
            intersectX=this.start().getX();
            intersectY=other.slope()*intersectX+other.B();
        }
        else if(other.slope()==null ){
            intersectX=other.start().getX();
            intersectY=this.slope*intersectX+this.B;
        }
        else {
            intersectX=(other.B()-this.B)/(this.slope-other.slope());
            intersectY=this.slope*intersectX+this.B;
        }

    if(Math.min(this.start.getX(),this.end.getX())>intersectX || intersectX> Math.max(this.start.getX(),this.end.getX()))
        return false;

    if(Math.min(this.start.getY(),this.end.getY())>intersectY || intersectY> Math.max(this.start.getY(),this.end.getY()))
        return false;

    if(Math.min(other.start.getX(),other.end.getX())>intersectX || intersectX> Math.max(other.start.getX(),other.end.getX()))
        return false;

    if(Math.min(other.start.getY(),other.end.getY())>intersectY || intersectY> Math.max(other.start.getY(),other.end.getY()))
        return false;


    return true;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if(!this.isIntersecting(other))
            return null;
        else {
            if(this.equals(other))
                return this.start;

            double intersectX,intersectY;
            if(this.slope==null ){
                intersectX=this.start().getX();
                intersectY=other.slope()*intersectX+other.B();
            }
            else if(other.slope()==null ){
                intersectX=other.start().getX();
                intersectY=this.slope*intersectX+this.B;
            }
            else {
                intersectX=(other.B()-this.B)/(this.slope-other.slope());
                intersectY=this.slope*intersectX+this.B;
            }

            return new Point(intersectX,intersectY);

        }
    }

    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        if(this.start.equals(other.start()) && this.end.equals(other.end()))
            return true;
        if(this.start.equals(other.end()) && this.end.equals(other.start()))
            return true;

        return false;
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect){
        List<Point> p=rect.intersectionPoints(this);
        if(p.size()==0)
            return null;

        double[] arr=new double[p.size()];
        double min= Integer.MAX_VALUE;
        int mini=0;

        for (int i=0;i<p.size();i++){
            arr[i]=this.start.distance(p.get(i));

            if(arr[i]<min){
                min=arr[i];
                mini=i;

            }
        }
        return p.get(mini);

    }
}

