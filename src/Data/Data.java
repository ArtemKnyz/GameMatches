package Data;

public class Data {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void stepExecution(int count) {
        this.count = this.count - count;
    }


}
