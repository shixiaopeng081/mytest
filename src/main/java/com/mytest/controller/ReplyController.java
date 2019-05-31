package com.mytest.controller;


import com.mytest.domain.ReplyDO;
import com.mytest.domain.ReplyDefaultDO;
import com.mytest.service.ReplyServiceImpl;
import com.mytest.vo.ReplyDTO;
import com.mytest.vo.RestPageImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author shixiaopeng
 * <p>
 * CRUD
 */
@Api(tags = "快捷回复相关方法")
@Slf4j
@RestController
public class ReplyController {

    @ApiOperation(value = "新增快捷回复", notes = "关键的salesId需要web-api认证通")
    @PostMapping("/replies")
    public ReplyDO createReply(@RequestBody ReplyDO replyDO) {
        replyDO.setId(null);
        validate(replyDO);
        return replyService.save(replyDO);
    }

    private void validate(@RequestBody ReplyDO replyDO) {
        Assert.isTrue(ReplyDO.Type.contains(replyDO.getType()), "type只能是text或者image格式！");
        if (replyDO.getType().equals(ReplyDO.Type.IMAGE.code)) {
            Assert.hasLength(replyDO.getImageUrl(), "imageUrl不能为空！");

            if (Objects.isNull(replyDO.getHeight())) {
                replyDO.setHeight(DEFAULT_HEIGHT);
            }

            if (Objects.isNull(replyDO.getWidth())) {
                replyDO.setWidth(DEFAULT_WIDTH);
            }
        }
    }

    @ApiOperation("批量导入快捷回复")
    @PostMapping("/replies/_batch")
    public List<ReplyDO> batchReply(@RequestBody List<ReplyDO> replyDOList) {
        List<ReplyDO> result = replyDOList.stream()
                .peek(replyDO -> {
                    replyDO.setType(ReplyDO.Type.TEXT.code);
                    replyDO.setId(null);
                }).collect(Collectors.toList());

        replyService.save(result);

        return result;
    }

//    @ApiOperation("根据groupId查询快捷回复列表")
//    @GetMapping("/replies")
//    public List<ReplyDO> listReply(@RequestParam("groupId") Integer groupId) {
//        log.info("根据groupId查询快捷回复列表, listReply");
//        return replyService.findByGroupId(groupId);
//    }

    @ApiOperation(value = "根据销售ID获取所有系统级和个人级的快捷回复", notes = "个人级快捷回复为空的时候, 显示系统级的分类列表, 内容为空")
    @GetMapping("/replies")
    public ReplyListDTO listReplyBySalesId(@RequestParam("salesId") Integer salesId) {
        return replyService.findBySalesId(salesId);
    }

    @ApiOperation(value = "查询快捷回复分类")
    @GetMapping("/categorys")
    public List<String> distinctCategory() {
        return replyService.distinctCategory();
    }

    @ApiOperation(value = "查询快捷键")
    @GetMapping("/replies/shortcut-key")
    public List<String> distinctShortcutKey(@RequestParam("salesId") Integer salesId) {
        return replyService.distinctShortcutKeyBySalesId(salesId);
    }

    @ApiOperation(value = "根据分类查询系统快捷回复列表")
    @GetMapping("/replies/system")
    public RestPageImpl<ReplyDefaultDO> replyDefaultDOList(@RequestParam(required = false, value = "text") String text, @RequestParam("category") String category, @PageableDefault(page = 0, size = 10, sort = "updateDateTime", direction = Sort.Direction.DESC) Pageable pageRequest) {
        if (StringUtils.isNotBlank(text)) {
            return replyService.defaultReplyListByCategoryAndTextLike(category, text, pageRequest);
        } else {
            return replyService.defaultReplyListByCategory(category, pageRequest);
        }
    }

    @ApiOperation(value = "根据分类查询自定义快捷回复列表")
    @GetMapping("/replies/person")
    public RestPageImpl<ReplyDTO> replyReplyDOList(@RequestParam("salesId") Integer salesId, @RequestParam(required = false, value = "text") String text, @RequestParam("category") String category, @PageableDefault(page = 0, size = 10, sort = "updateDateTime", direction = Sort.Direction.DESC) Pageable pageRequest) {
        if (StringUtils.isNotBlank(text)) {
            return replyService.personalReplyListByCategoryAndTextLike(salesId, category, text, pageRequest);
        } else {
            return replyService.personalReplyListByCategory(salesId, category, pageRequest);
        }
    }

    @ApiOperation(value = "获取单个快捷回复")
    @GetMapping("/replies/{id}")
    public ReplyDO getReply(@PathVariable Integer id) {
        return replyService.findById(id);
    }

    @ApiOperation(value = "更新快捷回复", notes = "只更新text字段, 需要web-api认证")
    @PutMapping("/replies")
    public ReplyDO updateReply(@RequestBody ReplyDO replyDO) {
        log.debug("更新快捷回复 replyDO = {}", replyDO);
        Assert.notNull(replyDO.getId(), "更新操作需要id！");
        validate(replyDO);
        return replyService.update(replyDO);
    }

    @ApiOperation(value = "删除快捷回复", notes = "需要web-api认证")
    @DeleteMapping("/replies/{id}")
    public String deleteReply(@PathVariable Integer id) {
        replyService.delete(id);
        return "";
    }

    @Data
    @ApiModel(value = "销售名下的所有快捷回复")
    public static class ReplyListDTO implements Serializable {
        @ApiModelProperty(value = "系统级快捷回复列表, 数据结构为 [类别:[快捷回复]]")
        private Map<String, List<ReplyDefaultDO>> system;

        @ApiModelProperty(value = "个人级快捷回复列表, 数据结构为 [类别:[快捷回复]]")
        private Map<String, List<ReplyDO>> personal;
    }


    private final ReplyServiceImpl replyService;
    public static final Integer DEFAULT_WIDTH = 1280;
    public static final Integer DEFAULT_HEIGHT = 600;

    public ReplyController(ReplyServiceImpl replyService) {
        this.replyService = replyService;
    }
}
