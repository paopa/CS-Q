package cs.notes;

public class TwoSum {

	public static void main(String[] args) {
		int[] a = {3,2,4};
		int target = 6;
		int [] answer = twoSum(a,target);
		
		for(int x:answer)
			System.out.print(x+" ");
	}
	
	/**
	 * 概念:bubble sort 全比較
	 * 
	 * Time  complexity:O(n^2)
	 * Space complexity:O(1)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * @throws IllegalAccessException 
	 * 
	 */
	public static int[] twoSum(int[] nums, int target){
		int match;
        for(int i=0;i<=nums.length-1;i++){
            match = target - nums[i];
            for(int j=0;j<=nums.length-1;j++) {
            	if(i == j) continue;
            	if(nums[j] == match)
            		return new int[] {i,j};
            }
        }
        
        return new int[] {0};
    }

}
