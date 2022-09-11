package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	AdminRepo repo;
	@Autowired
	AdminDAO dao;
	@Autowired
	UserDAO dao1;
	@Autowired
	ShoeDAO sdao;
	@Autowired
	UserRepo rp;
	@Autowired
	orderDAO odao;
	
	
	
	@RequestMapping("/")
	public ModelAndView Ftpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Index.jsp");
		return mv;
		
	}
	//admin
	@RequestMapping("/admin")
	public ModelAndView loadpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Home.jsp");
		return mv;
		
	}
	@RequestMapping("/adminlogin")
	public ModelAndView checklogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user= request.getParameter("aname");
		if((repo.findByName(user)!=null)&&(repo.findBypassword(request.getParameter("pwd"))!=null)) {
		if(repo.findByName(user).equals(repo.findBypassword(request.getParameter("pwd"))))
		{
			mv.setViewName("Done.jsp");
			mv.addObject("userid",user);
		}
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		
		return mv;
		
	}
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		a.setPassword(request.getParameter("pwd"));
		a.setId(Integer.parseInt(request.getParameter("id")));
		dao.update(a);
		mv.setViewName("updated.jsp");
		
		return mv;
		
	}
	//shoe
	@RequestMapping("/addShoe")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Shoe s=new Shoe();
		s.setShoebrand(request.getParameter("brand"));
		s.setColor(request.getParameter("col"));
		s.setQuantity(Integer.parseInt(request.getParameter("qn")));
		s.setCost(Integer.parseInt(request.getParameter("cost")));
		Shoe ss=sdao.insert(s);
		if(ss!=null) {
			mv.setViewName("/getallShoe");
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		return mv; 
		
		
		
	}
	@RequestMapping("/getallShoe")
	public ModelAndView retrieve(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Shoe> list=sdao.listofShoes();
		mv.setViewName("result.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/buyShoe")
	public ModelAndView buy(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("shoeid"));
		List<Shoe> list=sdao.findbyshoename(id);
		mv.setViewName("order.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/edit")
	public ModelAndView updateByName( HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Shoe s=new Shoe();
		int id=(Integer.parseInt(request.getParameter("id")));
		String brand=request.getParameter("brand");
		String color=request.getParameter("col");
		int quan=Integer.parseInt(request.getParameter("qn"));
		int cost=(Integer.parseInt(request.getParameter("cost")));
		s.setShoeid(id);
		s.setShoebrand(brand);
		s.setColor(color);
		s.setQuantity(quan);
		s.setCost(cost);
		sdao.updateByid(s);
		 mv.setViewName("/getallShoe");
		 return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Shoe s=new Shoe();
		int id=Integer.parseInt(request.getParameter("shoeid"));
        s.setShoeid(id);
		sdao.delete(id);
		mv.setViewName("/getallShoe"
				+ "");
		return mv;
		
	}
	@RequestMapping("/allOrders")
	public ModelAndView listofOrders(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Orders> list=odao.listoforders();
		mv.setViewName("vieworder.jsp");
		mv.addObject("list",list);
		return mv;
	}

	
	
	
	//user
	@RequestMapping("/user")
	public ModelAndView firstloadpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Loginuser.jsp");
		return mv;
		
	}
	@RequestMapping("/userlogin")
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user= request.getParameter("name");
		if((rp.findByName(user)!=null)&&(rp.findBypassword(request.getParameter("pwd"))!=null)) {
		if(rp.findByName(user).equals(rp.findBypassword(request.getParameter("pwd"))))
		{
			mv.setViewName("/buy");
			mv.addObject("userid",user);
		}
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		
		return mv;
		
	}
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Users u=new Users();
		u.setUsername(request.getParameter("name"));
		u.setPassword(request.getParameter("pwd"));
		u.setEmail(request.getParameter("email"));
		u.setAddress(request.getParameter("ad"));
		u.setPhno(Long.parseLong(request.getParameter("no")));
		Users us=dao1.userSignup(u);
		if(us!=null) {
			mv.setViewName("Login.jsp");
		}
		else {
			mv.setViewName("Log.jsp");
		}
		return mv; 
		
		
		
	}
	@RequestMapping("/buy")
	public ModelAndView retrieves(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Shoe> list=sdao.listofShoes();
		mv.setViewName("view.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/allUsers")
	public ModelAndView listofUsers(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Users> list=dao1.listofall();
		mv.setViewName("viewuser.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/adduser")
	public ModelAndView adduser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Users u=new Users();
		u.setUsername(request.getParameter("name"));
		u.setPassword(request.getParameter("pwd"));
		u.setEmail(request.getParameter("email"));
		u.setAddress(request.getParameter("ad"));
		u.setPhno(Long.parseLong(request.getParameter("no")));
		Users us=dao1.userSignup(u);
		if(us!=null) {
			mv.setViewName("adduser.jsp");
		}
		else {
			mv.setViewName("Log.jsp");
		}
		return mv; 
		
		
		
	}
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Users u=new Users();
		int id=Integer.parseInt(request.getParameter("userid"));
        u.setUserid(id);
		dao1.delete(id);
		mv.setViewName("/allUsers");
		return mv;
		
	}
	@RequestMapping("/editUser")
	public ModelAndView editUser( HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Users u=new Users();
		u.setUserid(Integer.parseInt(request.getParameter("id")));
		u.setUsername(request.getParameter("name"));
		u.setPassword(request.getParameter("pwd"));
		u.setEmail(request.getParameter("email"));
		u.setAddress(request.getParameter("ad"));
		u.setPhno(Long.parseLong(request.getParameter("no")));
		
		dao1.updateByid(u);
		 mv.setViewName("/allUsers");
		 return mv;
	}
	@RequestMapping("/pay")
	public ModelAndView pay( HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Orders o=new Orders();
		int id=Integer.parseInt(request.getParameter("shoeid"));
		String name=request.getParameter("shoebrand");
		String col=request.getParameter("color");
		int cost=Integer.parseInt(request.getParameter("cost"));
		o.setShoeid(id);
		o.setShoebrand(name);
		o.setColor(col);
		o.setCost(cost);
		Orders a=odao.insert(o);
		if(a!=null) {
			 List<Orders> as=odao.findbyshoeid(id);
			 mv.setViewName("confirm.jsp");
				mv.addObject("list",as); 
		 }
		 else {
			 mv.setViewName("Fail.jsp");
		 }
		 return mv;
	}
}