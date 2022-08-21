import com.glk.spring5.Myspring.BeanDefinition;
import com.glk.spring5.Myspring.MyAnnotationConfigApplicationContext;
import com.glk.spring5.User;
import org.junit.Test;


import java.util.Set;

public class TestSpring5 {

    @Test
    public void testAdd(){
        MyAnnotationConfigApplicationContext applicationContext = new MyAnnotationConfigApplicationContext("com.glk.spring5.Myspring.entity");
        Object account = applicationContext.getBean("account");
        Object myOrder = applicationContext.getBean("myOrder");
        System.out.println(myOrder);
        System.out.println(account);


    }
}
