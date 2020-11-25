/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.saojudas.sistema_academico.ui;

/**
 *
 * @author Trabalho
 */
public class DashboardTela extends javax.swing.JFrame {

	/**
	 * Creates new form DashboardTela
	 */
	public DashboardTela() {
		super("Cadastro de cursos e alunos");
		initComponents();
		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		gerenciarCursosButton = new javax.swing.JButton();
		gerenciarAlunosButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de cursos e alunos"));

		gerenciarCursosButton.setText("Gerenciar Cursos");
		gerenciarCursosButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gerenciarCursosButtonActionPerformed(evt);
			}
		});

		gerenciarAlunosButton.setText("Gerennciar alunos");
		gerenciarAlunosButton.addActionListener(evt -> gerenciarAlunosButtonActionPerformed(evt));
		
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(gerenciarCursosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(gerenciarAlunosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(39, 39, 39)
						.addComponent(gerenciarCursosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(45, 45, 45).addComponent(gerenciarAlunosButton, javax.swing.GroupLayout.PREFERRED_SIZE,
								62, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(56, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(40, 40, 40)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(31, 31, 31)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DashboardTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DashboardTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DashboardTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DashboardTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DashboardTela().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton gerenciarAlunosButton;
	private javax.swing.JButton gerenciarCursosButton;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

	private void gerenciarAlunosButtonActionPerformed(java.awt.event.ActionEvent evt) {
		AlunosTela alunosTela = new AlunosTela();
		alunosTela.setVisible(true);
		this.dispose();
	}

	private void gerenciarCursosButtonActionPerformed(java.awt.event.ActionEvent evt) {
		CursosTela cursosTela = new CursosTela();
		cursosTela.setVisible(true);
		this.dispose();
	}
}
