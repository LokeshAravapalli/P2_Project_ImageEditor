# Image Effect Application

## Instructions to run
1. Go to project directory and run “npm i".
2. Go to the ImageEffectFrontEnd directory inside the project folder and run “npm i".
3. Now run npm start then you have to open local host url in browser.
4. Now open a new terminal and go to ImageEffectBackend and run following commands one by one  
-> make clean  
-> make  
-> mvn clean package  or ./mvnw clean package   
-> java -jar target/imageEffectApplication-0.0.1-SNAPSHOT.jar   
Now you can start using the application.  

## Description
### This is how we implemented our project:
* In ImageEffectBackend/src/Libraries we have a sub folder for each effect named "effect"Library.  
* In that we have written our code in 3 files namely "effect".cpp,"effect".h,"effect"Interface.cpp.  
* In "effect".cpp we implemented our logic to modify the image.    
* In "effect".h we have declared our function which we defined in "effect".cpp.   
* In "effect"Interface.cpp we have called our function which we have defined in "effect".cpp    
   
* Inside src/main/java/com/iiitb/imageEffectApplication we have created "effectImplementations" package.   
* For each effect we have created "effect"Effect.java for each effect. In that we have implemented the interface of appropriate base effects. Each effect class has an apply method that calls the "effect"Interface.apply"effect". This apply method also calls addLog method of logging service.     
   
* In src/main/java/com/iiitb/imageEffectApplication/service we have completed LoggingService.java.
* In src/main/java/com/iiitb/imageEffectApplication/service/PhotoEffectService.java we have created objects of Effects written in effectImplementations package applied effects after setting parameter if needed.

### Effects/Feautures Implemented:
* Brightness  
* Contrast
* Flip
* GrayScale
* Invert
* Rotation
* Sepia
* Logs
### Optional Effects/Feautures Implemented:
* Hue Saturation
* Gaussian Blur
* Sharpen
* Dominant Colour
* The logs can retain the complete history of previous runs, not just the history of the present run.

## Contribution

- **Brightness**:
Sathwik
- **Contrast**:
Chinmay
- **Dominant Colour**:
Pradyumna
- **Flip**:
Srinivas
- **Gaussian Blur**:
Sathwik
- **Gray Scale**:
Soma Datta
- **Hue Saturation**:
Lokesh
- **Invert**:
Pradyumna
- **Rotation**:
Srinivas
- **Sepia**:
Soma Datta
- **Sharpen**:
Chinmay
- **Logs**:
Lokesh
- **EffectImplementation Package**:
Lokesh,Pradyumna  