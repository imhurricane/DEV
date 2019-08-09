package com.appsoft.systerm.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
	public static void main(String[] args) throws Exception {  
        
        JAXBContext context = JAXBContext.newInstance(Department.class,Staff.class);    // 获取上下文对象  
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象  
          
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进  
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//是否省略xml头信息
          
//        marshaller.marshal(getSimpleDepartment(),System.out);   // 打印到控制台  
          
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//        marshaller.marshal(getSimpleDepartment(), baos);  
//        String xmlObj = new String(writer.toByteArray());
        marshaller.marshal(getSimpleDepartment(), writer);
        String xmlObj = writer.toString();        // 生成XML字符串  
        System.out.println(xmlObj);  
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        InputStream in = new ByteArrayInputStream(xmlObj.getBytes());
        
        Department unmarshal = (Department) unmarshaller.unmarshal(in);
        System.out.println(unmarshal.getName());
        
    }  
      
    /** 
     * 生成一个简单的Department对象 
     * @return 
     */  
    private static Department getSimpleDepartment() {  
        List<Staff> staffs = new ArrayList<Staff>();  
          
        Staff stf = new Staff();  
        stf.setName("周杰伦");  
        stf.setAge(30);  
        stf.setSmoker(false);  
        staffs.add(stf);  
        Staff stf1 = new Staff();
        stf1.setName("周笔畅");  
        stf1.setAge(28);  
        stf1.setSmoker(false);  
        staffs.add(stf1);  
        Staff stf2 = new Staff();
        stf2.setName("周星驰");  
        stf2.setAge(40);  
        stf2.setSmoker(true);  
        staffs.add(stf2);  
          
        Department dept = new Department();  
        dept.setName("娱乐圈");  
        dept.setStaffs(staffs);  
          
        return dept;  
    }  
}
