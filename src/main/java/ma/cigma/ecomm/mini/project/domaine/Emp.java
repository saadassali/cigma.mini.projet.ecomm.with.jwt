package ma.cigma.ecomm.mini.project.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Emp {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double salary;
	
	@Basic(fetch = FetchType.LAZY)
	private String fonction;

	public Emp(String name, Double salary, String fonction) {
		super();
		this.name = name;
		this.salary = salary;
		this.fonction = fonction;
	}
}