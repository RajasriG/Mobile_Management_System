package pkg.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
	
	@Column(name="model_name")
	private String modelname;
	
	@Column(name="model_code")
	private String modecode;
}