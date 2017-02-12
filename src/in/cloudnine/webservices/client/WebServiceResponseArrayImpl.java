package in.cloudnine.webservices.client;

import java.io.Serializable;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import com.fasterxml.jackson.annotation.JsonTypeInfo;



@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "@class")
public class WebServiceResponseArrayImpl extends WebServiceResponse implements Serializable {
	
	

	private void setSystemTime() {
		Calendar cal = GregorianCalendar.getInstance();
		systemTime = cal.getTimeInMillis();

	}

	public WebServiceResponseArrayImpl() {
		super();
		responseCode = ResponseCodes.RESPONSE_STATUS_OK;
		responseMessage = ResponseCodes.RESPONSE_MSG_OK;
		setSystemTime();
	}

	public WebServiceResponseArrayImpl(Serializable[] data) {
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

	@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_ARRAY, property = "@class")
	
		private Serializable[] data;
        
        @Override
        public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

        @Override
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
        public Serializable getData() {
		return data;
	}


	public void setData(Serializable[] data) {
		System.out.println(data.getClass().getName());
		this.data = (Serializable[])data;

	}
	

	public WebServiceResponseArrayImpl(int responseCode, String responseMessage, Serializable[] data) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		setData(data);
	}
	

	public WebServiceResponseArrayImpl(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

}
