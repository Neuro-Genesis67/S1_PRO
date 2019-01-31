package pro_s1_24_opg2;

public class Person {
	private String navn;
	private String addresse;

	// Constructor
	// ---------------------------------------------------------------------------------------------------
	public Person(String navn, String addresse) {
		this.navn = navn;
		this.addresse = addresse;
	}

	// Get & Set methods
	// ---------------------------------------------------------------------------------------------
	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAddresse() {
		return this.addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
}
