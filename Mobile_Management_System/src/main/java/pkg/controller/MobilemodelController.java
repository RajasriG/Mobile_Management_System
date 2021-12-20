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

import pkg.dto.MobilemodelDto;
import pkg.entity.MobileCompany;
import pkg.entity.MobileModel;
import pkg.entity.User;
import pkg.service.MobilemodelService;

@RestController
@RequestMapping("/mobilemodel")
public class MobilemodelController {

	@Autowired
	private MobilemodelService mobilemodelService;
	
	@GetMapping(value="/all")
	@ResponseStatus(value = HttpStatus.OK)
    public List<MobileModel>  getAllMobilemodels() {
      return this.mobilemodelService.getAllMobilemodels(); 		
    }
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MobileModel> getMobilemodelById(@PathVariable int id) {
		return ResponseEntity.ok().body(mobilemodelService.getmodelById(id));
	}
	
	@PostMapping
	@ResponseStatus(value=HttpStatus.OK)
	public ResponseEntity<MobileModel> createMobileModel(@RequestBody MobilemodelDto mobilemodelDto)throws Exception{
		MobileModel mobilemodel = this.mobilemodelService.create(mobilemodelDto);
		return new ResponseEntity<>(mobilemodel,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<MobileModel> update(@RequestBody MobilemodelDto mobilemodel,@PathVariable int id) {
		mobilemodel.setId(id);
		return ResponseEntity.ok().body(mobilemodelService.update(mobilemodel));
		
		}
	
	@DeleteMapping(value="/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public HttpStatus delete(@PathVariable int id) {
			System.out.println("delete");
			this.mobilemodelService.deleteById(id);
			return HttpStatus.OK;
	        
	    }
}