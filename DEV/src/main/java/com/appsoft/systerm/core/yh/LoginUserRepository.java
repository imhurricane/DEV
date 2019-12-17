package com.appsoft.systerm.core.yh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

	
	@Query(value="select a from Meta a where a.metaId = ?1")
	LoginUser getMenuByLevel(String level);
}
