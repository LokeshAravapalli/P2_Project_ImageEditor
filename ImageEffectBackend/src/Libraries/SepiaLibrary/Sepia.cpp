#include "Sepia.h"
#include <vector>
#include "../Pixel.h"

void applySepia(vector<vector<Pixel>>& image) {
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            int red = image[i][j].r;
            int green = image[i][j].g;
            int blue = image[i][j].b;
            int sepiaRed = static_cast<int>(0.393 * red + 0.769 * green + 0.189 * blue);
            int sepiaGreen = static_cast<int>(0.349 * red + 0.686 * green + 0.168 * blue);
            int sepiaBlue = static_cast<int>(0.272 * red + 0.534 * green + 0.131 * blue);
            sepiaRed = min(255, max(0, sepiaRed));
            sepiaGreen = min(255, max(0, sepiaGreen));
            sepiaBlue = min(255, max(0, sepiaBlue));
            image[i][j].r = sepiaRed;
            image[i][j].g = sepiaGreen;
            image[i][j].b = sepiaBlue;
        }
    }
}
