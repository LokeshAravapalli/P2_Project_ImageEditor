#include "DominantColour.h"
using namespace std;

void getDominantColour(vector<vector<Pixel>>& image) {
    vector<int> colorFrequency(32769, 0);

    // Count the frequency of each unique color in the image
    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++) {
            int colorKey = ((image[i][j].r % 8) << 10) | ((image[i][j].g % 8) << 5) | (image[i][j].b % 8);
            colorFrequency[colorKey]++;
        }
    }

    // Find the color with the highest frequency (dominant color)
    int maxFrequency = 0;
    int dominantColorKey = 0;

    for (int i = 0; i < colorFrequency.size(); i++) {
        if (colorFrequency[i] > maxFrequency) {
            maxFrequency = colorFrequency[i];
            dominantColorKey = i;
        }
    }

    // Extract r, g, b components from the dominant color key
    Pixel dominantColor;
    dominantColor.r = ((dominantColorKey >> 10) & 0x1F) * 8;
    dominantColor.g = ((dominantColorKey >> 5) & 0x1F) * 8;
    dominantColor.b = (dominantColorKey & 0x1F) * 8;

    // Set the entire image to the dominant color
    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[i].size(); j++) {
            image[i][j] = dominantColor;
        }
    }
}
