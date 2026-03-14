public class Point {
    private  double x;
    private double y;

    // constructor
    public Point(double x, double y) {
    this.x=x;
    this.y=y;
    }

    // distance -- return the distance of this point to the other point
    public double distance(Point other) {

        double disX= (this.x-other.getX()) ;
        double disY=(this.y-other.getY());
        return Math.sqrt((disX*disX)+(disY*disY));

    }

    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        return this.x==other.getX() && this.y== other.getY();
    }

    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
}
