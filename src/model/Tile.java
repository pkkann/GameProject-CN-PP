/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Tile {

    protected Rectangle bounds;
    protected boolean occupied;
    protected boolean blocked;
    protected float moveCost;
    protected ArrayList<SmallTile> innerTiles;
    protected Image t9Texture;
    protected Image texture;
    protected int id;

    public Tile(Rectangle bounds) {
        this.bounds = bounds;
        occupied = false;
        blocked = false;
        setInnerTiles();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        texture.draw(bounds.getMinX(), bounds.getMinY());
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

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

    public void chooseTexture() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
