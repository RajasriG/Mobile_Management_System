package pkg.repository;

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
	
	@Query(value="select dd.* from user_info ui join distributiondetails dd on ui.id=dd.user_id where ui.user_name=:user_name",nativeQuery = true)
	
	public Distributiondetails findByUsername(@Param("user_name") String list) ;
}
