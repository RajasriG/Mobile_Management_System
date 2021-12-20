package pkg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pkg.dto.MobilemodelDto;
import pkg.entity.Distributiondetails;
import pkg.entity.MobileCompany;
import pkg.entity.MobileModel;
import pkg.exception.CustomException;
import pkg.repository.DistributiondetailsRepository;
import pkg.repository.MobileCompanyRepository;
import pkg.repository.MobilemodelRepository;

@Service
public class MobilemodelDetailsServiceImpl implements MobilemodelService{

	@Autowired
	private MobilemodelRepository mobilemodelRepository;
	
	@Autowired
	private DistributiondetailsRepository distributiondetailsRepository;
	
	@Autowired
	private MobileCompanyRepository mobileCompanyRepository;
	
	@Override
	@Transactional
	public MobileModel create(MobilemodelDto mobilemodeldto) throws Exception {
		MobileModel mm=new MobileModel();
		mm.setModelname(mobilemodeldto.getModelname());
		mm.setModelcode(mobilemodeldto.getModelcode());
		
		MobileCompany mc=this.mobileCompanyRepository.findByCompanyname(mobilemodeldto.getCompanyname());	
		mm.setMobilecompany(mc);

		return this.mobilemodelRepository.save(mm);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		
		Optional<MobileModel> mobile= this.mobilemodelRepository.findById(id);
        if(mobile.isPresent()) {
			
        	this.mobilemodelRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Record not found with modelid  :" +id);
		}
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<MobileModel> getAllMobilemodels() {
		
		return this.mobilemodelRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MobileModel getmodelById(int id) {
		
		Optional<MobileModel> modeldb=this.mobilemodelRepository.findById(id);
		if(modeldb.isPresent()) {
			return modeldb.get();
		}
		
		else {
			throw  new CustomException("Record not found with id  :" +id);
		}
	}

	@Override
	@Transactional
	public MobileModel update(MobilemodelDto modelDto) 
	{
	
        Optional<MobileModel> modeldb=this.mobilemodelRepository.findById(modelDto.getId());
			
		if(modeldb.isPresent()) {
			MobileModel modelUpdate=modeldb.get();
			modelUpdate.setModelname(modelDto.getModelname());
			modelUpdate.setModelcode(modelDto.getModelcode());
				
					
	          this.mobilemodelRepository.save(modelUpdate);
	          return modelUpdate;
		}
		else {
			throw new CustomException("Record not found with id" + modelDto.getId());
		}
	}
	
}

