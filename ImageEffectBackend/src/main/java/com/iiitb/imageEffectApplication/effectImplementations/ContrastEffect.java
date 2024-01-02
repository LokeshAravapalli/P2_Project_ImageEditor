package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class ContrastEffect implements SingleValueParameterizableEffect {//implementing SingleValueParameterizableEffect interface

    private float contrastValue;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {//function sets parameter value
        if (parameterValue < 0.0f || parameterValue > 200.0f) { // throws exception if parameter value is out of range(0,200)
            throw new IllegalParameterException("contrast value must be between -100.0 and +100.0");
        }
        this.contrastValue = parameterValue;//setting the parameter value
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//function applies contrast effect
        String optionValues = String.valueOf(contrastValue);
        loggingService.addLog(fileName,"Contrast",optionValues);//adding logs
        imageFile = ContrastInterface.applyContrast(imageFile,contrastValue);//applying the effect
        return imageFile;
    }
}
