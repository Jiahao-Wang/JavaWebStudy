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
import java.io.IOException;

/**
 * @author Jiahao Wang
 * @create 2022-05-08 12:06
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {

	private FruitDAO fruitDAO = new FruitDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fidStr = req.getParameter("fid");
		if (StringUtil.isNotEmpty(fidStr)){
			int fid = Integer.parseInt(fidStr);
			Fruit fruit = fruitDAO.getFruitByFid(fid);
			req.setAttribute("fruit", fruit);
			super.processTemplate("edit", req, resp);
		}
	}
}
