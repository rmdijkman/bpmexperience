package nl.tue.ieis.bpmexperience.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class TaskLog  implements Serializable{

	@Transient
	private static final long serialVersionUID = -4296045708797622518L;

	@Id
    @GeneratedValue
	private Long id;
	@Column
	private Long caseId;
	@Column
	private String time;
	@Column
	private String taskName;
	@Column
	private String user;
	@Column
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCaseId() {
		return caseId;
	}
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
