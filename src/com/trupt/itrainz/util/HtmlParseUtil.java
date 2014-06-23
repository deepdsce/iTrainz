package com.trupt.itrainz.util;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.trupt.itrainz.model.result.PnrStatus;
import com.trupt.itrainz.model.result.SeatStatus;

public class HtmlParseUtil {
	
	public static PnrStatus parsePNRData(Document document, String pnr) {
		ArrayList<ArrayList<String>> pnrJourneyDetailTableData = parsePnrInfoData(document);
		ArrayList<ArrayList<String>> pnrStatusTableData = parsePNRStatusTable(document);	
		PnrStatus pnrStatus = getPnrInfo(pnr, pnrJourneyDetailTableData, pnrStatusTableData);
		return pnrStatus;
	}
	
	private static PnrStatus getPnrInfo(String pnr, ArrayList<ArrayList<String>> pnrJourneyDetailTableData, ArrayList<ArrayList<String>> pnrStatusTableData) {
		PnrStatus pnrStatus = new PnrStatus();
		pnrStatus.setPnrNumber(pnr);
		//retrieve data from pnrJourneyDetailTableData
		ArrayList<String> data = pnrJourneyDetailTableData.get(2);
		pnrStatus.setTrainNumber(data.remove(0).replaceFirst("[\\*]", ""));
	    pnrStatus.setTrainName(data.remove(0));
	    pnrStatus.setDate(data.remove(0));
	    pnrStatus.setFromStation(data.remove(0));
	    pnrStatus.setToStation(data.remove(0));
	    pnrStatus.setReservedUptoStation(data.remove(0));
	    pnrStatus.setBoardingPointStation(data.remove(0));
	    pnrStatus.setClasss(data.remove(0));
	    
	    ArrayList<SeatStatus> listSeatStatus = new ArrayList<>();
	    //retrieve data from pnrStatusTableData
	    for(int i = 1; i < pnrStatusTableData.size(); i++) {
	    	ArrayList<String> listData = pnrStatusTableData.get(i);
	    	if(listData.get(0).contains("Charting Status")) {
	    		if(!listData.get(1).contains("NOT")) {
	    			pnrStatus.setChartPrepared(true);
	    		}
	    		break;
	    	}
	    	SeatStatus seatStatus = new SeatStatus();
	    	seatStatus.setBookingStatus(listData.get(1));
	    	seatStatus.setCurrentStatus(listData.get(2));
	    	listSeatStatus.add(seatStatus);
	    }
	    pnrStatus.setSeatStatus(listSeatStatus);
		return pnrStatus;
	}
	
	private static ArrayList<ArrayList<String>> parsePNRStatusTable(Document document) {
		Elements tableElements = document.body()
				.select("table:not(:has(table)):contains(Booking Status):contains(Current Status)");
		//System.out.println("Elements: " + tableElements);
		//TODO: check for possible number of errors
		Elements trElements = tableElements.select("TR");
	    Iterator<Element> rowIterator = trElements.iterator();
	    Iterator<Element> colIterator = null;
	    ArrayList<ArrayList<String>> tableData = null;
	    while(rowIterator.hasNext()) {
	    	if(tableData == null) {
	    		tableData = new ArrayList<>();
	    	}
	    	ArrayList<String> colData = null;
		    Element eleTR = (Element) rowIterator.next();
		    colIterator = eleTR.select("TD,TH").iterator();
		    while(colIterator.hasNext()) {
			    Element eleTD = (Element) colIterator.next();
			    if(colData == null) {
			    	colData = new ArrayList<>();
			    }
			    colData.add(eleTD.text().trim());
		    }
		    if(colData != null) {
		    	tableData.add(colData);
		    }
	    }
	    return tableData;
	}
	
	private static ArrayList<ArrayList<String>> parsePnrInfoData(Document document) {
		Elements tableElements = document
				.body()
				.select("table:not(:has(table)):contains(Train Number):contains(Train Name), table:not(:has(table)):contains(Train No):contains(Train Name)");
		//System.out.println("Elements: " + tableElements);
		//TODO: check for possible number of errors
		//select elements having error
		//select h2 value for error
		//if network error only h2 value can be considered
		Elements trElements = tableElements.select("TR");
	    Iterator<Element> rowIterator = trElements.iterator();
	    Iterator<Element> colIterator = null;
	    ArrayList<ArrayList<String>> tableData = null;
	    while(rowIterator.hasNext()) {
	    	if(tableData == null) {
	    		tableData = new ArrayList<>();
	    	}
	    	ArrayList<String> colData = null;
		    Element eleTR = (Element) rowIterator.next();
		    colIterator = eleTR.select("TD,TH").iterator();
		    while(colIterator.hasNext()) {
			    Element eleTD = (Element) colIterator.next();
			    if(colData == null) {
			    	colData = new ArrayList<>();
			    }
			    String text = eleTD.text().trim();
			    colData.add(text);
		    }
		    if(colData != null) {
		    	tableData.add(colData);
		    }
	    }
	    return tableData;
	}

}
