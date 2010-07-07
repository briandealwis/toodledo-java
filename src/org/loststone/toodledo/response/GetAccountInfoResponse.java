package org.loststone.toodledo.response;

import org.loststone.toodledo.data.AccountInfo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.GetAccountInfoParser;

public class GetAccountInfoResponse extends Response {
	
	public GetAccountInfoResponse(String resp) {
		super(resp);
	}

	public AccountInfo getAccountInfo() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new GetAccountInfoParser(getXmlResponseContent()).getAccountInfo();
	}

}
