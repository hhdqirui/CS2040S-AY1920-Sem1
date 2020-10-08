///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    int s, t; // s is size, t is tap.
    int mySeed[]/* = new int[100]*/;

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        s = size;
        t = tap;
        mySeed = new int[s];
    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     */
    @Override
    public void setSeed(int[] seed) {
        // TODO:
        if(s < seed.length){
            System.out.println("seed length is larger than specified size");
        }
        else{
            for(int i=0; i<s; i++){
                mySeed[i] = seed[i];
            }
        }
        /*for(int i=0; i<s; i++){
            mySeed[i] = seed[i];
        }*/
    }

    /**
     * shift
     * @return
     * Description:
     */
    @Override
    public int shift() {
        // TODO:
        int new_bit = mySeed[s - 1] ^ mySeed[t];
        for(int i=s-1; i>0; i--){
            mySeed[i] = mySeed[i-1];
        }
        mySeed[0] = new_bit;
        return new_bit;
    }

    /**
     * generate
     * @param k
     * @return
     * Description:
     */
    @Override
    public int generate(int k) {
        // TODO:
        //System.out.println(k);
        int temp[] = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = shift(); //System.out.println(temp[i]);
        }

        int ans = 0;
        int power = 0;
        for(int i = k-1; i>=0; i--){
            if(temp[i] == 1){
                ans = (int) (ans + Math.pow(2, power));
            }
            power = power + 1;
        }
        //System.out.println("ans is " + ans);
        return ans;
    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toBinary(int[] array) {
        // TODO:
        int ans = 0, ten = 1;
        for(int i=0; i<array.length; i++){
            ans = ans + array[i]*ten;
            ten = ten * 10;
        }
        return ans;
    }
}
