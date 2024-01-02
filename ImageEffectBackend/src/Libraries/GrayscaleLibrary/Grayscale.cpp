#include "Grayscale.h"
#include <vector>
#include "../Pixel.h"


void applyGrayscale(vector<vector<Pixel>>& image) {
    for (int i = 0; i < image.size(); ++i) {
        for (int j = 0; j < image[i].size(); ++j) {
            int gray = (image[i][j].r + image[i][j].g + image[i][j].b) / 3; //taking average of r,g,b and assigning it to same pixel
            image[i][j].r = gray;
            image[i][j].g = gray;
            image[i][j].b = gray;
        }
    }
}
