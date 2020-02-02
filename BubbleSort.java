package sort;

import java.util.Arrays;

/*	0	1	2	3	4	<----- index
 * 
 * 	7	3	8	2	10  <------ elements of array
 * 
 *  i					<----- outer loop i
 * 
 *  j					<----- inner loop j
 *  
 *  Best case: O(n^2)
 *  Worst case: O(n^2)
 *  But by introducing flag ---> Best case: O(n)
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = {9,8,4,2,1,12,45,3,89};
		
		String resultA = Arrays.toString(bubleSort(nums));
		System.out.println("using Bublesort\n"+resultA);
		String resultB = Arrays.toString(bubleSortWithFlag(nums));
		System.out.println("using Bublesort with FLAG\n"+resultB);
	}
	
	private static int[] bubleSort(int[] numbers){
		for(int i = 0; i < numbers.length-1; i++){ // -1, because the last number will be already in sorted order
			for(int j = 0; j < numbers.length-i-1; j++){  // -i, to separate sorted array from unsorted array
				if(numbers[j] > numbers[j+1]){           // this also prevents array index out of bound exception
					// swap
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		return numbers;
	}
	
	private static int[] bubleSortWithFlag(int[] numbers){
		for(int i = 0; i < numbers.length-1; i++){
			boolean swapped = false;
			for(int j = 0; j < numbers.length-i-1; j++){  
				if(numbers[j] > numbers[j+1]){           
					// swap
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
		}
		return numbers;
	}
	
}
