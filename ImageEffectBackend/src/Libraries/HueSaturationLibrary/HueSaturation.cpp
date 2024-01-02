#include "HueSaturation.h"
#include <algorithm>
#include <cmath>

// function to convert RGB to HSL
void rgbToHsl(int r, int g, int b, double& h, double& s, double& l) {
    double dr = r / 255.0;
    double dg = g / 255.0;
    double db = b / 255.0;
    double cmax = max(dr, max(dg, db));
    double cmin = min(dr, min(dg, db));
    double delta = cmax - cmin;
    l = (cmax + cmin) / 2.0;
    s = (delta == 0) ? 0 : delta / (1 - abs(2 * l - 1));
    if (delta == 0) {
        h = 0;  // undefined, but commonly set to 0
    } else if (cmax == dr) {
        h = 60.0 * fmod(((dg - db) / delta), 6.0);
    } else if (cmax == dg) {
        h = 60.0 * (((db - dr) / delta) + 2.0);
    } else {
        h = 60.0 * (((dr - dg) / delta) + 4.0);
    }
    h = fmod((h + 360.0), 360.0); 
}

// function to convert HSL to RGB
void hslToRgb(double h, double s, double l, int& r, int& g, int& b) {
    double c = (1 - abs(2 * l - 1)) * s;
    double x = c * (1 - abs(fmod(h / 60.0, 2.0) - 1));
    double m = l - c / 2.0;
    double rp, gp, bp;
    if (h >= 0 && h < 60) {
        rp = c;
        gp = x;
        bp = 0;
    } else if (h >= 60 && h < 120) {
        rp = x;
        gp = c;
        bp = 0;
    } else if (h >= 120 && h < 180) {
        rp = 0;
        gp = c;
        bp = x;
    } else if (h >= 180 && h < 240) {
        rp = 0;
        gp = x;
        bp = c;
    } else if (h >= 240 && h < 300) {
        rp = x;
        gp = 0;
        bp = c;
    } else {
        rp = c;
        gp = 0;
        bp = x;
    }
    r = int((rp + m) * 255.0);
    g = int((gp + m) * 255.0);
    b = int((bp + m) * 255.0);
}

void applyHueSaturation(vector<vector<Pixel>>& image, double hue, double saturation) {
    for (vector<Pixel>& row : image) {
        for (Pixel& pixel : row) {
            double h, s, l;
            rgbToHsl(pixel.r, pixel.g, pixel.b, h, s, l);
            h = fmod((hue*3.6), 360.0);
            s = saturation/100;
            hslToRgb(h, s, l, pixel.r, pixel.g, pixel.b);
        }
    }
}
