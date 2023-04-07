package ma.cigma.ecomm.mini.project.service;

import ma.cigma.ecomm.mini.project.dao.EmpRepository;
import ma.cigma.ecomm.mini.project.dao.RoleRepository;
import ma.cigma.ecomm.mini.project.dao.UserRepository;
import ma.cigma.ecomm.mini.project.domaine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmpRepository empRepository;




	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,EmpRepository empRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.empRepository=empRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
		for (Role r : roles) {
			springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return springSecurityAuthorities;
	}

	@Override
	public void save(UserVo userVo) {
		User user = UserConverter.toBo(userVo);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> rolesPersist = new ArrayList<>();
		for (Role role : user.getRoles()) {
			Role userRole = roleRepository.findByRole(role.getRole()).get(0);
			rolesPersist.add(userRole);
		}
		user.setRoles(rolesPersist);
		userRepository.save(user);
	}
	@Override
	public void save(RoleVo roleVo) {
		roleRepository.save(RoleConverter.toBo(roleVo));
	}

	@Override
	public List<UserVo> getAllUsers() {
		return UserConverter.toVoList(userRepository.findAll());
	}

	@Override
	public List<RoleVo> getAllRoles() {
		return RoleConverter.toVoList(roleRepository.findAll());
	}

	@Override
	public RoleVo getRoleByName(String role) {
		return RoleConverter.toVo(roleRepository.findByRole(role).get(0));
	}

	@Override
	public void cleanDataBase() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		empRepository.deleteAll();
	}

}