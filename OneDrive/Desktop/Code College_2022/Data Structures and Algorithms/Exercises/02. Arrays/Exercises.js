//Exercises

/* 1. Create a grades object that stores a set of student grades in an object. Provide a
function for adding a grade and a function for displaying the student’s grade average.
*/

var studentGrades = [65, 35, 3, 69, 75, 99, 89, 12, 78, 99];
var average = 0.0;
for (var i=0; i < studentGrades.length; i++) {
    average += studentGrades[i];
    var avg = (average/studentGrades.length);
}
console.log("Grade Average: " + (average)/studentGrades.length);

