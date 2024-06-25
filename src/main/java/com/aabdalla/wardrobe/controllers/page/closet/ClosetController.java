package com.aabdalla.wardrobe.controllers.page.closet;

import com.aabdalla.wardrobe.controllers.BaseUI;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class ClosetController {

    @FXML
    private HBox tagsList;
    @FXML
    private AnchorPane tagsAll;

    @FXML
    private TilePane itemsContainer;

    @FXML
    private AnchorPane sortShirts;
    @FXML
    private AnchorPane sortOuterWear;
    @FXML
    private AnchorPane sortBottoms;
    @FXML
    private AnchorPane sortShoes;
    @FXML
    private AnchorPane sortAccessories;


    @FXML
    public void initialize() {

    }
}
