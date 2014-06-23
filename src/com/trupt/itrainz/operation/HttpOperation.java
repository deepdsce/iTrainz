package com.trupt.itrainz.operation;

import com.trupt.itrainz.async.HttpRequestAsyncTask;
import com.trupt.itrainz.common.Error;
import com.trupt.itrainz.model.request.Request;
import com.trupt.itrainz.model.result.Result;

public class HttpOperation extends Operation {
	
	public HttpOperation(Request request, OperationStatusListener opStatusListener) {
		super(request, opStatusListener);
	}
	
	@Override
	public void startOperation() {
		startRequest();
	}

	@Override
	public void stopOperation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void cancelOperation() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onSuccess(Result result) {
		if(operationStatusListener != null) {
			operationStatusListener.onSuccess(result);
		}
	}
	
	@Override
	public void onFailure(Error error) {
		if(operationStatusListener != null) {
			operationStatusListener.onFailure(error);
		}
	}
	
	private void startRequest() {
		HttpRequestAsyncTask<Request, Result> httpRequestAsyncTask = new HttpRequestAsyncTask<Request, Result>();
		httpRequestAsyncTask.execute(this.request);
	}

}
