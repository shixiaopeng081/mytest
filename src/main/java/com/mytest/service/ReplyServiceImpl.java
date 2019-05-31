package com.mytest.service;


import com.mytest.controller.ReplyController;
import com.mytest.domain.ReplyDO;
import com.mytest.domain.ReplyDefaultDO;
import com.mytest.repository.ReplyDORepository;
import com.mytest.repository.ReplyDefaultDORepository;
import com.mytest.vo.ReplyDTO;
import com.mytest.vo.RestPageImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.jta.TransactionFactory;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shixiaopeng
 */
@Service
public class ReplyServiceImpl {

    @Transactional(rollbackFor = Exception.class)
    public ReplyDO save(ReplyDO replyDO) {
        if(StringUtils.isEmpty(replyDO.getShortcutKey())){
            replyDO.setShortcutKey("");
        }
        return replyDORepository.save(replyDO);
    }

    public List<ReplyDO> save(List<ReplyDO> replyDOList) {
        replyDOList.stream().map(replyDO -> {
            if(StringUtils.isEmpty(replyDO.getShortcutKey())){
                replyDO.setShortcutKey("");
            }
            return replyDO;
        }).collect(Collectors.toList());
        return replyDORepository.save(replyDOList);
    }

    public ReplyDO update(ReplyDO replyDO) {
        return replyDORepository.save(replyDO);
    }

    public void delete(Integer id) {
        replyDORepository.delete(id);
    }

    public List<String> distinctCategory(){
        return replyDefaultDORepository.findDistinctCategory();
    }

    public List<String> distinctShortcutKeyBySalesId(Integer salesId){
        return replyDORepository.distinctShortcutKeyBySalesId(salesId);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public ReplyDO findById(Integer id) {
        ReplyDO replyDO = new ReplyDO();
        replyDO.setSalesId(0);
        replyDO.setText("事务");
        replyDO.setCategory("");
        save(replyDO);
        return replyDORepository.findOne(id);
    }

    public RestPageImpl<ReplyDefaultDO> defaultReplyListByCategory(String category, Pageable pageable){
        Page<ReplyDefaultDO> page = replyDefaultDORepository.findAllByCategory(category, pageable);
        return new RestPageImpl<>(page.getContent(), pageable, page.getTotalElements());
    }

    public RestPageImpl<ReplyDefaultDO> defaultReplyListByCategoryAndTextLike(String category, String text, Pageable pageable){
        Page<ReplyDefaultDO> page = replyDefaultDORepository.findAllByCategoryAndTextLike(category, "%" + text + "%", pageable);
        return new RestPageImpl<>(page.getContent(), pageable, page.getTotalElements());
    }

    public RestPageImpl<ReplyDTO> personalReplyListByCategory(Integer salesId, String category, Pageable pageable){
        Page<ReplyDO> page = replyDORepository.findAllBySalesIdAndCategory(salesId, category, pageable);
        return new RestPageImpl<>(page.getContent().stream().map(this::from).collect(Collectors.toList()), pageable, page.getTotalElements());
    }

    public RestPageImpl<ReplyDTO> personalReplyListByCategoryAndTextLike(Integer salesId, String category, String text, Pageable pageable){
        Page<ReplyDO> page = replyDORepository.findAllBySalesIdAndCategoryAndTextLike(salesId, category, "%" + text + "%", pageable);
        return new RestPageImpl<>(page.getContent().stream().map(this::from).collect(Collectors.toList()), pageable, page.getTotalElements());
    }

    private ReplyDTO from(ReplyDO r){
        return ReplyDTO.builder()
                .category(r.getCategory())
                .id(r.getId())
                .imageUrl(r.getImageUrl())
                .salesId(r.getSalesId())
                .shortcutKey(r.getShortcutKey())
                .text(r.getText())
                .type(r.getType())
                .build();
    }

    public ReplyController.ReplyListDTO findBySalesId(Integer salesId) {
        //系统数据
        List<ReplyDefaultDO> defaultReplyList = replyDefaultDORepository.findAll();
        //个人数据
        List<ReplyDO> personalReplyList = replyDORepository.findBySalesId(salesId);

        LinkedHashMap<String, List<ReplyDO>> personalReplyMap = new LinkedHashMap<>();

        //个人分类同系统级的分类
        for (ReplyDefaultDO reply : defaultReplyList) {
            personalReplyMap.put(reply.getCategory(), Collections.emptyList());
        }

        personalReplyMap = personalReplyList.stream().collect(Collectors.groupingBy(
                ReplyDO::getCategory,
                LinkedHashMap::new,
                Collectors.toList()));

        LinkedHashMap<String, List<ReplyDefaultDO>> defaultReplyMap = defaultReplyList.stream().collect(Collectors.groupingBy(
                ReplyDefaultDO::getCategory,
                LinkedHashMap::new,
                Collectors.toList()));

        ReplyController.ReplyListDTO replyDTO = new ReplyController.ReplyListDTO();
        replyDTO.setPersonal(personalReplyMap);
        replyDTO.setSystem(defaultReplyMap);

        return replyDTO;
    }

    private final ReplyDORepository replyDORepository;
    private final ReplyDefaultDORepository replyDefaultDORepository;


    public ReplyServiceImpl(ReplyDORepository replyDORepository, ReplyDefaultDORepository replyDefaultDORepository) {
        this.replyDORepository = replyDORepository;
        this.replyDefaultDORepository = replyDefaultDORepository;
    }

}
