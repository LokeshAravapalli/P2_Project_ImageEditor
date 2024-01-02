#include "Invert.h"

void applyInvert(vector<vector<Pixel>>& image) {
    for (int i = 0; i < image.size(); ++i) {
        for (int j = 0; j < image[i].size(); ++j) {
            image[i][j].r = 255 - image[i][j].r;  
            image[i][j].g = 255 - image[i][j].g; //logic for inverting image
            image[i][j].b = 255 - image[i][j].b;
        }
    }
}