package be.shoktan.beeDatabase.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeGlobal;
import static play.test.Helpers.inMemoryDatabase;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.WithApplication;

public class ModpackQuickTest extends WithApplication {
	@Test
    public void createAndRetrieve() {
		new Modpack("monster", "1.1.1").save();
		
		Modpack result = Modpack.find.where().eq("name", "monster").eq("version", "1.1.1").findUnique();
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
