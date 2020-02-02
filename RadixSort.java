package sort;
import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] numbers = {9, 36, 215, 124, 87, 37, 24, 5, 12, 10, 56, 789, 211, 65, 73, 1};
		System.out.println("Before sorting: "+Arrays.toString(numbers));
		
		String result = Arrays.toString(radixSort(numbers));
		System.out.println("After sorting: "+result);
	}

	public static int[] radixSort(int[] array) {
		// get the max element to determine the number of digits
		// this is used to determine the number of passes required
		int maxElement = getMax(array);
		
		// call countSort method depending on the max digit
		// max digit determines the number of passes in this loop
		for(int exp = 1; maxElement/exp > 0; exp*=10) {
			countSort(array, exp );
		}
		
		return array;
	}
	
	private static void countSort(int[] array, int exp) {
		// initialise the count array with 0's
		int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		
		// digits are going to range from 0 - 9
		// "exp" determines which digit to count, and increment it
		// last digit or second last or third last or first digit etc..
		for(int i = 0; i < array.length; i++) {
			count[(array[i]/exp)%10]++;
		}
		
		// calculate the cumulative frequency
		// this help us to determine the actual position of 
		// the element in output array 
		// update the count array to hold this data.
		for(int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		
		// building the output array from the given array
		// create an empty array/output array
		// populate the output array starting from the end
		// this helps to maintain the stability of the algorithm
		int[] output = new int[array.length];
		for(int i = array.length-1; i>=0; i--) {
			output[ --count[(array[i]/exp)%10] ] = array[i];
		}
		
		// copy the output array to the original array.
		// so that next iteration it will use the partially sorted array
		for(int i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}

	private static int getMax(int[] array) {
		int max = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
}
