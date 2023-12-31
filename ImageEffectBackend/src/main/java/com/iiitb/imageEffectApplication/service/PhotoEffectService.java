package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.utils.ProcessingUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.*;
import com.iiitb.imageEffectApplication.controller.*;

import com.iiitb.imageEffectApplication.libraryInterfaces.*;
import com.iiitb.imageEffectApplication.effectImplementations.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            System.out.println(hueAmount);
            HueSaturationEffect hueSatEffect = new HueSaturationEffect();
            hueSatEffect.setParameter("Hue",hueAmount);
            hueSatEffect.setParameter("Saturation",saturationAmount);
            Pixel[][] modifiedImage = hueSatEffect.apply(inputImage,imageName,loggingService); // Replace this with actual modified image
            System.out.println(hueAmount);
            System.out.println(saturationAmount);
            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();




            // ACTUAL WORK STARTS HERE

            // TODO
            //Brightness 
            BrightnessEffect brightnessEffect = new BrightnessEffect();
            brightnessEffect.setParameterValue(amount);
            Pixel[][] modifiedImage = brightnessEffect.apply(inputImage, imageName, loggingService);


            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            System.out.println((amount-100)/100);
            ContrastEffect contrastEffect = new ContrastEffect();
            contrastEffect.setParameterValue(amount);
            Pixel[][] modifiedImage = contrastEffect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            FlipEffect flipEffect = new FlipEffect();
            flipEffect.selectOptionValue("horizontalFlipValue",horizontalFlipValue);
            flipEffect.selectOptionValue("verticalFlipValue",verticalFlipValue);
            Pixel[][] modifiedImage = flipEffect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GaussianBlurEffect gaussianBlurEffect = new GaussianBlurEffect();
            gaussianBlurEffect.setParameterValue(radius);
            Pixel[][] modifiedImage = gaussianBlurEffect.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            System.out.println(radius);

            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE
            GrayScaleEffect grayscale = new GrayScaleEffect();
            Pixel[][] modifiedImage = grayscale.apply(inputImage, imageName, loggingService);// Replace this with actual modified image
            // TODO
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            InvertEffect invert = new InvertEffect();
            Pixel[][] modifiedImage = invert.apply(inputImage, imageName, loggingService);
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO

            RotationEffect rotationEffect = new RotationEffect();
            rotationEffect.setParameterValue(value);
            Pixel[][] modifiedImage = rotationEffect.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            SepiaEffect sepia = new SepiaEffect();
            Pixel[][] modifiedImage = sepia.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            SharpenEffect sharpenEffect = new SharpenEffect();
            sharpenEffect.setParameterValue(amount);
            Pixel[][] modifiedImage = sharpenEffect.apply(inputImage,imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            System.out.println(amount);

            return processingUtils.postProcessing(modifiedImage);

        } catch (IllegalParameterException e) {
            e.printStackTrace(); // Handle the exception as per your application's requirements
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            DominantColour domicolour = new DominantColour();
            Pixel[][] modifiedImage = domicolour.apply(inputImage, imageName, loggingService);
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}