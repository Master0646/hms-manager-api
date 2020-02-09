package com.wentao.hmsmanager.repository;

import com.wentao.hmsmanager.entity.HmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<HmsUser, Integer> {
}
