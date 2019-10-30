package main.java.ListDI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author jjf
 * <describe> 测试同xml文件配置List类型的数据</describe>
 */
public class DIListValue {
    private List<Object> list;
    public void setList(List<Object> list) {
        this.list = list;
    }
    public List<Object> getList() {
        return list;
    }

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("main/java/ListDI/ListDI.xml");
        DIListValue diListValue = factory.getBean("list1", DIListValue.class);

        System.out.println(diListValue.getList());
    }
}
