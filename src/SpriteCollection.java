import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

public class SpriteCollection {
    private List<Sprite> obgectOnScreen=new ArrayList<>();

    public List<Sprite> get(){
        return obgectOnScreen;
    }

    public void addSprite(Sprite s){
        obgectOnScreen.add(s);

    }

    // call timePassed() on all sprites.
    public void notifyAllTimePassed(){
        List<Sprite> copy =new ArrayList<>(obgectOnScreen);

        for(int i=0;i<copy.size();i++){
            copy.get(i).timePassed();
        }

    }

    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d){
        List<Sprite> copy =new ArrayList<>(obgectOnScreen);

        for(int i=0;i<copy.size();i++){
            copy.get(i).drawOn(d);

        }
    }
   public void removeSprite(Sprite s){
        this.obgectOnScreen.remove(s);

   }
}
