# Plaigerism_Detector


## Functionality
The program is capable of:
- reading all text files (eg. 1.txt, 2.txt ...n.txt);
- compare it with other files contents (eg. a.txt, b.txt...);
- output similarity results to a comma-separated values (CSV) file with a score from [0 - 1.0]

## The program and Metric
- Use of java programming language 
- The program consists of one static method named ‘similarity’, and a main method to create the outputs. The ‘similarity’ static method takes two file arguments, one for the numerical files and one for the alphabetic files. It starts with two buffer readers to read each file, with the addition of a split() method to eliminate white spaces between strings. 
- The algorithm that performs the calculation to create the actual results starts with the similarity’s variable equal to 0. Two for loops then follow, which measure the length of each string from both argument files. 
- An if statement then checks, that if ‘file1’ contains the same word as ‘file2’. If so, the number of similarity’s are incremented each time to collect additional similarities. - - A return statement is used to return the similarity number calculated by dividing the number of similarities to the split string length of ‘file1’. 
- To create the CSV file, a PrinterWriter library method is used to write and specify the path to the CSV file, as well as a StringBuilder library method, to append the similarity results from all of the compared text files to the CSV file.
