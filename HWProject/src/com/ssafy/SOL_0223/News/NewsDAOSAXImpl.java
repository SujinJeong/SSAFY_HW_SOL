package com.ssafy.SOL_0223.News;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list = new ArrayList<>();
	
	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return list;
	}

	public void connectNews(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),
					handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb = new StringBuilder();
		News ns = new News();
		boolean flag;
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			if (ns != null) {
				if (name.equalsIgnoreCase("title")) {
					ns.setTitle(sb.toString().trim());
				} else if (name.equalsIgnoreCase("link")) {
					ns.setLink(sb.toString().trim());
				} else if (name.equalsIgnoreCase("description")) {
					ns.setDesc(sb.toString().trim());
				} else if (name.equalsIgnoreCase("item")) {
					list.add(ns);
				}
			}
			sb.setLength(0);
		}

		@Override
		public void startElement(String uri, String localName, String qname,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qname, attributes);
			if (qname.equalsIgnoreCase("item")) {
				ns = new News();
			}
		}
	}

	@Override
	public News search(int index) {
		return null;
	}
  
}
