package pkg.controller;

import java.util.List;

import javax.validation.Valid;

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
		
		@GetMapping(value="/all")
		@ResponseStatus(value = HttpStatus.OK)
	    public List<Distributiondetails>  getAllDistributiondetails() {
	      return this.distributiondetailsService.getAllDistributiondetails(); 
    }
	
		@GetMapping(value="/{id}")
		public ResponseEntity<Distributiondetails> getDestributiondetailsById(@PathVariable int id) {
			return ResponseEntity.ok().body(distributiondetailsService.findById(id));
		}
	
	@PostMapping(value = "/save")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Distributiondetails> create(@Valid @RequestBody DistributiondetailsDto distributiondetailsDto) throws Exception {
		System.out.println("post");
		Distributiondetails distributiondetails = this.distributiondetailsService.create(distributiondetailsDto);
		return new ResponseEntity<>(distributiondetails, HttpStatus.CREATED);	
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