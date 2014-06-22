package com.trupt.itrainz.operation;

public class PnrStatusOperation extends Operation {

	private String pnrNumber;
	
	public PnrStatusOperation() {
	}
	
	public PnrStatusOperation(String pnrNumber) {
		this.pnrNumber = pnrNumber;
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
	
	private void startRequest() {
		//create request object
		//
	}

}
