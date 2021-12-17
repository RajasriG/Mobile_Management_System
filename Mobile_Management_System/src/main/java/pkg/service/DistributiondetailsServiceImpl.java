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
import pkg.dto.MobileCompanyDto;
import pkg.dto.UserDto;
import pkg.entity.Authority;
import pkg.entity.Distributiondetails;
import pkg.entity.Mail;
import pkg.entity.MobileCompany;
import pkg.entity.MobileModel;
import pkg.entity.PasswordGenerator;
import pkg.entity.User;
import pkg.exception.CustomException;
import pkg.repository.AuthorityRepository;
import pkg.repository.DistributiondetailsRepository;
import pkg.repository.MobilemodelRepository;
import pkg.repository.UserRepository;

@Service
public class DistributiondetailsServiceImpl implements  DistributiondetailsService {

	@Autowired
	private MobilemodelRepository mobilemodelRepository;
	
	@Autowired
	private DistributiondetailsRepository distributiondetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	 private  PasswordGenerator passwordGenerator;
	
	@Autowired
	private EmailService  emailservice;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	@Transactional
	public  Distributiondetails create( DistributiondetailsDto userDto)throws Exception {
		
		Distributiondetails d=new Distributiondetails();
		d.setLocation(userDto.getLocation());
		d.setPhno(userDto.getPhno());
		
	/*	UserDto dto = userDto.getUserDto();
		System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+dto);
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
	     
	      User u2=null;
	      List<Authority> addAuthorities=authorityRepository.findAll();
        
          
	        String getName=addAuthorities.get(0).getName();
	        List<String> s4=new ArrayList<String>();
	        s4.add(getName);
	        
	        List<Authority> addAuthoritiess=authorityRepository.find(dto.getRole());
	       
	        if(s4.equals(dto.getRole()))
	        {
	        	throw new CustomException("this role was not added ");
	        }
	        else
	        {
          user.setAuthorities(addAuthoritiess);
         u2= userRepository.save(user);
	        }
	          
          
	Mail email = new Mail();
	 email.setSubject("Welcome to mobile Project");
  email.setToEmail(user.getEmail());
  email.setContent("user name:"+user.getUsername() +"\n"+ "password :"+pass);
  emailservice.sendEmail(email);
   d.setUser(user2);
   return distributiondetailsRepository.save(d);*/
		
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
			       emailservice.sendEmail(mail);
			       d.setUser(user2);
			      
			       MobileModel mm=this.mobilemodelRepository.findByModelname(userDto.getModelname());
			       
			       d.setMobilemodel(List.of(mm));
			       
				return distributiondetailsRepository.save(d);
			
	}
	
	
	
	@Override
	@Transactional
	public void deleteById(int id) {
		
		Optional<Distributiondetails> d1= this.distributiondetailsRepository.findById(id);
        if(d1.isPresent()) {
			
        	this.distributiondetailsRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Record not found with Distributiondetailsid  :" +id);
		}
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Distributiondetails> getAllDistributiondetails() {
		
		return this.distributiondetailsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Distributiondetails findById(int id) {
		
		Optional<Distributiondetails> dd=this.distributiondetailsRepository.findById(id);
		if(dd.isPresent()) {
			return dd.get();
		}
		
		else {
			throw  new CustomException("Record not found with id  :" +id);
		}
	}


	/*@Override
	@Transactional
	public Distributiondetails update(DistributiondetailsDto distributiondetailsDto) 
	{	
       Optional<Distributiondetails> dd1=this.distributiondetailsRepository.findById(distributiondetailsDto.getId());
			
		if(dd1.isPresent()) {
			Distributiondetails update=dd1.get();
			update.setLocation(distributiondetailsDto.getLocation());
			update.setPhno(distributiondetailsDto.getPhno());
			User userUpdate=new User();
				
		    UserDto user = distributiondetailsDto.getUserDto();
		 
		    userUpdate.setId(dd1.get().getUser().getId());
			userUpdate.setUsername(dd1.get().getUser().getUsername());
		    userUpdate.setFirstName(user.getFirstName());
		   userUpdate.setLastName(user.getLastName());
		   userUpdate.setEmail(dd1.get().getUser().getEmail());
		    userUpdate.setPassword(dd1.get().getUser().getPassword());
		   
		   
		    userRepository.save(userUpdate);
		    
		   update.setUser(userUpdate);
				
          this.distributiondetailsRepository.save(update);
          return update;
		}
		else {
			throw new CustomException("Record not found with id" + distributiondetailsDto.getId());
		}
		
	}*/
	@Override
	@Transactional
	public Distributiondetails update(DistributiondetailsDto distributiondetailsDto) 
	{
	
        Optional<Distributiondetails> dd=this.distributiondetailsRepository.findById(distributiondetailsDto.getId());

		if(dd.isPresent()) {
			Distributiondetails Update=dd.get();
			
			Distributiondetails q=new Distributiondetails();
			
			q.setLocation(distributiondetailsDto.getLocation());
			q.setPhno(distributiondetailsDto.getPhno());
			
			User userUpdate=new User();
			UserDto ss=distributiondetailsDto.getUserDto();
			userUpdate.setId(dd.get().getUser().getId());
				userUpdate.setUsername(dd.get().getUser().getUsername());
				userUpdate.setFirstName(ss.getFirstName());
				userUpdate.setLastName(ss.getLastName());
				userUpdate.setEmail(dd.get().getUser().getEmail());
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
			      String pass=passwordGenerator.generateRandomPassword(8);
			      String encodedPassword = passwordEncoder.encode(pass);
			      System.out.println(pass);
			      userUpdate.setPassword(encodedPassword);
			  
			      userUpdate.setAuthorities(dd.get().getUser().getAuthorities());
			      
			    userRepository.save(userUpdate);
			    
			    q.setUser(userUpdate);
					
	          this.distributiondetailsRepository.save(q);
	          return q;
		}
		else {
			throw new CustomException("Record not found with id" + distributiondetailsDto.getId());
		}
	}
}


