#include "Grayscale.h"
#include <vector>
#include "../Pixel.h"


void applyGrayscale(vector<vector<Pixel>>& image) {
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            int gray = (image[i][j].r + image[i][j].g + image[i][j].b) / 3;
            image[i][j].r = gray;
            image[i][j].g = gray;
            image[i][j].b = gray;
        }
    }
}
