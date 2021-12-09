package pkg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pkg.dto.MobileCompanyDto;
import pkg.dto.UserDto;
import pkg.entity.Authority;
import pkg.entity.Mail;
import pkg.entity.PasswordGenerator;
import pkg.entity.MobileCompany;
import pkg.entity.User;
import pkg.exception.CustomException;
import pkg.service.EmailService;
import pkg.repository.AuthorityRepository;
import pkg.repository.MobileCompanyRepository;
import pkg.repository.UserRepository;

@Service
public class MobileCompanyDetailsServiceImpl implements MobileCompanyService{

	@Autowired
	private MobileCompanyRepository mobileCompanyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordGenerator passwordGenerator;
	
	@Autowired
	private EmailService emailService;
	
	
	@Override
	@Transactional(readOnly = true)
	 public List<MobileCompany> getAllMobileCompanies() {
		 return this.mobileCompanyRepository.findAll();
	 } 
	
	@Override
	@Transactional
public MobileCompany createMobileCompany(MobileCompanyDto userDto)throws Exception{
		
		
		MobileCompany mobileCompanyDto = new MobileCompany();
		mobileCompanyDto.setCompanyname(userDto.getCompanyname());
		mobileCompanyDto.setCompanyplace(userDto.getCompanyplace());
		mobileCompanyDto.setCompanyphno(userDto.getCompanyphno());
		mobileCompanyDto.setCompanyemail(userDto.getCompanyemail());
		
		UserDto dto = userDto.getUserDto();
		User user=new User();
	      user.setFirstName(dto.getFirstName());
	      user.setLastName(dto.getLastName());
	      user.setEmail(dto.getEmail());
	      user.setUsername(dto.getUsername());
	      PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	      String pass=passwordGenerator.generateRandomPassword(8);
	      String encodedPassword = passwordEncoder.encode(pass);
	      System.out.println(pass);
	      user.setPassword(encodedPassword);
	      
	      @SuppressWarnings("unused")
			List<Authority> listAuList=authorityRepository.findAll();
		      @SuppressWarnings("unused")
			List<Authority> addList=authorityRepository.find(dto.getRole());
		      User user2=null;
		      List<Authority> listAll=authorityRepository.findAll();
			     String superAdmin=listAll.get(0).getName();
			     List<String> superList=new ArrayList<>();
			     superList.add(superAdmin);
			     
			     List<Authority> addAuthorities=authorityRepository.find(dto.getRole());
			    
			     if(superList.equals(dto.getRole()))
			     {
			     	throw new RuntimeException("this role was not added ");
			     }
			     else
			     {
			     user.setAuthorities(addAuthorities);
			    user2= userRepository.save(user);
			     }
			        Mail mail = new Mail();
					 mail.setSubject("Welcome to mobile Project");
			       mail.setToEmail(user.getEmail());
			       mail.setContent("You were " +"Username :"+user.getUsername() +"\n"+ "password :"+pass);
			       emailService.sendEmail(mail);
			       mobileCompanyDto.setUser(user2);
				return mobileCompanyRepository.save(mobileCompanyDto);
			
	}
	@Override
	@Transactional(readOnly = true)
	public MobileCompany findById(int id) {
		
		Optional<MobileCompany> mob=this.mobileCompanyRepository.findById(id);
		if(mob.isPresent()) {
			return mob.get();
		}
		
		else {
			throw  new RuntimeException("Record not found with companyid  :" +id);
		}
	}
	@Override
	@Transactional
	public void deleteById(int id) {
		
		Optional<MobileCompany> mobile= this.mobileCompanyRepository.findById(id);
        if(mobile.isPresent()) {
			
        	this.mobileCompanyRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Record not found with companyid  :" +id);
		}
		
	}
	
	
	
	/*
	@Override
	@Transactional
	public MobileCompany update(MobileCompanyDto mobileCompanyDto) 
	{
	
        Optional<MobileCompany> mobileCompany=this.mobileCompanyRepository.findById(mobileCompanyDto.getId());
	
		if(mobileCompany.isPresent()) {
			MobileCompany mobileCompanyUpdate=mobileCompany.get();
			mobileCompanyUpdate.setCompanyname(mobileCompanyDto.getCompanyname());
			mobileCompanyUpdate.setCompanyplace(mobileCompanyDto.getCompanyplace());
			mobileCompanyUpdate.setCompanyphno(mobileCompanyDto.getCompanyphno());
			mobileCompanyUpdate.setCompanyemail(mobileCompanyDto.getCompanyemail());
	
				User userUpdate=new User();
				
				userUpdate.setId(mobileCompany.get().getUser().getId());
				userUpdate.setPassword(mobileCompany.get().getUser().getPassword());
				userUpdate.setUsername(mobileCompany.get().getUser().getUsername());
				userUpdate.setFirstName(mobileCompany.get().getUser().getFirstName());
				userUpdate.setLastName(mobileCompany.get().getUser().getLastName());
				userUpdate.setEmail(mobileCompany.get().getUser().getEmail());
				
			    userRepository.save(userUpdate);
			    
			    mobileCompanyUpdate.setUser(userUpdate);
	          this.mobileCompanyRepository.save(mobileCompanyUpdate);
	          return mobileCompanyUpdate;
		}
		else {
			throw new RuntimeException("Record not found with id" + mobileCompanyDto.getId());
		}
	}

}
*/
	@Override
	@Transactional(readOnly = true)
	public List<MobileCompany> findCompanys() {
		
		return this.mobileCompanyRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public MobileCompany findCompanyById(int id) {
		
		Optional<MobileCompany> companydb=this.mobileCompanyRepository.findById(id);
		if(companydb.isPresent()) {
			return companydb.get();
		}
		
		else {
			throw  new CustomException("Record not found with id  :" +id);
		}
	}


	@Override
	@Transactional
	public MobileCompany update(MobileCompanyDto companyDto) 
	{
	
        Optional<MobileCompany> companydb=this.mobileCompanyRepository.findById(companyDto.getId());
	

		
		if(companydb.isPresent()) {
			MobileCompany companyUpdate=companydb.get();
			companyUpdate.setCompanyname(companyDto.getCompanyname());
			companyUpdate.setCompanyplace(companyDto.getCompanyplace());
			companyUpdate.setCompanyphno(companyDto.getCompanyphno());		
				User userUpdate=new User();
				
			userUpdate.setId(companydb.get().getUser().getId());
				
				userUpdate.setUsername(companydb.get().getUser().getUsername());
				userUpdate.setFirstName(companydb.get().getUser().getFirstName());
				userUpdate.setLastName(companydb.get().getUser().getLastName());
				userUpdate.setEmail(companydb.get().getUser().getEmail());
			   userUpdate.setPassword(companydb.get().getUser().getPassword());
			  
			    userRepository.save(userUpdate);
			    
			    companyUpdate.setUser(userUpdate);
					
	          this.mobileCompanyRepository.save(companyUpdate);
	          return companyUpdate;
		}
		else {
			throw new CustomException("Record not found with id" + companyDto.getId());
		}
	}
}


