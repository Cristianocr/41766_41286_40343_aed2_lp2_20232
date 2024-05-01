Open project folder with IntelliJ

Install and Set JDK 17 (or above):
   Open File > Project Structure
      Select Platform Settings > SDKs: corretto-17.0.10

Install and Activate JavaFX Plugin and Scene Builder:
   Open IntelliJ Settings/Preferences
      Plugins: install JavaFX
      Languages & Frameworks: JavaFX > set Path to SceneBuilder

Install and Activate Scene Builder (for drawing GUIs):

Execute Maven Goal to create local Maven repository for algs4 lib:
   Open Terminal (command line shell)
   Execute command:
      ./mvnw install:install-file -Dfile=libs/algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar
   Close the project and re-open it with IntelliJ
