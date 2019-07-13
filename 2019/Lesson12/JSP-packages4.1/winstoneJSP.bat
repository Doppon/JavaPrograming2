set WINSTONEBIN=Z:\winstone
set JAVA_HOME="C:\Program Files\Java\jdk1.7.0_67"
set JARFILE=winstone-4.0.jar
set LIB=%WINSTONEBIN%\lib
set WEBROOTDIR=Z:\win\eclipse\workspace\TestWinstone2\webapp

java -jar %WINSTONEBIN%\%JARFILE% --webroot=%WEBROOTDIR% --httpPort=8880 --toolsJar=%JAVA_HOME%\lib --useJasper

