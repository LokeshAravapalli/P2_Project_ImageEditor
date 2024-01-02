#include "Sharpen.h"

vector<vector<Pixel>> padImage(const vector<vector<Pixel>>& image, int paddingSize) {
  int rows = image.size();
  int cols = image[0].size();

  vector<vector<Pixel>> paddedImage(rows + 2 * paddingSize, vector<Pixel>(cols + 2 * paddingSize));

  // Fill the padded image with zeros
  for (int i = 0; i < rows + 2 * paddingSize; ++i) {
    for (int j = 0; j < cols + 2 * paddingSize; ++j) {
      paddedImage[i][j].r = 0;
      paddedImage[i][j].g = 0;
      paddedImage[i][j].b = 0;
    }
  }

  // Copy the original image data to the padded image
  for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
      paddedImage[i + paddingSize][j + paddingSize] = image[i][j];
    }
  }

  return paddedImage;
}
// Apply sharpening filter to the image
void applySharpen(vector<vector<Pixel>>& imageVector, float amountt) {
  // Define the sharpening kernel
  float amount =amountt /30;
  const int kernelSize = 3;
  float kernel[kernelSize][kernelSize] = {
    {-1, -1, -1},
    {-1, 9, -1},
    {-1, -1, -1}
  };

  // Pad the image with zeros to prevent edge effects
  vector<vector<Pixel>> paddedImage = padImage(imageVector, kernelSize / 2);

  // Apply the convolution filter
  for (int i = kernelSize / 2; i < paddedImage.size() - kernelSize / 2; ++i) {
    for (int j = kernelSize / 2; j < paddedImage[i].size() - kernelSize / 2; ++j) {
      Pixel& pixel = imageVector[i - kernelSize / 2][j - kernelSize / 2];

      // Calculate the weighted sum of neighboring pixels
      float sumR = 0.0f;
      float sumG = 0.0f;
      float sumB = 0.0f;
      for (int k = 0; k < kernelSize; ++k) {
        for (int l = 0; l < kernelSize; ++l) {
          int neighborX = i + k - kernelSize / 2;
          int neighborY = j + l - kernelSize / 2;
          Pixel neighborPixel = paddedImage[neighborX][neighborY];
          sumR += neighborPixel.r * kernel[k][l];
          sumG += neighborPixel.g * kernel[k][l];
          sumB += neighborPixel.b * kernel[k][l];
        }
      }

      // Apply the sharpening factor
      sumR *= amount;
      sumG *= amount;
      sumB *= amount;

      // Add the original pixel value to the weighted sum
      pixel.r = static_cast<int>(pixel.r + sumR);
      pixel.g = static_cast<int>(pixel.g + sumG);
      pixel.b = static_cast<int>(pixel.b + sumB);

      // Ensure color values are within bounds (0-255)
      pixel.r = max(0, min(pixel.r, 255));
      pixel.g = max(0, min(pixel.g, 255));
      pixel.b = max(0, min(pixel.b, 255));
    }
  }
}