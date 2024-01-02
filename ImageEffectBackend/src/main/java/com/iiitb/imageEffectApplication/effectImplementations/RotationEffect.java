package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class RotationEffect implements SingleValueDiscreteEffect{//implements SingleValueDiscreteEffect interface

    private int rotationValue;

    public void setParameterValue(int parameterValue) throws IllegalParameterException {//sets parameter value for rotation effect
        if (parameterValue!=0 && parameterValue!=1 && parameterValue!=2 && parameterValue!=3) {//throws exception if parameter values are not in the set : {0,1,2,3}
            throw new IllegalParameterException("Rotation value must be 0 or 90 or 180 or 270");
        }
        this.rotationValue = parameterValue;//setting parameter value
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//this function applies rotation effect
        String optionValues = String.valueOf(rotationValue*90);
        loggingService.addLog(fileName,"Rotation",optionValues);//adding to logs
        imageFile = RotationInterface.applyRotation(imageFile,rotationValue);//applying the effect
        return imageFile;
    }
}
