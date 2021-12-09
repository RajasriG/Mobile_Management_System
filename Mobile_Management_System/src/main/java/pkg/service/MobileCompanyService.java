package pkg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pkg.dto.MobileCompanyDto;
import pkg.dto.UserDto;
import pkg.entity.MobileCompany;
import pkg.entity.User;

@Service
public interface MobileCompanyService {

    public List<MobileCompany> getAllMobileCompanies();
	
	public MobileCompany createMobileCompany(MobileCompanyDto userDto)throws Exception;
	
	public MobileCompany findById(int id);
	
	public void deleteById(int id);
	
	public MobileCompany update(MobileCompanyDto mobileCompanyDto);

	List<MobileCompany> findCompanys();

	MobileCompany findCompanyById(int id);
}

