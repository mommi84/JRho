package org.aksw.jrho;


/**
 * @author Tommaso Soru {@literal tsoru@informatik.uni-leipzig.de}
 *
 */
public class JRhoObject implements Comparable<JRhoObject> {
	
	private Object reference;
	
	public Object getReference() {
		return reference;
	}

	public void setReference(Object reference) {
		this.reference = reference;
	}

	public JRhoObject(Object reference) {
		super();
		this.reference = reference;
	}

	public Integer getID() {
		return reference.hashCode();
	}

	@Override
	public int compareTo(JRhoObject o) {
		return this.getID().compareTo(o.getID());
	}
	
	@Override
	public String toString() {
		return reference.toString();
	}
	
}
