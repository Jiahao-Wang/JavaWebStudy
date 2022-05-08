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
import java.util.*;

/**
 * @author Jiahao Wang
 * @create 2022-05-08 13:44
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {


	private FruitDAO fruitDAO = new FruitDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.processTemplate("add",req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String fname = req.getParameter("fname");
		Integer price = Integer.parseInt(req.getParameter("price"));
		Integer fcount = Integer.parseInt(req.getParameter("fcount"));
		String remark = req.getParameter("remark");

		Fruit fruit = new Fruit(0, fname, price, fcount, remark);

		fruitDAO.addFruit(fruit);
		resp.sendRedirect("index");
	}


}
