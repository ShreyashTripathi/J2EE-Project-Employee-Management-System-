package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ConnectionDetails {
    Transaction transaction;
    Session session;
    SessionFactory factory;
	
    public Transaction getTransaction() {
		return transaction;
	}
	public ConnectionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
    
    
}
