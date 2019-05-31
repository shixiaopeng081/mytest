package com.mytest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shixi  on 2018/6/8
 */
@ApiModel(value = "个人级快捷回复")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    @ApiModelProperty(value = "id", readOnly = true)
    private Integer id;

    @ApiModelProperty(value = "所属销售的ID")
    private Integer salesId;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "文本")
    private String text;

    @ApiModelProperty(value = "快捷键")
    private String shortcutKey;

    @ApiModelProperty(value = "图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "图片宽度")
    private Integer width;

    @ApiModelProperty(value = "图片高度")
    private Integer height;

    @ApiModelProperty(value = "快捷回复类型")
    private String type;
}
