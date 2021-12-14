package pkg.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mobilecompany")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileCompany 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobilecompany_sequence")
	@SequenceGenerator(name = "mobilecompany_sequence", sequenceName = "mobilecompany_sequence", allocationSize = 1)
	
	@Column(name = "id")
	private int id;
	
	@Column(name="company_name")
	private String companyname;
	
	@Column(name="company_place")
	private String companyplace;
	
	@Column(name="company_phno")
	private int companyphno;
	
	@Pattern(regexp ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="mail id is not valid")
	@NotEmpty
	@Column(name="company_email",unique = true)
	private String companyemail;
	

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn
	private User user;
	
	/*@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private MobileModel mobilemodel;*/

}