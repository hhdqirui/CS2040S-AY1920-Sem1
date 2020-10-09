import java.util.Scanner;
import java.util.ArrayList;

class TestClass {
    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();                 // Reading input from STDIN

        for(int tc = 0; tc < testCase; tc++){
            ArrayList<String[]> item = new ArrayList<>();


            System.out.println(String.format("Case %d:", tc+1));

            int n = s.nextInt();
            //System.out.println(n);
            int q = s.nextInt();
            //ystem.out.println(q);
            for(int i=0; i<=n; i++){
                String line = s.nextLine();
                if(i == 0){
                    continue;
                }
                //System.out.println(line);
                String[] asdf = line.split(" ");

                item.add(asdf);
                //System.out.println("i: " + i);
            }

            for(int i=0; i<q; i++){
                int ans = 0;
                String[] query = s.nextLine().split(" ");
                /*for(int in=0; in<query.length; in++){
                    System.out.println(query[in]);
                }*/
                for(int j=0; j<item.size(); j++){
                    int qi = 0;
                    boolean start = false;
                    for(int k=0; k<item.get(j).length; k++){
                        if(!start){
                            if(item.get(j)[k].equals(query[qi])){
                                qi++;
                                start = true;
                            }
                        }
                        else{
                            if(!item.get(j)[k].equals(query[qi])){
                                break;
                            }
                            else{
                                qi++;
                            }
                        }
                        if(qi >= query.length){
                            break;
                        }
                    }
                    if(qi >= query.length){
                        ans++;
                        //System.out.println("j: "+j);
                    }

                }
                System.out.println(ans);
            }


        }


        // Write your code here

    }
}
