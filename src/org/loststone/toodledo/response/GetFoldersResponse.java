package org.loststone.toodledo.response;

import java.util.List;

import org.loststone.toodledo.data.Folder;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.FolderParser;


public class GetFoldersResponse extends Response {

	public GetFoldersResponse(String resp) {
		super(resp);
	}

	public List<Folder> getFolders() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new FolderParser(getXmlResponseContent()).getFolders();
	}

}
