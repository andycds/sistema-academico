/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.saojudas.sistema_academico.bd;

/**
 *
 * @author Trabalho
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
	private static String host = "localhost";
	private static String porta = "3306";
	private static String db = "sistema_escolar";
	private static String usuario = "alunos";
	private static String senha = "alunos";

	public static Connection obterConexao() throws Exception {
		String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo", host,
				porta, db);
		return DriverManager.getConnection(url, usuario, senha);
	}

}
