/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 *
 * @author PK
 */
public class InputReceiver {

    private Input input;

    public InputReceiver() {
    }

    public void reactToInput(GameContainer container, int delta) {
        input = container.getInput();
        universalInput(container);
    }

    private void universalInput(GameContainer container) {
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
    }

}
