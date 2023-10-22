/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify arr in-place instead.
 */
var duplicateZeros = function(arr) {
  for(let i = 0 ; i < arr.length ; i++){
    if(arr[i] === 0){
      arr.splice(i, 0, 0);
      arr.pop();
      i++;
    }
  }
};

/**
 * Three things needs to be done if encounter 0:
 * 1. Insert 0 at the current index
 * 2. Remove the last element
 * 3. Increment the index by 1
 */
