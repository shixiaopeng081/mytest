package com.mytest.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author shixiaopeng  on 2018/6/8
 */
@Entity(name = "reply_default")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "系统级快捷回复")
public class ReplyDefaultDO {
    @Id
    @ApiModelProperty(value = "id", readOnly = true)
    private Integer id;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "文本")
    private String text;

    @Column(insertable = false, updatable = false)
    LocalDateTime updateDateTime;

    @ApiModelProperty(value = "快捷键")
    private String shortcutKey;
}
