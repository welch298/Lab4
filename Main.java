import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String args[]) {
        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(12, 4, 8, 15, 9, 3, 1, 10));
        Bin[] result = putInBins(givenList, 20);

        for(Bin bin : result){
            String resultString = "";
            for(Integer value : bin.getContents(bin)){
                resultString = resultString + " " + value.toString();
            }
            System.out.println(resultString);
        }

    }

    public static Bin[] putInBins(ArrayList<Integer> givenValues, int binSize){
        // Our algorithm hinges on the values being sorted.
        Collections.sort(givenValues);

        // Initialize the array of bins we'll use
        Bin[] bins = new Bin[3];

        // Setting up the array of three bins
        for(int i = 0; i < bins.length; i++){
            bins[i] = new Bin(binSize);
        }

        // Initializing some variables we'll need looping through the bins and values
        int failedAttempts = 0;
        int binIndex = 0;
        int arrayIndex = givenValues.size()-1;

        // Loop through the given values starting with the largest value and going to the smallest
        while(arrayIndex >= 0){

            // Check if the current value has failed three times to insert into bins
            // If it has we move on to the next value
            if(failedAttempts == 3){
                arrayIndex--;
                failedAttempts = 0;
            } else {

                // Check if adding the current value to a bin would push it over the max capacity
                if ((Bin.getCurrentSize(bins[binIndex]) + givenValues.get(arrayIndex)) <= Bin.getMaxCapacity(bins[binIndex])) {
                    // Add the current value to the current bin
                    Bin.addValue(bins[binIndex], givenValues.get(arrayIndex));
                    // Reset the failed attempts so as not to mess with the algorithm
                    failedAttempts = 0;
                    arrayIndex--;
                } else {
                    failedAttempts++;
                }
            }

            binIndex = (binIndex+1) % 3;
        }

        return bins;
    }

}
