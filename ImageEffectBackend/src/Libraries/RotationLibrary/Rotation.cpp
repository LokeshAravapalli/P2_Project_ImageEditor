#include "Rotation.h"

void applyRotation(vector<vector<Pixel>>& image,int rotation){
    int height = image.size();
    int width = image[0].size();
    if(rotation%2==1){
        int temp = height;
        height = width;
        width = temp;
    }
    vector<vector<Pixel>> modifiedImage(height, vector<Pixel>(width));
    for(int x=0;x<height;x++){
        for(int y =0;y<width;y++){
            if(rotation==0){  //angle = 0
                modifiedImage[x][y] = image[x][y];
            }
            if(rotation==1){  //angle = 90
                modifiedImage[x][width-1-y] = image[y][x];
            }
            if(rotation==2){  //angle = 180
                modifiedImage[height-1-x][width-1-y] = image[x][y];
            }
            if(rotation==3){  //angle = 270
                modifiedImage[height-1-x][y] = image[y][x];
            }
        }
    }
    image = modifiedImage;
}
