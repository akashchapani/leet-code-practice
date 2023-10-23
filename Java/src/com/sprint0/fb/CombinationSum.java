package com.sprint0.fb;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	  public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        backtrack(candidates,0,target, new ArrayList<Integer>(), result);
	        
	        return result;
	        
	    }
	    
	    public void backtrack(int[] candidates,int start, int remain, List<Integer> list,List<List<Integer>> result)
	    {
	        if(remain <0)
	            return ;
	        
	        if(remain==0)
	        {  result.add(new ArrayList(list));
	        return;
	        }
	        
	        for(int i=start; i<candidates.length; i++)
	        {
	            list.add(candidates[i]);
	            backtrack(candidates,  i ,remain-candidates[i],list,result);
	            list.remove(list.size()-1);
	        }
	    }
}
