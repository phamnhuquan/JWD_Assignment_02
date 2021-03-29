package fa.training.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

@Table(name = "Employee")
@Proxy(lazy = true)
@Entity(name = "Employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
	@NotNull(message = "Employee id is require")
	private int employeeId;
	
	@Column(name = "first_name", columnDefinition = "varchar(255)")
	@NotNull(message = "First name is not empty !!!")
	private String firstName;
	
    
    @Column(name = "last_name", columnDefinition = "varchar(255)")
    @NotNull(message = "Last name is not empty !!!")
    private String lastName;
    
    @Column(name = "gender", columnDefinition = "int")
    @NotNull(message = "Gender is not empty !!!")
    private int gender;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", columnDefinition = "date")
    @NotNull(message = "Date of birth is not empty !!!")
    private Date dateOfBirth;
    
    @Column(name = "phone", columnDefinition = "varchar(20)")
	private String phone;
    
    @Column(name = "address", columnDefinition = "varchar(255)")
	private String address;
    
    @Column(name = "department_name", columnDefinition = "varchar(255)")
	private String departmentName;
    
    @Column(name = "remark", columnDefinition = "varchar(1000)")
	private String remark;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

    
    
	public Employee(
			@NotNull(message = "First name is not empty !!!") String firstName,
			@NotNull(message = "Last name is not empty !!!") String lastName,
			@NotNull(message = "Gender is not empty !!!") int gender,
			@NotNull(message = "Date of birth is not empty !!!") Date dateOfBirth, String phone, String address,
			String departmentName, String remark, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.departmentName = departmentName;
		this.remark = remark;
		this.account = account;
	}
	public Employee(
			@NotNull(message = "First name is not empty !!!") String firstName,
			@NotNull(message = "Last name is not empty !!!") String lastName,
			@NotNull(message = "Gender is not empty !!!") int gender,
			@NotNull(message = "Date of birth is not empty !!!") Date dateOfBirth, String phone, String address,
			String departmentName, String remark) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.departmentName = departmentName;
		this.remark = remark;
	}
	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
}
