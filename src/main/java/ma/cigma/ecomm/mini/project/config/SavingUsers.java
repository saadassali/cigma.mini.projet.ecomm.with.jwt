package ma.cigma.ecomm.mini.project.config;

import ma.cigma.ecomm.mini.project.domaine.*;import ma.cigma.ecomm.mini.project.service.*;import org.springframework.beans.factory.annotation.*;import org.springframework.boot.*;import org.springframework.security.core.userdetails.*;import org.springframework.stereotype.*;import java.util.*;
@Component
public class SavingUsers  implements CommandLineRunner{

        @Autowired
       IUserService userService;


    @Override
    public void run(String... args) throws Exception {

		userService.cleanDataBase();
		userService.save(new RoleVo("ADMIN"));
		userService.save(new RoleVo("CLIENT"));
		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
		RoleVo roleClient = userService.getRoleByName("CLIENT");
		UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin));
		UserVo admin2 = new UserVo("admin2", "admin2", Arrays.asList(roleAdmin));
		UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient));
		userService.save(admin1);
		userService.save(client1);
		userService.save(admin2);
    }}
