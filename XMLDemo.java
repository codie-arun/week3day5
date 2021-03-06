package week3day5;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLDemo {

	public static void main(String[] args) throws Exception{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		
		Document doc = db.parse("books.xml");
		
		System.out.println(doc.getDocumentElement().getNodeName());
		System.out.println(doc.getDocumentElement().getChildNodes().getLength());
		
		
		Element rootElement=doc.getDocumentElement();
		
		for(int i=0;i<rootElement.getChildNodes().getLength();i++) {
			for(int j=0;j<rootElement.getChildNodes().item(i).getChildNodes().getLength();j++) {
				System.out.println(rootElement.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
			}
		}
		
	}

}
