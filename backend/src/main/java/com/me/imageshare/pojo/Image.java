package com.me.imageshare.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Data
@Setter
@Getter
// 使用@AllArgsConstructor自动生成有参构造
@AllArgsConstructor
// 使用@NoArgsConstructor自动生成无参构造
@NoArgsConstructor
public class Image {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "image_url")
    private String imageUrl;

    @TableField(value = "image_name")
    private String imageName;

    @TableField(value = "upload_time")
    private String uploadTime;
}
