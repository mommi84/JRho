package org.aksw.jrho;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author Tommaso Soru {@literal tsoru@informatik.uni-leipzig.de}
 *
 */
public class SimpleJRhoTest {

	@Test
	public void test() {

		// node components
		Set<JRhoObject> comp = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			// a JRhoObject is a reference to a node component
			comp.add(new JRhoObject("obj" + String.valueOf(i)));
		}

		// execute refinement
		MyJRho jrho = new MyJRho(comp);
		jrho.refine();

	}

}

class MyJRho extends JRho {

	final static Integer PRUNE = 5;

	public MyJRho(Set<JRhoObject> objects) {
		super(objects);
	}

	@Override
	protected boolean process(Node node) {

		logger.info("refining: " + node + "; size: " + node.size()
				+ "; last added: " + node.getLast());

		if (node.size() >= PRUNE) {
			logger.info("pruning: " + node.size() + " >= " + PRUNE);
			// custom pruning criteria
			return false;
		}

		// continue refinement
		return true;
	}

}