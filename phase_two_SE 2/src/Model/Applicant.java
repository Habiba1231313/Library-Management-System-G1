package Model;

public class Applicant {
    private String name;
    private String address;

    public Applicant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public MembershipApplication submitApplication() {
    	return new MembershipApplication(name, address);
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
