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
		/*
		 * HashMap<Character, Integer> airplane = new HashMap<Character,
		 * Integer>(); for (int i = 0; i < rows; i++){ for (int j = 0; j <
		 * columns; j++){ char letter = airplane.put(letter, i+1); } }
		 * HashMap<HashMap<Character, Integer>, Character> seats = new
		 * HashMap<HashMap<Character, Integer>, Character>();
		 */
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
		/*char[] seat = seatName.toCharArray();
		char letter = seat[0];
		Character number = seat[1];
		int row = 0;
		int column = Integer.parseInt(number.toString());
		for (Map.Entry<Integer, Character> entry : letters.entrySet()) {
			if (entry.getValue() == letter) {
				row = entry.getValue();
			}
		}
		if (airplane[row][column] == "#") {
			return true;
		} else {
			return false;
		}*/
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

		builder.append("\t" + "\t");
		for (int i = 0; i < airplane.length + 1; i++) {
			builder.append(letters.get(i));
		}
		builder.append("\n");
		//builder.append("\n");
		for (int i = 0; i < airplane.length; i++) {
			builder.append(i + 1 + "\t");
			for (int j = 0; j < airplane[i].length; j++) {
				builder.append(airplaneSeats.get(airplane[i][j]));
			}
			if (i < airplane.length){
				builder.append("\n");
			}
		}

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
		//String[] reserveSeats = new String[numberOfSeatsTogether];
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
				;				row = i;
				int j = 0;
				while(j < numberOfSeatsTogether){
					if (airplaneSeats.get(airplane[row][j]) == 'o') {
						String seat = letters.get(j) + "" + (i + 1);
						//reserve(seat);
						seats.add(seat);
						reserve(seat);
						//reserveSeats.add(seat);
						j++;
					}
				}
				break;
			}
			count = 0;
		}
		/*for (int j = 0; j < airplane[row].length; j++) {
			if (airplaneSeats.get(airplane[row][j]) == 'o') {
				String seat = "letters.get(row)" + "j";
				//reserve(seat);
				seats.add(seat);
			}
		}*/
		/*for (String seat : seats){
			reserve(seat);
			//if (airplaneSeats.get(seat) == 'o'){
			//reserve(seat);
			//}
		}*/
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
