package uken.testStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    private String title;
    private int year;
//    private String brief;
    private double range;
    private String age;
    private short minPlayer;
    private short maxPlayer;
    private double difficulty;
    private String timePlay;
    private double price;
//    private String[] artists;
//    private String[] developers;
//    private String[] categories;

    public BoardGame() {}

    public BoardGame(String title, int year, double range, String age, short minPlayer, short maxPlayer, double difficulty, String timePlay, double price) {
        this.title = title;
        this.year = year;
        this.range = range;
        this.age = age;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.timePlay = timePlay;
        this.difficulty = difficulty;
        this.price = price;
    }

    public List<BoardGame> loadFromFile(String path) throws IOException {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public short getMinPlayer() {
        return minPlayer;
    }

    public void setMinPlayer(short minPlayer) {
        this.minPlayer = minPlayer;
    }

    public short getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(short maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public String getTimePlay() {
        return timePlay;
    }

    public void setTimePlay(String timePlay) {
        this.timePlay = timePlay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", range=" + range +
                ", age='" + age + '\'' +
                ", minPlayer=" + minPlayer +
                ", maxPlayer=" + maxPlayer +
                ", difficulty=" + difficulty +
                ", timePlay='" + timePlay + '\'' +
                ", price=" + price +
                '}';
    }
}
