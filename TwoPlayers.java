import java.util.Scanner;
import java.util.Arrays;

public class TwoPlayers {
	public static Scanner scan=new Scanner(System.in);

	public static void Play() {
		try {
			String[] players=GetPlayers();

			String[] row1=new String[3];
			String[] row2=new String[3];
			String[] row3=new String[3];

			String[][] Grid=new String[3][3];
			Grid[0]=row1;
			Grid[0][0]="  ";
			Grid[0][1]=" ";
			Grid[0][2]=" ";

			Grid[1]=row2;
			Grid[1][0]="  ";
			Grid[1][1]=" ";
			Grid[1][2]=" ";

			Grid[2]=row3;
			Grid[2][0]="  ";
			Grid[2][1]=" ";
			Grid[2][2]=" ";

			boolean Player1Turn=true;
			boolean Player2Turn=false;

			String PlayerTurn;
			String Turn;

			System.out.println();
			while (true) {

				if (Player1Turn) {
					PlayerTurn="(X) "+players[0];
					Turn="X";
				}
				else {
					PlayerTurn="(O) "+players[1];
					Turn="O";
				}

				GetGrid(Grid);
				System.out.println("\n\n"+PlayerTurn+"'s Turn");

				System.out.print("Row: ");
				int row=scan.nextInt();
				System.out.print("Column: ");
				int col=scan.nextInt();

				if (row>3||col>3) {
					System.out.println("\n- - - - - - - - - - - - - - - - - - - - -\n --> | Invalid Input | | Block at "+row+ " - "+col+" Not Found. |\n- - - - - - - - - - - - - - - - - - - - -");
					if (Player1Turn){
						Player2Turn=true;
						Player1Turn=false;
					}
					else {
						Player1Turn=true;
						Player2Turn=false;
					}
				}
				else if (Grid[row-1][col-1].equals(" ")||Grid[row-1][col-1].equals("  ")) {
					Grid[row-1][col-1]=Turn;
				}
				else {
					System.out.println("\n- - - - - - - - - - - - - - - - - - - - -\n --> | This block is already taken by "+Grid[row-1][col-1]+". |\n- - - - - - - - - - - - - - - - - - - - -");
					if (Player1Turn){
						Player2Turn=true;
						Player1Turn=false;
					}
					else {
						Player1Turn=true;
						Player2Turn=false;
					}
				}

				System.out.println();

				// Player Turn System
				if (Player1Turn) {
					Player2Turn=true;
					Player1Turn=false;
				}
				else {
					Player1Turn=true;
					Player2Turn=false;
				}

				// Player One Win Conditions
				if (Grid[0][0].equals("X")) {
					
					if (Grid[0][0].equals(Grid[0][1])&&Grid[0][1].equals(Grid[0][2])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
					else if (Grid[0][0].equals(Grid[1][0])&&Grid[1][0].equals(Grid[2][0])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[1][1].equals("X")) {
					if (Grid[1][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[1][2])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
					else if (Grid[0][1].equals(Grid[1][1])&&Grid[1][1].equals(Grid[2][1])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[2][0].equals("X")) {
					if (Grid[2][0].equals(Grid[2][1])&&Grid[2][1].equals(Grid[2][2])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[0][2].equals("X")) {
					if (Grid[0][2].equals(Grid[1][2])&&Grid[1][2].equals(Grid[2][2])) {
						PlayerOneWins(players[0]);
						GetGrid(Grid);
						break;
					}
				}
				if (Grid[0][0].equals("X")&&Grid[0][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[2][2])) {
					PlayerOneWins(players[0]);
					GetGrid(Grid);
					break;
				}
				else if (Grid[2][0].equals("X")&&Grid[2][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[0][2])) {
					PlayerOneWins(players[0]);
					GetGrid(Grid);
					break;
				}
				// Player Two Win Conditions
				if (Grid[0][0].equals("O")) {
					
					if (Grid[0][0].equals(Grid[0][1])&&Grid[0][1].equals(Grid[0][2])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
					else if (Grid[0][0].equals(Grid[1][0])&&Grid[1][0].equals(Grid[2][0])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[1][1].equals("O")) {
					if (Grid[1][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[1][2])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
					else if (Grid[0][1].equals(Grid[1][1])&&Grid[1][1].equals(Grid[2][1])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[2][0].equals("O")) {
					if (Grid[2][0].equals(Grid[2][1])&&Grid[2][1].equals(Grid[2][2])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
				}
				else if (Grid[0][2].equals("O")) {
					if (Grid[0][2].equals(Grid[1][2])&&Grid[1][2].equals(Grid[2][2])) {
						PlayerOneWins(players[1]);
						GetGrid(Grid);
						break;
					}
				}
				if (Grid[0][0].equals("O")&&Grid[0][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[2][2])) {
					PlayerOneWins(players[1]);
					GetGrid(Grid);
					break;
				}
				else if (Grid[2][0].equals("O")&&Grid[2][0].equals(Grid[1][1])&&Grid[1][1].equals(Grid[0][2])) {
					PlayerOneWins(players[1]);
					GetGrid(Grid);
					break;
				}
			}
		}
		catch (Exception Error) {
			System.out.println("\n- - - - - - - - - - -\n --> | Error Occured |\n- - - - - - - - - - -");
		}
	}
	public static void GetGrid(String[][] Grid) {
		for (int i=0;i<Grid.length;i++) {
			for (int v=0;v<Grid[i].length;v++) {
				if (v<2) {
					System.out.print(Grid[i][v]+" | ");
				}
				else {
					System.out.print(Grid[i][v]);
				}
			}
			if (i<2) {
				System.out.println("\n-----------");
			}
		}
	}
	public static String[] GetPlayers() {
		String players[]=new String[2];

		System.out.print("(X) Player 1: ");
		String p1=scan.nextLine();
		if (p1.length()<1) {
			players[0]="Player 1";
			System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\nPlayer 1 Name Was Invalid So Was Renamed To: \"Player 1\" |\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		}
		System.out.print("(O) Player 2: ");
		String p2=scan.nextLine();

		if (p2.length()<1) {
			players[1]="Player 2";
			System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\nPlayer 2 Name Was Invalid So Was Renamed To: \"Player 2\" |\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		}
		else if (p2.equals(p1)) {
			players[1]="Player 2";
			System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\nPlayer 2 Name Was The Same As Player 1 Name So Was Renamed To: \"Player 2\" |\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		}

		if (p1.length()>=1){
			players[0]=p1;
		}
		if (p2.length()>=1){
			players[1]=p2;
		}

		return players;
	}
	public static void PlayerOneWins(String PlayerName) {
		System.out.println("- - - - - - -\n"+PlayerName+" Wins!\n- - - - - - -");
	}
	public static void Tie() {
		System.out.println("- - - - - -\nGame Tie |\n- - - - - -");
	}
}