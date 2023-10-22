/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
  let count = 0;
  let currentMax = 0;
  for(let i = 0 ; i < nums.length; i++){
    if(nums[i] == 1){
      count++;
      if(count > currentMax){
        currentMax = count;
      }
    }else{
      count = 0;
    }
  }
  return currentMax;
};
