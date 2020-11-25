package br.saojudas.sistema_academico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.saojudas.sistema_academico.bd.ConexaoBD;
import br.saojudas.sistema_academico.model.Aluno;

public class AlunoDAO {
	public String[][] obterAlunos(boolean inserir) {
		try {
		String sql = "SELECT * FROM tb_aluno";
		try (Connection conn = ConexaoBD.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = ps.executeQuery()) {
			int totalDeAlunos = rs.last() ? rs.getRow() : 0;
			String[][] alunos = new String[(inserir ? totalDeAlunos + 1 : totalDeAlunos) ][3];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				alunos[contador++] = new String[] { ""+id, nome, sexo };
			}
			return alunos;
		}
		} catch (Exception e) {
			return null;
		}
	}
	
	public void atualizar(Aluno aluno) throws Exception {
		String sql = "update tb_aluno set nome = ?, sexo = ? where id = ?";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getSexo());
			ps.setInt(3, aluno.getId());
			ps.execute();
		}
	}
	
	public void remover(int id) throws Exception {
		String sql = "delete from tb_aluno where id = ?";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
		}
	}
	
	public void criar(Aluno aluno) throws Exception {
		String sql = "insert into tb_aluno (id, nome, sexo) values (?, ?, ?)";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, aluno.getId());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getSexo());
			ps.execute();
		}
	}
}
