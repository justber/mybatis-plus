package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

		user.setName("Helen");
		user.setAge(18);
		user.setEmail("55317332@qq.com");

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
		user.setId(2);
		user.setAge(34);

		int i = userMapper.updateById(user);
		System.out.println("--------------------------------------------");
		System.out.println(i); // 对多少条数据产生了影响
		System.out.println("--------------------------------------------");
		System.out.println(user);
	}

}
