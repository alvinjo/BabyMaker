package com.qa.BabyMaker.persistence.repository;

import com.qa.BabyMaker.persistence.domain.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {
}
