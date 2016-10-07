package client.model;

import client.model.Position;

import java.util.Scanner;
public class TestPosition {

	public static void main(String[] args) {
		
		
		printPosition();
	}
	
	// Prints position based on the two value the user input
	public static void printPosition() {
		
		System.out.println("please input the position, row first, column next: ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		System.out.println("row = " + row);
		int column = input.nextInt();
		System.out.println("column = " + column);
		Position point = new Position(row, column);
		System.out.println(point);
	}
}
