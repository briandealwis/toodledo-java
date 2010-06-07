package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.util.TdDateTime;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetDeletedParser extends DefaultHandler {

	String xml; 
	StringBuilder tempVal;
	Map<Integer,TdDateTime> deleted;

	int id;
	TdDateTime stamp;
	
	public GetDeletedParser(String xml) {
		this.xml = xml;
	}
	
	public Map<Integer, TdDateTime> getDeletedIds() {
		deleted = new HashMap<Integer,TdDateTime>();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			//parse the string and also register this class for call backs
			sp.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")), this);
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return deleted;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = new StringBuilder();
		
		if(qName.equalsIgnoreCase("deleted")) {
		} else if(qName.equalsIgnoreCase("task")) {
			id = -1; stamp = null;
		} else if(qName.equalsIgnoreCase("id")) {
		} else if(qName.equalsIgnoreCase("stamp")) {
		} else {
			System.err.println("warning: getDeleted: unexpected element: " + qName);
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal.append(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String content = tempVal.toString().trim();
		if(qName.equalsIgnoreCase("deleted")) {
		} else if(qName.equalsIgnoreCase("id")) {
			id = Integer.parseInt(content);
		} else if(qName.equalsIgnoreCase("stamp")) {
			stamp = new TdDateTime(content);
		} else if(qName.equalsIgnoreCase("task")) {
			deleted.put(id, stamp);
		}
	}




}
