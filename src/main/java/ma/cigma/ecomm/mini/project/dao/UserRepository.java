package ma.cigma.ecomm.mini.project.dao;

import ma.cigma.ecomm.mini.project.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Deux types de sessions :
 * 
 *  1- Session orientée transaction (par défaut).
 *  2- Extended context (la session reste ouverte).
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String userName);
}
