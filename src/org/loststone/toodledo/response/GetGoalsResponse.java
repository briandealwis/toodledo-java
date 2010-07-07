package org.loststone.toodledo.response;

import java.util.List;

import org.loststone.toodledo.data.Goal;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.xml.GoalsParser;

public class GetGoalsResponse extends Response {

	public GetGoalsResponse(String resp) {
		super(resp);
	}

	public List<Goal> getGoals() throws ToodledoApiException {
		// check for errors:
		if (!this.succeeded()) {
			throw new ToodledoApiException(response.substring(response.indexOf("<error>")+7, 
					response.indexOf("</error>")));
		}
		return new GoalsParser(getXmlResponseContent()).getGoals();
	}
	
}
