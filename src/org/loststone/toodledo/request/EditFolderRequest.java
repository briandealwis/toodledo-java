package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Folder;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GenericDeleteResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class EditFolderRequest extends Request {

	private TextEncoder tEnc = new TextEncoder();

	public EditFolderRequest(AuthToken token, Folder fold) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=editFolder;key="+token.getKey()+";id="+fold.getId();
		StringBuilder buff = new StringBuilder();
		if (fold.hasName()) { 
			buff.append(";title=").append(tEnc.encode(fold.getSName())); 
		} 
		if (fold.hasPrivate()) {
			buff.append(";private=");
			buff.append(fold.isBPrivate() ? "1" : "0");
		}
		if (fold.hasArchived()) {
			buff.append(";archived=");
			buff.append(fold.isArchived() ? "1" : "0");
		}
		
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		GenericDeleteResponse response = new GenericDeleteResponse(this.xmlResponse);
		return response;
	}
}
