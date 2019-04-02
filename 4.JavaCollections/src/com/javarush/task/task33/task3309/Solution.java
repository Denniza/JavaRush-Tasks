package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException, SAXException, ParserConfigurationException, TransformerException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();

        marshaller.marshal(obj,writer);

        String startText = writer.toString();

        System.out.println(writer.toString());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setCoalescing(true);
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();



        Document document = db.parse(new InputSource(new StringReader(startText)));
        document.setXmlStandalone(true);

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        NodeList list = root.getElementsByTagName(tagName);
        System.out.println(list.item(0).getNodeName());


        for(int i=0; i<list.getLength();i++){
            Node node = list.item(i);
            if(node.getNodeType() != Node.CDATA_SECTION_NODE){
                document.insertBefore(document.createComment(comment),node);

            }

        }

        TransformerFactory trf = TransformerFactory.newInstance();
        Transformer tr = trf.newTransformer();
        StringWriter writer1 = new StringWriter();

        tr.transform(new DOMSource(document),new StreamResult(writer1));

        return writer1.toString();
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException, TransformerException {


    }

}
