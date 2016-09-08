package pt.reditus.pocsiops.request;

import javax.xml.bind.annotation.XmlRootElement;

import pt.reditus.pocsiops.core.Operators;

@XmlRootElement
public class FullSaveOperator extends RequestBase {

	private Operators pOperator;
	
	public FullSaveOperator(){
		super();
	}
	
	public FullSaveOperator(String pUser){
		super(pUser);
	}
	
	public FullSaveOperator(String pUser, Operators pOperator){
		super(pUser);
		this.pOperator = pOperator;
	}
	
	public Operators getOperator(){
		return this.pOperator;
	}
	
	public void setOperator(Operators pOperator){
		this.pOperator=pOperator;
	}
}
