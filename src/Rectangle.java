import java.util.List;
import java.util.ArrayList;


public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height){
        this.upperLeft=upperLeft;
        this.height=height;
        this.width=width;
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line){
        List<Point> p=new ArrayList<Point>() ;
        Line a1=new Line(this.upperLeft,new Point(this.upperLeft.getX()+this.width,this.upperLeft.getY()));
        Line a2=new Line(this.upperLeft,new Point(this.upperLeft.getX(),this.upperLeft.getY()+this.height));
        Line a3=new Line(new Point(this.upperLeft.getX(),this.upperLeft.getY()+this.height),new Point(this.upperLeft.getX()+this.width,this.upperLeft.getY()+this.height));
        Line a4=new Line(new Point(this.upperLeft.getX()+this.width,this.upperLeft.getY()),new Point(this.upperLeft.getX()+this.width,this.upperLeft.getY()+this.height));
        // מחושב פעמיים חלק מהנקודות ניתן לייעל על ידי שנעשה את הנקודות בנפרד
        Line[]arr={a1,a2,a3,a4};

        for(int i=0;i< arr.length;i++){
            if(arr[i].isIntersecting(line))
                 p.add(arr[i].intersectionWith(line));
        }
        return p;

    }


    // Return the width and height of the rectangle
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft(){
        return this.upperLeft;
    }
}
