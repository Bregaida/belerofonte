package br.com.belerofonte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class ApplicationType {
	@Id @GeneratedValue private Long id;
	@NotEmpty @NotNull private String name;
	@NotNull @ManyToOne private ApplicationCategory applicationCategory;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ApplicationCategory getApplicationCategory() {
		return applicationCategory;
	}

	public void setApplicationCategory(ApplicationCategory applicationCategory) {
		this.applicationCategory = applicationCategory;
	}
}