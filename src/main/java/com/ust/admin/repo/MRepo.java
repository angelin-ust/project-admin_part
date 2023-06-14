package com.ust.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.admin.model.Menu;

public interface MRepo extends JpaRepository<Menu,Long> {

}
