package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.ModifyTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class ModifyTodoRequest extends Request {

	private TextEncoder tEnc = new TextEncoder();

	public ModifyTodoRequest(AuthToken token, Todo todo) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=editTask;key="+token.getKey();
		StringBuffer buff = new StringBuffer();
		if (todo.hasId()) {
			buff.append(";id="+todo.getId());
		} else {
			throw new ToodledoApiException("At least the todo must have the 'id' field.");
		}
		if (todo.hasTitle()) buff.append(";title=").append(tEnc.encode(todo.getTitle())); 
		if (todo.hasTag()) buff.append(";tag=").append(tEnc.encode(todo.getTag()));
		if (todo.hasFolder()) buff.append(";folder=").append(todo.getFolder());
		if (todo.hasContext()) buff.append(";context=").append(todo.getContext());
		if (todo.hasGoal()) buff.append(";goal=").append(todo.getGoal());
		if (todo.hasParent()) buff.append(";parent=").append(todo.getParent());
		if (todo.hasCompleted()) {
			buff.append(";completed=").append(todo.getCompleted() == null ? "0" : "1");
			if(todo.getCompleted() != null) {
				buff.append(";completedon=").append(todo.getCompleted());
			}
		}
		if (todo.hasStartDate()) buff.append(";startdate=").append(tEnc.encode(todo.getStartDate().toString()));
		if (todo.hasStartTime()) buff.append(";starttime=").append(tEnc.encode(todo.getStartTime().toString()));
		if (todo.hasDueDate()) buff.append(";duedate=").append(tEnc.encode(todo.getDueDate().toString()));
		if (todo.hasDueTime()) buff.append(";duetime=").append(tEnc.encode(todo.getDueTime().toString()));
		if (todo.hasReminder()) buff.append(";reminder=").append(todo.getReminder());
		if (todo.hasRepeat()) buff.append(";repeat=").append(todo.getRepeat());
		if (todo.hasRepAdvanced()) buff.append(";rep_advanced=").append(tEnc.encode(todo.getRepAdvanced()));
		if (todo.hasStatus()) buff.append(";status=").append(todo.getStatus());
		if (todo.hasLength()) buff.append(";length=").append(todo.getLength());
		if (todo.hasPriority()) buff.append(";priority=").append(todo.getPriority());
		if (todo.hasStar()) buff.append(";star=").append(todo.isStar() ? "1" : "0");
		if (todo.hasNote()) buff.append(";note=").append(tEnc.encode(todo.getNote()));
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		if (this.xmlResponse == null) 
			return null;
		ModifyTodoResponse mresp = new ModifyTodoResponse(this.xmlResponse);
		return mresp;
	}

}
