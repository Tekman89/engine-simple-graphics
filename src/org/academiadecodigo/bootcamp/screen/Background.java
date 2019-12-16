package org.academiadecodigo.bootcamp.screen;

import org.academiadecodigo.bootcamp.representation.Representation;

import java.util.LinkedList;

public class Background {


    private LinkedList<BackgroundRepresentation> backgrounds;

    public Background(BackgroundRepresentation initialRepresentation) {
        backgrounds = new LinkedList<>();
        backgrounds.add(initialRepresentation);
    }

    public void addRepresentation(BackgroundRepresentation representation) {
        Representation lastPicture = backgrounds.getLast();
        int startX = lastPicture.getX();
        int startY = lastPicture.getY() + lastPicture.getHeight();
        representation.setStartX(startX);
        representation.setStartY(startY);

        backgrounds.add(representation);
    }

    public void draw() {
        for (BackgroundRepresentation background : backgrounds) {
            background.draw();
        }
    }

    public void delete() {
        for (BackgroundRepresentation background : backgrounds) {
            background.delete();
        }
    }
}
