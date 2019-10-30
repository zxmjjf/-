package main.java.SetDI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * @author jjf
 * <describe> 测试同xml文件配置List类型的数据</describe>
 */
public class DISetValue {
    private Set<Object> myset;
    public void setSet(Set<Object> set) {
        this.myset = set;
    }
    public Set<Object> getSet() {
        return myset;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/java/SetDI/SetDI.xml");
        DISetValue diSetValue = factory.getBean("set1", DISetValue.class);

        System.out.println(diSetValue.getSet());
    }
}
