package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetAccountInfoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;

public class GetAccountInfoRequest extends Request {

	public GetAccountInfoRequest(AuthToken token) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getAccountInfo;key="+token.getKey();	
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetAccountInfoResponse response = new GetAccountInfoResponse(this.xmlResponse);
		return response;
	}
	
}
