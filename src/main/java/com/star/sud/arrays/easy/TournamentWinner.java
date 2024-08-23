package com.star.sud.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {

	public static void main(String[] args) {
		List<List<String>> competitions = new ArrayList<>();
		competitions.add(Arrays.asList("HTML", "Java"));
		competitions.add(Arrays.asList("Java", "Python"));
		competitions.add(Arrays.asList("Python", "HTML"));

		List<Integer> results = Arrays.asList(0, 1, 1);

		String tournamentWinner = tournamentWinner(competitions, results);
		System.out.println(tournamentWinner);

	}

	public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
		Map<String, Integer> teamResultMap = new HashMap<>();
		String finalWinningTeam = "";
		int highestScore = 0;

		for (int i = 0; i < competitions.size(); i++) {
			List<String> competition = competitions.get(i);
			String winnerTeam = results.get(i).equals(1) ? competition.get(0) : competition.get(1);

			Integer oldScore = teamResultMap.containsKey(winnerTeam) ? teamResultMap.get(winnerTeam) : 0;
			Integer newScore = oldScore + 3;

			if (newScore > highestScore) {
				finalWinningTeam = winnerTeam;
				highestScore = newScore;
			}
			teamResultMap.put(winnerTeam, newScore);
		}

		return finalWinningTeam;
	}

	public static String tournamentWinner_01(List<List<String>> competitions, List<Integer> results) {
		Map<String, Integer> teamResultMap = new HashMap<>();

		String teamWinner = "";
		Integer maxPoints = 0;
		Integer winnigPoints = 3;

		for (int i = 0; i < competitions.size(); i++) {

			Integer teamPoint = results.get(i);
			List<String> competition = competitions.get(i);

			String currentWinner = teamPoint.equals(1) ? competition.get(0) : competition.get(1);

			if (teamResultMap.containsKey(currentWinner)) {
				Integer oldPoints = teamResultMap.get(currentWinner);
				Integer currentWinnerPoints = oldPoints + winnigPoints;
				if (currentWinnerPoints > maxPoints) {
					teamWinner = currentWinner;
					maxPoints = currentWinnerPoints;
				}
				teamResultMap.put(currentWinner, currentWinnerPoints);
			} else {
				teamResultMap.put(currentWinner, winnigPoints);
				if (winnigPoints > maxPoints) {
					teamWinner = currentWinner;
					maxPoints = winnigPoints;
				}
			}
		}
		return teamWinner;
	}

}
