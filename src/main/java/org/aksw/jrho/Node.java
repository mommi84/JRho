package org.aksw.jrho;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tommaso Soru {@literal tsoru@informatik.uni-leipzig.de}
 *
 */
public class Node {
	
	private Set<JRhoObject> components;
	private JRho jrho;
	private JRhoObject last;
	
	public Set<JRhoObject> getComponents() {
		return components;
	}

	public Node(Set<JRhoObject> components, JRho jrho, JRhoObject last) {
		super();
		this.components = new HashSet<>(components);
		this.jrho = jrho;
		this.last = last;
		
		if(last != null)
			this.components.add(last);
	}
	
	@Override
	public String toString() {
		return components.toString();
	}

	public int size() {
		return components.size();
	}

	public JRho getJrho() {
		return jrho;
	}

	public JRhoObject getLast() {
		return last;
	}

	
}
