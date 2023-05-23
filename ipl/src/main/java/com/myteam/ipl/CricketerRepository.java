package com.myteam.ipl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CricketerRepository extends JpaRepository<CricketerEntity, Integer>{
	@Query("SELECT c FROM CricketerEntity c WHERE c.team = :team")
	public CricketerEntity findByTeam(@Param("team") String team);
}
