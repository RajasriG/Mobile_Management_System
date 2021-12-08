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
		mobileCompanyDto.setCompanyname(userDto.getCompany_name());
		mobileCompanyDto.setCompanyplace(userDto.getCompany_place());
		mobileCompanyDto.setCompanyphno(userDto.getCompany_phno());
		mobileCompanyDto.setCompanyemail(userDto.getCompany_email());
		
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
	@Override
	@Transactional
	public MobileCompany update(MobileCompanyDto mobileCompanyDto) 
	{
	
        Optional<MobileCompany> mobileCompany=this.mobileCompanyRepository.findById(mobileCompanyDto.getId());
	
		if(mobileCompany.isPresent()) {
			MobileCompany mobileCompanyUpdate=mobileCompany.get();
			mobileCompanyUpdate.setCompanyname(mobileCompanyDto.getCompany_name());
			mobileCompanyUpdate.setCompanyplace(mobileCompanyDto.getCompany_place());
			mobileCompanyUpdate.setCompanyphno(mobileCompanyDto.getCompany_phno());
			mobileCompanyDto.setCompany_email(mobileCompanyDto.getCompany_email());
	
				User userUpdate=new User();
				
				userUpdate.setId(mobileCompany.get().getUser().getId());
				userUpdate.setUsername(mobileCompany.get().getUser().getUsername());
				userUpdate.setFirstName(mobileCompany.get().getUser().getFirstName());
				userUpdate.setLastName(mobileCompany.get().getUser().getLastName());
				userUpdate.setEmail(mobileCompany.get().getUser().getEmail());
			   userUpdate.setPassword(mobileCompany.get().getUser().getPassword());
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