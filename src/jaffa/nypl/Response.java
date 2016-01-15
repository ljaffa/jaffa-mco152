package jaffa.nypl;

public class Response {

	private int numResults;
	private Result[] result;
	private Capture[] capture;

	public int getNumResults() {
		return numResults;
	}

	public Result[] getResults() {
		return result;
	}

	public Capture[] getCaptures() {
		return capture;
	}

}
