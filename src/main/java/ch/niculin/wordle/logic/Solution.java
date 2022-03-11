package ch.niculin.wordle.logic;

import java.time.LocalDate;

public class Solution {
    private  String solution;
    private  LocalDate date;

    public Solution(String solution, LocalDate date) {
        this.solution = solution;
        this.date = date;
    }

    public String getSolution() {
        return solution;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solution='" + solution + '\'' +
                ", date=" + date +
                '}';
    }
}
