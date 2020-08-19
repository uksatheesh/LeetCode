package algo.leet.jul;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SubsetofGivenNumbers {
	
public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> subset=new ArrayList<>();
	this.allSubsets(0, 0, subset,nums);
	
	return null;
        
    }
	
	void allSubsets(int pos, int len, List<List<Integer>> subset,int[] nums) 
	{
		/*
		 * if(pos == nums.length) { System.out.println(subset); return ; } // Try the
		 * current element in the subset.\ List<Integer> in=null; //
		 * if(len>=subset.size()) { in=new ArrayList<Integer>(); subset.add(in); // } //
		 * else { // in=subset.get(len); // } in.add(nums[pos]);
		 * 
		 * allSubsets(pos+1, len+1, subset,nums); // Skip the current element.
		 * allSubsets(pos+1, len, subset,nums);
		 */
	List<Integer> in=new ArrayList<Integer>();
	subset.add(in);
	  len=nums.length;
	  while(pos<len) {
		  in=new ArrayList<>();
		  in.add(nums[pos]);
		  subset.add(in);
		  pos++;
		 	  
	  }
	 int temp=0; pos=temp;
	 in=new ArrayList<>();
	 int limit=1;
	  while(pos<len) {  
		  limit+=pos;
		  in=new ArrayList<>();
		  for(int i=pos;i<=limit;i++) {
			  in.add(nums[i]);
		  }
		  subset.add(in);
		  pos++;
		  if(pos==len-1) {
			 break; 
			  
		  }
		  
	  }
	  pos=0;
	  in=new ArrayList<>();
	  while(pos<len) {  
		  in.add(nums[pos]);
		  pos++;
		 }
	  
	  subset.add(in);
	  
	  System.out.println(subset);
	  
	  
	}
	
	
	/*
	 * public static void main(String[] args) { Snippet s=new Snippet(); int[] nums=
	 * {1,2,3}; s.subsets(nums); }
	 */
	
	
	public static void findPowerSet(int[] S, Deque<Integer> out, int i)
	{
		// if all elements are processed, print the current subset
		if (i < 0) {
			System.out.println(out);
			return;
		}

		// include current element in the current subset and recur
		out.addLast(S[i]);
		findPowerSet(S, out, i - 1);

		// backtrack: exclude current element in the current subset
		out.pollLast();

		// remove adjacent duplicate elements
		while (i > 0 && S[i] == S[i - 1]) {
			i--;
		}

		// exclude current element in the current subset and recur
		findPowerSet(S, out, i - 1);
	}

	// Program to generate all distinct subsets of given set
	public static void main(String[] args)
	{
		int[] S = { 1, 3, 2 };

		// sort the set
		Arrays.sort(S);

		// create an empty list to store elements of a subset
		Deque<Integer> out = new ArrayDeque<>();
		findPowerSet(S, out, S.length - 1);
	}
}

;