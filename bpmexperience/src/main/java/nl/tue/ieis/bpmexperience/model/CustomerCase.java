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
public class CustomerCase implements Serializable{

	@Transient
	private static final long serialVersionUID = -9217446621833225765L;
	
	@Transient
	public static final String TASK_COMPUTE_RISK = "Compute risk";
	@Transient
	public static final String TASK_TAKE_DECISION = "Take decision"; 
	@Transient
	public static final String TASK_APPROVE_DECISION = "Approve decision"; 
	@Transient
	public static final String TASK_WRITE_ACCEPTANCE_LETTER = "Write acceptance letter"; 
	@Transient
	public static final String TASK_WRITE_REJECTION_LETTER = "Write rejection letter";
	@Transient
	public static final String TASK_DONE = "Done";
	@Transient
	public static final String[] allTasks = {TASK_COMPUTE_RISK,TASK_TAKE_DECISION, TASK_APPROVE_DECISION, TASK_WRITE_ACCEPTANCE_LETTER, TASK_WRITE_REJECTION_LETTER, TASK_DONE};
	
	//Preset case variables
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
	
	//Variable case variables
	@Column(nullable = false, columnDefinition = "integer default 0")
	private Integer riskEstimate;		
	@Column(nullable = false, columnDefinition = "text default ''")
	private String payoutRate;
	@Column(nullable = false, columnDefinition = "integer default 0")
	private Integer approvalState;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean requiresSecondary;
	@Column(nullable = false, columnDefinition = "text default ''")
	private String reason; 
	@Column(nullable = false, columnDefinition = "text default ''")
	private String acceptanceLetter;		
	@Column(nullable = false, columnDefinition = "text default ''")
	private String rejectionLetter;
	
	//Case state variables
	@Column(nullable = false, columnDefinition = "varchar(255) default 'Compute risk'")
	private String nextTask; 
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean reserved; 
	@Column
	private String reservedBy; 

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
	public String getReservedBy() {
		return reservedBy;
	}
	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}
	
	public String determineNextTask(){
		if (getNextTask().equals(TASK_COMPUTE_RISK)){
			return TASK_TAKE_DECISION;
		}else if (getNextTask().equals(TASK_TAKE_DECISION)){
			if (getRequiresSecondary()){
				return TASK_APPROVE_DECISION;
			}else{
				if (getApprovalState() == 0){
					return TASK_TAKE_DECISION;
				}else if (getApprovalState() == 1){
					return TASK_WRITE_ACCEPTANCE_LETTER;
				}else{
					return TASK_WRITE_REJECTION_LETTER;					
				}
			}
		}else if (getNextTask().equals(TASK_APPROVE_DECISION)){
			if (getApprovalState() == 0){
				return TASK_APPROVE_DECISION;
			}else if (getApprovalState() == 1){
				return TASK_WRITE_ACCEPTANCE_LETTER;
			}else{
				return TASK_WRITE_REJECTION_LETTER;					
			}			
		}else if (getNextTask().equals(TASK_WRITE_ACCEPTANCE_LETTER)){
			return TASK_DONE;
		}else if (getNextTask().equals(TASK_WRITE_REJECTION_LETTER)){
			return TASK_DONE;			
		}
		return TASK_DONE;		
	}
}
