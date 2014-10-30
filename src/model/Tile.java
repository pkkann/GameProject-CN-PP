/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class Tile {

    private Rectangle bounds;
    private boolean occupied;
    private boolean blocked;
    private float moveCost;
    private ArrayList<SmallTile> innerTiles;

    public Tile(Rectangle bounds) {
        this.bounds = bounds;
        occupied = false;
        blocked = false;
        setInnerTiles();
    }

    private void setInnerTiles() {
        innerTiles = new ArrayList<>();
        innerTiles.add(new SmallTile(new Rectangle(bounds.getMinX(), bounds.getMinY(), bounds.getWidth() / 2, bounds.getHeight() / 2)));
        innerTiles.add(new SmallTile(new Rectangle(bounds.getMinX() + (bounds.getWidth() / 2), bounds.getMinY(), bounds.getWidth() / 2, bounds.getHeight() / 2)));
        innerTiles.add(new SmallTile(new Rectangle(bounds.getMinX(), bounds.getMinY() + (bounds.getHeight() / 2), bounds.getWidth() / 2, bounds.getHeight() / 2)));
        innerTiles.add(new SmallTile(new Rectangle(bounds.getMinX() + (bounds.getWidth() / 2), bounds.getMinY() + (bounds.getHeight() / 2), bounds.getWidth() / 2, bounds.getHeight() / 2)));
    }

    public ArrayList<SmallTile> getInnerTiles() {
        return innerTiles;
    }

    public void setInnerTiles(ArrayList<SmallTile> innerTiles) {
        this.innerTiles = innerTiles;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public float getMoveCost() {
        return moveCost;
    }

    public void setMoveCost(float moveCost) {
        this.moveCost = moveCost;
    }

}
