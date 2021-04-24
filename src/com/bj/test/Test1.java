package com.bj.test;

import com.bj.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载Mybatis的主配置文件mybatis-config.xml，创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*
        SqlSessionFactory:SqlSessionFactoryd的建造者
        通过该建造这对象调用建造方法，为我们创建一个SqlSessionFactory对象

         SqlSessionFactory对象唯一的作用创建SqlSession对象

      * */
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //所有操作使用的都是SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //根据id查询单条
       /*Student s = session.selectOne("test1.getById", "A0001");

       System.out.println(s);

       session.close();*/

       //查询学生信息表中所有记录
      /*List<Student>  sList = session.selectList("test1.getAll");
      for (Student s:sList){
          System.out.println(s);
      }
      session.close();*/

      //添加 需要手动提交事务
        /*Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        session.insert("test1.set", s);
        session.commit();
        session.close();*/
      //删除 需要手动提交事务
        session.delete("test1.delete","A0006");
        session.commit();
        session.close();

      //修改 需要手动提交事务
        /*Student s = new Student();
        s.setId("A0006");
        s.setName("cxk—SB");
        s.setAge(52);
        session.update("test1.update", s);
        session.commit();
        session.close();*/
    }
}
