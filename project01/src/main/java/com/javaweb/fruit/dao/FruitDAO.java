package com.javaweb.fruit.dao;

/**
 * @author Jiahao Wang
 * @create 2022-05-03 20:29
 */

import com.javaweb.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
	//查询库存列表
	List<Fruit> getFruitList(Integer pageNo);

	List<Fruit> getFruitList();

	//新增库存
	void addFruit(Fruit fruit);

	//修改库存
	void updateFruit(Fruit fruit);

	//根据名称查询特定库存
	Fruit getFruitByFname(String fname);

	//删除特定库存记录
	void delFruit(Integer fid);

	Fruit getFruitByFid(Integer fid);

	Long getFruitCount();
}
