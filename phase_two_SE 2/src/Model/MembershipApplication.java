package Model;

public class MembershipApplication {
    int applicationID;
    boolean verified = false;
    String name;
    String address;

    public MembershipApplication() {
		super();
	}
	public MembershipApplication(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public void VerifyApplication() {
    	verified  = true;
    }
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

	


