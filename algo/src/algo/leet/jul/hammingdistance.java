package algo.leet.jul;

public class hammingdistance {
	/*Input: x = 1, y = 4

			Output: 2

			Explanation:
			1   (0 0 0 1)
			4   (0 1 0 0)
			       ↑   ↑

			The above arrows point to positions where the corresponding bits are different.*/
	public static int hammingDistance(int x, int y) {
        
		int val=x^y,count=0;
		String b=Integer.toBinaryString(val);
		for(int i=0;i<b.length();i++) {
			if(b.charAt(i)=='1')
				count++;
		}
		return count;
    }
	
	 public static void main(String[] args) {
		System.out.println(hammingDistanceBstSol(8, 3));
	 }
	 
	 public static int hammingDistanceBstSol(int x, int y) {
	        int count = 0;
	        if(x == y) {
	            return count;
	        }
	        while(x != 0 && y !=0) {
	            int xbit = (1 & x);
	            int ybit = (1 & y); 
	            if(xbit != ybit) {
	                count++;
	            }
	            x = x >> 1;
	            y = y >> 1;       
	        }
	        while(x != 0) {
	            int xbit = (1 & x);
	            if(xbit != 0) {
	                count++;
	            }
	             x = x >> 1;
	        }
	         while(y != 0) {
	            int ybit = (1 & y);
	            if(ybit != 0) {
	                count++;
	            }
	             y = y >> 1;
	        } 
	        
	        return count;
	        
	    }
}
