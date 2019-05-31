package com.mytest.repository;


import com.mytest.domain.ReplyDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liude
 */
@Repository
public interface ReplyDORepository extends JpaRepository<ReplyDO, Integer> {

    List<ReplyDO> findBySalesId(Integer salesId);

    Page<ReplyDO> findAllBySalesIdAndCategory(Integer salesId, String category, Pageable pageable);

    Page<ReplyDO> findAllBySalesIdAndCategoryAndTextLike(Integer salesId, String category, String text, Pageable pageable);

    @Query(value = "select DISTINCT shortcut_key from reply  where sales_id = ?1 and shortcut_key != '' ", nativeQuery = true)
    List<String> distinctShortcutKeyBySalesId(Integer salesId);
}
