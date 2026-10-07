package com.itheima;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParseDemo {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();

        //获取document对象
        Document document = saxReader.read(new FileInputStream("XML\\Students.xml"));

        //获取根节点对象
        Element rootElement = document.getRootElement();

        //从根节点元素查找其它节点元素
        List<Element> elements = rootElement.elements("student");

        List<Student> students = new ArrayList<>();

        //遍历每一个学生元素
        for(Element studentElement:elements){
            //获取属性
            Attribute attribute = studentElement.attribute("id");
            //获取属性值
            String id = attribute.getValue();

            //获取name元素
            Element nameElement = studentElement.element("name");
            //获取name元素值
            String name = nameElement.getText();

            Element ageElement = studentElement.element("age");
            String age = ageElement.getText();

            Element addressElement = studentElement.element("address");
            String address = addressElement.getText();

            Student s = new Student(name,Integer.parseInt(age),address);
            students.add(s);
        }

        students.forEach(s-> System.out.println(s));

    }
}
