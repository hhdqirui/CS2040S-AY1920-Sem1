/**
 * Contains static routines for solving the problem of balancing m jobs on p processors
 * with the constraint that each processor can only perform consecutive jobs.
 */


public class LoadBalancing {

    /**
     * Checks if it is possible to assign the specified jobs to the specified number of processors such that no
     * processor's load is higher than the specified query load.
     *
     * @param jobSize the sizes of the jobs to be performed
     * @param queryLoad the maximum load allowed for any processor
     * @param p the number of processors
     * @return true iff it is possible to assign the jobs to p processors so that no processor has more than queryLoad load.
     */
    public static boolean feasibleLoad(int[] jobSize, int queryLoad, int p) {  //runtime: O(n) n:size of jobsize
        // TODO: Implement this
        int load = 0, p_left = p/*, i = 0*/;
        //boolean ans = false;

        for(int i=0; i<jobSize.length; i++){
            if(jobSize[i] > queryLoad){return false;}
            else if(p_left <= 0){return false;}
            else{
                if(load + jobSize[i] <= queryLoad){
                    load = load + jobSize[i];
                }
                else{
                    load = jobSize[i];
                    p_left--;
                }
            }
            /*System.out.println("load is " + load );
            System.out.println("pleft is " + p_left);
            //System.out.println("i is " + i);
            System.out.println("\n");*/
        }
        p_left--;
        if(p_left>=0){
            return true;
        }
        else{
            return false;
        }
        /*if(p_left >= 0){
            ans = true;
        }*/

        /*while(p_left >= 0 && i < jobSize.length){
            if(jobSize[i] + load <= queryLoad){
                load = jobSize[i] + load;
                i++;
            }
            else if(jobSize[i] > queryLoad){
                break;
            }
            else{
                if(jobSize[i] > queryLoad){
                    break;
                }
                else{
                    load = jobSize[i];
                    i++;
                    p_left--;
                }
            }
            *//*System.out.println("load is " + load );
            System.out.println("pleft is " + p_left);
            System.out.println("i is " + i);
            System.out.println("\n");*//*
        }
        p_left--; // the last processor
        if(i >= jobSize.length && p >= 0){
            ans = true;
        }*/
        //return true;
    }

    public static boolean check(int[] arr, int arr_len, int p, int load){ //runtime: O(arr_len)
        int cnt = 0, summ = 0;
        for(int i=0; i<arr_len; i++){
            if(summ + arr[i] <= load){
                summ = summ + arr[i];
            }
            else{
                //System.out.println("subsum is "+summ+"\n");
                cnt++;
                summ = arr[i];
            }
        }
        cnt++;  // the last sub-array
        //System.out.println("cnt is " + cnt + "\n");
        if(cnt <= p){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Returns the minimum achievable load given the specified jobs and number of processors.
     *
     * @param jobSize the sizes of the jobs to be performed
     * @param p the number of processors
     * @return the maximum load for a job assignment that minimizes the maximum load
     */

    public static int findLoad(int[] jobSize, int p) {  /////////////////////////////////
        // TODO: Implement this                         //////////////O(nlog(s-m)) n: size of jonSize, s: sum of all element of jobSize, m:max element of jobSize
                                                        /////////////////////////////////////////////////////////////////////////////
        int arr_len = jobSize.length, arr_sum = 0, largest = jobSize[0];

        for(int i=0; i<arr_len; i++){  // search the max element in the jobSize
            if(jobSize[i] > largest){
                largest = jobSize[i];
            }
            arr_sum += jobSize[i];
        }
        //System.out.println(largest);
        //System.out.println(arr_sum);

        int low = largest, high = arr_sum, load, ans = largest;

        while(low <= high){  // O(nlogn)
            load = (low + high) / 2;

            boolean ch = check(jobSize, arr_len, p, load);
            /*System.out.println("low is "+low);
            System.out.println("high is "+high);
            System.out.println("load is "+load);
            System.out.println(ch);
            System.out.println("\n");*/

            if(check(jobSize, arr_len, p, load)){
                ans = load;
                high = load - 1;
                //System.out.println("ans is "+ ans);
            }

            else{
                low = load + 1;
            }
        }


        return ans;
    }

    // These are some arbitrary testcases.
    public static int[][] testCases = {
            {1, 3, 5, 7, 9, 11, 10, 8, 6, 4},
            {67, 65, 43, 42, 23, 17, 9, 100},
            {4, 100, 80, 15, 20, 25, 30},
            {2, 3, 4, 5, 6, 7, 8, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83},
            {7}
    };

    /**
     * Some simple tests for the findLoad routine.
     */
    public static void main(String[] args) {
        /*int[] jobs = {1,1};
        int processors = 1;
        int queryLoad = 1;
        System.out.println(feasibleLoad(jobs, queryLoad, processors));*/
        /*int[] jobSize = {1, 3, 5, 7, 9, 11, 10, 8, 6, 4};
        int processors = 5;
        System.out.println(findLoad(jobSize, processors));*/
        for (int p = 1; p < 30; p++) {
            //System.out.println("Processors: " + p);
            for (int[] testCase : testCases) {
                System.out.println(findLoad(testCase, p));
            }
        }
    }
}
