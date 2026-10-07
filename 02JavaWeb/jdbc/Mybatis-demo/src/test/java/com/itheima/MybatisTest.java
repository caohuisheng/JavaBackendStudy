package com.itheima;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void selectAllTest() throws IOException {
        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByidTest() throws IOException {
        //查询信息
        int id = 1;
        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);

        System.out.println(brand);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConadition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Brand brand = new Brand(status,companyName,brandName);

        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);


        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //List<Brand> brands = mapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = mapper.selectByCondition(brand);
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConaditionSinle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Brand brand = new Brand();
        brand.setBrandName(brandName);

        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByConditionSingle(brand);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void insertItem() throws IOException {
        //接收参数
        String brandName = "步步高";
        String companyName = "步步高";
        int ordered = 1;
        String description = "english is so easy";
        int status = 1;
        Brand brand = new Brand(brandName,companyName,ordered,description,status);

        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //设置true表示不开启事务

        //3.执行sql
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.insertItem(brand);

        System.out.println(brand.getId());

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void updateItem() throws IOException {
        //接收参数
        String brandName = "步步高";
        String companyName = "步步高公司";
        int ordered = 100;
        String description = "english is so easy";
        int status = 1;
        int id = 5;
        Brand brand = new Brand(status,companyName,brandName);
        brand.setId(id);

        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //设置true表示不开启事务

        //3.执行sql
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.updateItem(brand);

        System.out.println(count);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
        //接收参数
        int id = 5;

        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //设置true表示不开启事务

        //3.执行sql
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.deleteById(id);

        System.out.println(count);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
        //接收参数
        int ids[] = {2,3,6};

        //1.加载配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //设置true表示不开启事务

        //3.执行sql
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.deleteByIds(ids);

        System.out.println(count);

        //4.释放资源
        sqlSession.close();
    }

}
