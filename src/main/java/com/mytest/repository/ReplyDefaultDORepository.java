package com.mytest.repository;

import com.mytest.domain.ReplyDefaultDO;
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
public interface ReplyDefaultDORepository extends JpaRepository<ReplyDefaultDO, Integer> {
    @Query(value = "SELECT DISTINCT(category) from reply_default", nativeQuery = true)
    List<String> findDistinctCategory();

    Page<ReplyDefaultDO> findAllByCategory(String category, Pageable pageable);

    Page<ReplyDefaultDO> findAllByCategoryAndTextLike(String category, String text, Pageable pageable);

}
