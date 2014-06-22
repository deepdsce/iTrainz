package com.trupt.itrainz.operation;

import com.trupt.itrainz.common.Error;
import com.trupt.itrainz.model.Result;

public abstract class Operation {

	protected OperationStatusListener opStatusListener;
	
	public abstract void startOperation();
	public abstract void stopOperation();
	public abstract void cancelOperation();
	
	public OperationTypeEnum getOperationEnum() {
		return OperationTypeEnum.OP;
	}
	
	public void setOpStatusListener(OperationStatusListener opStatusListener) {
		this.opStatusListener = opStatusListener;
	}
	
	
	
	public interface OperationStatusListener {
		void onSuccess(Result result);
		void onFailure(Error error);
		void onCancel();
	}
	
	protected enum OperationTypeEnum {
		OP, PNR_OP
	}
}

