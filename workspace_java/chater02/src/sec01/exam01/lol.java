package sec01.exam01;

public class lol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lol[] = { 1, 2, 3, 4, 5 };
		int lol_loser[] = { 2, 4, 5, 1 };
		boolean lol_winner = false;

		for (int i = 0; i < lol.length; i++) {
			for (int j = 0; j < lol_loser.length; j++) {
				if (lol[i] == lol_loser[j]) {
					lol_winner = true;
				}
			}
			
		}

	}

}
