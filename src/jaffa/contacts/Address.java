package jaffa.contacts;

public class Address {

	private String street;
	private String suite;
	private String city;
	private String zipcode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Address: ");
		builder.append(" " + street);
		builder.append(" " + suite);
		builder.append(" " + city);
		builder.append(" " + zipcode);

		return builder.toString();
	}

}
