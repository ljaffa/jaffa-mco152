package jaffa.contacts;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInfo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		ContactInfo info = new ContactInfo();
		info.setVisible(true);
	}

	private String name;
	private String email;
	private Address address;
	private String phone;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;

	public ContactInfo(){

	}

	public ContactInfo(String name, String email, Address address, String phone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;

		setTitle("Contact Info");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		nameLabel = new JLabel();
		emailLabel = new JLabel();
		addressLabel = new JLabel();
		phoneLabel = new JLabel();

		container.add(nameLabel);
		container.add(emailLabel);
		container.add(addressLabel);
		container.add(phoneLabel);

		this.nameLabel.setText(name);
		this.emailLabel.setText(email);
		this.addressLabel.setText(address.toString());
		this.phoneLabel.setText(phone);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
