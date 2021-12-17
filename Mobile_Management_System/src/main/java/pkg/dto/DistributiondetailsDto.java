package pkg.dto;
import lombok.AllArgsConstructor;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DistributiondetailsDto {

	private Integer id;
	private String location;
	private Long phno;
	private String modelname;
	
	private UserDto userDto;
	
	private DistributiondetailsDto() {
		
	}
	@Override
	public String toString() {
		return "DistributiondetailsDto [id=" + id + ", location=" + location + ", phno=" + phno + " userDto=" + userDto + "]";
	}
	
}