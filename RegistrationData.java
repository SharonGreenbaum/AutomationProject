package Data;

public class RegistrationData {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String expectedResult;
	private String actualResult;
	private String errorElementLocator;
	private String failPass;

	public RegistrationData() {
	}

	public RegistrationData(String firstName, String lastName, String id, String phone, String email, String birthday,
			String password, String confirmPassword, String expectedResult, String actualResult,
			String errorElementLocator, String failPass) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.expectedResult = expectedResult;
		this.actualResult = actualResult;
		this.errorElementLocator = errorElementLocator;
		this.failPass = failPass;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return the id
	 */


	/**


	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the expectedResult
	 */
	public String getExpectedResult() {
		return expectedResult;
	}

	/**
	 * @param expectedResult the expectedResult to set
	 */
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	/**
	 * @return the actualResult
	 */
	public String getActualResult() {
		return actualResult;
	}

	/**
	 * @param actualResult the actualResult to set
	 */
	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}

	/**
	 * @return the errorElementLocator
	 */
	public String getErrorElementLocator() {
		return errorElementLocator;
	}

	/**
	 * @param errorElementLocator the errorElementLocator to set
	 */
	public void setErrorElementLocator(String errorElementLocator) {
		this.errorElementLocator = errorElementLocator;
	}

	/**
	 * @return the failPass
	 */
	public String getFailPass() {
		return failPass;
	}

	/**
	 * @param failPass the failPass to set
	 */
	public void setFailPass(String failPass) {
		this.failPass = failPass;
	}

	@Override
	public String toString() {
		return "RegistrationData [firstName=" + firstName + ", lastName=" + lastName 
				+ ", email=" + email +", password=" + password + 
				", expectedResult=" + expectedResult + ", actualResult=" + actualResult
				+ ", errorElementLocator=" + errorElementLocator + ", failPass=" + failPass + "]";
	}

}
