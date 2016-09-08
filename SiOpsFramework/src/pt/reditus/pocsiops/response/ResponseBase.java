package pt.reditus.pocsiops.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseBase {
	
	private String MSG_TYPE;
	private String Message;
	
	public ResponseBase(){
		// Empty Constructor
	}
	
	public ResponseBase(String MSG_TYPE){
		this.MSG_TYPE=MSG_TYPE;
	}
	
	public ResponseBase(String MSG_TYPE, String Message){
		this.MSG_TYPE=MSG_TYPE;
		this.Message=Message;
	}

	public String getMSG_TYPE() {
		return this.MSG_TYPE;
	}

	public void setMSG_TYPE(String MSG_TYPE) {
		this.MSG_TYPE = MSG_TYPE;
	}

	public String getMessage() {
		return this.Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}
	
	

}
