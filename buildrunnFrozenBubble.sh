#sh
javac -source 1.2 -target 1.1 *.java net/library/jiga/*.java
jar cvfm frozenBubble.jar manifest.mf *.txt *.gif *.jpg *.au *.class net/library/jiga/*.class
java -jar frozenBubble.jar 