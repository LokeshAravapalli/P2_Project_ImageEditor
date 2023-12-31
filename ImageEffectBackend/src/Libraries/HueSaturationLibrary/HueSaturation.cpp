#include"HueSaturation.h"
#include <cmath>
#include <algorithm>
#include <iostream>
#include <vector>


// Function to convert RGB to HSL
void RGBtoHSL(const Pixel& pixel, double& hue, double& saturation, double& lightness) {
    double r = pixel.r / 255.0;
    double g = pixel.g / 255.0;
    double b = pixel.b / 255.0;

    double cmax = std::max({r, g, b});
    double cmin = std::min({r, g, b});
    double delta = cmax - cmin;

    lightness = (cmax + cmin) / 2;

    if (delta == 0) {
        hue = 0; // Undefined, set to 0
    } else if (cmax == r) {
        hue = 60 * fmod(((g - b) / delta), 6);
    } else if (cmax == g) {
        hue = 60 * (((b - r) / delta) + 2);
    } else if (cmax == b) {
        hue = 60 * (((r - g) / delta) + 4);
    }

    if (delta == 0) {
        saturation = 0;
    } else {
        saturation = delta / (1 - std::abs(2 * lightness - 1));
    }
}

// Function to convert HSL to RGB
Pixel HSLtoRGB(double hue, double saturation, double lightness) {
    double c = (1 - std::abs(2 * lightness - 1)) * saturation;
    double x = c * (1 - std::abs(fmod((hue / 60), 2) - 1));
    double m = lightness - c / 2;

    double r1, g1, b1;
    if (hue >= 0 && hue < 60) {
        r1 = c;
        g1 = x;
        b1 = 0;
    } else if (hue >= 60 && hue < 120) {
        r1 = x;
        g1 = c;
        b1 = 0;
    } else if (hue >= 120 && hue < 180) {
        r1 = 0;
        g1 = c;
        b1 = x;
    } else if (hue >= 180 && hue < 240) {
        r1 = 0;
        g1 = x;
        b1 = c;
    } else if (hue >= 240 && hue < 300) {
        r1 = x;
        g1 = 0;
        b1 = c;
    } else {
        r1 = c;
        g1 = 0;
        b1 = x;
    }

    int r = static_cast<int>(((r1 + m) * 255));
    int g = static_cast<int>(((g1 + m) * 255));
    int b = static_cast<int>(((b1 + m) * 255));

    r = r%255;
    g = g%255;
    b = b%255;
    return {r, g, b};
}

// Function to apply hue adjustment to the entire image
void applyHueAdjustment(std::vector<std::vector<Pixel>>& image, double hueAdjustment) {
    for (auto& row : image) {
        for (auto& pix : row) {
            double hue, saturation, lightness;
            RGBtoHSL(pix, hue, saturation, lightness);

            // Adjust hue
            hue += hueAdjustment;

            // Wrap hue value within the valid range (0-360 degrees)
            hue = fmod(hue, 360.0);
            if (hue < 0) {
                hue += 360.0;
            }

            pix = HSLtoRGB(hue, saturation, lightness);
        }
    }
}

// Function to apply saturation adjustment to the entire image
void applySaturationAdjustment(std::vector<std::vector<Pixel>>& image, double saturationAdjustment) {
    for (auto& row : image) {
        for (auto& pix : row) {
            double hue, saturation, lightness;
            RGBtoHSL(pix, hue, saturation, lightness);

            // Adjust saturation
            saturation *= saturationAdjustment;

            // Clamp saturation value between 0 and 1
            saturation = std::max(0.0, std::min(saturation, 1.0));

            pix = HSLtoRGB(hue, saturation, lightness);
        }
    }
}

void applyHueSaturation(vector<vector<Pixel>>& image, double hue, double saturation) {
            applyHueAdjustment(image, hue*3.6);
            applySaturationAdjustment(image, saturation/100);
}