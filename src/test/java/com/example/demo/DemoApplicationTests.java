package com.example.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
//@MapperScan("com.example.demo.mapper")
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void testTSelectList() {
		System.out.println("测试mybatis_plus");
		/**
		 * 这个selectList的里面的参数是wrapper类型的数据
		 */
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}


	/**
	 * 测试添加用户
	 */
	@Test
	public void testAddUser() {
		User user = new User();

		user.setName("wangwu");
		user.setAge(31);
		user.setEmail("djshdjhadh@qq.com");

		int insert = userMapper.insert(user);
		System.out.printf("**************************************************************");
		System.out.println(insert); // 打印更新影响了几行
		System.out.printf("**************************************************************");
		System.out.println(user); // 回传数据
	}

	/**
	 * 测试修改用户
	 */
	@Test
	public void testUpdateuser(){
		User user = new User();
		user.setId(9);
		user.setAge(9);

		int i = userMapper.updateById(user);
		System.out.println("--------------------------------------------");
		System.out.println(i); // 对多少条数据产生了影响
		System.out.println("--------------------------------------------");
		System.out.println(user);
	}

	/**
	 * 测试添加数据
	 */
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setId(9);
		user.setAge(3);
		user.setName("hdad");
		int result = userMapper.updateById(user);
		System.out.println(result);
	}

	@Test
	public void testOptimisticLocker() {
		//查询
		User user = new User();
		//修改数据
		user.setId(1);
		user.setName("Helen Yao");
		user.setEmail("helen@qq.com");
		//执行更新
		userMapper.updateById(user);
	}

	// 根据id查询用户
	@Test
	public void selectUser(){
		User user = userMapper.selectById(1);
		System.out.println(user);
	}

	//根据多个id，批量查询user
	@Test
	public void selectAllIdUser() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,4));
		System.out.println(users);

	}
	
	// 测试分页
	@Test
	public void pageTest(){
		Page<User> page = new Page<>(1,5);

		page.getRecords().forEach(System.out::println);
		System.out.println(page.getCurrent());
		System.out.println(page.getPages());
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());


	}
}
