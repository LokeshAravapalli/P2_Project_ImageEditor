#include "Sharpen.h"
#include "../Pixel.h" 

vector<vector<Pixel>> applySharpen(vector<vector<Pixel>>& image, float amount) {

    float mappedValue = (float)amount / 100.0f;
    vector<vector<Pixel>> sharpenedImage = image;

    int centralWeight = 5; 
    int surroundWeight = -1;

    int adjustedCentralWeight = centralWeight + 5 * mappedValue;
    int adjustedSurroundWeight = surroundWeight - mappedValue;

    float c=amount/10;
    float s=c*-0.2;
    vector<vector<float>> kernel = {
        {0, s, 0},
        {s, c, s},
        {0, s, 0}
        
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

            sumR = min(max(sumR, 0), 255);
            sumG = min(max(sumG, 0), 255);
            sumB = min(max(sumB, 0), 255);

            sharpenedImage[i][j].r = sumR;
            sharpenedImage[i][j].g = sumG;
            sharpenedImage[i][j].b = sumB;
        }
    }
    float namount = 100-(100-amount);
    for (size_t i = 0; i < sharpenedImage.size(); ++i) {
        for (size_t j = 0; j < sharpenedImage[i].size(); ++j) {
            sharpenedImage[i][j].r = (sharpenedImage[i][j].r * namount <= 255) ? sharpenedImage[i][j].r * namount : 255;
            sharpenedImage[i][j].g = (sharpenedImage[i][j].g * namount <= 255) ? sharpenedImage[i][j].g * namount : 255;
            sharpenedImage[i][j].b = (sharpenedImage[i][j].b * namount <= 255) ? sharpenedImage[i][j].b * namount : 255;
        }
    }

    return sharpenedImage;
}


// #include <vector>
// #include "bitmap.h"

// using namespace std;

/*
 * NOTE!
 *
 * This only works with 24-bit based uncompressed Bitmap format.
 * Use this tool below to convert your image into compatible format.
 * https://online-converting.com/image/convert2bmp/
 * also, don't forget to choose "Color" option to "24 Bit (True Color)."
 *
 * The algorithm is based on this tutorial (with few changes)
 * https://lodev.org/cgtutor/filtering.html#Sharpen
 *
 */


// double filter[5][5] =
// {
//   -1, -1, -1, -1, -1,
//   -1,  2,  2,  2, -1,
//   -1,  2,  8,  2, -1,
//   -1,  2,  2,  2, -1,
//   -1, -1, -1, -1, -1,
// };

// int filterWidth=5;
// int filterHeight=5;

// double factor = (amount+20)/500;
// double bias = 0.0;

// //int main () {

//     int h = bmp.size();
//     int w = bmp[0].size();

//     // SHARPENING!

//     for (int x = 0; x < w; x++) {
//       for (int y = 0; y < h; y++) {
//         double red = 0.0;
//         double green = 0.0;
//         double blue = 0.0;

//         for (int filterY = 0; filterY < filterHeight; filterY++) {
//           for (int filterX = 0; filterX < filterWidth; filterX++) {
//             int imageX = (x - filterWidth / 2 + filterX + w) % w;
//             int imageY = (y - filterHeight / 2 + filterY + h) % h;
//             red += bmp[imageY][imageX].r * filter[filterY][filterX];
//             green += bmp[imageY][imageX].g * filter[filterY][filterX];
//             blue += bmp[imageY][imageX].b * filter[filterY][filterX];
//           }
//         }

//         bmp[y][x].r =  min(max(int(factor * red + bias), 0), 255);
//         bmp[y][x].g =  min(max(int(factor * green + bias), 0), 255);
//         bmp[y][x].b =  min(max(int(factor * blue + bias), 0), 255);
//       }
//     }

//     // END SHARPENING!

//     return bmp;
//   }
