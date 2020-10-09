/**
 * The Optimization class contains a static routine to find the maximum in an array that changes direction at most once.
 */
public class Optimization {

    /**
     * A set of test cases.
     */
    static int[][] testCases = {
            {1, 3, 5, 7, 9, 11, 10, 8, 6, 4},
            {67, 65, 43, 42, 23, 17, 9, 100},
            {4, -100, -80, 15, 20, 25, 30},
            {2, 3, 4, 5, 6, 7, 8, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83}
    };

    /**
     * Returns the maximum item in the specified array of integers which changes direction at most once.
     *
     * @param dataArray an array of integers which changes direction at most once.
     * @return the maximum item in data Array
     */
    public static int searchMax(int[] dataArray) {
        // TODO: Implement this
        /*if(dataArray.length == 1){ // array length of 1
            return dataArray[0];
        }
        else if(dataArray.length == 2){ // array length of 2
            if(dataArray[0] > dataArray[1]){return dataArray[0];}
            else{return dataArray[1];}
        }
        else if(dataArray[0] > dataArray[1]){ // this is for array that decrease then increase
            if(dataArray[0] > dataArray[dataArray.length-1]){return dataArray[0];}
            else{return dataArray[dataArray.length-1];}
        }
        else{ //this is for array that increase then decrease
            int start = 0, end = dataArray.length-1, mid = (start + end + 1) / 2;
            while(start < end && mid < dataArray.length-1){
                if(dataArray[mid-1] > dataArray[mid] && dataArray[mid] > dataArray[mid+1]){
                    end = mid;
                }
                else if(dataArray[mid-1] < dataArray[mid] && dataArray[mid] < dataArray[mid+1]){
                    start = mid;
                }
                else{
                    return dataArray[mid];
                }
                mid = (start + end + 1) / 2;
                //System.out.println(mid);
            }
            return dataArray[mid];
        }*/

        /*if(dataArray.length == 1){
            return dataArray[0];
        }
        else if(dataArray.length == 2){
            if(dataArray[0] > dataArray[1]){
                return dataArray[0];
            }
            else{
                return dataArray[1];
            }
        }
        else if(dataArray[0] > dataArray[1]){
            if(dataArray[0] > dataArray[dataArray.length-1]){
                return dataArray[0];
            }
            else{
                return dataArray[dataArray.length-1];
            }
        }
        else{
            int ans = dataArray[0];
            for(int i=1; i<dataArray.length; i++){
                if(dataArray[i] < ans){
                    break;
                }
                else{
                    ans = dataArray[i];
                }

            }
            return ans;
        }*/

        /*if(dataArray.length == 0){

        }
        else if(dataArray.length == 1){
            return dataArray[0];
        }
        else if(dataArray.length == 2){
            if(dataArray[0] > dataArray[1]){
                return dataArray[0];
            }
            else{
                return dataArray[1];
            }
        }
        else{
            if(dataArray[0] > dataArray[1]){    // this is for array that decrease to a min then increase
                if(dataArray[0] > dataArray[dataArray.length-1]){
                    return dataArray[0];
                }
                else{
                    return dataArray[dataArray.length-1];
                }
            }
            else{ // this is for array that increase to a max then decrease
                boolean found = false;
                int start = 0, end = dataArray.length-1;
                int mid = (start + end) / 2;
                while(!found){
                    if(dataArray[mid-1] > dataArray[mid] && dataArray[mid] > dataArray[mid+1]){
                        end = mid;
                        mid = (start + end) / 2;
                    }
                    else if(dataArray[mid-1] < dataArray[mid] && dataArray[mid] < dataArray[mid+1]){
                        start = mid;
                        mid = (start + end) / 2;
                    }
                    else{//System.out.println(mid);
                        found = true;
                    }
                }
                return dataArray[mid];
            }
        }*/
        /*boolean found = false;
        int start = 0, end = dataArray.length-1;
        int mid = (start + end) / 2;

        if(start == end){

        }
        else if(dataArray.length == 2){
            if(dataArray[0] > dataArray[1]){
                mid = 0;
            }
            else{
                mid = 1;
            }
        }
        else if(dataArray[0] > dataArray[1]){
            if(dataArray[0] > dataArray[dataArray.length-1]){
                mid = 0;
            }
            else{
                mid = dataArray.length-1;
            }
        }
        else{
            while(!found){
                if(dataArray[mid-1] > dataArray[mid] && dataArray[mid] > dataArray[mid+1]){
                    end = mid;
                    mid = (start + end) / 2;
                }
                else if(dataArray[mid-1] < dataArray[mid] && dataArray[mid] < dataArray[mid+1]){
                    start = mid;
                    mid = (start + end) / 2;
                }
                else{//System.out.println(mid);
                    found = true;
                }
            }
        }
        return dataArray[mid];*/
        //return 0;


        // other version

        int len = dataArray.length;
        if(len == 1) { //size of the data Array is 1
            return dataArray[0];
        } else if (dataArray[0] > dataArray[1]) { //check the trend, if decreasing at first, compare two extreme points
            return dataArray[0] > dataArray[len - 1] ? dataArray[0] : dataArray[len - 1];
        } else { // else do binary search for peak
            int begin = 0;
            int end = len - 1;
            int maxIndex = 0;
            while (begin <= end) {
                int mid = begin + (end - begin) / 2;
                if ((mid == 0 || dataArray[mid] > dataArray[mid - 1])
                        && (mid == len - 1 || dataArray[mid] > dataArray[mid + 1])) {
                    maxIndex = mid;
                    break;
                } else if (dataArray[mid + 1] > dataArray[mid]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return dataArray[maxIndex];
        }

    }

    /**
     * A routine to test the searchMax routine.
     */
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println(searchMax(a));
        /*for (int[] testCase : testCases) {
            System.out.println(searchMax(testCase));
        }*/
    }
}
