package ma.cigma.ecomm.mini.project.service;

import ma.cigma.ecomm.mini.project.domaine.RoleVo;
import ma.cigma.ecomm.mini.project.domaine.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;
//
import java.util.List;

public interface IUserService
		extends UserDetailsService
{
	void save(UserVo user);
	void save(RoleVo role);
	List<UserVo> getAllUsers();
	List<RoleVo> getAllRoles();
	RoleVo getRoleByName(String role);
	void cleanDataBase();
}
