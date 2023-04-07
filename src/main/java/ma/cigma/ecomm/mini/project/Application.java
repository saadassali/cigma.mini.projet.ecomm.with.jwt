package ma.cigma.ecomm.mini.project;

import ma.cigma.ecomm.mini.project.domaine.EmpVo;
import ma.cigma.ecomm.mini.project.domaine.Product;
import ma.cigma.ecomm.mini.project.domaine.RoleVo;
import ma.cigma.ecomm.mini.project.domaine.UserVo;
import ma.cigma.ecomm.mini.project.service.IEmpService;
import ma.cigma.ecomm.mini.project.service.IUserService;
import ma.cigma.ecomm.mini.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {





	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {

		List<Product> productList= new ArrayList<>();


		//Category	Quantity	ModelNumber	AboutProduct	TechnicalDetails	ShippingWeight	Image
//		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrateur\\Desktop\\csv_products.csv"))) {
//			String line;
//			System.out.println("line");
//			while ((line = br.readLine()) != null) {
//				String[] values = line.replaceAll("\""," ").split("##;");
//				System.out.println("");
//				//String category=values[0].split(" ")[0];
//				Product product;
//				Integer quantity = null;
//				Float price=null;
//				try {
//
//					try {
//						quantity=Integer.parseInt(values[2].split(",")[0]);
//						price=Float.parseFloat(values[3].split(",")[0]);
//
//					}catch (Exception e)
//					{}
//					 product=			Product.builder()
//							.productName(values[0].isEmpty()?"_":values[0])
//							//.category(category)
//							.quantity(quantity)
//							.price(price)
//							.modelNumber(values[4].isEmpty()?"_":values[0])
//							.aboutProduct(usingSplitMethod(values[5].split(";")[1],220))
//
//
//							.image(values[5].split(";")[0])
//							.build()
//;
//
//					productList.add(product);
//					productService.save(product);
//				}catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//
//
//			}
//		}
//		//productService.save(productList);
//		System.out.println(productList.toString());

//		userService.cleanDataBase();
//		userService.save(new RoleVo("ADMIN"));
//		userService.save(new RoleVo("CLIENT"));
//
//		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
//		RoleVo roleClient = userService.getRoleByName("CLIENT");
//		UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin));
//		UserVo admin2 = new UserVo("admin2", "admin2", Arrays.asList(roleAdmin));
//		UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient));
//		userService.save(admin1);
//		userService.save(client1);
//		userService.save(admin2);
//
//		// *************
//		empService.save(new EmpVo("emp1", 10000d, "Fonction1"));
//		empService.save(new EmpVo("emp2", 20000d, "Fonction3"));
//		empService.save(new EmpVo("emp3", 30000d, "Fonction4"));
//		empService.save(new EmpVo("emp4", 40000d, "Fonction5"));
//		empService.save(new EmpVo("emp5", 50000d, "Fonction6"));

	}
	static String usingSplitMethod(String text, int length) {

		String[] results = text.split("(?<=\\G.{" + length + "})");

		return results[0];
	}
}
