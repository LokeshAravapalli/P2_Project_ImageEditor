package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class InvertEffect implements PhotoEffect{//implemets PhotoEffect interface

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//this effect takes no parameter value, this function applies invert effect
        loggingService.addLog(fileName,"Invert","no value");//adding logs
        imageFile = InvertInterface.applyInvert(imageFile);//applying the effect
        return imageFile;
    }
}
