/**
 * This class is a simple example for how to use the sorting classes.
 * It sorts three numbers, and measures how long it takes.
 */
public class SortTestExample {

    public static void main(String[] args){
        // Create three key value pairs
        /*KeyValuePair[] testArray = new KeyValuePair[3];
        testArray[0] = new KeyValuePair(10, 20);
        testArray[1] = new KeyValuePair(5, 21);
        testArray[2] = new KeyValuePair(8, 20);*/

        KeyValuePair[] testArray = new KeyValuePair[1000];
        int low= 10000/2, high = 10000/2;
        for(int i=0; i<1000; i++){
            testArray[i] = new KeyValuePair(i, i);
        }
        /*for(int i=0; i<10000; i++){
            if(i%2 == 0){
                testArray[i] = new KeyValuePair(low, i);
                low--;
            }
            else{
                testArray[i] = new KeyValuePair(high, i);
                high++;
            }
        }*/

        // Create a stopwatch
        StopWatch watch = new StopWatch();
        ISort sortingObject = new SorterD();

        // Do the sorting
        watch.start();
        sortingObject.sort(testArray);
        watch.stop();

        /*System.out.println(testArray[0]);
        System.out.println(testArray[1]);
        System.out.println(testArray[2]);*/
        System.out.println("Time: " + watch.getTime());
    }

}
