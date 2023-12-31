package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class HueSaturationEffect implements ParameterizableEffect {

    private float hueValue;
    private float saturationValue;

    public void setParameter(String paramName,float parameterValue) throws IllegalParameterException {
        if (parameterValue<0 || parameterValue>100) {
            if(paramName.equals("Hue")){
                throw new IllegalParameterException("Hue value must be between 0 and 100");
            }
            if(paramName.equals("Saturation")){
                throw new IllegalParameterException("Saturation value must be between 0 and 100");
            }
        }
        if(paramName.equals("Hue")){
            this.hueValue=parameterValue;
        }
        if(paramName.equals("Saturation")){
            this.saturationValue=parameterValue;
        }
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        String hueVal = String.valueOf(hueValue);
        String satVal = String.valueOf(saturationValue);
        String optionValues = "Hue Value: " + hueVal + "," + "Stauration Value: " + satVal;
        loggingService.addLog(fileName,"Hue and Saturation",optionValues);
        imageFile = HueSaturationInterface.applyHueSaturation(imageFile,saturationValue,hueValue);
        return imageFile;
    }
}
