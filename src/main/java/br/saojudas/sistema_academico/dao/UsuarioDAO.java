package br.saojudas.sistema_academico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.saojudas.sistema_academico.bd.ConexaoBD;
import br.saojudas.sistema_academico.model.Usuario;

public class UsuarioDAO {
	public boolean existe(Usuario usuario) throws Exception {
		String sql = "SELECT * FROM tb_usuario WHERE nome= ? AND senha = ?";
		try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		}
	}
}
