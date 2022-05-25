package soccer;

import java.util.ArrayList;

public class NewPopulationGenerator {
	
	Team team1;
	Team team2;
	
	public NewPopulationGenerator(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public Team mutation(Team team) {
		Team newTeam = new Team();
		return crossing(team, newTeam);
	}
	
	public Team crossing(Team team1, Team team2) {
		Team newTeam = new Team();
		newTeam.lineup = team1.lineup;
		newTeam.players = new ArrayList<Player>();
		ArrayList<Player> crossPlayers = new ArrayList<Player>();
		
		for (int i = 0; i < team1.players.size() + team2.players.size(); i++) {
			if (i % 2 == 0) {
				crossPlayers.add(team1.players.get(i / 2));
			} else {
				crossPlayers.add(team2.players.get(i / 2));
			}
		}
		int i = 0;
		while (i < crossPlayers.size() && newTeam.players.size() < 11) {
			boolean ok = true;
			if (i != 0) {
				for (int j = 0; j < newTeam.players.size(); j++) {
					if (newTeam.players.get(j).name.contentEquals(crossPlayers.get(i).name)) {
						ok = false;
					} else {
						
					}
				}
			} else {
				ok = false;
				newTeam.players.add(crossPlayers.get(i));
			}
			
			if (ok == true) {
				newTeam.players.add(crossPlayers.get(i));
			}
			i++;
		}
		
		return newTeam;
	}
	
	public ArrayList<Team> getNewPopulation() {
		ArrayList<Team> list = new ArrayList<Team>();
		list.add(crossing(team1, team2));
		list.add(crossing(team2, team1));
		list.add(mutation(team1));
		list.add(mutation(team2));
		list.add(mutation(team1));
		list.add(mutation(team2));
		return list;
	}
}
