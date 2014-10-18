
package control;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Game extends StateBasedGame {
    
    public static final int PLAYSTATE = 0;
    
    private PlayState playState;
    
    public static void main(String[] args) throws SlickException {
        System.setProperty("org.lwjgl.opengl.Display.enableHighDPI", "true");
        AppGameContainer app = new AppGameContainer(new Game("Game"));
        app.setTargetFrameRate(60);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        System.out.println(screenSize);
        app.setDisplayMode(screenSize.width, screenSize.height, true);
        app.setVerbose(true);
        app.setShowFPS(true);
        app.start();
    }

    public Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new PlayState(PLAYSTATE));
        
        getState(PLAYSTATE).init(container, this);
        
        enterState(PLAYSTATE);
    }

}
