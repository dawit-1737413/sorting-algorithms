/*
 * O(n*log(n))
 * n --> number of elements
 * log(n) --> level of tree(passes)
 */
package sort;

public class MergeSort {
	public static void main(String[] args){
		int[] numbers = {5, 4, 3, 2, 1, 8, 0, 13, 7, 9, 34, 25, 11};
		System.out.print("Before sorting: ");
		printArray(numbers);
		
		System.out.println();
		
		System.out.print("After sorting: ");
		numbers = mergeSort(numbers);
		printArray(numbers);
	}
	
	// divide the problem 
	private static int[] mergeSort(int[] array){
		if(array.length <= 1){
			return array;
		}
		int midPoint = array.length/2;
		int[] left = new int[midPoint];
		int[] right = new int[array.length - midPoint];
		
		//Populating the left and right array
		for(int i = 0; i < left.length; i++){
			left[i] = array[i];
		}
		for(int j = 0; j < right.length; j++){
			right[j] = array[midPoint + j];
		}
		
		// recursively call the method till one element is left which is sorted by default
		left = mergeSort(left);
		right = mergeSort(right);
		int[] result = new int[array.length];
		result = merge(left, right);
	
		return result;
	}

	// conquer/combine the solution now
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		// two way merge, merging two sorted lists into one sorted list
		while(leftPointer < left.length && rightPointer < right.length){
			if(left[leftPointer] < right[rightPointer]){
				result[resultPointer++] = left[leftPointer++];
			}else{
				result[resultPointer++] = right[rightPointer++];
			}
		}
		// filling up the remaining list on to the result list
		for(;leftPointer < left.length; leftPointer++){
			result[resultPointer++] = left[leftPointer];
		}
		for(;rightPointer < right.length; rightPointer++){
			result[resultPointer++] = right[rightPointer];
		}
		
		return result;
	}
	
	private static void printArray(int[] nums){
		for(int number: nums){
			System.out.print(number+" ");
		}
	}
}
