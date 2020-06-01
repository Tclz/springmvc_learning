import com.service.IPersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    /**
     * 测试spring的环境配置是否正确
     */
    @Test
    public void  run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        IPersonService ps = (IPersonService) ac.getBean("personService");
        ps.findAll();
    }
}
