/*
 * represents an emergency room in a hospital
 */

public class EmergencyRoom {

	private PriorityQueue patients;

	/* 
 	 * constructor that initializes patients to a default-sized priority queue
	 */
	public EmergencyRoom() {
		// TODO: implement this
	}

	/* 
	 * constructor that initializes patients to a priority queue of given size
	 */
	public EmergencyRoom(int size) {
		// TODO: implement this
	}


	/* Purpose: add given Patient p to patients or prints
	 *          a notification message if patients is full
	 * Parameters: Patient p - the patient who just arrived at
	 *             the emergency room and needs to be added
	 * Returns: void - nothing
	 */
	public void addPatient(Patient p) {
		// TODO: implement this
	}


	/* Purpose: gets the number of patients waiting to be helped
	 * Parameters: none
	 * Returns: int - number of patients waiting to be helped
	 */
	public int numPatientsWaiting() {
		// TODO: implement this
		return -1; // so it compiles
	}


	/* Purpose: removes and returns the next patient from patients
	 * Parameters: none
	 * Returns: Patient - the next patient, null if there is no more patients.
	 */
	public Patient nextPatient() {
		// TODO: implement this
		return null; // so it compiles
	}
}

