package com.aabdalla.wardrobe.controllers;

import com.aabdalla.wardrobe.Wardrobe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BaseUI {
    @FXML
    private Text pageTitle;

    @FXML
    private BorderPane mainLayout;

    @FXML
    private AnchorPane navHome;

    @FXML
    private AnchorPane navCloset;
    @FXML
    private Text navClosetAddPiece;
    @FXML
    private Text navClosetAddTag;

    @FXML
    private AnchorPane navOutfits;
    @FXML
    private Text navOutfitsAddOutfit;
    @FXML
    private Text navOutfitsAddGroup;

    private AnchorPane currentPage;
    private FXMLLoader loader;

    @FXML
    public void initialize() {
        loadPage(navHome, Page.HOME);

        handleNavigation(navHome, Page.HOME);
        handleNavigation(navCloset, Page.CLOSET);
        handleNavigation(navOutfits, Page.OUTFITS);
    }

    private void handleNavigation(AnchorPane navPane, Page page) {
        navPane.setOnMouseClicked(event -> {
            if (navPane == currentPage) return;

            loadPage(navPane, page);
        });
    }

    private void loadPage(AnchorPane navPane, Page page) {
        try {
            FXMLLoader loader = new FXMLLoader(Wardrobe.class.getResource(page.getLocation()));
            mainLayout.setCenter(loader.load());

            if (currentPage != null) {
                currentPage.setId(null);
            }

            pageTitle.setText(page.getTitle());
            navPane.setId("selected_nav");
            currentPage = navPane;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private enum Page {
        HOME("fxml/pages/home/home_main.fxml", "Home"),
        CLOSET("fxml/pages/closet/closet_main.fxml", "Your Closet"),
        OUTFITS("fxml/pages/outfits/outfits_main.fxml", "Your Outfits");

        private final String loc;
        private final String title;

        Page(String loc, String title) {
            this.loc = loc;
            this.title = title;
        }

        String getLocation() {
            return loc;
        }

        String getTitle() {
            return title;
        }
    }



}

