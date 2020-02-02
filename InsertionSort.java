package sort;
/*	0	1	2	3	4	<----- index
 * 
 * 	7	3	8	2	10  <------ elements of array
 * 
 *  i					<----- outer loop i
 * 
 *  j					<----- inner loop j
 *  
 *  insertion sort is efficient compared to bubble and selection sort
 *  it takes O(n) at best case where as selection sort is O(n^2)
 *  worst case it takes O(n^2)
 *  But it's not the best sorting algo in terms of performance
 */

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] nums = new int[]{9,8,4,2,1};
		printArray(insertionSort(nums));
	}
	
	private static int[] insertionSort(int[] numbers){
		for(int i = 1; i < numbers.length; i++){ // the card at the top of deck
			// items to the left of key are sorted array
			// items to the right of key are unsorted array
			// since there is no item behind the first item
			// we consider the first item as sorted
			// so the key will be set to index 1 of array to start
			int key = numbers[i]; 
			int j = i - 1; // the elements in our hand to be compared
			while(j >= 0 && key < numbers[j]){
				/*
				  	int temp = numbers[j+1];
					numbers[j+1] = numbers[j];  
					numbers[j] = temp; //swapping each time
					j--;
				*/
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = key;
		}
		return numbers;
	}
	
	private static void printArray(int[] nums){
		for(int number: nums){
			System.out.print(number+"\t");
		}
	}

}
