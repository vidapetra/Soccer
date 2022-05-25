package soccer;

import java.util.ArrayList;
import java.util.Random;

public class Team {

	ArrayList<Player> players;
	Lineup lineup;
	int value;
	
	public Team() {
		players = new ArrayList<Player>();
		setPlayers();
		Random r = new Random();
		int lineup = r.nextInt(3) + 1;
		if (lineup == 1) this.lineup = Lineup.FOURTHREETHREE;
		else if (lineup == 2) this.lineup = Lineup.THREEFOURTHREE;
		else if (lineup == 3) this.lineup = Lineup.FIVETHREETWO;
		getValue();
	}
	
	public int getValue() {
		int defender = 0;
		int midfielder = 0;
		int striker = 0;
		value = 0;
		
		if(lineup == Lineup.FOURTHREETHREE) {
			defender = 4;
			midfielder = 3;
			striker = 3;
		}
		else if(lineup == Lineup.THREEFOURTHREE) {
			defender = 3;
			midfielder = 4;
			striker = 3;
		}
		else if(lineup == Lineup.FIVETHREETWO) {
			defender = 5;
			midfielder = 3;
			striker = 2;
		}
		
		for (int i = 0; i < defender; i++) {
			value += players.get(i).pace;
			value += players.get(i).defence * 2;
			value += players.get(i).physical;
		}
		for (int i = defender; i < defender + midfielder; i++) {
			value += players.get(i).pace;
			value += players.get(i).passing;
			value += players.get(i).dribbling * 2;
		}
		for (int i = defender + midfielder; i < defender + midfielder + striker; i++) {
			value += players.get(i).pace;
			value += players.get(i).shooting * 2;
			value += players.get(i).physical;
		}
		value += players.get(10).reflex * 5;
		
		return value;
	}
	
	public void setPlayers() {
		// pace, shooting, passing, dribbling, defence, physical, reflex
		Player player1 = new Player("Casemiro", 65, 73, 76, 73, 86, 90, 0);
		Player player2 = new Player("Benzema", 76, 86, 74, 88, 46, 86, 0);
		Player player3 = new Player("Kroos", 53, 81, 91, 81, 71, 68, 0);
		Player player4 = new Player("Modric", 73, 76, 89, 88, 72, 66, 0);
		Player player5 = new Player("Carvajal", 80, 54, 78, 80, 81, 80, 0);
		Player player6 = new Player("Hazard", 84, 80, 82, 88, 35, 63, 0);
		Player player7 = new Player("Alaba", 77, 70, 81, 80, 83, 76, 0);
		Player player8 = new Player("Asensio", 82, 80, 81, 83, 43, 62, 0);
		Player player9 = new Player("Mendy", 92, 64, 76, 79, 78, 84, 0);
		Player player10 = new Player("Valverde", 86, 74, 78, 79, 77, 80, 0);
		Player player11 = new Player("Militao", 83, 50, 69, 71, 83, 82, 0);
		Player player12 = new Player("Bale", 82, 84, 82, 80, 55, 70, 0);
		Player player13 = new Player("Nacho", 87, 37, 66, 69, 81, 80, 0);
		Player player14 = new Player("Vinicius", 95, 70, 71, 87, 29, 66, 0);
		Player player15 = new Player("Rodrygo", 87, 76, 71, 83, 32, 56, 0);
		Player player16 = new Player("Camavinga", 72, 65, 76, 80, 75, 77, 0);
		Player player17 = new Player("Courtois", 0, 0, 0, 0, 0, 0, 88);
		Player player18 = new Player("Luin", 0, 0, 0, 0, 0, 0, 76);
		Player player19 = new Player("Lopez", 0, 0, 0, 0, 0, 0, 73);
		// Forrás: https://www.ea.com/games/fifa/fifa-22/ratings/ratings-database
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		players.add(player7);
		players.add(player8);
		players.add(player9);
		players.add(player10);
		players.add(player11);
		players.add(player12);
		players.add(player13);
		players.add(player14);
		players.add(player15);
		players.add(player16);
		players.add(player17);
		players.add(player18);
		players.add(player19);
		
		ArrayList<Integer> random = getRandomNumbers();
		
		for (int i = 0; i < 11; i++) {
			this.players.add(players.get(random.get(i)));
		}
		
	}
	
	public ArrayList<Integer> getRandomNumbers() {
		Random r = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			int x = r.nextInt(19);
			if (!list.contains(x)) {
				list.add(x);
			} else {
				i--;
			}
		}
		return list;
	}
	
}
