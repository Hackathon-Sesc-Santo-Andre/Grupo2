package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;
/**
 * Classe responsável por controlar a fila
 * @author longo
 *
 */
@Entity
public class Fila extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fila(String senha) {
		super();
		this.senha = senha;
	}
	@Id
	public Integer idFila;
	@NotNull
	public Date dataCriacao;
	public Date dataAtendimento;
	@NotNull
	public TpFila tpFila;
	public Usuario usuario; 
	@NotNull
	public String senha;
	
	public static Finder<Integer,Fila> find = new Finder<Integer,Fila>(
		    Integer.class, Fila.class
		  ); 
}
