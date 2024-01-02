package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class BrightnessEffect implements SingleValueParameterizableEffect {// implements SingleValueParameterizableEffect interface

    private float brightnessValue;

    public void setParameterValue(float parameterValue) throws IllegalParameterException { //this function sets the parameter value
        if (parameterValue < 0.0f || parameterValue > 200.0f) {// throws exception if range of parameter is out of range (0,200)
            throw new IllegalParameterException("Brightness value must be between 0.0 and 200.0");
        }
        this.brightnessValue = parameterValue; //setting parameter value
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) { //function applies brightness effect
        String optionValues = String.valueOf(brightnessValue);
        loggingService.addLog(fileName,"Brightness",optionValues);//adding to logs
        imageFile = BrightnessInterface.applyBrightness(imageFile,brightnessValue/100);//applying the effect
        return imageFile;
    }
}
