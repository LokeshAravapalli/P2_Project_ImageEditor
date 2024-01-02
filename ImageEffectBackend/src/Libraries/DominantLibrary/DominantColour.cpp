#include "DominantColour.h"

void getDominantColour(vector<vector<Pixel>>& image) {
    vector<int> colorFrequency(32769, 0); //vector to count frequencies of each pixel

    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++) {
            int colorKey = ((image[i][j].r / 8) << 10) | ((image[i][j].g / 8) << 5) | (image[i][j].b / 8); //dividing by 8 to reduce reguired vector size
            colorFrequency[colorKey]++; //increasing frequency of colour
        }
    }

    int maxFrequency = 0;
    int dominantColorKey = 0;
//for loop to find most repeated colour
    for (int i = 0; i < colorFrequency.size(); i++) {
        if (colorFrequency[i] > maxFrequency) {
            maxFrequency = colorFrequency[i]; //updating max frequency index
            dominantColorKey = i;
        }
    }

    // extracting r, g, b components from the dominant color key
    Pixel dominantColor;
    dominantColor.r = ((dominantColorKey >> 10) & 0x1F) * 8;
    dominantColor.g = ((dominantColorKey >> 5) & 0x1F) * 8;
    dominantColor.b = (dominantColorKey & 0x1F) * 8;

    // filling the entire image using dominant colour
    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++) {
            image[i][j] = dominantColor;
        }
    }
}
