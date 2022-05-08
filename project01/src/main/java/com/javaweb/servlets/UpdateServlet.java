package com.javaweb.servlets;

import com.javaweb.fruit.dao.FruitDAO;
import com.javaweb.fruit.dao.FruitDAOImpl;
import com.javaweb.fruit.pojo.Fruit;
import com.javaweb.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jiahao Wang
 * @create 2022-05-08 12:43
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
	private FruitDAO fruitDAO = new FruitDAOImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		Integer fid = Integer.parseInt(req.getParameter("fid"));
		String fname = req.getParameter("fname");
		int price = Integer.parseInt(req.getParameter("price"));
		int fcount = Integer.parseInt(req.getParameter("fcount"));
		String remark = req.getParameter("remark");

		fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));
//		super.processTemplate("index", req, resp);
		resp.sendRedirect("index");
	}
}
