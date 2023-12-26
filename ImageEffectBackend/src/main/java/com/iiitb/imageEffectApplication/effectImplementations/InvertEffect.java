package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class InvertEffect implements SingleValueDiscreteEffect{

    // private int sepiaValue;
    // private boolean isParameterSet;

    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        // if (parameterValue!=0 && parameterValue!=1 && parameterValue!=2 && parameterValue!=3) {
        //     throw new IllegalParameterException("Rotation value must be 0 or 90 or 180 or 270");
        // }
        if(1>2){
            throw new IllegalParameterException("Ro");
        }
        // this.sepiaValue = parameterValue;
        // this.isParameterSet = true;
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName,"Invert","no value");
        imageFile = InvertInterface.applyInvert(imageFile);
        return imageFile;
    }
}
