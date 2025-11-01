package fr.matthieuperrin.dblp;

import java.net.http.*;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import fr.matthieuperrin.Paper;

import java.io.*;


public class DBLPFetcher {

	public static void main(String[] args) throws Exception {
//		List<Paper> journals = new ArrayList<Paper>();
//		List<Paper> conferences = new ArrayList<Paper>();

		HttpClient http = HttpClient.newHttpClient();
		HttpRequest r2 = HttpRequest.newBuilder(URI.create("https://dblp.org/pid/157/8438.xml")).GET().build();
		String xml = http.send(r2, HttpResponse.BodyHandlers.ofString()).body();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

		NodeList entries = doc.getDocumentElement().getElementsByTagName("r");
		for (int i = 0; i < entries.getLength(); i++) {
			Element r = (Element) entries.item(i);
			Element pub = (Element) r.getFirstChild();
			if (pub == null) continue;
//			String type = pub.getTagName();
			List<String> author = getList(pub, "author");
			String title = getText(pub, "title");
			String year  = getText(pub, "year");
			String venue = getText(pub, "journal");
			if (venue.isEmpty()) venue = getText(pub, "booktitle");
			String url = getText(pub, "ee"); // electronic edition link
			Paper paper = new Paper(url, title, venue + " (" + year + ")", author, List.of());

			System.out.println(paper.toJava() + ",");
			
			
			
//			if(type.equals("article") && ! venue.equals("CoRR")) {
//				journals.add(paper);
//			} else if(type.equals("inproceedings")) {
//				conferences.add(paper);
//			}
		}

//		System.out.println("private static List<Paper> journals = List.of(");
//		for(var paper : journals) {
//			System.out.println(paper.toJava() + ",");
//		}
//		System.out.println(");\nprivate static List<Paper> conferences = List.of(");
//		for(var paper : conferences) {
//			System.out.println(paper.toJava() + ",");
//		}
//		System.out.println(");");
	}

	static String getText(Element parent, String tag) {
		NodeList list = parent.getElementsByTagName(tag);
		if (list.getLength() == 0) return "";
		return list.item(0).getTextContent().trim();
	}

	static List<String> getList(Element parent, String tag) {
		List<String> list = new ArrayList<String>();
		NodeList nodes = parent.getElementsByTagName(tag);
		for (int i = 0; i < nodes.getLength(); i++) {
			String text = nodes.item(i).getTextContent().trim();
			if(!text.equals("Matthieu Perrin"))list.add(text);
		}
		return list;
	}

}
