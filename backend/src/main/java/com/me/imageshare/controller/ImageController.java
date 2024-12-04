package com.me.imageshare.controller;

import com.me.imageshare.pojo.Image;
import com.me.imageshare.sevice.ImageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("")指定路径名

@RequestMapping(value = "/api/image")
public class ImageController {
    @Autowired
    private ImageSevice imageSevice;
    @GetMapping(value = "queryAll")
    @ResponseBody
    public List<Image> queryAll() {
        List<Image> ImageList = imageSevice.queryAll();
        System.out.println(ImageList);
        return ImageList;
    }
    @PostMapping(value = "add")
    @ResponseBody
    public String add(@RequestBody Image image){
        imageSevice.add(image);
        return "添加成功";
    }

}
