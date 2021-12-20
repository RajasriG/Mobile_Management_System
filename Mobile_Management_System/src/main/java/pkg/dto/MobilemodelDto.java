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
  private String companyname;
    private String username;
    
private void MobilemodelDto() {
		
	}   
	@Override
	public String toString() {
		return "MobilemodelDto [id=" + id + ", modelname=" + modelname + ", modelcode=" + modelcode + 
				", companyname=" + companyname + ", username=" + username+"]";
	}

}