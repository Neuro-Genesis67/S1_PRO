// Tom Steinmeier - DMU 18v

package model;

public class AnalyseOpgave extends PraktikOpgave {

	String analyseModel;

	public AnalyseOpgave(String navn, int semester, String analyseModel) {
		super(navn, semester);
		this.analyseModel = analyseModel;
	}

	public String getAnalyseModel() {
		return analyseModel;
	}

	public void setAnalyseModel(String analyseModel) {
		this.analyseModel = analyseModel;
	}

	public String toString() {
		return "Navn: " + this.getNavn() + " Semester: " + this.getSemester() + " AnalyseModel: "
				+ this.getAnalyseModel();
	}
}
