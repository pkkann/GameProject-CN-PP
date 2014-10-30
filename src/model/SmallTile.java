/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author PK
 */
public class SmallTile {

    private Rectangle bounds;
    private boolean occupied;
    private boolean blocked;
    private float moveCost;

    public SmallTile(Rectangle bounds) {
        this.bounds = bounds;
        occupied = false;
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
