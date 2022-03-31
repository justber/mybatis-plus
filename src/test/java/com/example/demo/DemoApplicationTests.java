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

}
