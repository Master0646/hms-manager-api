package com.wentao.hmsmanager.repository;

import com.wentao.hmsmanager.entity.HmsCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<HmsCourse, Integer> {
}
