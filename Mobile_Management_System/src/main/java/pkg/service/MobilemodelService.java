
package pkg.service;

import java.util.List;

import pkg.dto.MobilemodelDto;
import pkg.entity.MobileModel;

public interface MobilemodelService {

	
	   public MobileModel create(MobilemodelDto mobilemodeldto)throws Exception;
		
		public MobileModel update(MobilemodelDto mobilemodeldto);
		

	public 	void deleteById(int id);
	
	public List<MobileModel> getAllMobilemodels();

	public MobileModel getmodelById(int id);

}