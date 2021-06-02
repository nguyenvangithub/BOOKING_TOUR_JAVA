package test;

import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Anc {

	public static void main(String args[]) {

		JFrame jFrame = new JFrame("Move this Window");

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AncestorListener ancListener = new AncestorListener() {

			@Override

			public void ancestorAdded(AncestorEvent ancestorEvent) {
				System.out.println("No");
			}

			@Override

			public void ancestorMoved(AncestorEvent ancestorEvent) {

				System.out.println("Window Moved");

			}

			@Override

			public void ancestorRemoved(AncestorEvent ancestorEvent) {
				System.out.println("Hello");
			}

		};

		jFrame.getRootPane().addAncestorListener(ancListener);

		jFrame.getRootPane().setVisible(false);

		jFrame.getRootPane().setVisible(true);

		jFrame.setSize(300, 100);

		jFrame.setVisible(true);
	}
}