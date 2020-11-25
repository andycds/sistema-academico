package br.saojudas.sistema_academico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class Aluno {
	private int id;
	private String nome;
	private String sexo;
}
