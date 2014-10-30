/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class ImageArchive {

    //Tiles
    private static Image t9Grass;

    public static void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Tiles
        t9Grass = new Image("res/texture.png");
    }

//Tiles
    public static Image getT9Grass() {
        return t9Grass;
    }

}
