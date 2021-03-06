package org.loststone.toodledo.request;

import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TextEncoder;

public class AddTodoRequest extends Request {

	private TextEncoder tEnc = new TextEncoder();
	
	public AddTodoRequest(AuthToken token, Todo todo) throws ToodledoApiException {
		super();
		this.url = "http://api.toodledo.com/api.php?method=addTask;key="+token.getKey();
		// ensure changes are also made to ModifyTodoRequest
		StringBuilder buff = new StringBuilder();
		if (todo.hasTitle()) { buff.append(";title=").append(tEnc.encode(todo.getTitle())); 
		} else { 
			throw new ToodledoApiException("Todo object at least must have a title!");
		}
		if (todo.hasTag()) buff.append(";tag=").append(tEnc.encode(todo.getTag()));
		if (todo.hasFolder()) buff.append(";folder=").append(todo.getFolder());
		if (todo.hasContext()) buff.append(";context=").append(todo.getContext());
		if (todo.hasGoal()) buff.append(";goal=").append(todo.getGoal());
		if (todo.hasParent()) buff.append(";parent=").append(todo.getParent());
		if (todo.hasStartDate()) buff.append(";startdate=").append(todo.getStartDate());
		if (todo.hasStartTime()) buff.append(";starttime=").append(tEnc.encode(todo.getStartTime().toString()));
		if (todo.hasDueDate()) buff.append(";duedate=").append(todo.getDueDate());
		if (todo.hasDueTime()) buff.append(";duetime=").append(tEnc.encode(todo.getDueTime().toString()));
		if (todo.hasReminder()) buff.append(";reminder=").append(todo.getReminder());
		if (todo.hasRepeat() && todo.getRepeat() != null) {
			buff.append(";repeat=").append(todo.getRepeat().getRepeatAsInteger());
		}
		if (todo.hasRepAdvanced()) buff.append(";rep_advanced=").append(tEnc.encode(todo.getRepAdvanced()));
		if (todo.hasStatus() && todo.getStatus() != null) {
			buff.append(";status=").append(todo.getStatus().getStatusAsInteger());
		}
		if (todo.hasLength()) buff.append(";length=").append(todo.getLength());
		if (todo.hasPriority() && todo.getPriority() != null) {
			buff.append(";priority=").append(todo.getPriority().getPriorityAsInt());
		}
		if (todo.hasStar()) buff.append(";star=").append(todo.isStar() ? "1" : "0");
		if (todo.hasNote()) buff.append(";note=").append(tEnc.encode(todo.getNote()));
		this.url = this.url.concat(buff.toString());
	}

	@Override
	public Response getResponse() {
		this.exec();
		AddTodoResponse response = new AddTodoResponse(this.xmlResponse);
		return response;
	}
	
}
