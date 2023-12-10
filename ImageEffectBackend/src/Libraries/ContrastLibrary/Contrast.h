#ifndef CONTRAST_H
#define CONTRAST_H
#include "../Pixel.h"
#include<vector>
using namespace std;

vector<vector<Pixel>> applyContrast(vector<vector<Pixel>>& image,float contrastFactor);
#endif