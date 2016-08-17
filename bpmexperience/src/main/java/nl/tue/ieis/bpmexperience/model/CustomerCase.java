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
	
	public static final String TASK_COMPUTE_RISK = "Compute risk";
	public static final String TASK_TAKE_DECISION = "Take decision"; 
	public static final String TASK_APPROVE_DECISION = "Approve decision"; 
	public static final String TASK_WRITE_ACCEPTANCE_LETTER = "Write acceptance letter"; 
	public static final String TASK_WRITE_REJECTION_LETTER = "Write rejection letter";
	public static final String TASK_DONE = "Done";
	public static final String[] allTasks = {TASK_COMPUTE_RISK,TASK_TAKE_DECISION, TASK_APPROVE_DECISION, TASK_WRITE_ACCEPTANCE_LETTER, TASK_WRITE_REJECTION_LETTER, TASK_DONE};
	
	@Id
    @GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String postalCode;
	@Column
	private String city;
	@Column
	private String objectType;
	@Column
	private Integer amountBought;
	@Column
	private Integer estimatedValue;
	@Column
	private Integer annualIncome;
	@Column
	private Integer yearBuilt;
	@Column
	private Integer age;		
	@Column
	private Integer riskEstimate;		
	@Column
	private String payoutRate;
	@Column
	private Integer approvalState;
	@Column
	private Boolean requiresSecondary;
	@Column
	private String reason; 
	@Column
	private String acceptanceLetter;		
	@Column
	private String rejectionLetter;
	@Column(nullable = false, columnDefinition = "varchar(255) default 'Compute risk'")
	private String nextTask; 
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean reserved; 

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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public Integer getAmountBought() {
		return amountBought;
	}
	public void setAmountBought(Integer amountBought) {
		this.amountBought = amountBought;
	}
	public Integer getEstimatedValue() {
		return estimatedValue;
	}
	public void setEstimatedValue(Integer estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
	public Integer getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}
	public Integer getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getRiskEstimate() {
		return riskEstimate;
	}
	public void setRiskEstimate(Integer riskEstimate) {
		this.riskEstimate = riskEstimate;
	}
	public String getPayoutRate() {
		return payoutRate;
	}
	public void setPayoutRate(String payoutRate) {
		this.payoutRate = payoutRate;
	}
	public Integer getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(Integer approvalState) {
		this.approvalState = approvalState;
	}
	public Boolean getRequiresSecondary() {
		return requiresSecondary;
	}
	public void setRequiresSecondary(Boolean requiresSecondary) {
		this.requiresSecondary = requiresSecondary;
	}
	public String getAcceptanceLetter() {
		return acceptanceLetter;
	}
	public void setAcceptanceLetter(String acceptanceLetter) {
		this.acceptanceLetter = acceptanceLetter;
	}
	public String getRejectionLetter() {
		return rejectionLetter;
	}
	public void setRejectionLetter(String rejectionLetter) {
		this.rejectionLetter = rejectionLetter;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getNextTask() {
		return nextTask;
	}
	public void setNextTask(String nextTask) {
		this.nextTask = nextTask;
	}
	public Boolean getReserved() {
		return reserved;
	}
	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}
	
}
