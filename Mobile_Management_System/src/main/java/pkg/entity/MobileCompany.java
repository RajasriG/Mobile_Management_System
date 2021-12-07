package pkg.entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mobilecompanies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileCompany 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobilecompany_sequence")
	@SequenceGenerator(name = "mobilecompany_sequence", sequenceName = "mobilecompany_sequence", allocationSize = 1)
	
	@Column(name = "company_id")
	private int companyid;
	
	@Column(name="company_name")
	private String companyname;
	
	@Column(name="company_place")
	private String companyplace;
	
	@Column(name="company_phno")
	private int companyphno;
	
	@Column(name="company_email")
	private String companyemail;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User user;
}