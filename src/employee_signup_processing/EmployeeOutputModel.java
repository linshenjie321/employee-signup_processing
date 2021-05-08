package employee_signup_processing;

public class EmployeeOutputModel implements Cloneable {
	private String lastName;
	private String firstName;
	private int employeeNum;
	private String list;
	private int listOrder;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String otherPhone;
	private String aboriginalCulturesTraditions;
	private String africanHeritage;
	private String eslLinc;
	private String esu;
	private String internationalLang;
	private String parenting;
	private String seniorsDaytime;
	private String N;
	private String E;
	private String S;
	private String W;
	private String mfam;
	private String mfpm;
	private String mfeve;
	private String satam;
	private String satpm;
	private String sunam;
	private String sunpm;
	private String language;
	private String seniors;
	private String notes;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public int getListOrder() {
		return listOrder;
	}

	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getAboriginalCulturesTraditions() {
		return aboriginalCulturesTraditions;
	}

	public void setAboriginalCulturesTraditions(String aboriginalCulturesTraditions) {
		this.aboriginalCulturesTraditions = aboriginalCulturesTraditions;
	}

	public String getAfricanHeritage() {
		return africanHeritage;
	}

	public void setAfricanHeritage(String africanHeritage) {
		this.africanHeritage = africanHeritage;
	}

	public String getEslLinc() {
		return eslLinc;
	}

	public void setEslLinc(String eslLinc) {
		this.eslLinc = eslLinc;
	}

	public String getEsu() {
		return esu;
	}

	public void setEsu(String esu) {
		this.esu = esu;
	}

	public String getInternationalLang() {
		return internationalLang;
	}

	public void setInternationalLang(String internationalLang) {
		this.internationalLang = internationalLang;
	}

	public String getParenting() {
		return parenting;
	}

	public void setParenting(String parenting) {
		this.parenting = parenting;
	}

	public String getSeniorsDaytime() {
		return seniorsDaytime;
	}

	public void setSeniorsDaytime(String seniorsDaytime) {
		this.seniorsDaytime = seniorsDaytime;
	}

	public String getN() {
		return N;
	}

	public void setN(String n) {
		N = n;
	}

	public String getE() {
		return E;
	}

	public void setE(String e) {
		E = e;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getMfam() {
		return mfam;
	}

	public void setMfam(String mfam) {
		this.mfam = mfam;
	}

	public String getMfpm() {
		return mfpm;
	}

	public void setMfpm(String mfpm) {
		this.mfpm = mfpm;
	}

	public String getMfeve() {
		return mfeve;
	}

	public void setMfeve(String mfeve) {
		this.mfeve = mfeve;
	}

	public String getSatam() {
		return satam;
	}

	public void setSatam(String satam) {
		this.satam = satam;
	}

	public String getSatpm() {
		return satpm;
	}

	public void setSatpm(String satpm) {
		this.satpm = satpm;
	}

	public String getSunam() {
		return sunam;
	}

	public void setSunam(String sunam) {
		this.sunam = sunam;
	}

	public String getSunpm() {
		return sunpm;
	}

	public void setSunpm(String sunpm) {
		this.sunpm = sunpm;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSeniors() {
		return seniors;
	}

	public void setSeniors(String seniors) {
		this.seniors = seniors;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Object clone() throws CloneNotSupportedException {
		// Assign the shallow copy to new reference variable t
		EmployeeOutputModel t = (EmployeeOutputModel) super.clone();

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}

}
