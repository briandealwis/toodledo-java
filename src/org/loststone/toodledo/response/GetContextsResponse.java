package org.loststone.toodledo.response;

import java.util.List;

import org.loststone.toodledo.data.Context;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.ContextsParser;

public class GetContextsResponse extends Response {

	public GetContextsResponse(String resp) {
		super(resp);
	}

	public List<Context> getContexts() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new ContextsParser(getXmlResponseContent()).getContexts();
	}
	
}
