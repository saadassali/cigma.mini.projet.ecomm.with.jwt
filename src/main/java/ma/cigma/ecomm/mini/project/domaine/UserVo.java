package ma.cigma.ecomm.mini.project.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserVo {
	private Long id;
	private String username;
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	public UserVo(String username, String password,List<RoleVo> roles) {
		this.username = username;
		this.password = password;
		this.roles=roles;
	}
}