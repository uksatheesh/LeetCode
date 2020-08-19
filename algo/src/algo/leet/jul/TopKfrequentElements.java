package algo.leet.jul;

import java.util.*;
import java.util.stream.Collectors;

class TopKfrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        
        
        Map<Integer,Integer> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            count=0;
            if(hm.get(nums[i])==null){
                count+=1;
               }else{
                count=hm.get(nums[i])+1;
            }
            hm.put(nums[i],count);
        }
    hm=   hm.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,                           LinkedHashMap::new));
        
        Set<Integer> keys=hm.keySet();
        int[] op=new int[k];
        int j=0;
        for(Integer key:keys){
           
            if(!(j+1>k)){
                op[j]= key;
                j++;
            }
        }
        return op;
    }
    
    /*
     * Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]
     */
    
}