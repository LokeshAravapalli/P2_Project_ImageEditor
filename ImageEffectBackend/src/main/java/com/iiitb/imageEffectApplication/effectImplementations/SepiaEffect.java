package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class SepiaEffect implements PhotoEffect{//implements PhotoEffect interface

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//this effect does not take any parameter values, this function applies sepia effect
        loggingService.addLog(fileName,"Sepia","no value");//adding to logs
        imageFile = SepiaInterface.applySepia(imageFile);//applying the effect
        return imageFile;
    }
}
