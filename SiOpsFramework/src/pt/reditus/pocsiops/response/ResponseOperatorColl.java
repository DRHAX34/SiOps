package pt.reditus.pocsiops.response;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import pt.reditus.pocsiops.core.Operators;

@XmlRootElement
public class ResponseOperatorColl extends ResponseBase {

	private Collection<Operators> pOperators;
	
	public ResponseOperatorColl() {
		super();
	}

	public ResponseOperatorColl(String MSG_TYPE) {
		super(MSG_TYPE);
	}
	
	public ResponseOperatorColl(String MSG_TYPE, String Message) {
		super(MSG_TYPE, Message);
	}
	
	public ResponseOperatorColl(String MSG_TYPE, String Message, Collection<Operators> pOperators) {
		super(MSG_TYPE, Message);
		this.pOperators=pOperators;
	}

	public Collection<Operators> getOperators() {
		return this.pOperators;
	}

	public void setOperators(Collection<Operators> pOperators) {
		this.pOperators = pOperators;
	}
	
	
}
