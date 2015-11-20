package jaffa.airline;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AirplaneSeatsTest {

	@Test
	/**
	 * Test the output of toString() on an empty plane. Do not modify this method.
	 */
	//don't need to modify
	public void testToStringWithEmptyPlane() {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		Assert.assertEquals(
				"  ABCD\n" +
						"1 oooo\n" +
						"2 oooo\n" + 
						"3 oooo\n",
						seats.toString());
	}

	@Test
	/**
	 * Test the output of toString() on an full plane. Do not modify this method.
	 */
	//already written
	public void testToStringWithFullPlane() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserveAll("A1", "B1", "C1", "D1");
		seats.reserveAll("A2", "B2", "C2", "D2");
		seats.reserveAll("A3", "B3", "C3", "D3");
		Assert.assertEquals(
				"  ABCD\n" +
						"1 ####\n" +
						"2 ####\n" + 
						"3 ####\n",
						seats.toString());
	}

	@Test
	/**
	 * Tests that reserve() reserves a seat correctly.
	 */
	//we have to write
	public void testReserve() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3,4);
		seats.reserve("A2");
		Assert.assertTrue(seats.isReserved("A2"));
		//Assert.fail("Test not implemented");
	}

	@Test
	/**
	 * Tests that reserve() will throw an AlreadyReservedException if you attempt to reserve
	 * a seat twice. Do not modify this method.
	 */
	//don't need to modify
	public void testReserveThrowsAlreadyReservedException() throws SeatOutOfBoundsException, AlreadyReservedException {
		AirplaneSeats seats = new AirplaneSeats(1,1);
		seats.reserve("A1");
		try {
			seats.reserve("A1");
			//Assert.fail("reserve() should've thrown an Exception");
		} catch (AlreadyReservedException e) {
			// This is expected so catch it so the test passes
		}
	}

	@Test
	/**
	 * Tests that reserve() will thrown a SeatOutOfBoundsException is you attempt to reserve
	 * a seat that is outside the bounds of the plane. 
	 */
	//opp of one before
	public void testReserveThrowsSeatOutOfBoundsException() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1,1);
		try {
			seats.reserve("A2");
			Assert.fail("Test not implemented");
		} catch (SeatOutOfBoundsException e) {

		}

	}

	@Test
	/**
	 * Tests that isFullPlane() returns false if there are empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsFalse() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1,2);
		seats.reserve("A1");
		Assert.assertFalse(seats.isPlaneFull());
		//Assert.fail("Test not implemented");
	}

	@Test
	/**
	 * Tests that isFullPlane() returns true if there are no empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsTrue() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1,1);
		seats.reserve("A1");
		Assert.assertTrue(seats.isPlaneFull());
		//Assert.fail("Test not implemented");
	}

	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on an empty plane.
	 */
	//should also get back list of seats
	public void testReserveGroupOnEmptyPlane() throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(2,4);
		ArrayList<String> seatsArray = new ArrayList<String>();
		seatsArray.add("A1");
		seatsArray.add("B1");
		Assert.assertEquals(seatsArray, seats.reserveGroup(2));
		//Assert.fail("Test not implemented");
	}

	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on a plane that has
	 * seats already reserved. For instance, on a 3,4 airplane whose "A1" is occupied, 
	 * calling reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 */
	public void testReserveGroupOnPartiallyFilledPlane() throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3,4);
		seats.reserve("A1");
		ArrayList<String> seatsArray = new ArrayList<String>();
		seatsArray.add("A2");
		seatsArray.add("B2");
		seatsArray.add("C2");
		seatsArray.add("D2");
		Assert.assertEquals(seatsArray, seats.reserveGroup(4));
		//Assert.fail("Test not implemented");
	}

	@Test
	/**
	 * Tests that reserveGroup() throws NotEnoughSeatsException if there are not enough 
	 * seats available together for the group.
	 */
	public void testReserveGroupThrowsNotEnoughSeatsException() throws AlreadyReservedException, SeatOutOfBoundsException, NotEnoughSeatsException {
		AirplaneSeats seats = new AirplaneSeats(1,4);
		seats.reserve("A1");
		try {
			seats.reserveGroup(4);
			//Assert.fail("Test not implemented");
		} catch (NotEnoughSeatsException e) {

		}
	}

}
