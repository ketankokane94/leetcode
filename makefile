
prob3.class:	prob3.java ListNodeInt.class LinkedListUtil.class
	javac prob3.java  -Xlint
	java prob3

ListNodeInt.class: ListNodeInt.java
	javac ListNodeInt.java -Xlint

LinkedListUtil.class: LinkedListUtil.java
	javac LinkedListUtil.java -Xlint

prob4.class: prob4.java
	javac prob4.java -Xlint
	java prob4

prob5.class: prob5.java prob4.class
	javac prob5.java -Xlint
	java prob5

prob6.class: prob6.java
	javac prob6.java -Xlint
	java prob6


prob7.class: prob7.java
	javac prob7.java -Xlint
	java prob7

prob8.class: prob8.java
	javac prob8.java -Xlint
	java prob8
