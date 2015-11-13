package jaffa.ups;

public class Package {

	private final String trackingNumber;

	public Package(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}


	//when want to use Object in HashMap or HashSet - have to override both these methods.
	//two Objects are equal if both return same hashCode, and if the equals method returns true
	//set or map calls hashCode for you - don't need to call it 
	@Override
	public String toString() {
		return "Package [trackingNumber=" + trackingNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (trackingNumber == null ? 0 : trackingNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Package other = (Package) obj;
		if (trackingNumber == null) {
			if (other.trackingNumber != null) {
				return false;
			}
		} else if (!trackingNumber.equals(other.trackingNumber)) {
			return false;
		}
		return true;
	}

}
