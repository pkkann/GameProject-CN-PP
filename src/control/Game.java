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
    public InputReceiver inputReceiver;

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("Game"));
        app.setTargetFrameRate(60);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        app.setDisplayMode(screenSize.width, screenSize.height, true);
        app.setVerbose(true);
        app.setShowFPS(true);
        app.start();
    }

    public Game(String name) throws SlickException {
        super(name);
        inputReceiver = new InputReceiver();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        initControl(container, this);

        addState(new PlayState(PLAYSTATE, this));

        getState(PLAYSTATE).init(container, this);

        enterState(PLAYSTATE);
    }

    public void initControl(GameContainer container, StateBasedGame game) throws SlickException {
        ImageArchive.init(container, game);
    }

}
