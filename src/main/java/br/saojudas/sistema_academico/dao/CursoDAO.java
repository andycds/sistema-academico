/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.saojudas.sistema_academico.dao;

/**
 *
 * @author Trabalho
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.saojudas.sistema_academico.bd.ConexaoBD;
import br.saojudas.sistema_academico.model.Curso;

public class CursoDAO {
	public Curso[] obterCursos() throws Exception {
		String sql = "SELECT * FROM tb_curso";
		try (Connection conn = ConexaoBD.obterConexao();
				PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = ps.executeQuery()) {
			int totalDeCursos = rs.last() ? rs.getRow() : 0;
			Curso[] cursos = new Curso[totalDeCursos];
			rs.beforeFirst();
			int contador = 0;
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				cursos[contador++] = new Curso(id, nome, tipo);
			}
			return cursos;
		}
	}

	public void remover(int id) throws Exception {
		String sql = "delete from tb_curso where id = ?";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
		}
	}

	public void atualizar(Curso curso) throws Exception {
		String sql = "update tb_curso set nome = ?, tipo = ? where id = ?";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getTipo());
			ps.setInt(3, curso.getId());
			ps.execute();
		}
	}

	public void criar(Curso curso) throws Exception {
		String sql = "insert into tb_curso (nome, tipo) values (?, ?)";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getTipo());
			ps.execute();
		}
	}
}