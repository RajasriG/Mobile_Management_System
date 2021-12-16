/*package pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pkg.dto.MobilemodelDto;
import pkg.entity.MobileModel;
import pkg.service.MobilemodelDetailsServiceImpl;


@RestController
@RequestMapping("/Mobilemodel")
public class MobilemodelController {

	@Autowired
	 private MobilemodelDetailsServiceImpl detailsServiceImpl; 
		
		public MobilemodelController(MobilemodelDetailsServiceImpl detailsServiceImpl) {
			this.detailsServiceImpl = detailsServiceImpl;
		} 
		
	@GetMapping(value="/get")
    public List<MobileModel> getAll() {
        return detailsServiceImpl.getAll();
    }
	
	@RequestMapping(value="/post",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<MobileModel> create(@RequestBody MobilemodelDto mobilemodel) throws Exception{
        detailsServiceImpl.create(mobilemodel);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MobileModel> getMobilemodelById(@PathVariable int id) {
		return ResponseEntity.ok().body(detailsServiceImpl.getMobilemodelById(id));
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<MobileModel> update(@RequestBody MobilemodelDto mobilemodels,@PathVariable int id) {
		mobilemodels.setId(id);
		//return detailsServiceImpl.update(users);
		return ResponseEntity.ok().body(detailsServiceImpl.update(mobilemodels));
		
		}

	@DeleteMapping("/Mobilemodel/{id}")
	public HttpStatus deleteById(@PathVariable int id){
		this.detailsServiceImpl.deleteById(id);
		return HttpStatus.OK;
	}
	
}*/

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
	@PostMapping
	@ResponseStatus(value=HttpStatus.OK)
	public ResponseEntity<MobileModel> createMobileModel(@RequestBody MobilemodelDto mobilemodelDto)throws Exception{
		MobileModel mobilemodel = this.mobilemodelService.create(mobilemodelDto);
		return new ResponseEntity<>(mobilemodel,HttpStatus.CREATED);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<MobileModel> getMobilemodelById(@PathVariable int id) {
		return ResponseEntity.ok().body(mobilemodelService.getmodelById(id));
	}
	@DeleteMapping(value="/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public HttpStatus delete(@PathVariable int id) {
			System.out.println("delete");
			this.mobilemodelService.deleteById(id);
			return HttpStatus.OK;
	        
	    }
	@PutMapping(value="/{id}")
	public ResponseEntity<MobileModel> update(@RequestBody MobilemodelDto mobilemodel,@PathVariable int id) {
		mobilemodel.setId(id);
		return ResponseEntity.ok().body(mobilemodelService.update(mobilemodel));
		
		}
}