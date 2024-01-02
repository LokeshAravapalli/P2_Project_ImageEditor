package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class GaussianBlurEffect implements SingleValueParameterizableEffect { //implements SingleValueParameterizableEffect interface

    private float radius;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {// this function sets parameter value
        if (parameterValue < 0 || parameterValue > 50) {//throws exception is value is out of range(0,50)
            throw new IllegalParameterException("Radius value must be between 0.0 and 50.0");
        }
        this.radius = parameterValue;//setting parameter value
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//this functions applies gaussian blur effect
        String optionValues = String.valueOf(radius);
        loggingService.addLog(fileName,"GaussianBlur",optionValues);//adding to logs
        imageFile = GaussianBlurInterface.applyGaussianBlur(imageFile,radius);//applying effect
        return imageFile;
    }
}
