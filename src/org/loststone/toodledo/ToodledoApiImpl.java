package org.loststone.toodledo;

import java.util.List;
import java.util.Map;

import org.loststone.toodledo.data.AccountInfo;
import org.loststone.toodledo.data.Context;
import org.loststone.toodledo.data.Folder;
import org.loststone.toodledo.data.Goal;
import org.loststone.toodledo.data.Todo;
import org.loststone.toodledo.data.TodoFilter;
import org.loststone.toodledo.exception.IncorrectUserPasswordException;
import org.loststone.toodledo.exception.MissingPasswordException;
import org.loststone.toodledo.exception.ToodledoApiException;
import org.loststone.toodledo.request.AddContextRequest;
import org.loststone.toodledo.request.AddFolderRequest;
import org.loststone.toodledo.request.AddGoalRequest;
import org.loststone.toodledo.request.AddTodoRequest;
import org.loststone.toodledo.request.AuthorizeRequest;
import org.loststone.toodledo.request.DeleteFolderRequest;
import org.loststone.toodledo.request.DeleteTodoRequest;
import org.loststone.toodledo.request.EditFolderRequest;
import org.loststone.toodledo.request.GetAccountInfoRequest;
import org.loststone.toodledo.request.GetContextsRequest;
import org.loststone.toodledo.request.GetDeletedRequest;
import org.loststone.toodledo.request.GetFoldersRequest;
import org.loststone.toodledo.request.GetGoalsRequest;
import org.loststone.toodledo.request.GetTodosRequest;
import org.loststone.toodledo.request.GetUserIdRequest;
import org.loststone.toodledo.request.ModifyTodoRequest;
import org.loststone.toodledo.request.Request;
import org.loststone.toodledo.response.AddContextResponse;
import org.loststone.toodledo.response.AddFolderResponse;
import org.loststone.toodledo.response.AddGoalResponse;
import org.loststone.toodledo.response.AddTodoResponse;
import org.loststone.toodledo.response.AuthorizeResponse;
import org.loststone.toodledo.response.GenericDeleteResponse;
import org.loststone.toodledo.response.GetAccountInfoResponse;
import org.loststone.toodledo.response.GetContextsResponse;
import org.loststone.toodledo.response.GetDeletedResponse;
import org.loststone.toodledo.response.GetFoldersResponse;
import org.loststone.toodledo.response.GetGoalsResponse;
import org.loststone.toodledo.response.GetTodosResponse;
import org.loststone.toodledo.response.GetUserIdResponse;
import org.loststone.toodledo.response.ModifyTodoResponse;
import org.loststone.toodledo.response.Response;
import org.loststone.toodledo.util.AuthToken;
import org.loststone.toodledo.util.TdDateTime;

public class ToodledoApiImpl implements ToodledoApi {
	int requestCount = 0;
	
	public int getRequestCount() {
		return requestCount;
	}

	public void resetRequestCount() {
		this.requestCount = 0;
	}

	public int addTodo(AuthToken auth, Todo todo) throws ToodledoApiException {
		AddTodoRequest request = new AddTodoRequest(auth, todo);
		AddTodoResponse resp = (AddTodoResponse) request.getResponse();
		requestCount++;
		if (resp.succeeded())
			return Integer.parseInt(resp.getResponseContent());
		else
			return -1;
	}

	public Todo getTodo(AuthToken auth, int id) throws ToodledoApiException {
		TodoFilter filter = new TodoFilter();
		filter.setId(id);
		List<Todo> res = getTodosList(auth,filter);
		requestCount++;
		if (res != null && res.size() > 0) {
			return res.get(0);
		} else {
			return null;
		}
	}

	public List<Todo> getTodosList(AuthToken auth) throws ToodledoApiException {
		return getTodosList(auth,null);
	}
	
	public List<Todo> getTodosList(AuthToken auth, TodoFilter filter) throws ToodledoApiException {
		Request getTodosRequest = new GetTodosRequest(auth, filter);
		GetTodosResponse response = (GetTodosResponse)getTodosRequest.getResponse();
		requestCount++;
		if (response.succeeded())
			return response.getTodos();
		else
			return null;
	}

	public Map<Integer,TdDateTime> getDeletedTodosList(AuthToken auth, TdDateTime after) throws ToodledoApiException {
		Request getTodosRequest = new GetDeletedRequest(auth, after);
		GetDeletedResponse response = (GetDeletedResponse)getTodosRequest.getResponse();
		requestCount++;
		if (response.succeeded())
			return response.getDeletedIds();
		else
			return null;
	}

	public AuthToken initialize(String username, String password) throws ToodledoApiException {
		Request initReq = new AuthorizeRequest(username);
		// response gives back the token, now create the AuthToken
		AuthorizeResponse resp = (AuthorizeResponse) initReq.getResponse();
		AuthToken token = new AuthToken(password, username, resp.getResponseContent());
		return token;
	}

	public boolean modifyTodo(AuthToken auth, Todo newOne)  throws ToodledoApiException{
		ModifyTodoRequest modifyRequest = new ModifyTodoRequest(auth,newOne);
		ModifyTodoResponse resp = (ModifyTodoResponse)modifyRequest.getResponse();
		requestCount++;
		if (resp.succeeded()) {
			Integer _t = Integer.parseInt(resp.getResponseContent());
			if (_t == 1) return true;
			else return false;
		} else
			return false;
	}

	public boolean deleteTodo(AuthToken auth, int id)  throws ToodledoApiException{
		DeleteTodoRequest request = new DeleteTodoRequest(auth, id);
		GenericDeleteResponse resp = (GenericDeleteResponse)request.getResponse();
		requestCount++;
		if (resp.succeeded()) {
			Integer _t = Integer.parseInt(resp.getResponseContent());
			if (_t == 1) return true;
			else return false;
		} else
			return false;
	}

	
	public List<Context> getContexts(AuthToken auth)  throws ToodledoApiException{
		GetContextsRequest request = new GetContextsRequest(auth);
		GetContextsResponse resp = (GetContextsResponse)request.getResponse();
		if (resp.succeeded())
			return resp.getContexts();
		else
			return null;
	}

	public List<Folder> getFolders(AuthToken auth)  throws ToodledoApiException{
		GetFoldersRequest request = new GetFoldersRequest(auth);
		GetFoldersResponse resp = (GetFoldersResponse)request.getResponse();
		requestCount++;
		if (resp.succeeded())
			return resp.getFolders();
		else
			return null;
	}

	public List<Goal> getGoals(AuthToken auth)  throws ToodledoApiException{
		GetGoalsRequest request = new GetGoalsRequest(auth);
		GetGoalsResponse resp = (GetGoalsResponse)request.getResponse();
		requestCount++;
		if (resp.succeeded())
			return resp.getGoals();
		else
			return null;
	}

	public int addFolder(AuthToken auth, Folder fold)
			throws ToodledoApiException {
		AddFolderRequest request = new AddFolderRequest(auth,fold);
		AddFolderResponse response = (AddFolderResponse)request.getResponse();
		requestCount++;
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

	public int addContext(AuthToken auth, Context context)
			throws ToodledoApiException {
		AddContextRequest request = new AddContextRequest(auth, context);
		AddContextResponse response = (AddContextResponse)request.getResponse();
		requestCount++;
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

	public int addGoal(AuthToken auth, Goal goal) throws ToodledoApiException {
		AddGoalRequest request = new AddGoalRequest(auth, goal);
		AddGoalResponse response = (AddGoalResponse)request.getResponse();
		requestCount++;
		if (response.succeeded())
			return Integer.parseInt(response.getResponseContent());
		else
			return -1;
	}

	public String getUserId(String mail, String password)
			throws ToodledoApiException, IncorrectUserPasswordException, MissingPasswordException {
		GetUserIdRequest request = new GetUserIdRequest(mail,password);
		GetUserIdResponse response = (GetUserIdResponse)request.getResponse();
		if(response.succeeded()) 
			return response.getUserId();
		else
			return null;
	}

	public boolean deleteFolder(AuthToken auth, int folderId)
			throws ToodledoApiException {
		DeleteFolderRequest request = new DeleteFolderRequest(auth, folderId);
		GenericDeleteResponse resp = (GenericDeleteResponse)request.getResponse();
		requestCount++;
		if (resp.succeeded()) {
			Integer _t = Integer.parseInt(resp.getResponseContent());
			if (_t == 1) return true;
			else return false;
		} else
			return false;		
	}

	public AccountInfo getAccountInfo(AuthToken auth) throws ToodledoApiException {
		GetAccountInfoRequest request = new GetAccountInfoRequest(auth);
		GetAccountInfoResponse resp = (GetAccountInfoResponse) request.getResponse();
		requestCount++;
		if (resp.succeeded())
			return resp.getAccountInfo();
		else
			return null;
	}

	public boolean editFolder(AuthToken authtoken, Folder folder) throws ToodledoApiException {
		EditFolderRequest request = new EditFolderRequest(authtoken, folder);
		Response resp = request.getResponse();
		requestCount++;
		return resp.succeeded();
	}

}
