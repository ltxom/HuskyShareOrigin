package com.huskyshare.backend.dao;

import com.huskyshare.backend.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandDao extends JpaRepository<Demand, Long> {
}
