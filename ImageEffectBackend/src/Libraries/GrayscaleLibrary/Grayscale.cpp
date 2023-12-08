#include "Grayscale.h"
#include <vector>
#include "../Pixel.h"


    vector<vector<Pixel>> applyGrayscale(vector<vector<Pixel>>& image) {
        vector<vector<Pixel>> modifiedImage = image;
        for (size_t i = 0; i < modifiedImage.size(); ++i) {
            for (size_t j = 0; j < modifiedImage[i].size(); ++j) {
                int gray = (modifiedImage[i][j].r + modifiedImage[i][j].g + modifiedImage[i][j].b) / 3;
                modifiedImage[i][j].r = gray;
                modifiedImage[i][j].g = gray;
                modifiedImage[i][j].b = gray;
            }
        }

        return modifiedImage;
    }
