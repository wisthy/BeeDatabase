package be.shoktan.beeDatabase.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeGlobal;
import static play.test.Helpers.inMemoryDatabase;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import play.libs.Yaml;
import play.test.WithApplication;

import com.avaje.ebean.Ebean;

public class ModpackTest extends WithApplication {
		@Before
		public void setUp(){
	    	start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
	    	Ebean.save((Collection<?>) Yaml.load("test-data.yml"));
	    }
		
		@Test
		public void test() {
			// Count things
	        assertEquals(1, Modpack.find.findRowCount());
	        //assertEquals(1, Employee.find.findRowCount());
		}
		
		@Test
		public void testRetrieve(){
			Modpack result = Modpack.find.where().eq("name", "monster").eq("version", "1.1.1").findUnique();
			assertNotNull(result);
			assertEquals("monster", StringUtils.lowerCase(result.getName()));
			assertEquals("1.1.1", StringUtils.lowerCase(result.getVersion()));
			
		}
}
