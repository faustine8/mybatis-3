package com.faustine;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author faustine
 * @date 2023/4/24
 */
public class MybatisTest {

  /**
   * 测试传统开发方式
   */
  public void test1() throws IOException {
    // 1.读取配置文件，读成字节输入流。注意：现在还没有解析
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    // 2.解析配置文件，封装 Configuration 对象；创建 DefaultSqlSessionFactory 对象
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    // 3.生产了 DefaultSqlSession 实例对象；设置了事务不自动提交；完成了 Executor 对象的创建
    SqlSession sqlSession = factory.openSession();
    // 4.根据 statementId 从 Configuration 对象中的 Map 集合中获取到指定的 MappedStatement 对象；将查询任务委派给 executor 执行器
    List<Object> list = sqlSession.selectList("namespace.id");

  }

  /**
   * 测试 Mapper 代理方式
   */
  public void test2() throws IOException {

  }

}
