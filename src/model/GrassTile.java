/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.ImageArchive;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class GrassTile extends Tile {

    public GrassTile(Rectangle bounds) {
        super(bounds);
        t9Texture = ImageArchive.getT9Grass();
        id = 1;
    }

    public void chooseTexture() {
        int[] surroundingTiles = TileMap.getSurroundingTiles((int) bounds.getMinX() / (int) bounds.getWidth(), (int) bounds.getMinY() / (int) bounds.getHeight());

        if (surroundingTiles[0] == 2) {
            if (surroundingTiles[1] == 2) {
                texture = t9Texture.getSubImage(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            } else if (surroundingTiles[2] == 2) {
                texture = t9Texture.getSubImage((int) t9Texture.getWidth() / 2, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            } else {
                texture = t9Texture.getSubImage((int) t9Texture.getWidth() / 4, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            }
        } else if (surroundingTiles[1] == 2) {
            if (surroundingTiles[3] == 2) {
                texture = t9Texture.getSubImage(0, t9Texture.getHeight() / 2, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            } else {
                texture = t9Texture.getSubImage(0, t9Texture.getHeight() / 4, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            }
        } else if (surroundingTiles[2] == 2) {
            if (surroundingTiles[3] == 2) {
                texture = t9Texture.getSubImage(t9Texture.getWidth() / 2, t9Texture.getHeight() / 2, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            } else {
                texture = t9Texture.getSubImage(t9Texture.getWidth() / 2, t9Texture.getHeight() / 4, (int) bounds.getWidth(), (int) bounds.getHeight());
                return;
            }
        } else if (surroundingTiles[3] == 2) {
            texture = t9Texture.getSubImage(t9Texture.getWidth() / 4, t9Texture.getHeight() / 2, (int) bounds.getWidth(), (int) bounds.getHeight());
            return;
        }
        texture = t9Texture.getSubImage((int) t9Texture.getWidth() / 4, (int) t9Texture.getHeight() / 4, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

}
