
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
