
package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class})
public class AllTests {

    // Geen constructor nodig of iets, gewoon runnen en dan runt die alles achter @SuiteClasses

}