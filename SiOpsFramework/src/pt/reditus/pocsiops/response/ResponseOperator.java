package pt.reditus.pocsiops.response;

import javax.xml.bind.annotation.XmlRootElement;

import pt.reditus.pocsiops.core.Operators;

@XmlRootElement
public class ResponseOperator extends ResponseBase {

	private Operators pOperator;
	
	public ResponseOperator() {
		super();
	}

	public ResponseOperator(String MSG_TYPE) {
		super(MSG_TYPE);
	}
	
	public ResponseOperator(String MSG_TYPE, String Message) {
		super(MSG_TYPE, Message);
	}
	
	public ResponseOperator(String MSG_TYPE, String Message, Operators pOperator) {
		super(MSG_TYPE, Message);
		this.pOperator=pOperator;
	}

	public Operators getOperator() {
		return this.pOperator;
	}

	public void setOperator(Operators pOperator) {
		this.pOperator = pOperator;
	}
	
	
}
