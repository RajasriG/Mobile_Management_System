/*package pkg.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mobilecompany")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Distributiondetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "location")
    private String location;

    @Column(name = "phno")
    private Long phno;
   
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User user;
	
 /*   @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mobilemodel_distributiondetails", 
		joinColumns = @JoinColumn(name = "model_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "distributor_id", referencedColumnName = "id"))
	@OrderBy
	@JsonIgnore*/
	//private MobileModel mobilemodel;

//}


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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="distributiondetails")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Distributiondetails 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distributiondetails_sequence")
	@SequenceGenerator(name = "distributiondetails_sequence", sequenceName = "distributiondetails_sequence", allocationSize = 1)
	
	@Column(name = "id")
	private int id;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phno")
	private Long phno;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	
@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mobilemodel_distributiondetails", 
		joinColumns = @JoinColumn(name = "loc_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "model_id", referencedColumnName = "id"))
	@OrderBy
	@JsonIgnore
	private List<MobileModel> mobilemodel;
}