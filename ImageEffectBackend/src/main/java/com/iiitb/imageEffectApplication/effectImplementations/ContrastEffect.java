package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class ContrastEffect implements SingleValueParameterizableEffect {

    private float contrastValue;
    private boolean isParameterSet;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < -0.0f || parameterValue > 200.0f) {
            throw new IllegalParameterException("contrast value must be between -100.0 and +100.0");
        }
        this.contrastValue = parameterValue;
        this.isParameterSet = true;
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        if (!isParameterSet) {
            return imageFile;
        }
        String optionValues = String.valueOf(contrastValue);
        loggingService.addLog(fileName,"Contrast",optionValues);
        imageFile = ContrastInterface.applyContrast(imageFile,contrastValue/100);
        return imageFile;
    }
}
