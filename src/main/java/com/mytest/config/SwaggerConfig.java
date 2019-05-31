package com.mytest.config;

import com.fasterxml.classmate.TypeResolver;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.Pageable;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.schema.AlternateTypeRules;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author liude
 */
@EnableSwagger2Doc
@Configuration
public class SwaggerConfig {

    /**
     * swagger不会自动解析Pageable, 需要加入以下配置
     */
    @Configuration
    public static class SpringDataConfiguration {
        @Bean
        public AlternateTypeRuleConvention pageableConvention(final TypeResolver resolver) {
            return new AlternateTypeRuleConvention() {
                @Override
                public int getOrder() {
                    return Ordered.HIGHEST_PRECEDENCE;
                }

                @Override
                public List<AlternateTypeRule> rules() {
                    return newArrayList(AlternateTypeRules.newRule(resolver.resolve(Pageable.class), resolver.resolve(Page.class)));
                }
            };
        }

        @ApiModel
        @Data
        public static class Page {
            @ApiModelProperty(value = "取第几页的数据? 取值0-N", example = "0")
            private Integer page;

            @ApiModelProperty(value = "每页的数据量", example = "10")
            private Integer size;

            @ApiModelProperty("排序字段(可以是多个)")
            private List<String> sort;
        }
    }
}