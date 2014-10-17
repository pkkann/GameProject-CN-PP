
package control;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Game extends StateBasedGame {
    
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("Game"));
        app.setTargetFrameRate(60);
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        
    }

}
