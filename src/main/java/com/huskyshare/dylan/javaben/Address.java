package main.java.com.huskyshare.dylan.javaben;

public class Address {
	private String mailAddress;
	private String mailAddress2;
	private String fromAddress;
	private int zip;
	/**
	 * @return the mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	/**
	 * @return the mailAddress2
	 */
	public String getMailAddress2() {
		return mailAddress2;
	}
	/**
	 * @param mailAddress2 the mailAddress2 to set
	 */
	public void setMailAddress2(String mailAddress2) {
		this.mailAddress2 = mailAddress2;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @return the fromAddress
	 */
	public String getFromAddress() {
		return fromAddress;
	}
	/**
	 * @param fromAddress the fromAddress to set
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
}
