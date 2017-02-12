package in.cloudnine.webservices.client;

import java.io.Serializable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class WebServiceResponseImpl extends WebServiceResponse implements Serializable {
	/*
	@JsonIgnore
	public boolean isArray() {
		return (dataArray !=null);
	}
*/
	public static final int RESPONSE_STATUS_STATE_NOT_FOUND = 97000;

	private void setSystemTime() {
		Calendar cal = GregorianCalendar.getInstance();
		systemTime = cal.getTimeInMillis();

	}

	public WebServiceResponseImpl() {
		super();
		responseCode = ResponseCodes.RESPONSE_STATUS_OK;
		responseMessage = ResponseCodes.RESPONSE_MSG_OK;
		setSystemTime();
	}

	public WebServiceResponseImpl(Serializable data) {
		super();
		responseCode = ResponseCodes.RESPONSE_STATUS_OK;
		responseMessage = ResponseCodes.RESPONSE_MSG_OK;
		setData(data);
		setSystemTime();
	}
	

	public long getSystemTime() {
		return systemTime;
	}

	private int responseCode;
	private String responseMessage;
	private long systemTime;

	@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@class")
	private Serializable data;

	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
public Serializable getData() {
	return data;
	}


	public void setData(Serializable data) {

		this.data = data;

	}
	

	public WebServiceResponseImpl(int responseCode, String responseMessage, Serializable data) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		setData(data);
	}
	

	public WebServiceResponseImpl(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

}
