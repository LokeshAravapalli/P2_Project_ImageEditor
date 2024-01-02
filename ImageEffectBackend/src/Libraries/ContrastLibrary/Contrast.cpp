#include "Contrast.h"

void applyContrast(vector<vector<Pixel>>& image,float contrastFactor){
    if(contrastFactor<100){
        contrastFactor = ((float)(200/3) + (float)(contrastFactor/3))/100;
    }else{
        contrastFactor = contrastFactor/100;
    }
    for (int i = 0; i < image.size(); ++i) {
        for (int j = 0; j < image[i].size(); ++j) {
        image[i][j].r = (int) (contrastFactor * (image[i][j].r - 128) + 128); //contrast logic
        image[i][j].g = (int) (contrastFactor * (image[i][j].g - 128) + 128);
        image[i][j].b = (int) (contrastFactor * (image[i][j].b - 128) + 128);

        image[i][j].r = (image[i][j].r > 255) ? 255 : ((image[i][j].r < 0) ? 0 : image[i][j].r); //making sure that r,g,b lies between 0 and 255
        image[i][j].g = (image[i][j].g > 255) ? 255 : ((image[i][j].g < 0) ? 0 : image[i][j].g); 
        image[i][j].b = (image[i][j].b > 255) ? 255 : ((image[i][j].b < 0) ? 0 : image[i][j].b);
        }
    }    
}