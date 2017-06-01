Project 5
Clayton Lewis
lewis323@purdue.edu

Files:
BurrowsWheeler.java
Suffix.java
MoveToFront.java

The included suffix class is used to implement an array of suffixes in
BurrowsWheeler. This class uses a static String to hold the input text and
each instance accesses a portion of that text starting at the appropriate
index. This class is necessary to save memory space.

Compilation Commands:
javac -cp .:stdlib.jar:algs4.jar BurrowsWheeler.java Suffix.java
javac -cp .:stdlib.jar:algs4.jar MoveToFront.java

Execution Command Examples:
run statement to send encoded to decoded
java -cp .:stdlib.jar:algs4.jar BurrowsWheeler - < abra.txt | java -cp .:stdlib.jar:algs4.jar BurrowsWheeler +

run statement to send encoded to HexDump
java -cp .:stdlib.jar:algs4.jar BurrowsWheeler - < abra.txt | java -cp .:stdlib.jar:algs4.jar HexDump

run statement to create mtf file after encode (abra2 so you don't overwrite the file they gave)
java -cp .:stdlib.jar:algs4.jar MoveToFront - < abra.txt > abra2.txt.mtf