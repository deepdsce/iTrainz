package com.trupt.itrainz.async;

import android.os.AsyncTask;

import com.trupt.itrainz.model.Request;
import com.trupt.itrainz.model.Result;

public class TrAsyncTask<IN extends Request, OUT extends Result> extends AsyncTask<IN, Void, OUT> {

	protected AsyncTaskCompletionListener<OUT> listener;
	
	public void setListener(AsyncTaskCompletionListener<OUT> listener) {
		this.listener = listener;
	}
	
	@Override
	protected OUT doInBackground(IN... params) {
		return null;
	}

	
	private interface AsyncTaskCompletionListener<OUT extends Result> {
		void onSuccess(OUT result);
		void onError();
	}
}
