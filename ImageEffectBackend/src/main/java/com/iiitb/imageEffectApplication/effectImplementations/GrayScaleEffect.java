package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class GrayScaleEffect implements PhotoEffect{// implements PhotoEffect interface

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//Grayscale takes no parameter, this function applies grayscale effect
        loggingService.addLog(fileName,"Grayscale","no value");//adding to logs
        imageFile = GrayscaleInterface.applyGrayscale(imageFile);//applying the effect
        return imageFile;
    }
}
