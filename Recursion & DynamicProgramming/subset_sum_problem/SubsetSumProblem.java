package subset_sum_problem;

public class SubsetSumProblem {

	// use Dynamic Programming to find if a subset of numbers add up to a given number

	public static void main(String[] args) {

		int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 

		//System.out.println(dynamicAttempt1(set, sum));
		
		System.out.println(dynamicSolution(set, sum, n));

	}

	private static boolean dynamicSolution(int[] set, int n, int sum) {

		int[][] matrix = new int[1][1];
		
		return false;
		
		
        
	}

	private static boolean dynamicAttempt1(int[] set, int n) {
		
		// Method uses bottom up approach to fill an n x m array with every possible  

		boolean result = false;

		int[][] dynamicArray = new int[set.length][set.length];

		for (int i = 0; i < set.length; i++) {

			for (int j = 0; j < set.length; j++) {


				dynamicArray[i][j] = set[i] + set[j];
				
				if (dynamicArray[i][j] == n)
					result = true;
				}
			
		}

		for (int i = 0; i < dynamicArray.length; i++) {
			for (int j = 0; j < dynamicArray.length; j++) {
				System.out.print(dynamicArray[i][j] + ", ");
			}
			System.out.println(" ");
		}

		return result;

	}

}
