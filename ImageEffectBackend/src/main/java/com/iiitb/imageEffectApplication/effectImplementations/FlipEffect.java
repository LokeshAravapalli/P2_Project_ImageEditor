package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.*;

public class FlipEffect implements DiscreteEffect {

    private int horizontalFlipValue;
    private int verticalFlipValue;

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        if (value!=0 && value != 1) {
            throw new IllegalParameterException("value must be between 0 or 1");
        }
        if(optionName.equals("horizontalFlipValue")){
            this.horizontalFlipValue=value;
        }
        if(optionName.equals("verticalFlipValue")){
            this.verticalFlipValue=value;
        }
    }

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        String optionValue1 = String.valueOf(horizontalFlipValue);
        String optionValue2 = String.valueOf(verticalFlipValue);
        String optionValues = optionValue1+","+optionValue2;
        loggingService.addLog(fileName,"Flip",optionValues);
        imageFile = FlipInterface.applyFlip(imageFile,horizontalFlipValue,verticalFlipValue);
        return imageFile;
    }
}
