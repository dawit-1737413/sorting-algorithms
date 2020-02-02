package sort;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] numbers = {5, 9, 20, 1, 4, 3, 23, 7, 34, 2, 8, 11};
		System.out.print("Before sorting: ");
		System.out.println(Arrays.toString(numbers));
		System.out.print("After sorting: ");
		quickSort(numbers, 0, numbers.length -1);
		System.out.println(Arrays.toString(numbers));

	}

	public static void quickSort(int[] array, int low, int high){
		int mid = (low + high)/2;
		int i = low;
		int j = high;
		int pivot = array[mid];
		while(i <= j){
			while(array[i] < pivot){
				i++;
			}
			while(array[j] > pivot){
				j--;
			}
			
			// if i and j doesn't move past each other/ doesn't cross the pivot point
			if(i <= j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		//recursively call the quickSort
		if(low < j){
			quickSort(array, low, j);
		}
		if(high > i){
			quickSort(array, i, high);
		}
	}
}
