package Model;

public class Item {
		private int callNumber;
		private String title;
		private int year;
		private boolean isAvailable;
		private String securityCode;
		private boolean isLost;
		private boolean isReserved;
	
		public boolean isReserved() {
			return isReserved;
		}

		public void setReserved(boolean isReserved) {
			this.isReserved = isReserved;
		}

		public int getCallNumber() {
			return callNumber;
		}

		public Item() {
			super();
			this.isAvailable = true;
		}

		public void setCallNumber(int callNumber) {
			this.callNumber = callNumber;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}

		public String getSecurityCode() {
			return securityCode;
		}

		public void setSecurityCode(String securityCode) {
			this.securityCode = securityCode;
		}

		public boolean isLost() {
			return isLost;
		}

		public void setLost(boolean isLost) {
			this.isLost = isLost;
		}

		public boolean checkAvailability() {
			return isAvailable;
		}
	
		public void markLost() {
			this.isLost = true;
		}
	
		public void markReturned() {
			isAvailable = true;
			isLost = false;
		}

		public Item(int callNumber, String title) {
			super();
			this.isLost = false;
			this.isAvailable = true;
			this.callNumber = callNumber;
			this.title = title;
		}
		
		
		
	}
