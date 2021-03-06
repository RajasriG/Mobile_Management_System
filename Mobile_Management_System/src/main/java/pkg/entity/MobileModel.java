
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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mobilemodel", uniqueConstraints = {@UniqueConstraint(columnNames = {"model_code"})})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileModel 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobilemodel_sequence")
	@SequenceGenerator(name = "mobilemodel_sequence", sequenceName = "mobilemodel_sequence", allocationSize = 1)
	
	@Column(name = "id")
	private int id;
	
	@Column(name="model_name",unique=true)
	private String modelname;
	
	@Column(name="model_code")
	private String modelcode;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private MobileCompany mobilecompany;
}