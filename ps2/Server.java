import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Server {
    public static int findMin(int[] a){
        int index = 0, e = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i] > 0 && a[i] < e){
                index = i;
                e = a[i];
            }
        }
        return index;
    }
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int in=0; in<testcase; in++){
            System.out.print(String.format("Case %d: ", in + 1));
            //ArrayList<Integer> sor = new ArrayList<>();
            int s = sc.nextInt(), n = sc.nextInt();
            int[] price = new int[s];
            for(int i=0; i<s; i++){
                price[i] = sc.nextInt();
                //sor.add(price[i]);
            }
            //Collections.sort(sor);
            int ans = 0;
            while(n > 0){
                int mi = Server.findMin(price);
                ans += price[mi];
                price[mi] = -1;
                n--;

                if(n <= 0){
                    break;
                }
                if(mi == 0 && s > 1){
                    //ans+=price[1];
                    price[1] = -1;
                }
                else if(mi == s-1 && s > 2){
                    //ans += price[s-2];
                    price[s-2] = -1;
                }
                else{
                    if(price[mi + 1] > price[mi - 1]){
                        //ans += price[mi + 1];
                        price[mi + 1] = -1;
                    }
                    else{
                        //ans += price[mi - 1];
                        price[mi - 1] = -1;
                    }
                }
                n--;
            }
            System.out.println(ans);
        }


    }
}
