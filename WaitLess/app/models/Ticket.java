package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Ticket extends Model {

	private static final long serialVersionUID = 1L;

	public static Finder<Integer, Ticket> find = new Finder<Integer, Ticket>(Integer.class, Ticket.class);
	
	@Id
	public Long numero;

}