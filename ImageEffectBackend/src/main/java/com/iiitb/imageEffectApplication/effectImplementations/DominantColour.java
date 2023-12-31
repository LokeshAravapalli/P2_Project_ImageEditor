package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class DominantColour implements PhotoEffect{
    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName,"Dominant Colour","no value");
        imageFile = DominantColourInterface.applyDominantColour(imageFile);
        return imageFile;
    }
}
