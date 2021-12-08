package pkg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobileCompanyDto {

	private Integer id;
	private String company_name;
	private String company_place;
	private Integer company_phno;
	private String company_email;
	private UserDto userDto;

	private MobileCompanyDto() {
		
	}
	@Override
	public String toString() {
		return "MobileCompanyDto [company_id=" + id + ", company_name=" + company_name + ", company_place=" + company_place + ", company_phno=" + company_phno + ", company_email=" + company_email + ", userDto=" + userDto + "]";
	}
}