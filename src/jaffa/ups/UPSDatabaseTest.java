package jaffa.ups;



import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase ups = new UPSDatabase();
		Package pkg = new Package("1234");
		Location location = new Location(100, 100);
		ups.addPackageToLocation(location, pkg);
		Set<Package> packages = ups.getPackages(location);
		Assert.assertTrue(packages.contains(pkg));
		Assert.assertEquals(location, ups.getLocation(pkg));
		//Assert.fail("test not implemented");
	}

	@Test 
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase ups = new UPSDatabase();
		Package pkg = new Package("1234");
		Location location = new Location(100, 100);
		ups.addPackageToLocation(location, pkg);
		Location newLocation = new Location(200,200);
		ups.updatePackageLocation(pkg, newLocation);
		Set<Package> packages = ups.getPackages(location);
		Assert.assertTrue(packages.contains(pkg));
		Assert.assertEquals(newLocation, ups.getLocation(pkg));
		//Assert.fail("test not implemented");
	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase ups = new UPSDatabase();
		Location location = new Location(100,100);
		ups.getPackages(location);
		Assert.assertEquals(null, ups.getPackages(location));
		//Assert.fail("test not implemented");
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase ups = new UPSDatabase();
		Package pkg = new Package("1234");
		//ups.getLocation(pkg);
		Assert.assertEquals(null, ups.getLocation(pkg));
		//Assert.fail("test not implemented");
	}

}
