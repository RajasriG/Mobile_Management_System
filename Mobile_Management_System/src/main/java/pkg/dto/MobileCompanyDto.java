package pkg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobileCompanyDto {

	private Integer id;
	private String companyname;
	private String companyplace;
	private Long companyphno;
	private String companyemail;
	private UserDto userDto;

	private MobileCompanyDto() {
		
	}
	@Override
	public String toString() {
		return "MobileCompanyDto [companyid=" + id + ", companyname=" + companyname + ", companyplace=" + companyplace + ", companyphno=" + companyphno + ", company_email=" + companyemail + ", userDto=" + userDto + "]";
	}
	
}