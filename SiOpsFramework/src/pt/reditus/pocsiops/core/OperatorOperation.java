package pt.reditus.pocsiops.core;
// Generated Sep 7, 2016 11:27:49 AM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OperatorOperation generated by hbm2java
 */
@Entity
@Table(name = "OPERATOR_OPERATION")
public class OperatorOperation implements java.io.Serializable {

	private int idOperatorOperation;
	private Operations operations;
	private Operators operators;
	private States states;

	public OperatorOperation() {
	}

	public OperatorOperation(int idOperatorOperation, Operations operations, Operators operators, States states) {
		this.idOperatorOperation = idOperatorOperation;
		this.operations = operations;
		this.operators = operators;
		this.states = states;
	}

	@Id

	@Column(name = "ID_OPERATOR_OPERATION", unique = true, nullable = false)
	public int getIdOperatorOperation() {
		return this.idOperatorOperation;
	}

	public void setIdOperatorOperation(int idOperatorOperation) {
		this.idOperatorOperation = idOperatorOperation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OPERATION", nullable = false)
	public Operations getOperations() {
		return this.operations;
	}

	public void setOperations(Operations operations) {
		this.operations = operations;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OPERATOR", nullable = false)
	public Operators getOperators() {
		return this.operators;
	}

	public void setOperators(Operators operators) {
		this.operators = operators;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_STATE", nullable = false)
	public States getStates() {
		return this.states;
	}

	public void setStates(States states) {
		this.states = states;
	}

}
