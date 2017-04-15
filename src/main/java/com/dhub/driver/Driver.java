package com.dhub.driver;

import org.springframework.stereotype.Component;

import com.dhub.beans.Users;
import com.dhub.dao.UsersDao;
import com.dhub.dao.UsersDaoImpl;

@Component
public class Driver {

	public static void main(String[] args) {

		/*FiltersDao dao = new FiltersDaoImpl();
		List<Filters> users = dao.getAllFilters();
		for (Filters u:users){
			System.out.println(u);
		}
		*/
		UsersDao dao = new UsersDaoImpl();
		Users user = dao.getUserInfo(200);
		System.out.println(user);
		
		dao.deleteUser(user);
		
		
		/*//List<Users> user = dao.getAllUsers();
		List<Users> user = (List<Users>)dao.getUserInfo(1);
		System.out.println(user);
		System.out.println("size: " + user.get(0).getSubtype().get(0));
		
		for (int i = 0; i < user.get(0).getSubtype().size();i++){
			System.out.println(user.get(0).getSubtype().get(i).getFilter().get(0).getFilterId());
		}
		
		
		for (int i = 0; i < user.get(0).getSubtype().size();i++){
			if (user.get(0).getSubtype().get(i).getFilterSubtypeId()<8)
				System.out.println(user.get(0).getSubtype().get(i).getFilterSubtype());
		}
		
		List<Users> user = dao.getAllUsers();
		for (Users u:user){
			System.out.println(u);
	
		System.out.println("Size = " + user.get(0).getSkills().size());
		for ( int i = 0; i < user.get(0).getSkills().size();i++)
			System.out.println(user.get(0).getSkills().get(i).getSkill());
		List<Users> users = dao.getCredentials("AToman");
		if(users.isEmpty()){
			System.out.println("Nothing there");
		} else {
			for (Users u:users){
				System.out.println(u);
			
		}
		System.out.println("test2\n");
		List<Users> user1 = dao.getUserInfo(5);
		if(user1.isEmpty()){
			System.out.println("Nothing there");
		} else {
			for (Users u:user1){
				System.out.println(u);
			}
		}		
		System.out.println("test3\n");
		RolesDao roleDao = new RolesDaoImpl();
		List<Roles> roles = roleDao.getAllRoles();
		for (Roles r:roles){
			System.out.println(r);
		}
		
		Roles r = new Roles(3, "Admin");
		roleDao.deleteRole(r);
		System.out.println("after delete");

		Roles r = new Roles(3, "Admin");
		roleDao.createRole(r);
		System.out.println("after insert");
		
		Roles r = new Roles(3, "Awesome");
		roleDao.updateRole(r);
		System.out.println("after update");
		
		System.out.println("test5\n");
		SkillsDao skillsDao = new SkillsDaoImpl();
		List<Skills> skillss = skillsDao.getAllSkills();
		for (Skills d:skillss){
			System.out.println(d);
		}
		
		Skills d = new Skills(5, "test1");
		skillsDao.deleteSkill(d);
		System.out.println("after delete");

		Skills d1 = new Skills(8, "Admin");
		skillsDao.createSkill(d1);
		System.out.println("after insert");
		
		Skills d2 = new Skills(6, "Awesome");
		skillsDao.updateSkill(d2);
		System.out.println("after update");
		
		System.out.println("test5\n");
		SkillsDao skillsDao = new SkillsDaoImpl();
		List<Skills> skillss = skillsDao.getAllSkills();
		for (Skills d:skillss){
			System.out.println(d);
		}
		
		Skills d = new Skills(8, "test1");
		skillsDao.deleteSkill(d);
		System.out.println("after delete");

		Skills d1 = new Skills(11, "Admin");
		skillsDao.createSkill(d1);
		System.out.println("after insert");
		
		Skills d2 = new Skills(10, "Awesome");
		skillsDao.updateSkill(d2);
  		System.out.println("after update");*/		
	}
}

