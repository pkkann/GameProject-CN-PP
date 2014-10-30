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
    private static Tile[][] map;
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
        drawMap(container, game, g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    /*
     Creates the amount of tiles specified by mapHeight and mapWidth in the tileSize.
     */
    private void populateTileMap() {
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                map[x][y] = new GrassTile(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
            }
        }
        map[5][5].setId(2);
        map[6][5].setId(2);
        map[6][6].setId(2);
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                map[x][y].chooseTexture();
            }
        }
    }

    /*
     Draws the map as a grid for testing purposes.
     */
    public void drawMap(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                g.setColor(Color.white);
                Tile t = map[x][y];
                t.render(container, game, g);
                g.drawRect(t.getBounds().getMinX(), t.getBounds().getMinY(), t.getBounds().getWidth(), t.getBounds().getHeight());
                g.setColor(Color.yellow);
                for (SmallTile st : t.getInnerTiles()) {
                    //g.drawRect(st.getBounds().getMinX(), st.getBounds().getMinY(), st.getBounds().getWidth(), st.getBounds().getHeight());
                }
            }
        }
    }

    public static int[] getSurroundingTiles(int x, int y) {
        int[] surrounding = new int[4];
        try {
            surrounding[0] = surroundingTile(x, y - 1);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            surrounding[0] = -1;
        }
        try {
            surrounding[1] = surroundingTile(x - 1, y);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            surrounding[1] = -1;
        }
        try {
            surrounding[2] = surroundingTile(x + 1, y);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            surrounding[2] = -1;
        }
        try {
            surrounding[3] = surroundingTile(x, y + 1);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            surrounding[3] = -1;
        }
        for (int i : surrounding) {
            System.out.println(i);
        }
        return surrounding;
    }

    private static int surroundingTile(int x, int y) {
        switch (map[x][y].getId()) {
            case 1:
                return 1;
            case 2:
                return 2;
        }
        return -1;
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
