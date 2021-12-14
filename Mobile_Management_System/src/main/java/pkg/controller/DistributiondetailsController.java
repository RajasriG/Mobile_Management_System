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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pkg.dto.DistributiondetailsDto;
import pkg.entity.Distributiondetails;
import pkg.service.DistributiondetailsService;



@RestController
@RequestMapping("/Distributiondetails")
public class DistributiondetailsController {

	@Autowired
	 private DistributiondetailsService distributiondetailsService; 
		
		public DistributiondetailsController(DistributiondetailsService distributiondetailsService) {
			this.distributiondetailsService = distributiondetailsService;
		} 
		
		@GetMapping(value="/all")
		@ResponseStatus(value = HttpStatus.OK)
	    public List<Distributiondetails>  getAllDistributiondetails() {
	      return this.distributiondetailsService.getAllDistributiondetails(); 
    }
	
	@RequestMapping(value="/model",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Distributiondetails> create(@RequestBody DistributiondetailsDto distributiondetails) throws Exception{
		distributiondetailsService.create(distributiondetails);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Distributiondetails> getDestributiondetailsById(@PathVariable int id) {
		return ResponseEntity.ok().body(distributiondetailsService.findDistributiondetailsById(id));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Distributiondetails> update(@RequestBody DistributiondetailsDto distributiondetails,@PathVariable int id) {
		distributiondetails.setId(id);
		return ResponseEntity.ok().body(distributiondetailsService.update(distributiondetails));
		
		}

	@DeleteMapping("/{id}")
	public HttpStatus deleteById(@PathVariable int id){
		this.distributiondetailsService.deleteById(id);
		return HttpStatus.OK;
	}
	
}