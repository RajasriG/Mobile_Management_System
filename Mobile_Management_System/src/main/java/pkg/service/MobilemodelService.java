
package pkg.service;

import java.util.List;

import pkg.dto.MobilemodelDto;
import pkg.entity.MobileModel;

public interface MobilemodelService {

	
	   public MobileModel create(MobilemodelDto mobilemodeldto)throws Exception;
		
		public MobileModel update(MobilemodelDto mobilemodeldto);
		

	public 	void deleteById(int id);

	public MobileModel getmodelById(int id);

	List<MobileModel> getAllMobilemodels();

	List<MobileModel> getAllMobileModels();

	MobileModel findById(int id);

	List<MobileModel> findMobilemodels();

	public MobileModel findModelById(int id);

	MobileModel createMobileModel(MobilemodelDto mobilemodelDto);
	

	


	
		 
}