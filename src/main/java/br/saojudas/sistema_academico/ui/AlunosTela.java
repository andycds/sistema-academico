package br.saojudas.sistema_academico.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.saojudas.sistema_academico.dao.AlunoDAO;
import br.saojudas.sistema_academico.model.Aluno;

public class AlunosTela extends JFrame {
	JPanel painel = new JPanel();
	JTable tabelaAlunos = new JTable();
	JButton botaoInserir = new JButton("Inserir");

	public AlunosTela() {
		super("Alunos");
		initComponents();
		//		buscarAlunos();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Gerenciamento de alunos")));
		painel.setPreferredSize(new Dimension(522, 487));

		JScrollPane scroll = new JScrollPane();
		preencherTabelaAlunos();
		scroll.setViewportView(tabelaAlunos);
		painel.add(scroll);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(painel, BorderLayout.CENTER);
		JPanel areaBotoes = new JPanel();
		areaBotoes.setLayout(new GridLayout(2, 2));
		JButton botaoAtualizar = new JButton("Atualizar");
		JButton botaoApagar = new JButton("Apagar");
		JButton botaoCancelar = new JButton("Cancelar");
		areaBotoes.add(botaoAtualizar);
		areaBotoes.add(botaoApagar);
		areaBotoes.add(botaoInserir);
		areaBotoes.add(botaoCancelar);
		getContentPane().add(areaBotoes, BorderLayout.SOUTH);
		botaoAtualizar.addActionListener(evt -> atualizarAction(evt));
		botaoApagar.addActionListener(evt -> apagarAction(evt));
		botaoInserir.addActionListener(evt -> inserirAction(evt));
		botaoCancelar.addActionListener(evt -> cancelarAction(evt));
		pack();
	}

	private void preencherTabelaAlunos() {
		preencherTabelaAlunos(false);
	}
	
	private void preencherTabelaAlunos(boolean inserir) {
		tabelaAlunos.setModel(new DefaultTableModel(
				conteudoAlunos(inserir),
				nomeColunas()
				));
	}

	private void atualizarAction(ActionEvent evt) {
		Aluno aluno = obterAlunoSelecionado();
		AlunoDAO alunoDAO = new AlunoDAO();
		try {
			alunoDAO.atualizar(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Aluno obterAlunoSelecionado() {
		TableModel model = tabelaAlunos.getModel();
		int linhaSel = tabelaAlunos.getSelectedRow();
		Aluno aluno = new Aluno(
				Integer.valueOf("" + model.getValueAt(linhaSel, 0)),
				"" + model.getValueAt(linhaSel, 1),
				"" + model.getValueAt(linhaSel, 2)
				);
		return aluno;
	}

	private void apagarAction(ActionEvent evt) {
		Aluno aluno = obterAlunoSelecionado();
		AlunoDAO alunoDAO = new AlunoDAO();
		try {
			alunoDAO.remover(aluno.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		preencherTabelaAlunos();
	}

	private void inserirAction(ActionEvent evt) {
		if (botaoInserir.getText().equals("Confirmar")) {
			Aluno aluno = obterAlunoSelecionado();
			AlunoDAO alunoDAO = new AlunoDAO();
			try {
				alunoDAO.criar(aluno);
			} catch (Exception e) {
				e.printStackTrace();
			}
			botaoInserir.setText("Inserir");
		} else {
			preencherTabelaAlunos(true);
			botaoInserir.setText("Confirmar");
		}
	}
	
	private void cancelarAction(ActionEvent evt) {
		botaoInserir.setText("Inserir");
		preencherTabelaAlunos();
	}

	private String[][] conteudoAlunos(boolean inserir) {
		AlunoDAO alunoDAO = new AlunoDAO();
		return alunoDAO.obterAlunos(inserir);
	}

	private String[] nomeColunas() {
		return new String[] {
				"Id", "Nome", "Sexo"
		};
	}

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
			java.util.logging.Logger.getLogger(CursosTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CursosTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CursosTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CursosTela.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AlunosTela().setVisible(true);
			}
		});
	}

}
