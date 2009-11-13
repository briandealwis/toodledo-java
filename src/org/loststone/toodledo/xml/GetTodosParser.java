package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.data.Priority;
import org.loststone.toodledo.data.Repeat;
import org.loststone.toodledo.data.Status;
import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.util.TdDate;
import org.loststone.toodledo.util.TdDateTime;
import org.loststone.toodledo.util.TdTime;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetTodosParser extends DefaultHandler {

	String xml; 
	StringBuilder tempVal; 
	Todo tmp_;
	
	ArrayList<Todo> todoList; 
	
	public GetTodosParser(String xml) {
		this.xml = xml;
		todoList = new ArrayList<Todo>();
	}
	
	public ArrayList<Todo> getTodos() {
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
		
		return todoList;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = new StringBuilder();
		
		if(qName.equalsIgnoreCase("task")) {
			tmp_ = new Todo();
		} else if(qName.equalsIgnoreCase("id")) {
			
		} else if(qName.equalsIgnoreCase("parent")) {
			
		} else if(qName.equalsIgnoreCase("children")) {
			
		} else if(qName.equalsIgnoreCase("title")) {
			
		} else if(qName.equalsIgnoreCase("tag")) {
			
		} else if(qName.equalsIgnoreCase("folder")) {
			
		} else if(qName.equalsIgnoreCase("context")) {
			tmp_.setContext(Integer.parseInt(attributes.getValue("id")));
		} else if(qName.equalsIgnoreCase("goal")) {
			tmp_.setGoal(Integer.parseInt(attributes.getValue("id")));
		} else if(qName.equalsIgnoreCase("added")) {
			
		}else if(qName.equalsIgnoreCase("modified")) {
			
		}else if(qName.equalsIgnoreCase("startdate")) {
			
		}else if(qName.equalsIgnoreCase("starttime")) {
			
		}else if(qName.equalsIgnoreCase("duedate")) {
			
		}else if(qName.equalsIgnoreCase("duetime")) {
			
		}else if(qName.equalsIgnoreCase("completed")) {
			
		}else if(qName.equalsIgnoreCase("repeat")) {
			
		}else if(qName.equalsIgnoreCase("rep_advanced")) {
			
		}else if(qName.equalsIgnoreCase("status")) {
			
		}else if(qName.equalsIgnoreCase("star")) {
			
		}else if(qName.equalsIgnoreCase("priority")) {
			
		}else if(qName.equalsIgnoreCase("length")) {
			
		}else if(qName.equalsIgnoreCase("timer")) {
			// TODO
		}else if(qName.equalsIgnoreCase("note")) {
						
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal.append(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String content = tempVal.toString().trim();
		if(qName.equalsIgnoreCase("task")) {
			todoList.add(tmp_);
		}else if(qName.equalsIgnoreCase("id")) {
			tmp_.setId(Integer.parseInt(content));
		}else if(qName.equalsIgnoreCase("parent") && !content.isEmpty()) {
			tmp_.setParent(Integer.parseInt(content));
		}else if(qName.equalsIgnoreCase("children")) {
			//ignored
		}else if(qName.equalsIgnoreCase("title") && !content.isEmpty()) {
			tmp_.setTitle(content);
		}else if(qName.equalsIgnoreCase("tag") && !content.isEmpty()) {
			tmp_.setTag(content);
		}else if(qName.equalsIgnoreCase("folder") && !content.isEmpty()) {
			tmp_.setFolder(Integer.parseInt(content));
		}else if(qName.equalsIgnoreCase("context")) {
		}else if(qName.equalsIgnoreCase("goal")) {
		}else if(qName.equalsIgnoreCase("added") && !content.isEmpty()) {
			tmp_.setAdded(new TdDate(content));
		}else if(qName.equalsIgnoreCase("modified") && !content.isEmpty()) {
			tmp_.setModified(new TdDateTime(content));
		}else if(qName.equalsIgnoreCase("startdate") && !content.isEmpty()) {
			tmp_.setStartDate(new TdDate(content));
		}else if(qName.equalsIgnoreCase("starttime") && !content.isEmpty()) {
			tmp_.setStartTime(new TdTime(content));
		}else if(qName.equalsIgnoreCase("duedate") && !content.isEmpty()) {
			tmp_.setDueDate(new TdDate(content));
		}else if(qName.equalsIgnoreCase("duetime") && !content.isEmpty()) {
			tmp_.setDueTime(new TdTime(content));
		}else if(qName.equalsIgnoreCase("completed") && !content.isEmpty()) {
			tmp_.setCompleted(new TdDate(content));
		}else if(qName.equalsIgnoreCase("repeat") && !content.isEmpty()) {
			tmp_.setRepeat(Repeat.get(Integer.parseInt(content)));
		}else if(qName.equalsIgnoreCase("rep_advanced") && !content.isEmpty()) {
			tmp_.setRepAdvanced(content);
		}else if(qName.equalsIgnoreCase("status") && !content.isEmpty()) {
			tmp_.setStatus(Status.get(Integer.parseInt(content)));
		}else if(qName.equalsIgnoreCase("star")) {
			tmp_.setStar(Integer.parseInt(content) == 1);
		}else if(qName.equalsIgnoreCase("priority") && !content.isEmpty()) {
			tmp_.setPriority(Priority.get(Integer.parseInt(content)));
		}else if(qName.equalsIgnoreCase("length") && !content.isEmpty()) {
			tmp_.setLength(Integer.parseInt(content));			
		}else if(qName.equalsIgnoreCase("timer") && !content.isEmpty()) {
			
		}else if(qName.equalsIgnoreCase("note") && !content.isEmpty()) {
			tmp_.setNote(content);
		}
	}

	
}
