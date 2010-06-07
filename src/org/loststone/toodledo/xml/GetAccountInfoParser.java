package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.data.AccountInfo;
import org.loststone.toodledo.util.TdDateTime;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetAccountInfoParser extends DefaultHandler {

	String xml; 
	StringBuilder tempVal; 
	AccountInfo accountInfo;
	
	public GetAccountInfoParser(String xml) {
		this.xml = xml;
	}
	
	public AccountInfo getAccountInfo() {
		accountInfo = new AccountInfo();
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
		
		return accountInfo;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = new StringBuilder();
		
		if(qName.equalsIgnoreCase("account")) {
		} else if(qName.equalsIgnoreCase("userid")) {
		} else if(qName.equalsIgnoreCase("alias")) {
		} else if(qName.equalsIgnoreCase("pro")) {
		} else if(qName.equalsIgnoreCase("dateformat")) {
		} else if(qName.equalsIgnoreCase("timezone")) {
		} else if(qName.equalsIgnoreCase("hidemonths")) {
		} else if(qName.equalsIgnoreCase("hotlistpriority")) {
		} else if(qName.equalsIgnoreCase("hotlistduedate")) {
		} else if(qName.equalsIgnoreCase("lastaddedit")) {
		} else if(qName.equalsIgnoreCase("lastdelete")) {
		} else if(qName.equalsIgnoreCase("lastfolderedit")) {
		} else if(qName.equalsIgnoreCase("lastcontextedit")) {
		} else if(qName.equalsIgnoreCase("lastgoaledit")) {
		} else if(qName.equalsIgnoreCase("lastnotebookedit")) {
		} else {
			System.err.println("warning: getAccountInfo: unexpected element: " + qName);
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal.append(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// NB: we can't represent the date-time "0000-00-00 00:00:00": there is no
		// year 0.  So we filter it out.
		String content = tempVal.toString().trim();
		if(qName.equalsIgnoreCase("account")) {
		} else if(qName.equalsIgnoreCase("userid")) {
			accountInfo.setUserId(content);
		} else if(qName.equalsIgnoreCase("alias")) {
			accountInfo.setAlias(content);
		} else if(qName.equalsIgnoreCase("pro")) {
			accountInfo.setPro(content.equals("1"));
		} else if(qName.equalsIgnoreCase("dateformat") && !content.isEmpty()) {
			accountInfo.setDateFormat(Integer.parseInt(content));
		} else if(qName.equalsIgnoreCase("timezone") && !content.isEmpty()) {
			accountInfo.setTimezone(Integer.parseInt(content));
		} else if(qName.equalsIgnoreCase("hidemonths") && !content.isEmpty()) {
			accountInfo.setHideMonths(Integer.parseInt(content));
		} else if(qName.equalsIgnoreCase("hotlistpriority") && !content.isEmpty()) {
			accountInfo.setHotlistPriority(Integer.parseInt(content));
		} else if(qName.equalsIgnoreCase("hotlistduedate") && !content.isEmpty()) {
			accountInfo.setHotlistDueDate(Integer.parseInt(content));
		} else if(qName.equalsIgnoreCase("lastaddedit") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastAddEdit(new TdDateTime(content));
		} else if(qName.equalsIgnoreCase("lastdelete") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastDelete(new TdDateTime(content));
		} else if(qName.equalsIgnoreCase("lastfolderedit") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastFolderEdit(new TdDateTime(content));
		} else if(qName.equalsIgnoreCase("lastcontextedit") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastContextEdit(new TdDateTime(content));
		} else if(qName.equalsIgnoreCase("lastgoaledit") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastGoalEdit(new TdDateTime(content));
		} else if(qName.equalsIgnoreCase("lastnotebookedit") && !content.isEmpty()
				&& !content.equals("0000-00-00 00:00:00")) {
			accountInfo.setLastNotebookEdit(new TdDateTime(content));
		}
	}


}
