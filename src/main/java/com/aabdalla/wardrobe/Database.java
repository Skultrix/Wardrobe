package com.aabdalla.wardrobe;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String CLOSET_TABLE = "CREATE TABLE IF NOT EXISTS closet ("
                                                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                + "tags TEXT NOT NULL, "
                                                + "photos TEXT NOT NULL, "
                                                + "cover_photo TEXT NOT NULL, "
                                                + "type TEXT NOT NULL, "
                                                + "favorite BOOLEAN NOT NULL, "
                                                + "position INTEGER NOT NULL"
                                                + ");";

    private final String closetURL;

    public Database(File dir) {
        File dataDir = new File(dir, "data");

        if (!dataDir.exists()) dataDir.mkdirs();

        String cPath = Paths.get(dataDir.getAbsolutePath(), "closet.db").toString();
        this.closetURL = "jdbc:sqlite:" + cPath;

        loadCloset(dataDir);
        loadOutfits(dataDir);
    }

    private void loadCloset(File dir) {
        try (Connection conn = DriverManager.getConnection(closetURL); Statement stmt = conn.createStatement()) {
            stmt.execute(CLOSET_TABLE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getClosetConnection() {
        try {
            return DriverManager.getConnection(closetURL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }



    private void loadOutfits(File dir) {

    }

}
