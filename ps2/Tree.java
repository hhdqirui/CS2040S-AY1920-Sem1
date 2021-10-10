import java.util.*;

public class Tree {
    public int type;
    public int number;
    public int parent;
    public HashMap<Integer, Tree> children = new HashMap<>();
    public int qty;
    public int stock;

    public Tree(int type, int parent, int qty, int number){
        this.type = type;
        this.parent = parent;
        this.number = number;
        this.qty = qty;
        this.stock = 0;
    }

    public Tree(int type, int parent, int qty, int stock, int number){
        this.type = type;
        this.parent = parent;
        this.number = number;
        this.qty = qty;
        this.stock = stock;
    }

    public static void down(Tree root){
        for(Map.Entry entry: root.children.entrySet()){
            Tree chi = (Tree)entry.getValue();
            if(chi.type == 1){
                chi.stock = root.stock / chi.qty;
                down(chi);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("number: %d, type: %d, parent: %d, qty: %d, stock: %d", number, type, parent, qty, stock);
    }

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        Tree root = new Tree(2, 1, 1, m, 1);
        HashMap<Integer, Tree> map = new HashMap<>();
        map.put(1, root);
        //System.out.println(root);
        int index = 2;


        for(int i=0; i<n-1; i++){
            int type = s.nextInt(), parent = s.nextInt(), qty = s.nextInt(), stock = 0;
            Tree child;
            if(type == 1){
                child = new Tree(type, parent, qty, index);
            }
            else{
                stock = s.nextInt();
                child = new Tree(type, parent, qty, stock, index);
            }

            map.get(parent).children.put(index, child);
            map.put(index, child);

            Tree par = map.get(parent);
            if(type == 1){
                child.stock = par.stock / qty;
            }
            else{
                int coe = qty;
                while(par.type != 2){
                    coe *= par.qty;
                    par = map.get(par.parent);
                    //System.out.println((par.number));
                }

                int take = coe * stock;
                par.stock -= take;
            }

            down(par);
            index++;
            //System.out.println(child);
        }

        for(Map.Entry entry: map.entrySet()){
            System.out.println(((Tree)entry.getValue()).stock);
        }

    }
}
