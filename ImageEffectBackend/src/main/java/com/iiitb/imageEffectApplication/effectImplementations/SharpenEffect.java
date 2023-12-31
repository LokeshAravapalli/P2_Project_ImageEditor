package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class SharpenEffect implements SingleValueParameterizableEffect {

    private float sharpenValue;

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if (parameterValue < 0.0f || parameterValue > 100.0f) {
            throw new IllegalParameterException("Sharpen value must be between 0.0 and 100.0");
        }
        this.sharpenValue = parameterValue;
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        String optionValues = String.valueOf(sharpenValue);
        loggingService.addLog(fileName,"Sharpen",optionValues);
        imageFile = SharpenInterface.applySharpen(imageFile,sharpenValue);
        return imageFile;
    }
}
