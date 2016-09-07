package pt.reditus.pocsiops.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestBase {
	
	private String pUser;
	
	public RequestBase(){
		// Empty Constructor
	}
	
	public RequestBase(String pUser){
		this.pUser=pUser;
	}
	
	public String getUser(){
		return this.pUser;
	}
	
	public void setUser(String pUser){
		this.pUser=pUser;
	}

}
