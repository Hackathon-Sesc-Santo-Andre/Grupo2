package models;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long id;
	public String nome;
	public String senha;
	public Usuario() {
	}
	public Usuario(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	public static Finder<Long,Usuario> find = new Finder<Long,Usuario>(
		    Long.class, Usuario.class
		  ); 
}
