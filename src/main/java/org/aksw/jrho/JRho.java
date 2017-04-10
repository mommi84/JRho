package org.aksw.jrho;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tommaso Soru {@literal tsoru@informatik.uni-leipzig.de}
 *
 */
public abstract class JRho {
	
	protected Set<JRhoObject> objects;
	
	protected Node root;
	
	public JRho(Set<JRhoObject> objects) {
		super();
		this.objects = objects;
		
		// empty set for root
		this.root = new Node(new HashSet<JRhoObject>(), this, null);
	}
	
	public void refine() {
		refine(root);
	}
	
	public void refine(Node node) {
		// process node
		boolean result = process(node);
		
		// prune refinement
		if(!result)
			return;
		
		// continue refinement
		objects.parallelStream().forEach(o -> {
			
			// if not root
			if(node.getLast() != null)
				// references are sorted
				if(o.compareTo(node.getLast()) <= 0)
					return;
			
			Node refNode = new Node(node.getComponents(), this, o);
			refine(refNode);
			
		});
	}

	protected abstract boolean process(Node node);
}
