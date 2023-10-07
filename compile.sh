#!/bin/bash --verbose

javac -d bin src/cs2720/hw2/NodeType.java
javac -d bin -cp bin src/cs2720/hw2/DoublyLinkedList.java
javac -d bin -cp bin src/cs2720/hw2/DListDriver.java
java -cp bin src/cs2720/hw2/DListDriver.java string-input.txt
