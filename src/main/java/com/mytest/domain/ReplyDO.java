package com.mytest.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author shixi  on 2018/6/8
 */
@Entity(name = "reply")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "个人级快捷回复")
public class ReplyDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer salesId;

    private String category;

    private String text;

    private String shortcutKey;

    private String imageUrl;

    private Integer width;

    private Integer height;

    private String type;

    @Column(insertable = false, updatable = false)
    LocalDateTime updateDateTime;

    @SuppressWarnings("all")
    public enum Type {
        TEXT("text", "文字"),
        IMAGE("image", "图片");
        public String code;
        public String desc;

        private Type(String code, String desc) {
            this.desc = desc;
            this.code = code;
        }

        public static boolean contains(String type) {
            for (Type t : Type.values()) {
                if(t.code.equals(type)){
                    return true;
                }
            }
            return false;
        }
    }

}
