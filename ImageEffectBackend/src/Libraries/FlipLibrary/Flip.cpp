#include "Flip.h"
#include "../Pixel.h"

vector<vector<Pixel>> applyFlip(vector<vector<Pixel>>& image,int horizontalFlipValue, int verticalFlipValue){
    vector<vector<Pixel>> modifiedImage = image;
    int width = image.size();
    int height = image[0].size();
    
    if(horizontalFlipValue==1){
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width / 2; ++x) {
                Pixel temp = modifiedImage[y][x];
                modifiedImage[y][x] = modifiedImage[y][width - x - 1];
                modifiedImage[y][width - x - 1] = temp;
            }
        }
    }
    if(verticalFlipValue==1){
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height / 2; ++y) {
                Pixel temp = modifiedImage[y][x];
                modifiedImage[y][x] = modifiedImage[height - y - 1][x];
                modifiedImage[height - y - 1][x] = temp;
            }
        }
    }
    return modifiedImage;
}