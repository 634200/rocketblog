@echo on
cd vueblog
call npm run build
xcopy /e /y dist\ ..\rocketblog\src\main\resources\static
cd ..\rocketblog
call ./mvnw clean package -DskipTests
xcopy /y .\target\rocketblog-0.0.1-SNAPSHOT.jar ..