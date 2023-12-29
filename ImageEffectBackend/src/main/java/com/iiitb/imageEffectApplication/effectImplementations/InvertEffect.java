package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class InvertEffect implements PhotoEffect{

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName,"Invert","no value");
        imageFile = InvertInterface.applyInvert(imageFile);
        return imageFile;
    }
}
