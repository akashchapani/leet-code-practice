/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  for(let i = 0 ; i < (m+n) ; i++){
    if(i >= m){
      nums1.splice(i, 1, nums2[i-m]);
    }
  }

  nums1.sort((a, b) => a-b);
};
