import java.util.ArrayList;

public class Bin {
    private int capacity;
    private ArrayList<Integer> contents = new ArrayList<>();

    public Bin(int givenSize){
        capacity = givenSize;
    }

    public ArrayList<Integer> getContents(Bin bin){
        return bin.contents;
    }

    public static int getCurrentSize(Bin bin){
        int currentSize = 0;
        ArrayList<Integer> binContents = bin.contents;

        for(int value : binContents){
            currentSize = currentSize + value;
        }

        return currentSize;
    }

    public static int getMaxCapacity(Bin bin){
        return bin.capacity;
    }

    public static void addValue(Bin bin, int value){
        bin.contents.add(value);
    }

}
