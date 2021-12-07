package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pkg.entity.MobileCompany;

@Repository
public interface MobileCompanyRepository extends JpaRepository<MobileCompany, Integer> {

	MobileCompany findByName(String companyname);
}