package nl.tue.ieis.bpmexperience.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CustomerCase implements Serializable{

	private static final long serialVersionUID = -9217446621833225765L;
	
	@Id
    @GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String type;

	public CustomerCase() {
	}	
	public CustomerCase(String name) {
		this.name = name;
	}
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
