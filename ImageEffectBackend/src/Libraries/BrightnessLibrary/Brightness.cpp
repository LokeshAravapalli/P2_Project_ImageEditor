#include "Brightness.h"
#include "../Pixel.h" 

vector<vector<Pixel>> applyBrightness(vector<vector<Pixel>>& image,float amount) {
    vector<vector<Pixel>> modifiedImage = image; 
    for (size_t i = 0; i < modifiedImage.size(); ++i) {
        for (size_t j = 0; j < modifiedImage[i].size(); ++j) {
            modifiedImage[i][j].r = (modifiedImage[i][j].r * amount <= 255) ? modifiedImage[i][j].r * amount : 255;
            modifiedImage[i][j].g = (modifiedImage[i][j].g * amount <= 255) ? modifiedImage[i][j].g * amount : 255;
            modifiedImage[i][j].b = (modifiedImage[i][j].b * amount <= 255) ? modifiedImage[i][j].b * amount : 255;
        }
    }
    return modifiedImage;
}