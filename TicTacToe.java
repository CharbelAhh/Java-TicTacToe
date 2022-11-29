public class TicTacToe {

	private static TwoPlayers tp=new TwoPlayers();

	public static void main(String[] args) {
		String lines="----------------";
		System.out.print("\n\n"+lines+"\n\n TicTacToe Game\n\n"+lines+"\n");

		tp.Play();
	}
}