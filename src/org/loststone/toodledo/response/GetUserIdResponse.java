package org.loststone.toodledo.response;

import org.loststone.toodledo.exception.IncorrectUserPasswordException;
import org.loststone.toodledo.exception.MissingPasswordException;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.GetUserIdParser;

public class GetUserIdResponse extends Response {

	public GetUserIdResponse(String resp) {
		super(resp);
	}

	public String getUserId() throws ToodledoApiException, IncorrectUserPasswordException, MissingPasswordException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new GetUserIdParser(getXmlResponseContent()).getUserId();
	}

}
