package in.cloudnine.webservices.client;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;



/**
 * Created by sagar on 30/12/15.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({  @JsonSubTypes.Type(value = WebServiceResponseImpl.class, name = "webserviceResponseImpl"),
     @JsonSubTypes.Type(value = WebServiceResponseArrayImpl.class, name = "webserviceResponseArrayImpl")
})
public abstract class WebServiceResponse {
    public abstract Serializable getData();
    public abstract int getResponseCode();
    public abstract String getResponseMessage();
}
