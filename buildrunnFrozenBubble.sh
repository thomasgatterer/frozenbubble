#sh
javac *.java net/library/jiga/*.java 
jar cvfm frozenBubble.jar manifest.mf *.txt *.gif *.jpg *.au *.class net/library/jiga/*.class
java -jar frozenBubble.jar 