package ma.cigma.ecomm.mini.project.service;


import ma.cigma.ecomm.mini.project.domaine.EmpVo;

import java.util.List;

public interface IEmpService {
	List<EmpVo> getEmployees();
	void save(EmpVo emp);
	EmpVo getEmpById(Long id);
	void delete(Long id);
	List<EmpVo> findBySalary(Double salary);
	List<EmpVo> findByFonction(String designation);
	List<EmpVo> findBySalaryAndFonction(Double salary, String fonction);
	EmpVo getEmpHavaingMaxSalary();
	//Pour la pagination
	List<EmpVo> findAll(int pageId, int size);
	//pour le tri
	List<EmpVo> sortBy(String fieldName);
}
