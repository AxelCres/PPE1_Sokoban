public class JSoko {

	public static void main(String[] args)throws Exception 
	{
		Partie partie = new Partie();
		Plateau p = new Plateau(partie);
		VuePartie vp2 = new VuePartie(p);
		VuePlateau vp = new VuePlateau(p);
		
		javax.swing.JFrame f = new javax.swing.JFrame("PPE Sokoban");
		f.getContentPane().add(vp2,java.awt.BorderLayout.SOUTH);
		f.getContentPane().add(vp,java.awt.BorderLayout.CENTER);
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(vp);
		f.pack();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((screenSize.width-f.getWidth())/2,(screenSize.height-f.getHeight())/2);
		f.setJMenuBar(new MenuSoko(p));
		f.setResizable(false);
		f.setVisible(true);
	}
}
