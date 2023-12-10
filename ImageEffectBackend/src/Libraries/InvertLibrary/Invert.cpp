#include "Invert.h"
#include "../Pixel.h" 

//vector<vector<Pixel>> 
void applyInvert(vector<vector<Pixel>>& image) {
    vector<vector<Pixel>> modifiedImage = image; 
    for (size_t i = 0; i < modifiedImage.size(); ++i) {
        for (size_t j = 0; j < modifiedImage[i].size(); ++j) {
            modifiedImage[i][j].r = 255 - modifiedImage[i][j].r;
            modifiedImage[i][j].g = 255 - modifiedImage[i][j].g;
            modifiedImage[i][j].b = 255 - modifiedImage[i][j].b;
        }
    }
    image = modifiedImage;
    //return modifiedImage;
}