/*
 * Best case: O(n^2)
 * Worst case: : O(n^2)
 */
package sort;

public class SelectionSort {
	public static void main(String[] args){
		int[] nums = new int[]{5,4,3,2,1};
		printArray(selectionSort(nums));
		System.out.println();
		printArray(selectionSortB(nums));
	}
	
	private static int[] selectionSort(int[] numbers){
		
		// We have to loop through unsorted part of an array
		// Hence we need two loops, sorted part and unsorted part
		
		for(int i = 0;  i < numbers.length-1; i++){
			
			for(int j = i+1; j < numbers.length; j++){
				if(numbers[j] < numbers[i]){
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
	 	}
		
		return numbers; 
	} 
	
private static int[] selectionSortB(int[] numbers){
		
		// We have to loop through unsorted part of an array
		// Hence we need two loops, sorted part and unsorted part
		
		for(int i = 0;  i < numbers.length-1; i++){
			
			// find the min Index
			int minIndex = i;
			for(int j = i+1; j < numbers.length; j++){
				if(numbers[j] < numbers[i]){
					j = minIndex;
				}
			}
			// swap the numbers
			int temp = numbers[i];
			numbers[i] = numbers[minIndex];
			numbers[minIndex] = temp;
	 	}
		
		return numbers; 
	} 
	
	
	private static void printArray(int[] nums){
		for(int number: nums){
			System.out.print(number+"\t");
		}
	}
}
