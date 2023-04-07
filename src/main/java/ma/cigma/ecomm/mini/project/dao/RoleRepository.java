package ma.cigma.ecomm.mini.project.dao;

import ma.cigma.ecomm.mini.project.domaine.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findByRole(String role);
	List<Role> findAll();

}