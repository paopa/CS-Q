package cs.notes;

public class SortZero {
	/**
	 * 題目：不新開 array 去解決排序上問題，而不改變其順序
	 * 		使其輸出結果會是:{9,4,6,7,1,0,0,0,0}
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {9,0,4,6,0,7,0,1,0};
//		solve1(a);
		solve2(a);
		
		for(int n:a) {
			System.out.print(n+" ");
		}
	}
	
	/**
	 * 概念：使用bubblesort的原理，去解決排序問題
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
	 * 概念：
	 * 時間複雜度：O(n)
	 * 
	 * @param array
	 */
	public static void solve2(int[] array) {
		int max=array.length-1;
		int i = 0;//array key
		int t = 0;// t=1開始用以重置i，進入下一輪
		int count = 0;//計算array[i]==0的連續性
		int count2 = 0;//計算array內有多少0
		while(true){
				if(t==1 && count == count2) break;
			
				if(t==0) {
					if(array[i]==0) count2++;
					if(i==max && t==0) t=1;
				}else {
					if(i>=max) {
						i=0;
					}else if(array[i] != 0) {
						count=0;
					}else if(array[i] == 0) {
						if(array[i+1] !=0) {
							array[i] = array[i+1];
							array[i+1] = 0;
						}else {
							count++;	
						}
					} 
				}
				i++;
			}
	}
}
