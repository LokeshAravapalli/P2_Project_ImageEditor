package com.iiitb.imageEffectApplication.libraryInterfaces;




public class DominantColourInterface {
    static {
        String libraryPath = "DominantLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyDominantColour(Pixel[][] image);
}


