public class Counter {
    private int count=0;
    public Counter(){

    }
    // add number to current count.
    public void increase(int number){
        count+=number;
    }
    // subtract number from current count.
   public void decrease(int number){
        count-=number;
   }
    // get current count.
   public int getValue(){
        return count;
   }
}
