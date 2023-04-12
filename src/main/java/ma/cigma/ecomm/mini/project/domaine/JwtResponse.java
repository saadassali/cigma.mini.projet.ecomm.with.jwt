package ma.cigma.ecomm.mini.project.domaine;


import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public List<String> getRoles() {
        return roles;
    }

    private List<String> roles=new ArrayList<>();

    public JwtResponse(UserDetails user,String jwttoken) {
        this.jwttoken = jwttoken;
        user.getAuthorities().forEach(a->this.roles.add(a.getAuthority()));

    }

    public String getToken() {
        return this.jwttoken;
    }
}