package pkg.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobilemodelDto {

	private int id;
    private String modelname;
    private String modelcode;
  
private void DistributordetailsDto() {
		
	}
    
	@Override
	public String toString() {
		return "MobilemodelDto [id=" + id + ", modelname=" + modelname + ", modelcode=" + modelcode + "]";
	}


}