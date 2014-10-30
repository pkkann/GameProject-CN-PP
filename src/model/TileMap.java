/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author PK
 */
public class TileMap implements TileBasedMap {

    /*
     2 dimensional array of Tiles, which will be the tilemap.
     */
    private Tile[][] map;
    /*
     Amount of tiles on the y axis.
     */
    private int mapHeight = 50;
    /*
     Amount of tiles on the x axis.
     */
    private int mapWidth = 50;
    /*
     The size of each tile.
     */
    private int tileSize = 20;
    /*
     A 2 dimensional array of booleans used by the A* pathfinder.
     */
    private boolean[][] visited = new boolean[mapWidth][mapHeight];

    public TileMap() {
        map = new Tile[mapWidth][mapHeight];
        populateTileMap();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        drawMap(g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    /*
     Creates the amount of tiles specified by mapHeight and mapWidth in the tileSize.
     */
    private void populateTileMap() {
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                map[x][y] = new Tile(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
            }
        }
    }

    /*
     Draws the map as a grid for testing purposes.
     */
    public void drawMap(Graphics g) {
        g.setColor(Color.white);
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                g.setColor(Color.white);
                Tile t = map[x][y];
                g.drawRect(t.getBounds().getMinX(), t.getBounds().getMinY(), t.getBounds().getWidth(), t.getBounds().getHeight());
                g.setColor(Color.yellow);
                for (SmallTile st : t.getInnerTiles()) {
                    g.drawRect(st.getBounds().getMinX(), st.getBounds().getMinY(), st.getBounds().getWidth(), st.getBounds().getHeight());
                }
            }
        }
    }

    @Override
    public int getWidthInTiles() {
        return mapWidth;
    }

    @Override
    public int getHeightInTiles() {
        return mapHeight;
    }

    @Override
    public void pathFinderVisited(int x, int y) {
        visited[x][y] = true;
    }

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        return map[tx][ty].isBlocked();
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {
        return map[tx][ty].getMoveCost();
    }

}
