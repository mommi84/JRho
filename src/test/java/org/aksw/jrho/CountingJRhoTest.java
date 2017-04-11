package org.aksw.jrho;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.aksw.jrho.JRho;
import org.aksw.jrho.JRhoObject;
import org.aksw.jrho.Node;
import org.junit.Test;

/**
 * @author Tommaso Soru {@literal tsoru@informatik.uni-leipzig.de}
 *
 */
public class CountingJRhoTest {

	@Test
	public void test() {

		// node components
		Set<JRhoObject> comp = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			// a JRhoObject is a reference to a node component
			comp.add(new JRhoObject("obj" + String.valueOf(i)));
		}

		// execute refinement
		CountingJRho jrho = new CountingJRho(comp);
		jrho.refine();

		assertTrue(jrho.count == (int) Math.pow(2, comp.size()));

	}

}

class CountingJRho extends JRho {

	Integer count = 0;

	public CountingJRho(Set<JRhoObject> objects) {
		super(objects);
	}

	@Override
	protected boolean process(Node node) {

		synchronized (count) {
			count++;
		}

		logger.info("refining: " + node + "; size: " + node.size()
				+ "; last added: " + node.getLast());
		
		// continue refinement
		return true;
	}

}