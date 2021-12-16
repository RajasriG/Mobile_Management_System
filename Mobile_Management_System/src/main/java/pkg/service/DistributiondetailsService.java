
/*package pkg.service;

import java.util.List;

import pkg.dto.DistributiondetailsDto;
import pkg.entity.Distributiondetails;


public interface DistributiondetailsService {

		
	public  Distributiondetails update( DistributiondetailsDto  distributiondetailsdto);
		

	public 	void deleteById(int id);

	 public Distributiondetails findById(int id);

	 public List< Distributiondetails> findDistributiondetails();

	public  Distributiondetails findDistributiondetailsById(int id);

	 public Distributiondetails createDistributiondetails( DistributiondetailsDto  distributiondetailsDto);


	public List<Distributiondetails> getAllDistributiondetails();


	public Distributiondetails create(DistributiondetailsDto distributiondetailsDto);		 
}*/

package pkg.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import pkg.dto.DistributiondetailsDto;
import pkg.entity.Distributiondetails;


@Service
public interface DistributiondetailsService {

    public List<Distributiondetails> getAllDistributiondetails();
	
	public Distributiondetails create(DistributiondetailsDto userDto)throws Exception;
	
	public Distributiondetails findById(int id);
	
	public void deleteById(int id);
	
	public Distributiondetails update(DistributiondetailsDto DistributiondetailsDto);

	
	

	

}

