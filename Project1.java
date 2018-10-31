public class Project1 {

	private static int minIndexBinarySearch(int[] array, int key) {
    	int low = 0;
    	int high = array.length - 1;
    	while (low <= high)
    	{
    	    int mid = (low + high) / 2;
    	    if (array[mid] < key)
    	    {
    	      low = mid+1;
    	    }
    	    else
    	    {
    	    	high = mid-1;
    	    }
    	}
    	return low;
    	    	
    }

	private static int maxIndexBinarySearch(int[] array, int key) {
    	int low = 0;
    	int high = array.length - 1;
    	while (low <= high)
    	{
    	    int mid = (low + high) / 2;
    	    if (array[mid] > key)
    	    {
    	      high= mid-1;
    	    }
    	    else
    	    {
    	    	low = mid+1;
    	    }
    	}
    	return high;
    }

	private static int countNumberOfKeys(int[] array, int key) {
		int max = maxIndexBinarySearch(array, key);
		int min = minIndexBinarySearch(array, key);
		if (max == -1|| min == -1)
			return 0;

		int count = max-min+1;
		return count;
		
	}

	
	private static int numCommonElements(int[]A, int[]B, int lenA, int lenB) {
		
		int count =0;
		int i = 0, j = 0;
		for(i=0; i<lenA; i++) { //O(n)
			while(j<lenB) { //O(logn)
				//O(nlogn)
				if(A[i]>B[j]) {
					j++;
				}
				else if (A[i]<B[j]) {
					break;
				}
				else {
					if((i!=0 && j!=0) && (A[i]!=A[i-1]&&B[j]!=B[j-1])) {
						count++;
					}
					else if(i==0 && j==0) {
						count++;
					}
					j++;
				}
			}
		}return count;
	}

	public static void main(String[] args) throws Exception {

		int array[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 27, 39, 39, 39 };
		System.out.println("*** Counting the number of occurrences of key ***\n");
		System.out.println("Number of occurrences of 1 is " + countNumberOfKeys(array, 1));
		System.out.println("Number of occurrences of 14 is " + countNumberOfKeys(array, 14));
		System.out.println("Number of occurrences of 39 is " + countNumberOfKeys(array, 39));
		System.out.println("Number of occurrences of 7 is " + countNumberOfKeys(array, 7));
		System.out.println("Number of occurrences of 100 is " + countNumberOfKeys(array,100));
		System.out.println("Number of occurrences of -88 is " + countNumberOfKeys(array, -88));
		System.out.println("Number of occurrences of 16 is " + countNumberOfKeys(array, 16));
		System.out.println("\n*** Counting the number of elements with occurrences in two arrays ***\n");

		int A[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int B[] = { 1, 1, 5, 7, 9, 14, 23, 27, 39, 39 };
		System.out.println("Number of common elements is " + numCommonElements(B, A, B.length, A.length));
		int C[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 23, 39, 39, 39 };
		int D[] = { 8, 17, 17, 26, 38, 43, 43 };
		System.out.println("Number of common elements is " + numCommonElements(D, C, D.length, C.length));
		int E[] = { 1, 3, 7, 9, 14, 18, 23, 39 };
		int F[] = { 1, 5, 7, 9, 14, 39 };
		System.out.println("Number of common elements is " + numCommonElements(F, E, F.length, E.length));
	}
}

