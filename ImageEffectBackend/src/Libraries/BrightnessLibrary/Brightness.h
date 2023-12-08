#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H

#include <vector>
#include "../Pixel.h" 
using namespace std;
vector<vector<Pixel>> applyBrightness(vector<vector<Pixel>>& image,float amount);

#endif