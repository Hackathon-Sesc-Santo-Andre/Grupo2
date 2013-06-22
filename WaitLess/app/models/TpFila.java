package models;

import javax.persistence.Entity;

import play.db.ebean.Model;
@Entity
public class TpFila  extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Integer tpFila;
	public String dsFila;
	
	
	public static Finder<Integer,TpFila> find = new Finder<Integer,TpFila>(
		    Integer.class, TpFila.class
		  ); 
}
