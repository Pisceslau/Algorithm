package OthersAboutJava;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


/**
 * Created by Lunar on 2016/3/21.
 * Java XML解析
 */
public class XMLParse {
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) {
        XMLParse parser = new XMLParse();
        Document document = parser.parse("F:\\JavaEEWorkSpace\\Test\\src\\OthersAboutJava\\parse.xml");

        //得到根结点
        Element rootElement = document.getDocumentElement();
        //遍历子结点元素
        NodeList nodes = rootElement.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                //处理子结点
            }
        }


        NodeList bookTitles = rootElement.getElementsByTagName("title");
        if (bookTitles != null) {
            for (int i = 0; i < bookTitles.getLength(); i++) {
                Element element = (Element) bookTitles.item(i);
                System.out.println(element.getTextContent());
            }
        }


        NodeList nodeList = rootElement.getElementsByTagName("book");
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute("id");
                System.out.println(id);

            }
        }
    }

    //W3C标准，树结构，可移植，性能不太好需要读取整个文档的DOM方式
    public Document parse(String filePath) {
        Document document = null;
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        //解析一个XML文件在DOM树
        try {
            document = builder.parse(new File(filePath));

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
