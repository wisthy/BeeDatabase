package be.shoktan.beeDatabase.models;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeGlobal;
import static play.test.Helpers.inMemoryDatabase;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;

import org.junit.Before;

import play.test.FakeApplication;
import play.test.WithApplication;

public class ModPackHibernateTest extends WithApplication{
//	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see play.test.WithApplication#provideFakeApplication()
	 */
	@Override
	protected FakeApplication provideFakeApplication() {
		return fakeApplication(inMemoryDatabase(), fakeGlobal());
	}

	@Before
	public void setUp(){
		// A SessionFactory is set up once for an application
//	    sessionFactory = new Configuration()
//	            .configure() // configures settings from hibernate.cfg.xml
//	            .buildSessionFactory();
	}
}