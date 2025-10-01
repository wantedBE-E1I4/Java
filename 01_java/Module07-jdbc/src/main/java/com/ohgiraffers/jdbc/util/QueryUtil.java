package com.ohgiraffers.jdbc.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class QueryUtil {
    private static final Map<String, String> queries = new HashMap();

    static {
        loadQueries();
    }

    public static void loadQueries(){
        try {
            InputStream inputStream = QueryUtil.class.getClassLoader().getResourceAsStream("queries.xml");
            //xml -> 자바에서 string됨
            if (inputStream == null) {
                throw new RuntimeException("queries.xml not found");
            }
            // -> xml형태를 가진 string
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("query");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element queryElement = (Element) nodeList.item(i); //text node들 가져오겠다.
                String key = queryElement.getAttribute("key"); //course.save
                String sql = queryElement.getTextContent().trim();

                queries.put(key, sql);
            }
        } catch (Exception e) {
            throw new RuntimeException("쿼리 로딩 중 오류 발생", e);
        }
    }

    public static String getQuery(String key) {
        return queries.get(key);
    }
}
