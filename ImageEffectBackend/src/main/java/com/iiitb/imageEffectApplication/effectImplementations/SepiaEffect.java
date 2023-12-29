package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class SepiaEffect implements PhotoEffect{

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName,"Sepia","no value");
        imageFile = SepiaInterface.applySepia(imageFile);
        return imageFile;
    }
}
