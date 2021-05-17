package fr.formation.afpa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.afpa.domain.Compte;
import fr.formation.afpa.domain.Department;
import fr.formation.afpa.domain.Employee;
import fr.formation.afpa.domain.EmployeeForm;
import fr.formation.afpa.service.ServiceCompte;
import fr.formation.afpa.service.ServiceDepartment;
import fr.formation.afpa.service.ServiceEmploye;

@Controller
public class LogController{
	private static final Log log = LogFactory.getLog(LogController.class);
	ServiceCompte service;
	ServiceEmploye serviceEmp; 
	ServiceDepartment serviceDept;
	
	public LogController() {
		System.out.println("constructeur logController Vide");
	}

	@Autowired
	public LogController(ServiceCompte service, ServiceEmploye serviceEmp,ServiceDepartment serviceDept) {
		System.out.println("constructeur controller avec les services");
		this.service = service;
		this.serviceEmp = serviceEmp;
		this.serviceDept= serviceDept;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHome(Model m) {

		m.addAttribute("compte", new Compte());

		return "login";

	}
	@RequestMapping(path = "/accueil", method = RequestMethod.GET)
	public String getAccueilFirstTime() {
		
		return "accueil";
	}

	/*
	 * Méthode validation Login qui donne accès à l'accueil
	 */
	@RequestMapping(path = "/accueil", method = RequestMethod.POST)
	public String getAccueil(Compte compte, BindingResult result,HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		try {
			
			if (service.validation(compte.getLogin(), compte.getPassword()) != null) {
				httpSession.setAttribute("error", "**Login et/ou mot de passe incorrect(s)**");

				return "accueil";
			} else {
				System.out.println("login ou mdp incorrect");
				httpSession.setAttribute("error", "**Login et/ou mot de passe incorrect(s)**");/*on utilise ici la session pour avoir accès aau msg dans tte l'application mais on aurait pu utiliser le model pour l'envoyer vers une destination précise*/
				
				
				return "login";
			}

		} catch (NoResultException nre) {
			System.out.println("je suis nulle");
			httpSession.setAttribute("error", "**Login et/ou mot de passe incorrect(s)**");
			return "login";
		}

	}
   /* Affiche la liste des employés*/
	@RequestMapping(path = "/employe", method = RequestMethod.POST)
	public String getEmploye(Model m) {

		List<Employee> employees = serviceEmp.findAll();
		m.addAttribute("employees", employees);
		
		return "employes";

	}
	/* Affiche la liste des employés*/
	@RequestMapping(path = "/employeRedirect", method = RequestMethod.GET)
	public String getEmployeRedirect(Model m) {

		List<Employee> employees = serviceEmp.findAll();
		m.addAttribute("employees", employees);
		
		return "employes";

	}
	
	/*Redirect vers la page d'accueil qd on est connecté*/
	@RequestMapping(path = "/accueilConnecte", method = RequestMethod.GET)
	public String getAccueilConnecte() {

		return "accueil";
	}
	
	
	/*affiche l'ajout employé la première fois*/
	@RequestMapping(path = "/ajoutEmploye", method = RequestMethod.GET)
	public String getAjoutEmploye(Model m) {
		List<Employee> employees = serviceEmp.findManagers();
		System.out.println(employees);
		m.addAttribute("employee",new Employee());
		m.addAttribute("employees", employees);
		
		
		return "ajoutEmploye";
	}
	
	/*Enregistre l'employé en bdd*/
	@RequestMapping(path = "/ajoutEmploye", method = RequestMethod.POST)
	public String getSaveEmploye(@ModelAttribute Employee employee, BindingResult result,@RequestParam Integer manager,Date startDate,String dept) {
	   
	    if (manager != null) {
	    System.out.println(dept);	
		System.out.println("manager " +manager);
		System.out.println("startDate " +startDate);
		int dptId = Integer.parseInt(dept);
		
		/*recherche du dept grâce à l'id choisi*/
		Department department = serviceDept.findById(dptId);
		
		Employee employe = serviceEmp.findById(manager);

		employee.setManager(employe);
		employee.setDepartment(department);
		
		
		System.out.println(employee);
	    
	    }
	    
		serviceEmp.save(employee);
	
		return "redirect:/employeRedirect";
	}
	
	 /* Affiche la liste des managers*/
		@RequestMapping(path = "/manager", method = RequestMethod.GET)
		public String getManager(Model m) {

			List<Employee> managers = serviceEmp.findManagers();
			m.addAttribute("managers", managers);
			

			return "manager";

		}
		 /* Affiche la liste des subordonnés*/
		@RequestMapping(path = "/listeSub", method = RequestMethod.GET, params = {"idmanager"})
		public String getSubordonnés(Model m,@RequestParam(name="idmanager",required = true) String idmanager) {
			System.out.println(idmanager);
			Integer intmanager = Integer.parseInt(idmanager);
			List<Employee> subordonnes = serviceEmp.getSubordonnes(intmanager);
			System.out.println(subordonnes);
			m.addAttribute("subordonnes", subordonnes);
			

			return "subordonne";

		}
		
		
		
		
		/* Affiche la page des paramètres*/
		@RequestMapping(path = "/parametres", method = RequestMethod.GET)
		public String getParametres(Model m) {
			
			EmployeeForm employeeForm =  new EmployeeForm();
					

			List<Employee> empSansManag = serviceEmp.findEmpSansManager();
			employeeForm.setEmployees(empSansManag);	
			
			List<Employee> managers = serviceEmp.findManagers();
			
			
			m.addAttribute("employeeForm", employeeForm);
			m.addAttribute("managers", managers);
			
			return "parametre";

		}
		/* Valide le changement des paramètres*/
		@RequestMapping(path = "/parametres", method = RequestMethod.POST)
		public String getValidParametres(@ModelAttribute EmployeeForm employeeForm) {
			
		List<Employee> list = employeeForm.getEmployees();
			for(Employee e : list) {
				for (int i=0;i<5;i++)System.out.println(e.toString());
				Integer idManager = e.getManager().getEmpId();
				for (int i=0;i<5;i++)System.out.println(idManager);
				if(idManager!=null) {
				e.setManager(serviceEmp.findById(idManager));
				for (int i=0;i<5;i++)System.out.println(e.getManager().toString());
				System.out.println(e);
				
				serviceEmp.update(e);
			}
			}
			
			return "redirect:/employeRedirect";

		}
		
	
		@RequestMapping(path = "/logout", method = RequestMethod.GET)
	    public String logout(HttpServletRequest request) {
	      
	        HttpSession httpSession = request.getSession();
	        httpSession.invalidate();
	        return "redirect:/";
	    }

		@RequestMapping(path = "/contact", method = RequestMethod.GET)
		public String getContactPage() {
			
			return "contact";
		}
		
		/*Supprime l'employé de la bdd*/
		@RequestMapping(path = "/delete", method = RequestMethod.POST)
		public String getDeleteEmploye(@RequestParam Integer idToDel) {
			System.out.println(idToDel);
			
			serviceEmp.deleteById(idToDel);
			
			return "redirect:/employeRedirect";
		}
		
		/*Affiche l'employé à modifier*/
		@RequestMapping(path = "/update", method = RequestMethod.GET)
		public String getEmployeToUpdate(Model m,@RequestParam  Integer idToUp ) {
			System.out.println(idToUp);
		List <Employee> managers = serviceEmp.findManagers();	
		Employee employee =	serviceEmp.findById(idToUp);
			m.addAttribute("employee", employee);
			m.addAttribute("managers",managers);
			
			return "modifieEmp";
		}
		
		/*Modifie l'employé dans la bdd*/
		@RequestMapping(path = "/update", method = RequestMethod.POST)
		public String getUpdateEmploye(Model m,@ModelAttribute Employee employee) {
		
			System.out.println("JE SUIS LE NOUVEL EMPLOYE "+ employee);
			System.out.println("MANAGER " + employee.getManager());
			Integer idManager = employee.getEmpId();
			Integer idDept = employee.getDepartment().getDeptId();
			
			serviceEmp.update(employee);
			return "redirect:/employeRedirect";
		}
		
		/*page about us*/
		@RequestMapping(path = "/qsm", method = RequestMethod.GET)
		public String getAboutUs() {
		
			return "aboutUs";
		}
		
		/*Cancel modification update*/
		@RequestMapping(path = "/cancel", method = RequestMethod.GET)
		public String getCancel() {
		
			return "redirect:/employeRedirect";
		}
		
		
		
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}

}
