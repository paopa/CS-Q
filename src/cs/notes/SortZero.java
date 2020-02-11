package cs.notes;

public class SortZero {
	/**
	 * 題目：不新開 array 去解決排序上問題，而不改變其順序
	 * 		使其輸出結果會是:{9,4,6,7,1,0,0,0,0}
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {9,0,4,6,0,7,0,1,0};
//		int[] a = {0,3,0,8,1,0,0,2,0};
//		solve1(a);
		solve2(a);
		
		for(int n:a) {
			System.out.print(n+" ");
		}
	}
	
	/**
	 * 概念：使用bubblesort的原理，去解決排序問題
	 * 
	 * 時間複雜度：O(n^2)
	 * 
	 * @param array
	 */
	public static void solve1(int[] array) {
		for(int i=array.length-2;i>=0;i--) 
			for(int j=0;j<=i;j++) {
				if(array[j]==0) {
					array[j] = array[j+1];
					array[j+1] = 0;
				}
			}
	
	}
	
	/**
	 * 概念：利用temp紀錄目前有0的array key值，
	 * 再去進行交換
	 * 
	 * 時間複雜度：O(n)
	 * 
	 * @param array
	 */
	public static void solve2(int[] array) {
		int temp = 0;
		for(int i =0;i<array.length-1;i++){
			if(array[i] !=0 && i-temp>=0 ) {
				if(array[i-temp] ==0 && temp>0) {
					array[i-temp] = array[i];
					array[i] = 0;	
				}
			}else {
				temp++;
			}
		}
	}
}
