package com.me.imageshare.sevice;

import com.me.imageshare.pojo.Image;

import java.util.List;


public interface ImageSevice {


    List<Image> queryAll();
    void add(Image image);

}

