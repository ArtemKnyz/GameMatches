package Data;

import java.util.ArrayList;

public class Data {
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
