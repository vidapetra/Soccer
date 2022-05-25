package soccer;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		ArrayList<Team> population = new ArrayList<Team>();
		for (int i = 0; i < 6; i++) {
			population.add(new Team());
		}
		int i = 0;

		int maxValue1 = 0;
		int maxValue2 = 0;
		int max1 = 0;
		int max2 = 0;
		
		while(maxValue1 < 3600) {
			maxValue1 = 0;
			maxValue2 = 0;
			max1 = 0;
			max2 = 0;
			for (int j = 0; j < population.size(); j++) {
				if (maxValue1 < population.get(j).getValue()) {
					maxValue2 = maxValue1;
					maxValue1 = population.get(j).getValue();
					max2 = max1;
					max1 = j;
				}
				else if (maxValue2 < population.get(j).getValue()) {
					maxValue2 = population.get(j).getValue();
					max2 = j;
				}
			}
			NewPopulationGenerator generator = new NewPopulationGenerator(population.get(max1), population.get(max2));
			population.clear();
			population = generator.getNewPopulation();
			
			for (int j = 0; j < population.size(); j++) {
				if (maxValue1 < population.get(j).getValue()) {
					maxValue1 = population.get(j).getValue();
					max1 = j;
				}
			}
			
			i++;
		}
		
		int defender = 0;
		int midfielder = 0;
		int striker = 0;
		
		if(population.get(max1).lineup == Lineup.FOURTHREETHREE) {
			System.out.println("Felállás: 4 - 3 - 3");
			defender = 4;
			midfielder = 3;
			striker = 3;
		}
		else if(population.get(max1).lineup == Lineup.THREEFOURTHREE) {
			System.out.println("Felállás: 3 - 4 - 3");
			defender = 3;
			midfielder = 4;
			striker = 3;
		}
		else if(population.get(max1).lineup == Lineup.FIVETHREETWO) {
			System.out.println("Felállás: 5 - 3 - 2");
			defender = 5;
			midfielder = 3;
			striker = 2;
		}
		
		
		System.out.println("Kapus:          " + population.get(max1).players.get(10).name);
		System.out.print("Védõk:          ");
		
		for (i = 0; i < defender; i++) {
			System.out.print(population.get(max1).players.get(i).name + ", ");
		}
		System.out.println();
		System.out.print("Középpályások:  ");
		for (i = defender; i < defender + midfielder; i++) {
			System.out.print(population.get(max1).players.get(i).name + ", ");
		}
		System.out.println();
		System.out.print("Csatárok:       ");
		for (i = defender + midfielder; i < defender + midfielder + striker; i++) {
			System.out.print(population.get(max1).players.get(i).name + ", ");
		}

		System.out.println();
		System.out.println("Érték: " + population.get(max1).getValue());
		System.out.println();
		
	}
	
}
