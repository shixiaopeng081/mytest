package com.mytest.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liude
 */
@Slf4j
@ApiModel("分页数据格式")
public class RestPageImpl<T> extends PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestPageImpl(@JsonProperty("content") List<T> content,
                        @JsonProperty("number") int page,
                        @JsonProperty("size") int size,
                        @JsonProperty("totalElements") long total,
                        @JsonProperty("sort") List<?> orders) {
        super(content, orders == null ? new PageRequest(page, size) : new PageRequest(page, size, new Sort((List<Sort.Order>) orders)), total);
    }

    public RestPageImpl(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestPageImpl(List<T> content) {
        super(content);
    }

    public RestPageImpl() {
        super(new ArrayList<T>());
    }

    @ApiModelProperty(position = 0, value = "页码,第一页为0", example = "0")
    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @ApiModelProperty(position = 1, value = "每页的记录条数", example = "10")
    @Override
    public int getSize() {
        return super.getSize();
    }

    @ApiModelProperty(position = 2, value = "总页数", example = "1")
    @Override
    public int getTotalPages() {
        return super.getTotalPages();
    }

    @ApiModelProperty(position = 3, value = "总记录条数", example = "10")
    @Override
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @ApiModelProperty(position = 4, value = "是否为第一页")
    @Override
    public boolean isFirst() {
        return super.isFirst();
    }

    @ApiModelProperty(position = 5, value = "是否为最后一页")
    @Override
    public boolean isLast() {
        return super.isLast();
    }

    @ApiModelProperty(position = 6, value = "本页记录条数(可能小于每页记录条数)")
    @Override
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }

    @ApiModelProperty(position = 7, value = "排序方式")
    @Override
    public Sort getSort() {
        return super.getSort();
    }
}

