package cs.notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author pao.s
 * 
 * @题目描述
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 
 * @解题思路
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。
 * 因此不能使用排序的方法，也不能使用额外的标记数组。
 * 
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
 * 本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
 * 
 * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，
 * 因此可以知道 2 重复。
 *
 */
public class FindSameNum {

	public static void main(String[] args) {
		
		/** 產生arrayList */
		List<Integer> alist = new ArrayList<Integer>();
		Random rand = new Random();
		
		int i =0;
		while(i<6) {
			alist.add(rand.nextInt(5));
			i++;
		}
		
		System.out.println("Input:");
		System.out.println(alist);
		
		/** 判斷是否有重複的數字*/
		Fsn fsn = new Fsn(alist) ;
		
		System.out.println("\nOnput:");
		
		if(fsn.output() != -1)
			System.out.println(fsn.output());
		else
			System.out.println("無");
	}
	
}

class Fsn {
	int outNum = 0;
	boolean check = false;
	List<Integer> alist; 
	
	public Fsn(List<Integer> alist) 
	{
		this.alist = alist;
		check();
	}
	
	public void check() 
	{
		Iterator<Integer> itr = alist.iterator();
		int temp = 0;
		while(itr.hasNext()) {
			temp = itr.next();
			itr.remove();
			if(alist.contains(temp)) {
				outNum = temp;
				check = true;
				break;
			}
		}
	}
	
	public int output() 
	{
		if(check)
			return outNum;
		else
			return -1;
	}
	
}
