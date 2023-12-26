#include "Sharpen.h"
#include "../Pixel.h" 

vector<vector<Pixel>> applySharpen(vector<vector<Pixel>>& image, float amount) {
    vector<vector<Pixel>> sharpenedImage = image; 

    float mappedValue = (float)amount / 100.0f;

    int centralWeight = 5; 
    int surroundWeight = -1;

    // Adjust weights based on mappedValue
    int adjustedCentralWeight = centralWeight + 5 * mappedValue;
    int adjustedSurroundWeight = surroundWeight - mappedValue;

    vector<vector<int>> kernel = {
        {0, adjustedSurroundWeight, 0},
        {adjustedSurroundWeight, adjustedCentralWeight, adjustedSurroundWeight},
        {0, adjustedSurroundWeight, 0}
    };

    int kernelSize = kernel.size();
    int halfKernelSize = kernelSize / 2;

    for (size_t i = halfKernelSize; i < image.size() - halfKernelSize; ++i) {
        for (size_t j = halfKernelSize; j < image[i].size() - halfKernelSize; ++j) {
            int sumR = 0, sumG = 0, sumB = 0;

            for (int x = -halfKernelSize; x <= halfKernelSize; ++x) {
                for (int y = -halfKernelSize; y <= halfKernelSize; ++y) {
                    sumR += image[i + x][j + y].r * kernel[x + halfKernelSize][y + halfKernelSize];
                    sumG += image[i + x][j + y].g * kernel[x + halfKernelSize][y + halfKernelSize];
                    sumB += image[i + x][j + y].b * kernel[x + halfKernelSize][y + halfKernelSize];
                }
            }

            // Clamping the pixel values to [0, 255]
            sumR = min(max(sumR, 0), 255);
            sumG = min(max(sumG, 0), 255);
            sumB = min(max(sumB, 0), 255);

            sharpenedImage[i][j].r = sumR;
            sharpenedImage[i][j].g = sumG;
            sharpenedImage[i][j].b = sumB;
        }
    }

    return sharpenedImage;
}
