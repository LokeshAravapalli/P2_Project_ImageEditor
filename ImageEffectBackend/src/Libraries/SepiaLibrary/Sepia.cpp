#include "Sepia.h"

void applySepia(vector<vector<Pixel>>& image) {
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            int red = image[i][j].r;
            int green = image[i][j].g;
            int blue = image[i][j].b;
            int sepiaRed = static_cast<int>(0.393 * red + 0.769 * green + 0.189 * blue);
            int sepiaGreen = static_cast<int>(0.349 * red + 0.686 * green + 0.168 * blue); //sepia logic
            int sepiaBlue = static_cast<int>(0.272 * red + 0.534 * green + 0.131 * blue);
            image[i][j].r = sepiaRed > 255 ? 255 : (sepiaRed < 0 ? 0 : sepiaRed);
            image[i][j].g = sepiaGreen > 255 ? 255 : (sepiaGreen < 0 ? 0 : sepiaGreen); //making sure the values of r,g,b lies between 0 and 255
            image[i][j].b = sepiaBlue > 255 ? 255 : (sepiaBlue < 0 ? 0 : sepiaBlue);
        }
    }
}
