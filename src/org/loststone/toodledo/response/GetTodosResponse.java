package org.loststone.toodledo.response;

import java.util.List;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.GetTodosParser;

public class GetTodosResponse extends Response {

	public GetTodosResponse(String resp) {
		super(resp);
	}

	public List<Todo> getTodos() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}

		return new GetTodosParser(getXmlResponseContent()).getTodos();
	}
	
}
