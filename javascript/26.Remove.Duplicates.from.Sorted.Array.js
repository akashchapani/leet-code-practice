/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let previousValue = null;
  for(let i = 0 ; i < nums.length ; i++){
    if(previousValue == nums[i]){
      nums.splice(i, 1);
      i--;
    }else{
      previousValue = nums[i]
    }
  }
};
