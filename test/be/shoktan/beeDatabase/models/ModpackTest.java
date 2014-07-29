package be.shoktan.beeDatabase.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeGlobal;
import static play.test.Helpers.inMemoryDatabase;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import play.libs.Yaml;
import play.test.FakeApplication;
import play.test.WithApplication;

import com.avaje.ebean.Ebean;

public class ModpackTest extends WithApplication {
	/* (non-Javadoc)
	 * @see play.test.WithApplication#provideFakeApplication()
	 */
	@Override
	protected FakeApplication provideFakeApplication() {
		return fakeApplication(inMemoryDatabase(), fakeGlobal());
	}

	@Before
	public void setUp(){
		Ebean.save((Collection<?>) Yaml.load("test-data.yml"));
	}

	@Test
	public void count() {
		assertEquals(1, Modpack.find.findRowCount());
	}

	@Test
	public void testRetrieve(){
		Modpack result = Modpack.find.where().eq("name", "monster").eq("version", "1.1.1").findUnique();
		assertNotNull(result);
		assertEquals("monster", StringUtils.lowerCase(result.getName()));
		assertEquals("1.1.1", StringUtils.lowerCase(result.getVersion()));
	}
	
	@Test
	public void testRetrieveWrongVersion(){		
		assertNull(Modpack.find.where().eq("name", "monster").eq("version", "1.1.2").findUnique());
	}
	
	@Test
	public void testRetrieveNullSafe(){		
		assertNull(Modpack.find.where().eq("name", "monster").eq("version", null).findUnique());
		assertNull(Modpack.find.where().eq("name", null).eq("version", "1.1.2").findUnique());
	}
}
