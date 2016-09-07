package pt.reditus.pocsiops.core;
// Generated Sep 7, 2016 11:27:49 AM by Hibernate Tools 4.3.1.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Operators generated by hbm2java
 */
@Entity
@Table(name = "OPERATORS")
public class Operators implements java.io.Serializable {

	private int idOperator;
	private Serializable name;
	private Serializable photoPath;
	private Serializable location;
	private Set<OperatorOperation> operatorOperations = new HashSet<OperatorOperation>(0);

	public Operators() {
	}

	public Operators(int idOperator, Serializable name, Serializable location) {
		this.idOperator = idOperator;
		this.name = name;
		this.location = location;
	}

	public Operators(int idOperator, Serializable name, Serializable photoPath, Serializable location,
			Set<OperatorOperation> operatorOperations) {
		this.idOperator = idOperator;
		this.name = name;
		this.photoPath = photoPath;
		this.location = location;
		this.operatorOperations = operatorOperations;
	}

	@Id

	@Column(name = "ID_OPERATOR", unique = true, nullable = false)
	public int getIdOperator() {
		return this.idOperator;
	}

	public void setIdOperator(int idOperator) {
		this.idOperator = idOperator;
	}

	@Column(name = "NAME", nullable = false)
	public Serializable getName() {
		return this.name;
	}

	public void setName(Serializable name) {
		this.name = name;
	}

	@Column(name = "PHOTO_PATH")
	public Serializable getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(Serializable photoPath) {
		this.photoPath = photoPath;
	}

	@Column(name = "LOCATION", nullable = false)
	public Serializable getLocation() {
		return this.location;
	}

	public void setLocation(Serializable location) {
		this.location = location;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operators")
	public Set<OperatorOperation> getOperatorOperations() {
		return this.operatorOperations;
	}

	public void setOperatorOperations(Set<OperatorOperation> operatorOperations) {
		this.operatorOperations = operatorOperations;
	}

}