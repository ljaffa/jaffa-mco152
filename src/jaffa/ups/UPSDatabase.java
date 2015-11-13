package jaffa.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	private HashMap<Package, Location> packageLocation;
	private HashMap<Location, HashSet<Package>> locationPackages;

	public UPSDatabase(){
		packageLocation = new HashMap<Package, Location>();
		locationPackages = new HashMap<Location, HashSet<Package>>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation( Location location, Package pkg ) {
		if (!locationPackages.containsKey(location)){
			HashSet<Package> packages = new HashSet<Package>();
			packages.add(pkg);
			locationPackages.put(location, packages);
			packageLocation.put(pkg, location);
		}
		else {
			HashSet<Package> packages = locationPackages.get(location);
			locationPackages.put(location, packages);
			packageLocation.put(pkg, location);
		}
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation( Package pkg, Location location ) {
		if (packageLocation.containsKey(pkg)){
			packageLocation.put(pkg, location);
		}
		HashSet<Package> packages = new HashSet<Package>();
		packages.add(pkg);
		locationPackages.put(location, packages);
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if 
	 * the Location doesn't exist or there are no Packages at that Location.
	 */
	public Set<Package> getPackages( Location location ) {
		HashSet<Package> packages = new HashSet<Package>();
		if (locationPackages.containsKey(location)){
			packages = locationPackages.get(location);
		}
		return packages;
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		if (packageLocation.containsKey(pkg)){
			return packageLocation.get(pkg);
		}
		return null;
	}


}
