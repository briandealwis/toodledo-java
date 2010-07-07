package org.loststone.toodledo.request;

import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetDeletedResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TdDateTime;
import org.loststone.toodledo.util.TextEncoder;

public class GetDeletedRequest extends Request {
	
	private TextEncoder tEnc = new TextEncoder();

	public GetDeletedRequest(AuthToken token, TdDateTime after) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getDeleted;key="+token.getKey();
		if(after != null) { this.url += ";after=" + tEnc.encode(after.toString()); }	
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetDeletedResponse response = new GetDeletedResponse(this.xmlResponse);
		return response;
	}
}
