#include "Sepia.h"
#include <vector>
#include "../Pixel.h"

    vector<vector<Pixel>> applySepia(vector<vector<Pixel>>& image) {
        vector<vector<Pixel>> modifiedImage = image;
        for (size_t i = 0; i < modifiedImage.size(); ++i) {
            for (size_t j = 0; j < modifiedImage[i].size(); ++j) {
                int red = modifiedImage[i][j].r;
                int green = modifiedImage[i][j].g;
                int blue = modifiedImage[i][j].b;

                int sepiaRed = static_cast<int>(0.393 * red + 0.769 * green + 0.189 * blue);
                int sepiaGreen = static_cast<int>(0.349 * red + 0.686 * green + 0.168 * blue);
                int sepiaBlue = static_cast<int>(0.272 * red + 0.534 * green + 0.131 * blue);

                sepiaRed = min(255, max(0, sepiaRed));
                sepiaGreen = min(255, max(0, sepiaGreen));
                sepiaBlue = min(255, max(0, sepiaBlue));

                modifiedImage[i][j].r = sepiaRed;
                modifiedImage[i][j].g = sepiaGreen;
                modifiedImage[i][j].b = sepiaBlue;
            }
        }

        return modifiedImage;
    }
