#include "Flip.h"

void applyFlip(vector<vector<Pixel>>& image,int horizontalFlipValue, int verticalFlipValue){
    vector<vector<Pixel>> modifiedImage = image;
    int height = image.size();
    int width = image[0].size();
    //flipping horizontally
    if(horizontalFlipValue==1){
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                modifiedImage[y][x] = image[y][width - x - 1];
            }
        }
    }
    image = modifiedImage;
    //flipping vertically
    if(verticalFlipValue==1){
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                modifiedImage[y][x] = image[height - y - 1][x];
            }
        }
    }
    image = modifiedImage;
}