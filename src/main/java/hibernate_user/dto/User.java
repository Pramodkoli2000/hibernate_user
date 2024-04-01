package hibernate_user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	@Id
	@Column(name = "user_id")
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	@Column(unique = true)
	private String email;
	private String password;
	private String facebook;
	private String instagram;
	private String snapchat;
	private String twitter;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public String getSnapchat() {
		return snapchat;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public void setSnapchat(String snapchat) {
		this.snapchat = snapchat;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

}
