package com.trupt.itrainz.async;

import com.google.gson.Gson;
import com.trupt.itrainz.model.request.HttpRequest;
import com.trupt.itrainz.model.request.Request;
import com.trupt.itrainz.model.result.PnrStatus;

public class HttpRequestAsyncTask<IN extends Request, Result> extends TrAsyncTask<IN, Result> {

	protected HttpRequest request;
	
	@Override
	protected Result doInBackground(IN... params) {
		Result result = null;
		try {
			String response = this.getResponse(params[0]);
			String jsonResponse = this.getJsonResponse(response);
			Class<? extends Result> clazz = this.getResultClass();
			Gson gson = new Gson();
			result = gson.fromJson(jsonResponse, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected String getResponse(Request req) throws Exception {
		return null;
	}
	
	protected String getJsonResponse(String resp) {
		return resp;
	}
	
	protected Class getResultClass() {
		Class clazz = null;
		switch (request.getRequestType()) {
		case PNR_STATUS:
			clazz = PnrStatus.class;
			break;
		}
		return clazz;
	}
}
