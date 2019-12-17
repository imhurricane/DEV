package com.appsoft.systerm.core.menu.meta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MetaRepository extends JpaRepository<Meta, String> {

	
	@Query(value="select a from Meta a where a.metaId = ?1")
	Meta getMenuByLevel(String level);
}
