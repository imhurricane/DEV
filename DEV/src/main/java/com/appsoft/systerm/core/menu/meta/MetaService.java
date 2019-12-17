package com.appsoft.systerm.core.menu.meta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetaService {
	
	@Autowired
	private MetaRepository repository;
	
	public Meta saveMeta(Meta meta) {
		return repository.save(meta);
	}
	
	public Meta getMetaById(String metaId) {
		Optional<Meta> findById = repository.findById(metaId);
		return findById.isPresent()?findById.get():null;
	}

}
