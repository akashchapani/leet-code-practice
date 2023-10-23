package com.lc.playground;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonAncestorStreams {
	
	  private Set<Integer> ancestors = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonAncestorStreams solution = new CommonAncestorStreams();
		
		System.out.println("Graph 1");
        int[][] parentChildArray = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9},
                {9, 11}, {14, 4}, {13, 12}, {12, 9}};
        List<Pair> parentChildPairs = Arrays.stream(parentChildArray).map(pair -> {
            return new Pair(pair[0], pair[1]);
        }).collect(Collectors.toList());
        
        System.out.println("Result is " +solution.hasCommonAncestor(parentChildPairs, 3, 8));
        assert !solution.hasCommonAncestor(parentChildPairs, 3, 8);
		/*
		 * assert solution.hasCommonAncestor(parentChildPairs, 5, 8); assert
		 * solution.hasCommonAncestor(parentChildPairs, 6, 8); assert
		 * solution.hasCommonAncestor(parentChildPairs, 6, 9); assert
		 * !solution.hasCommonAncestor(parentChildPairs, 1, 3); assert
		 * !solution.hasCommonAncestor(parentChildPairs, 3, 1); assert
		 * solution.hasCommonAncestor(parentChildPairs, 7, 11); assert
		 * solution.hasCommonAncestor(parentChildPairs, 6, 5); assert
		 * solution.hasCommonAncestor(parentChildPairs, 5, 6);
		 */
	}

	private boolean hasCommonAncestor(List<Pair> parentChildPairs, int one, int two) {
		// TODO Auto-generated method stub
		 ancestors = new HashSet<>();
	        boolean commonAncestor = childrenHasCommonAncestors(parentChildPairs, Arrays.asList(one, two));
	        System.out.println(one + ", " + two + " has common ancestor: " + commonAncestor);
	        return commonAncestor;
	}

	private boolean childrenHasCommonAncestors(List<Pair> parentChildPairs, Collection<Integer> children) {
		// TODO Auto-generated method stub
		if (children.isEmpty())
            return false;
		
		Set<Integer> parents = new HashSet<>();
		
		 for (Pair pair : parentChildPairs) {
			 System.out.println(" Pair is "+ pair.parent  +"  " +pair.child);
			 System.out.println(" children is "+ children);
	            if (children.contains(pair.child)) {
	                if (ancestors.contains(pair.parent))
	                    return true;
	                parents.add(pair.parent);
	                ancestors.add(pair.parent);
	            }
	        }
		 return childrenHasCommonAncestors(parentChildPairs, parents);
		 
	}

}

class Pair {
    int parent;
    int child;

    Pair(int parent, int child) {
        this.parent = parent;
        this.child = child;
    }
}
