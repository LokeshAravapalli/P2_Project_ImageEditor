package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class BrightnessEffect implements SingleValueParameterizableEffect {

    private float brightnessValue;
    private boolean isParameterSet;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < -0.0f || parameterValue > 200.0f) {
            throw new IllegalParameterException("Brightness value must be between 0.0 and 200.0");
        }
        this.brightnessValue = parameterValue;
        this.isParameterSet = true;
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        if (!isParameterSet) {
            return imageFile;
        }
        String optionValues = String.valueOf(brightnessValue);
        loggingService.addLog(fileName,"Brightness",optionValues);
        imageFile = BrightnessInterface.applyBrightness(imageFile,brightnessValue/100);
        return imageFile;
    }
}
