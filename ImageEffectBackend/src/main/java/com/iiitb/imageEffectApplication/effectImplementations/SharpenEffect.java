package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class SharpenEffect implements SingleValueParameterizableEffect {//implements SingleValueParameterizableEffect interface

    private float sharpenValue;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {//this function sets the parameter value
        if (parameterValue < 0.0f || parameterValue > 100.0f) {//throws exception if parameter value is out of range(0,100)
            throw new IllegalParameterException("Sharpen value must be between 0.0 and 100.0");
        }
        this.sharpenValue = parameterValue;//setting the parameter value
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//this function applies sharpen effect
        String optionValues = String.valueOf(sharpenValue);
        loggingService.addLog(fileName,"Sharpen",optionValues);//adding to logs
        imageFile = SharpenInterface.applySharpen(imageFile,sharpenValue);//applying the effect
        return imageFile;
    }
}
