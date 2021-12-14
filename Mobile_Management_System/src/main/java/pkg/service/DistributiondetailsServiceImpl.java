package pkg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pkg.dto.DistributiondetailsDto;
import pkg.entity.Distributiondetails;
import pkg.exception.CustomException;
import pkg.repository.DistributiondetailsRepository;
import pkg.repository.MobilemodelRepository;

@Service
public class DistributiondetailsServiceImpl implements  DistributiondetailsService{

	@Autowired
	private MobilemodelRepository mobilemodelRepository;
	
	@Autowired
	private DistributiondetailsRepository distributiondetailsRepository;
	
	@Override
	@Transactional(readOnly = true)
	 public List<Distributiondetails> getAllDistributiondetails() {
		 return this.distributiondetailsRepository.findAll();
	 } 
	
	@Override
	@Transactional
	public  Distributiondetails create( DistributiondetailsDto distributiondetailsDto) {
		Distributiondetails d=new Distributiondetails();
		d.setLocation(distributiondetailsDto.getLocation());
		d.setPhno(distributiondetailsDto.getPhno());
	
		return this.distributiondetailsRepository.save(d);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Distributiondetails findById(int id) {
		
		Optional<Distributiondetails> d=this.distributiondetailsRepository.findById(id);
		if(d.isPresent()) {
			return d.get();
		}
		
		else {
			throw  new RuntimeException("Record not found with id  :" +id);
		}
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		
		Optional<Distributiondetails> d1= this.distributiondetailsRepository.findById(id);
        if(d1.isPresent()) {
			
        	this.distributiondetailsRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Record not found with id  :" +id);
		}
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Distributiondetails> findDistributiondetails() {
		
		return this.distributiondetailsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Distributiondetails findDistributiondetailsById(int id) {
		
		Optional<Distributiondetails> db=this.distributiondetailsRepository.findById(id);
		if(db.isPresent()) {
			return db.get();
		}
		
		else {
			throw  new CustomException("Record not found with id  :" +id);
		}
	}


	@Override
	@Transactional
	public Distributiondetails update(DistributiondetailsDto distributiondetailsDto) 
	{
	
        Optional<Distributiondetails> db1=this.distributiondetailsRepository.findById(distributiondetailsDto.getId());
	

		
		if(db1.isPresent()) {
			Distributiondetails Update=db1.get();
			Update.setLocation(distributiondetailsDto.getLocation());
			Update.setPhno(distributiondetailsDto.getPhno());
				
					
	          this.distributiondetailsRepository.save(Update);
	          return Update;
		}
		else {
			throw new CustomException("Record not found with id" + distributiondetailsDto.getId());
		}
	}

	@Override
	public Distributiondetails createDistributiondetails(DistributiondetailsDto distributiondetailsDto) {

		return null;
	}


}


