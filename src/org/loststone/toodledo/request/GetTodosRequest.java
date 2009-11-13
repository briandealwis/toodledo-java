package org.loststone.toodledo.request;

import org.loststone.toodledo.data.TodoFilter;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.GetTodosResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class GetTodosRequest extends Request {
	private TextEncoder tEnc = new TextEncoder();

	public GetTodosRequest(AuthToken token, TodoFilter filter) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=getTasks;key="+token.getKey();
		if (filter != null) {
			StringBuilder buff = new StringBuilder();
			if (filter.hasTitle()) { buff.append(";title=").append(tEnc.encode(filter.getTitle())); }
			if (filter.hasTag()) buff.append(";tag=").append(tEnc.encode(filter.getTag()));
			if (filter.hasFolder()) buff.append(";folder=").append(filter.getFolder());
			if (filter.hasContext()) buff.append(";context=").append(filter.getContext());
			if (filter.hasGoal()) buff.append(";goal=").append(filter.getGoal());
			if (filter.hasParent()) buff.append(";parent=").append(filter.getParent());
			if (filter.hasBefore()) buff.append(";before=").append(filter.getBefore());
			if (filter.hasStartbefore()) buff.append(";startbefore=").append(filter.getStartbefore());
			
			// TODO missiing duetime and starttime
			
			if (filter.hasRepeat()) buff.append(";repeat=").append(filter.getRepeat());
			if (filter.hasRepAdvanced()) buff.append(";rep_advanced=").append(tEnc.encode(filter.getRepAdvanced()));
			if (filter.hasStatus()) buff.append(";status=").append(filter.getStatus());
			if (filter.hasLength()) buff.append(";length=").append(filter.getLength());
			if (filter.hasPriority()) buff.append(";priority=").append(filter.getPriority());
			if (filter.hasStar()) buff.append(";star=").append(filter.isStar() ? "1" : "0");
			if (filter.hasNote()) buff.append(";note=").append(tEnc.encode(filter.getNote()));
			this.url = this.url.concat(buff.toString());
		}
	}

	@Override
	public Response getResponse() {
		this.exec();
		GetTodosResponse response = new GetTodosResponse(this.xmlResponse);
		return response;
	}
	
}
