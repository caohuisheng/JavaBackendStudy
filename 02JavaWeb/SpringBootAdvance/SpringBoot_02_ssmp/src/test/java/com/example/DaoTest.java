package com.example;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional //阻止测试用例提交数据
@Rollback(true)
public class DaoTest {

}
