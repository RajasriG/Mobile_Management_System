/*package pkg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pkg.dto.MobilemodelDto;
import pkg.entity.MobileModel;

@Repository
public interface MobilemodelRepository extends JpaRepository<MobileModel, Integer> {
	
	 @Query("SELECT DISTINCT mobilemodel FROM MobileModel mobilemodel " +
	            "INNER JOIN FETCH mobilemodel.distributiondetails AS distributiondetails " +
	            "WHERE mobilemodel.modelname = :modelname")
	public    MobileModel findBymodelname(@Param("modelname") String modelname);


}*/

package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pkg.entity.MobileModel;


@Repository
public interface MobilemodelRepository extends JpaRepository<MobileModel, Integer> {

	MobileModel findByModelname(String modelname);
}

	 	