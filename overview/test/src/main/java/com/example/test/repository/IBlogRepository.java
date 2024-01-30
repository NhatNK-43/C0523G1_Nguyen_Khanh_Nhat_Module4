package com.example.test.repository;

import com.example.test.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByDeletedIsFalse(Pageable pageable);
    List<Blog> findAllByDeletedIsFalse();
    @Transactional
    @Modifying
    @Query(value = "update blogs set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteBlogById(@Param("id") int id);
}
