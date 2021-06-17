package br.unicesumar.aula20210617.grasp.creator;

import java.util.UUID;

public abstract class BaseEntity {
	private String id;
	
	public BaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
}
