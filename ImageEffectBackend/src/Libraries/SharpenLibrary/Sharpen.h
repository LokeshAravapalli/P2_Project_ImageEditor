#ifndef SHARPEN_H
#define SHARPEN_H

#include <vector>
#include "../Pixel.h" 
using namespace std;
vector<vector<Pixel>> applySharpen(vector<vector<Pixel>>& image,float amount);

#endif