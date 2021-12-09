package pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pkg.dto.MobileCompanyDto;
import pkg.dto.UserDto;
import pkg.entity.MobileCompany;
import pkg.entity.User;
import pkg.service.MobileCompanyService;
import pkg.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/mobilecompany")
public class MobileCompanyController {

	@Autowired
	private MobileCompanyService mobileCompanyService;
	
	@GetMapping(value="/all")
	@ResponseStatus(value = HttpStatus.OK)
    public List<MobileCompany>  getAllMobileCompanies() {
      return this.mobileCompanyService.getAllMobileCompanies(); 
		
    }
	@PostMapping
	@ResponseStatus(value=HttpStatus.OK)
	public ResponseEntity<MobileCompany> createMobileCompany(@RequestBody MobileCompanyDto mobileCompanyDto)throws Exception{
		MobileCompany mobileCompany = this.mobileCompanyService.createMobileCompany(mobileCompanyDto);
		return new ResponseEntity<>(mobileCompany,HttpStatus.CREATED);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<MobileCompany> getUserById(@PathVariable int id) {
		return ResponseEntity.ok().body(this.mobileCompanyService.findById(id));
	} 
	@DeleteMapping(value="/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public HttpStatus delete(@PathVariable int id) {
			System.out.println("delete");
			this.mobileCompanyService.deleteById(id);
			return HttpStatus.OK;
	        
	    }
	@PutMapping(value="/{id}")
	public ResponseEntity<MobileCompany> update(@RequestBody MobileCompanyDto mobileCompany,@PathVariable int id) {
		mobileCompany.setId(id);
		return ResponseEntity.ok().body(mobileCompanyService.update(mobileCompany));
		
		}
}