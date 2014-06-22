package com.trupt.itrainz.async;

import java.net.URL;
import java.util.LinkedHashMap;

import com.trupt.itrainz.model.Request;
import com.trupt.itrainz.model.Result;

public class HttpRequestAsyncTask<IN extends Request, OUT extends Result> extends TrAsyncTask<IN, OUT> {

	protected URL url;
	protected LinkedHashMap<String, String> mapParameters;
	protected LinkedHashMap<String, String> mapCookie;
	
	public HttpRequestAsyncTask(URL url,
			LinkedHashMap<String, String> mapParameters,
			LinkedHashMap<String, String> mapCookie) {
		super();
		this.url = url;
		this.mapParameters = mapParameters;
		this.mapCookie = mapCookie;
	}

	@Override
	protected OUT doInBackground(IN... params) {
		// TODO Auto-generated method stub
		return super.doInBackground(params);
	}
}
