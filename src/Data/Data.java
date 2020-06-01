package Data;

public class Data {
    final public int allMatches = 20;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void value(int count){
        this.count=this.count-count;
    }


}
