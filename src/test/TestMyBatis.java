import com.dao.IPersonDao;
import com.domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        IPersonDao personDao = session.getMapper(IPersonDao.class);
        // 查询所有
        List<Person> list = personDao.findAll();
        for(Person person:list){
            System.out.println(person);
        }
        session.close();
        in.close();


    }
    /**
     * 测试保存
     */
    @Test
    public void run2() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        IPersonDao personDao = session.getMapper(IPersonDao.class);

        Person person = new Person();
        person.setMoney(500f);
        person.setName("gg");
        // 保存
        personDao.savePerson(person);
        // 提交事务
        session.commit();
        // 关闭资源
        session.close();
        in.close();


    }

}
