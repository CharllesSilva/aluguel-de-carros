package app;

import view.View;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        View view = new View();
        view.startProgram();
    }
}
