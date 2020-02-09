package com.wentao.hmsmanager.repository;

import com.wentao.hmsmanager.entity.HmsHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkDao extends JpaRepository<HmsHomework, Integer> {
}
