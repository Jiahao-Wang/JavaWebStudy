package com.javaweb.servlets;

import com.javaweb.fruit.dao.FruitDAO;
import com.javaweb.fruit.dao.FruitDAOImpl;
import com.javaweb.fruit.pojo.Fruit;
import com.javaweb.myspringmvc.ViewBaseServlet;
import com.javaweb.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Jiahao Wang
 * @create 2022-05-06 09:35
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
		Integer pageNo = 1;
		String pageNoStr = request.getParameter("pageNo");
		if (StringUtil.isNotEmpty(pageNoStr)){
			pageNo = Integer.parseInt(pageNoStr);
		}

		HttpSession session = request.getSession();
		session.setAttribute("pageNo", pageNo);

		FruitDAO fruitDAO = new FruitDAOImpl();
		List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);
		//保存到session作用域
		session.setAttribute("fruitList",fruitList);

		long fruitCount = fruitDAO.getFruitCount();
		long pageCount = (fruitCount + 4) / 5;
		session.setAttribute("pageCount", pageCount);


//		System.out.println(session.getAttribute("fruitList"));

//		System.out.println(fruitList.get(1));
		super.processTemplate("index",request,response);
	}
}

//	@Test
//	public void test(){
//		FruitDAO f = new FruitDAOImpl();
//		List<Fruit> fruitList = f.getFruitList();
//		for (Fruit fruit : fruitList){
//			System.out.println(fruit);
//		}
//	}

