import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String args[]) {
        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(12, 4, 8, 15, 9, 3, 1, 10));
        Bin[] result = putInBins(givenList, 20);

        for(Bin bin : result){
            System.out.println(bin.getContents(bin).toString());
        }

    }

    public static Bin[] putInBins(ArrayList<Integer> givenValues, int binSize){
        Collections.sort(givenValues);
        Bin[] bins = new Bin[3];

        // Setting up the array of three bins
        for(int i = 0; i < bins.length; i++){
            bins[i] = new Bin(binSize);
        }

        int failedAttempts = 0;
        int binIndex = 0;
        int arrayIndex = givenValues.size()-1;


        while(arrayIndex >= 0){

            if(failedAttempts == 3){
                arrayIndex--;
            }

            if((Bin.getCurrentSize(bins[binIndex]) + givenValues.get(arrayIndex)) < Bin.getMaxCapacity(bins[binIndex])){
                Bin.addValue(bins[binIndex], givenValues.get(arrayIndex));
                failedAttempts = 0;
                arrayIndex--;
            } else {
                failedAttempts++;
            }

            binIndex = (binIndex+1) % 3;
        }

        return bins;
    }

}
