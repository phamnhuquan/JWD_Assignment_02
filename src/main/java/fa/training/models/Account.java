package fa.training.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;

@Table(name = "Account")
@Proxy(lazy = true)
@Entity(name = "Account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true, nullable = false)
	@NotNull(message = "Account id is not empty !!!")
	private int accountId;
	
	@Column(name = "account", columnDefinition = "varchar(255)", unique = true)
	@NotNull(message = "Account is not empty !!!")
	private String account;
	
	@Column(name = "email", columnDefinition = "varchar(255)", unique = true)
	@Email(message = "Must be email !!!")
	private String email;
	
	@Column(name = "password", columnDefinition = "varchar(255)")
	@Length(min = 6, message = "Password must be at least 6 characters")
	@Length(max = 50, message = "Password must be less than 50 characters")
	private String password;
	
    @Column(name = "status", columnDefinition = "int")
	private int status;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

	public Account(
			@NotNull(message = "Account is not empty !!!") String account,
			@Email(message = "Must be email !!!") String email,
			@Length(min = 6, message = "Password must be at least 6 characters") @Length(max = 50, message = "Password must be less than 50 characters") String password,
			int status, Employee employee) {
		super();
		this.account = account;
		this.email = email;
		this.password = password;
		this.status = status;
		this.employee = employee;
	}
	public Account( @NotNull(message = "Account is not empty !!!") String account,
			@Email(message = "Must be email !!!") String email,
			@Length(min = 6, message = "Password must be at least 6 characters") @Length(max = 50, message = "Password must be less than 50 characters") String password,
			int status) {
		super();
		this.account = account;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public Account() {
		super();
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

    
}
