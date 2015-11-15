package jaffa.archive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private HashMap<String, Character> airplaneSeats;
	private String[][] airplane;
	private HashMap<Integer, Character> letters;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.airplaneSeats = new HashMap<String, Character>();
		this.letters = new HashMap<Integer, Character>();
		Character[] let = new Character[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 0; i < 26; i++) {
			letters.put(i, let[i]);
		}
		this.airplane = new String[rows][columns];
		String seat;
		Integer num;
		for (Integer i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				num = i +1; 
				seat = airplane[i][j] = letters.get(j) + num.toString();
				airplaneSeats.put(seat, 'o');
			}
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException,
	SeatOutOfBoundsException {
		if (airplaneSeats.containsKey(seatName)){
			if (airplaneSeats.get(seatName) == '#') {
				throw new AlreadyReservedException();
			} else {
				airplaneSeats.put(seatName, '#');
			}
		}
		else{
			throw new SeatOutOfBoundsException();
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		if (airplaneSeats.get(seatName) == '#'){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 
	 *         1 #oo#\n 
	 *         2 #ooo\n 
	 *         3 ###o\n 
	 *         4 ##oo\n 
	 *         5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("  ");
		for (int i = 0; i < airplane.length + 1; i++) {
			builder.append(letters.get(i));
		}

		for (int i = 0; i < airplane.length; i++) {
			builder.append("\n");
			builder.append(i + 1 + " ");
			for (int j = 0; j < airplane[i].length; j++) {
				builder.append(airplaneSeats.get(airplane[i][j]));
			}
		}
		System.out.println(builder.toString());
		builder.append("\n");
		return builder.toString();
	}


	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	// prob most complicated.
	// also call reserve - reserve the seats
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {
		ArrayList<String> seats = new ArrayList<String>();
		int count = 0;
		boolean enough = false;
		int row = 0;
		for (int i = 0; i < airplane.length; i++) {
			for (int j = 0; j < airplane[i].length; j++) {
				if (airplaneSeats.get(airplane[i][j]) == 'o') {
					count++;
				}
			}
			if (count >= numberOfSeatsTogether) {
				enough = true;
				row = i;
				int j = 0;
				while(j < numberOfSeatsTogether){
					if (airplaneSeats.get(airplane[row][j]) == 'o') {
						String seat = letters.get(j) + "" + (i + 1);
						seats.add(seat);
						reserve(seat);
						j++;
					}
				}
				break;
			}
			count = 0;
		}
		return seats;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (Map.Entry<String, Character> entry : airplaneSeats.entrySet()) {
			if (entry.getValue() == 'o') {
				return false;
			}
		}
		return true;
	}

}
