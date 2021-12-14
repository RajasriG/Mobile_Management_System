package pkg.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistributiondetailsDto {

	private Integer id;
	private String location;
	private Long phno;

	private DistributiondetailsDto() {
		
	}
	@Override
	public String toString() {
		return "DistributiondetailsDto [id=" + id + ", location=" + location + ", phno=" + phno + "]";
	}
	
}