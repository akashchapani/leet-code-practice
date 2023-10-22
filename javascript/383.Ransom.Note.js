/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
// var canConstruct = function(ransomNote, magazine) {
//   const ransomNoteArray = ransomNote.split('');
//   const magazineArray = magazine.split('');

//   for(let i = 0 ; i < ransomNoteArray.length; i++){
//       console.log("searching for -- "+ransomNoteArray[i]);
//       const magazineIndex = magazineArray.findIndex((e) => e == ransomNoteArray[i]);
//       if(magazineIndex < 0){
//           return false;
//       }
//       magazineArray.splice(magazineIndex, 1);
//   }
//   return true;
// };

function convertStringToObject(inputString){
  const resultingObject = {};
  for(let i = 0 ; i < inputString.length; i++){
    if(resultingObject[inputString[i]]){
      resultingObject[inputString[i]] = resultingObject[inputString[i]] + 1;
    }else{
      resultingObject[inputString[i]] = 1;
    }
  }
  return resultingObject;
}

var canConstruct = function(ransomNote, magazine) {
  const magazineObject = convertStringToObject(magazine);

  for(let i = 0 ; i < ransomNote.length; i++){
    if(magazineObject[ransomNote[i]]){
      magazineObject[ransomNote[i]] = magazineObject[ransomNote[i]] -1;
    }else{
      return false
    }
  }
  return true;
};
