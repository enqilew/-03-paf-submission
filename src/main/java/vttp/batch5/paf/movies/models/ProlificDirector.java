package vttp.batch5.paf.movies.models;

public class ProlificDirector {
    private String directorName;
    private int moviesCount;
    private double totalRevenue;
    private double totalBudget;
    private double profitOrLoss;

    public ProlificDirector(String directorName, int moviesCount, double totalRevenue, double totalBudget) {
        this.directorName = directorName;
        this.moviesCount = moviesCount;
        this.totalRevenue = totalRevenue;
        this.totalBudget = totalBudget;
        this.profitOrLoss = totalRevenue - totalBudget; // Profit or loss calculation
    }

    // Getters and Setters
    public String getDirectorName() { return directorName; }
    public void setDirectorName(String directorName) { this.directorName = directorName; }

    public int getMoviesCount() { return moviesCount; }
    public void setMoviesCount(int moviesCount) { this.moviesCount = moviesCount; }

    public double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

    public double getTotalBudget() { return totalBudget; }
    public void setTotalBudget(double totalBudget) { this.totalBudget = totalBudget; }

    public double getProfitOrLoss() { return profitOrLoss; }
    public void setProfitOrLoss(double profitOrLoss) { this.profitOrLoss = profitOrLoss; }
}

