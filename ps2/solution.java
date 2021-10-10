import java.util.PriorityQueue;
public class solution {
    public static int minDays(int[] bloomDay, int m, int k) {

        long total = m * k;
        if(total > bloomDay.length){
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i< bloomDay.length; i++){
            q.add(bloomDay[i]);
        }

        int day = q.poll();
        for(int i=0; i<total-1; i++){
            if(i == total - 2){
                day = q.poll();
            }
            else{
                //System.out.println((q.peek()));
                q.poll();
            }
        }
        //System.out.println(day);

        boolean[] bloom = new boolean[bloomDay.length];
        for(int i=0; i<bloomDay.length; i++){
            bloom[i] = bloomDay[i] <= day;
            //System.out.println(bloom[i]);
        }

        int len = k, ans= -1;
        for(int i=0; i<bloomDay.length; i++){
            if(m <= 0){
                ans = day;
                break;
            }
            if(bloom[i]) {
                len--;
                if (len <= 0) {
                    //System.out.println("m: " + m);
                    m--;
                    len = k;
                }
            }
            else{
                if(len < k){
                    len = k;
                }
            }
        }
        if(m <= 0){
            ans = day;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] a = {1,10,3,10,2};
        System.out.println(minDays(a, 3,2));
    }
}
