package com.example.pig_management.repository;


import com.example.pig_management.model.Pig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPigRepository extends JpaRepository<Pig, Integer> {
    //    @Query(value = "select * from pigs where (is_sold = :isSold) and (pig_code like :pigCode) and (origin_id = :idOrigin)", nativeQuery = true)
//    List<Pig> searchPig(@Param("isSold") int isSold, @Param("id") String pigCode, @Param("originId") int idOrigin);
//    @Query(value = "select * from pigs where (is_sold = :isSold) and (pig_code like :pigCode) and (origin_id = :idOrigin)", nativeQuery = true)
//    List<Pig> searchPig(@Param("isSold") int isSold, @Param("id") String pigCode, @Param("originId") int idOrigin);
//    @Transactional
    List<Pig> findAllByDeletedIsFalse();

    @Query(value = "select * from pigs where (is_sold like : isSold) and (pig_code like : pigCode) and (origin_id like : originId)", nativeQuery = true)
    List<Pig> searchPig(@Param("isSold") String isSold, @Param("id") String pigCode, @Param("originId") String originId);

    //    List<Pig> findAllByPigCodeContainingAndSoldAndOrOrigin(int isSold,String pigCode,int originId);
    @Transactional
    @Modifying
    @Query(value = "update pigs set id_deleted = 1 where id = :id", nativeQuery = true)
    boolean deletePig(@Param("id") int id);
}
