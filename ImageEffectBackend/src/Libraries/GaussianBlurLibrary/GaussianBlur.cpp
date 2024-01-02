#include "GaussianBlur.h"
#include <cmath>   
#include <numeric>  
using namespace std;

void applyGaussianBlur(vector<vector<Pixel>>& image, float radius) {
    if(radius==0) return;
    int height = image.size();
    int width = image[0].size();

    // creating a temporary copy of the image to store the modified values
    vector<vector<Pixel>> modifiedImage(height, vector<Pixel>(width));

    // gaussian kernel size and weights
    int kernelSize = static_cast<int>(2 * radius) + 1;
    vector<float> kernel(kernelSize);
    float sigma = radius / 3.0f;

    // generating the 1D Gaussian kernel
    for (int i = 0; i < kernelSize; ++i) {
        float x = i - static_cast<float>(kernelSize) / 2.0f;
        kernel[i] = exp(-(x * x) / (2 * sigma * sigma));
    }

    // normalising the kernel weights
    float sum = accumulate(kernel.begin(), kernel.end(), 0.0f);
    for (int i = 0; i < kernelSize; ++i) {
        kernel[i] /= sum;
    }

    // applying horizontal blur
    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            Pixel blurredPixel = {0, 0, 0};

            for (int i = 0; i < kernelSize; ++i) {
                int offsetX = x - static_cast<int>(kernelSize) / 2 + i;
                offsetX =   (offsetX < 0) ? 0 : ((offsetX > width-1) ? width-1 : offsetX);
                blurredPixel.r += kernel[i] * image[y][offsetX].r;
                blurredPixel.g += kernel[i] * image[y][offsetX].g;
                blurredPixel.b += kernel[i] * image[y][offsetX].b;
            }

            modifiedImage[y][x] = blurredPixel;
        }
    }

    // applying vertical blur
    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            Pixel blurredPixel = {0, 0, 0};

            for (int i = 0; i < kernelSize; ++i) {
                int offsetY = y - static_cast<int>(kernelSize) / 2 + i;
                offsetY =   (offsetY < 0) ? 0 : ((offsetY > height-1) ? height-1 : offsetY);
                blurredPixel.r += kernel[i] * modifiedImage[offsetY][x].r;
                blurredPixel.g += kernel[i] * modifiedImage[offsetY][x].g;
                blurredPixel.b += kernel[i] * modifiedImage[offsetY][x].b;
            }

            image[y][x] = blurredPixel;
        }
    }
}