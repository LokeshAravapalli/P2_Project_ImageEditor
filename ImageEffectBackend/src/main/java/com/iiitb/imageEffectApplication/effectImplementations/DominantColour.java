package com.iiitb.imageEffectApplication.effectImplementations;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.service.*;

public class DominantColour implements PhotoEffect{// implemets Photo Effect interface
    public Pixel[][] apply(Pixel[][] imageFile, String fileName, LoggingService loggingService) {//function applies dominant colour effect
        //Dominant colour effect has no parameter value
        loggingService.addLog(fileName,"Dominant Colour","no value");//adding to logs
        imageFile = DominantColourInterface.applyDominantColour(imageFile);//applying effect
        return imageFile;
    }
}
