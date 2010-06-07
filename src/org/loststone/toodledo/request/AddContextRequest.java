package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Context;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddContextResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class AddContextRequest extends Request {

	private TextEncoder tEnc = new TextEncoder();

	public AddContextRequest(AuthToken token, Context context) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addContext;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (context.hasName()) { 
			buff.append(";title=").append(tEnc.encode(context.getName())); 
		} else { 
			throw new ToodledoApiException("Folder object at least must have a name!");
		}
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		AddContextResponse response = new AddContextResponse(this.xmlResponse);
		return response;
	}

}
