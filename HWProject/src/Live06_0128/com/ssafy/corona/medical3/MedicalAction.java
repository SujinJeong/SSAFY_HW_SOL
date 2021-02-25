package Live06_0128.com.ssafy.corona.medical3;

public interface MedicalAction {
	void addPatient(Patient p) throws NotCoronaException;
	void removePatient(Patient p);
}
