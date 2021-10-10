import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.Random;
import java.util.Arrays;

public class SortingTester {

 	
	public static boolean checkSort(ISort sorter, int size){
		//TODO: implement this.
		KeyValuePair testArr[] = new KeyValuePair[size];
		//KeyValuePair sortedArr[] = new KeyValuePair[size];
		//int s = size;
		Random rand = new Random();
		int temp;
		int arr[] = new int[size];
		for(int i=0; i<size; i++){
			temp = rand.nextInt();
			testArr[i] = new KeyValuePair(temp, i);
			arr[i] = temp;
			//sortedArr[i] = new KeyValuePair(i, i);
		}
		sorter.sort(testArr);
		Arrays.sort(arr);

		for(int i=0; i<size-1; i++){
			if(testArr[i].getKey() != arr[i]){
				//System.out.println(testArr[i].getKey());
				//System.out.println(sortedArr[i].getKey());
				return false;
			}
		}
		return true;
	}

	public static boolean isStable(ISort sorter, int size){
		//TODO: implement this.
		KeyValuePair testArr[] = new KeyValuePair[size];
		Random rand = new Random();
		for(int i=0; i<size; i++){
			testArr[i] = new KeyValuePair(rand.nextInt(3), i);
		}

		sorter.sort(testArr);

		for(int i=0; i<size-1; i++){
			if(testArr[i].getKey() == testArr[i+1].getKey()){
				if(testArr[i].getValue() > testArr[i+1].getValue()){
					return false;
				}
			}
		}
		return true;
  }


	public static void main(String[] args){
		//TODO: implement some sorting tests
		System.out.println(isStable(new SorterE(), 1000)); //A and D unstable

	}
}
