#include "Contrast.h"

vector<vector<Pixel>> applyContrast(vector<vector<Pixel>>& image,float contrastFactor){
    vector<vector<Pixel>> modifiedImage = image;
    if(contrastFactor<100){
        contrastFactor = ((float)(200/3) + (float)(contrastFactor/3))/100;
    }else{
        contrastFactor = contrastFactor/100;
    }
    for (size_t i = 0; i < modifiedImage.size(); ++i) {
        for (size_t j = 0; j < modifiedImage[i].size(); ++j) {
        modifiedImage[i][j].r = (int) (contrastFactor * (modifiedImage[i][j].r - 128) + 128);
        modifiedImage[i][j].g = (int) (contrastFactor * (modifiedImage[i][j].g - 128) + 128);
        modifiedImage[i][j].b = (int) (contrastFactor * (modifiedImage[i][j].b - 128) + 128);

        modifiedImage[i][j].r = (modifiedImage[i][j].r > 255) ? 255 : ((modifiedImage[i][j].r < 0) ? 0 : modifiedImage[i][j].r);
        modifiedImage[i][j].g = (modifiedImage[i][j].g > 255) ? 255 : ((modifiedImage[i][j].g < 0) ? 0 : modifiedImage[i][j].g);
        modifiedImage[i][j].b = (modifiedImage[i][j].b > 255) ? 255 : ((modifiedImage[i][j].b < 0) ? 0 : modifiedImage[i][j].b);
        }
    }    
    return modifiedImage;
}