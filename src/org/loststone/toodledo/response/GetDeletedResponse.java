package org.loststone.toodledo.response;

import java.util.Map;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.util.TdDateTime;
import org.loststone.toodledo.xml.GetDeletedParser;

public class GetDeletedResponse extends Response {

	public GetDeletedResponse(String response) {
		super(response);
	}

	public Map<Integer, TdDateTime> getDeletedIds() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new GetDeletedParser(getXmlResponseContent()).getDeletedIds();	
	}

}
