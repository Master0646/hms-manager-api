package com.wentao.hmsmanager.repository;

import com.wentao.hmsmanager.entity.HmsClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao extends JpaRepository<HmsClass, Integer> {
}
