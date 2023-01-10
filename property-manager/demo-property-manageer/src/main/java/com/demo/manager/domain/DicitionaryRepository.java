package com.demo.manager.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DicitionaryRepository extends JpaRepository<Dictionary, Long> {

    @Query(value = "select dic.value from Dictionary as dic where dic.key = :key")
    public String find(String key);

    @Query(value = "select dic from Dictionary as dic where dic.key = :key")
    public Dictionary findForManager(String key);


}
