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

@SuppressWarnings("ALL")
@SpringBootTest
@MapperScan("com.example.demo.mapper")
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

		user.setName("helw");
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
		user.setId(10);
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
		user.setAge(3);
		user.setName("ceshi");
		int result = userMapper.updateById(user);
		System.out.println(result);
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
    // 测试乐观锁
	@Test
	public void testOptimisticLocker() {
		//查询
		User user = userMapper.selectById(10);
		//User user = new User();  这种方式不行
		user.setId(10);
		//修改数据
		user.setName("Helen Yao1");
		user.setEmail("helen@qq.com");
		//执行更新
		userMapper.updateById(user);
	}
	
	// 测试分页
	@Test
	public void pageTest(){
		Page<User> page = new Page<>(1,5);
		userMapper.selectPage(page, null);
		page.getRecords().forEach(System.out::println);
		System.out.println(page.getCurrent());
		System.out.println(page.getPages());
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
	}

	/**
	 * 第二种测试方式用map存数据
	 */
	@Test
	public void pageTest2(){
		Page<User> page = new Page<>(1,5);
		IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
		for (Map<String, Object> record : mapIPage.getRecords()) {
			System.out.println(record);
		}
	}

	/**
	 * 测试逻辑删除，这个逻辑删除的delete值必须是0
	 */
	@Test
	public void testLogicDelete() {
		int result = userMapper.deleteById(9);
		System.out.println(result);
	}

/**
 * 测试 逻辑删除后的查询：
 * 不包括被逻辑删除的记录
 */

	@Test
	public void testLogicDeleteSelect() {
		User user = new User();
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	/**
	 * 测试 性能分析插件
	 */
	@Test
	public void testPerformance() {
		User user = new User();
		user.setName("我是Helen");
		user.setEmail("helen@sina.com");
		user.setAge(18);
		userMapper.insert(user);
	}
}
