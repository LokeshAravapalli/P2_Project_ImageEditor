package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class GrayScaleEffect implements PhotoEffect{

    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName,"Grayscale","no value");
        imageFile = GrayscaleInterface.applyGrayscale(imageFile);
        return imageFile;
    }
}
