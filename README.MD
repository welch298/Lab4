Lab Goals
-
Efficiently pack N items of different sizes into three bins of fixed size B wasting as little space as possible.

Our Implementation
-
Since actually finding the optimal packing configuration requires creating every possible permutation of bin setups and that entails exponential runtime, we used a simpler algorithm.<br>

First we sort the given array of values from lowest to highest<br>

Then, starting with the largest value we attempt to put it into the first bin<br>

After that we move to the next bin and see if we can fit the next item into it<br>

If at any time a value cannot fit in a bin we move to the next one until we have tried on three different bins. Once that happens we move to the next value.<br>

We continue doing this until we reach the beginning of the given values and have tried to bin them all.

Time Complexity
-
Our worst case ends up being big O(nlgn) primarily due to the sorting algorithm we use.

Ignoring the sorting algorithm the bulk of our time complexity comes from the while loop we use which at worst will run big O(3n)

Packing Efficiency
-
Our implementation manages to pack the bins while leaving only a few values out of it.

The worst case for our implementation is when the first three values are just a little too big for any other values to be inserted. The first three greatest values have to be greater than half of the bin max capacity for this to work.