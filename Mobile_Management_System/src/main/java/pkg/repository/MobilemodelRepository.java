
package pkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pkg.entity.Distributiondetails;
import pkg.entity.MobileModel;
import pkg.entity.User;

@Repository
public interface MobilemodelRepository extends JpaRepository<MobileModel, Integer> {
	
@Query(value="select mm.* from mobilemodel mm where mm.model_name=:model_name",nativeQuery = true)
	
	public MobileModel findByModelname(@Param("model_name") String list) ;
}

	 	