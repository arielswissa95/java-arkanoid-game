import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {
    private List<Collidable> c=new ArrayList<>();


    public List<Collidable> getC(){
        return c;
    }
    // add the given collidable to the environment.
    public void addCollidable(Collidable c){
        this.c.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory){
        List<Point> pointArray=new ArrayList<Point>();
        List<Collidable> cArray=new ArrayList<Collidable>();

        for(int i=0;i<this.c.size();i++){
            Rectangle r=c.get(i).getCollisionRectangle();
            Point p=trajectory.closestIntersectionToStartOfLine(r);
            if(p!=null){
                pointArray.add(p);
                cArray.add(c.get(i));
            }

        }

        if(pointArray.size()==0)
            return null;

        double min=Integer.MAX_VALUE;
        int mini=0;

        for(int i=0;i<pointArray.size();i++){
            double d=trajectory.start().distance(pointArray.get(i));
            if(d<min){
                min=d;
                mini=i;
            }
        }

        return new CollisionInfo(pointArray.get(mini),cArray.get(mini));
    }
    public void removeCollidable(Collidable c){
        this.c.remove(c);
    }




}
