package com.appsoft.hk.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.appsoft.systerm.xml.Department;
import com.appsoft.systerm.xml.Staff;

public class Test {

	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Root.class,Head.class,Vehispara.class);    // 获取上下文对象  
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象  
          
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集  
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进  
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//是否省略xml头信息
          
//        marshaller.marshal(getSimpleDepartment(),System.out);   // 打印到控制台  
          
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");
//        marshaller.marshal(getSimpleDepartment(), baos);  
//        String xmlObj = new String(writer.toByteArray());
        marshaller.marshal(getRootXmlData(), writer);
        String xmlObj = writer.toString();        // 生成XML字符串  
        System.out.println(xmlObj);  
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        InputStream in = new ByteArrayInputStream(xmlObj.getBytes());
        
        Root unmarshal = (Root) unmarshaller.unmarshal(in);
        System.out.println(unmarshal.getStavehisparas());
	}
	
	public static Root getRootXmlData() {
		Root root = new Root();
		Head head = new Head();
		Vehispara vehispara = new Vehispara();
		head.setOrgan("13020201");
		head.setJkxlh("B58EDC74E6FC0DF878C88E403A9F4045");
		head.setJkid("YC002");
		head.setSjc("2019-06-22 10:08:06.232");
		
		vehispara.setLicense("冀C1V168");
		vehispara.setLicensetype("02");
		
		List<Head> headList = new ArrayList<Head>();
		headList.add(head);
		
		List<Vehispara> vehisparaList = new ArrayList<Vehispara>();
		vehisparaList.add(vehispara);
		
		root.setHeads(headList);
		root.setStavehisparas(vehisparaList);
		
		return root;
	}
}
