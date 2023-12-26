package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class RotationEffect implements SingleValueDiscreteEffect{

    private int rotationValue;
    private boolean isParameterSet;

    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        if (parameterValue!=0 && parameterValue!=1 && parameterValue!=2 && parameterValue!=3) {
            throw new IllegalParameterException("Rotation value must be 0 or 90 or 180 or 270");
        }
        this.rotationValue = parameterValue;
        this.isParameterSet = true;
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        if (!isParameterSet) {
            return imageFile;
        }
        String optionValues = String.valueOf(rotationValue*90);
        loggingService.addLog(fileName,"Rotation",optionValues);
        imageFile = RotationInterface.applyRotation(imageFile,rotationValue);
        return imageFile;
    }
}
