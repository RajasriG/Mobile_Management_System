/*package pkg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pkg.dto.MobilemodelDto;
import pkg.entity.Distributiondetails;
import pkg.entity.MobileModel;


@Repository
public interface DistributiondetailsRepository extends JpaRepository<Distributiondetails, Integer> {
	
	 @Query("SELECT DISTINCT distributiondetails FROM Distributiondetails distributiondetails " +
	            "INNER JOIN FETCH distributiondetails.mobilemodel AS mobilemodel " +
	            "WHERE distributiondetails.location = :location")
	public    Distributiondetails findBylocation(@Param("location") String location);


}*/


package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pkg.entity.Distributiondetails;

@Repository
public interface DistributiondetailsRepository extends JpaRepository<Distributiondetails, Integer> {

	Distributiondetails findByLocation(String location);
}
