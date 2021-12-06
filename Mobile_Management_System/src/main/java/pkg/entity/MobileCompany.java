package pkg.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MobileCompany", uniqueConstraints = { @UniqueConstraint(columnNames = { "company_email" }) })
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class MobileCompany {
@Id
	private int id;
	private String company_name;
	private int company_phno;
	private String company_email;
}
