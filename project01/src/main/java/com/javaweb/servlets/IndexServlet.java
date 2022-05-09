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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String oper = request.getParameter("oper");
		String keyword = null;
		Integer pageNo = 1;

		if (StringUtil.isNotEmpty(oper) && "search".equals(oper)){
			// 有 oper，说明是点击表单查询发送的请求
			// 此时 pageNo 还原为 1，keyword 从请求参数中获取
			pageNo = 1;
			keyword = request.getParameter("keyword");
			if (StringUtil.isEmpty(keyword)) {
				keyword = "";
			}
			session.setAttribute("keyword", keyword);
		} else {
			// 如果 oper 是空，说明不是点击表单发送的请求，是直接进 index 的请求
			// 就直接显示原来的分页
			String pageNoStr = request.getParameter("pageNo");
			if (StringUtil.isNotEmpty(pageNoStr)){
				pageNo = Integer.parseInt(pageNoStr);
			}
			Object keywordObj = session.getAttribute("keyword");
			if (keywordObj != null){
				keyword = (String) keywordObj;
			}
			else {
				keyword = "";
			}
		}




		session.setAttribute("pageNo", pageNo);

		FruitDAO fruitDAO = new FruitDAOImpl();
		List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);
		//保存到session作用域
		session.setAttribute("fruitList",fruitList);

		long fruitCount = fruitDAO.getFruitCount(keyword);
		long pageCount = (fruitCount + 4) / 5;
		session.setAttribute("pageCount", pageCount);

		super.processTemplate("index",request,response);
	}
}

