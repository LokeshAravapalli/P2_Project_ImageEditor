#include "Brightness.h"

void applyBrightness(vector<vector<Pixel>>& image,float amount) {
    for (int i = 0; i < image.size(); ++i) {
        for (int j = 0; j < image[i].size(); ++j) {  //logic for brightening the image
            image[i][j].r = (image[i][j].r * amount <= 255) ? image[i][j].r * amount : 255; //colour.r multiplied by brightness amount
            image[i][j].g = (image[i][j].g * amount <= 255) ? image[i][j].g * amount : 255; //if colour.r*amount>255 this takes 255(since it is max)
            image[i][j].b = (image[i][j].b * amount <= 255) ? image[i][j].b * amount : 255; //similarly for blue and green
        }
    }
}