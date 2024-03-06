del *.class
del *.jar
"C:\Program Files\Java\jdk-21\bin\javac.exe"  *.java net\library\jiga\*.java
"C:\Program Files\Java\jdk-21\bin\jar.exe" cvfm frozenBubble.jar manifest.mf *.txt *.gif *.jpg *.au *.class net\library\jiga\*.class
"C:\Program Files\Java\jdk-21\bin\java.exe" -jar frozenBubble.jar

