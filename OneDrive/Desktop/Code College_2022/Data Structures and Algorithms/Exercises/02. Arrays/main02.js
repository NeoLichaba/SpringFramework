//Chapter 2

//Exercises
//Question 1
// This object has functions to add student grades and comput the average as stored in the object

function studentGrades() {
    this.grades= [];
    this.add = add;
    this.average = average;
    
}
function add(grades) {
    this.grades.push(grades);
    }

function average() {
        var total = 0;
        for (var i = 0; i < this.grades.length; ++i) {
        total += this.grades[i];
        }
        return total / this.grades.length;
}

var student1 = new studentGrades();
student1.add(89);
student1.add(100);
student1.add(75);
student1.add(79);
student1.add(67);
student1.add(98);
student1.add(50);
student1.add(15);
student1.add(65);
console.log(thisGrade.average());

//Question 2

//We make use of the reduce () function with strings to perform concatenation

var words = ["I ", "am "," a ", "Programming ", "Genius"]
var sentence = words.reduce(concat); 
console.log(sentence) // displays the text forwards - "I am a Programming Genius"

var words = ["I ", "am "," a ", "Programming ", "Genius"];
var sentence = words.reduceRight(concat);
console.log(sentence); // displays the text in reverse - "Genius Programming a am I" 

//Question 3
//Modify the weeklyTemps object in the chapter so that it stores a month’s worth of
//data using a two-dimensional array. Create functions to display the monthly average,
//a specific week’s average, and all the weeks’ averages.

var temps = [[20,28,32,23,12,14,-8], [32, -1, 40, 23, 12, 6, 13], [12, 34, 23, 12, 4, 8, 9], [23, 12, -2, 19, 23, 13, 17]];

week1 = [20,28,32,23,12,14,-8];
week2 = [32,-1,40,23,12,6,13];
week3 = [12,34,23,12,4,8,9];
week4=  [23,12,-2,19,23,13,17];

function monthTemps() {
    this.dataStore = [];
    this.add = add;
    this.averageWeek = averageWeek;
    this.averageAllWeeks= averageAllWeeks;
    this.averageMonthly = averageMonthly
    }

    function add(temp) {
    this.dataStore.push(temp);
    }
//Create function to calculate monthly temperature average
function averageMonthly() {
    var total = 0;
    for (var i = 0; i < this.averageMonthly.length; ++i) {
    total += this.averageMonthly[i];
    }
    return total / this.averageMonthly.length;
    }

//Create function calculating weekly average
    function average() {
        var total = 0;
        for (var i = 0; i < this.dataStore.length; ++i) {
        total += this.dataStore[i];
        }
        return total / this.dataStore.length;
        }
    var temps = new temps();
 
    temps.add([20,28,32,23,12,14,-8]);
    temps.add([32,-1,40,23,12,6,13]);
    temps.add([12,34,23,12,4,8,9]);
    temps.add([23,12,-2,19,23,13,17]);

console.log(temps.averageWeek(1));
console.log(temps.averageAllWeeks());
console.logt(temps.averageMonthly());

// Create an object that stores individual letters in an array and has a function for
//displaying the letters as a single word.

var alphabet