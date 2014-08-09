package be.shoktan.beeDatabase.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeGlobal;
import static play.test.Helpers.inMemoryDatabase;
import play.db.jpa.JPA;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.WithApplication;

public class ModpackQuickTest extends WithApplication {
	@Test
    public void createAndRetrieve() {
		Modpack test = new Modpack("monster", "1.1.1");
		JPA.em();
		
		//Modpack result = Modpack.find.where().eq("name", "monster").eq("version", "1.1.1").findUnique();
		Modpack result = JPA.em().find(Modpack.class, 1);
		assertNotNull(result);
		assertEquals("monster", StringUtils.lowerCase(result.getName()));
		assertEquals("1.1.1", StringUtils.lowerCase(result.getVersion()));
    }

	/* (non-Javadoc)
	 * @see play.test.WithApplication#provideFakeApplication()
	 */
	@Override
	protected FakeApplication provideFakeApplication() {
		return fakeApplication(inMemoryDatabase(), fakeGlobal());
	}

}
