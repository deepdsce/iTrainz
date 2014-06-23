package com.trupt.itrainz.async;

import android.os.AsyncTask;

import com.trupt.itrainz.common.Error;
import com.trupt.itrainz.model.request.Request;

public abstract class TrAsyncTask<IN extends Request, Result> extends AsyncTask<IN, Void, Result> {

	protected AsyncTaskCompletionListener<Result> listener;
	
	public void setListener(AsyncTaskCompletionListener<Result> listener) {
		this.listener = listener;
	}
	
	@Override
	protected Result doInBackground(IN... params) {
		return null;
	}
	
	public interface AsyncTaskCompletionListener<Result> {
		void onSuccess(Result result);
		void onFailure(Error error);
	}
}
