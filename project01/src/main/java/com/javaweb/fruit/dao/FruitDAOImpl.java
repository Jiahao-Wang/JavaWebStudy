package com.javaweb.fruit.dao;

import com.javaweb.fruit.pojo.Fruit;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
	@Override
	public List<Fruit> getFruitList() {
		return super.executeQuery("select * from t_fruit");
	}

	@Override
	public List<Fruit> getFruitList(Integer pageNo) {
		return super.executeQuery("select * from t_fruit limit ?, 4", (pageNo-1) * 4);
	}

	@Override
	public List<Fruit> getFruitList(String keyword, Integer pageNo) {
		return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?, 4", "%"+keyword+"%", "%"+keyword+"%", (pageNo-1) * 4);
	}


	@Override
	public void addFruit(Fruit fruit) {
		String sql = "insert into t_fruit values(0,?,?,?,?)";
		super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark()) ;
		//insert语句返回的是自增列的值，而不是影响行数
		//System.out.println(count);
	}

	@Override
	public void updateFruit(Fruit fruit) {
		String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ? ";
		super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(),fruit.getRemark(), fruit.getFid());
	}

	@Override
	public Fruit getFruitByFname(String fname) {
		return super.load("select * from t_fruit where fname like ? ",fname);
	}

	@Override
	public void delFruit(Integer fid) {
		String sql = "delete from t_fruit where fname like ? " ;
		super.executeUpdate("delete from t_fruit where fid = ?", fid);
	}

	@Override
	public Fruit getFruitByFid(Integer fid) {
		return super.load("select * from t_fruit where fid = ?", fid);
	}

	@Override
	public Long getFruitCount() {
		return (Long)super.executeComplexQuery("select count(*) from t_fruit")[0];
	}

	@Override
	public Long getFruitCount(String keyword) {
		return (Long)super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?","%"+keyword+"%","%"+keyword+"%")[0];
	}
}