
package control;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class PlayState extends BasicGameState {
    
    private int id;
    private Game ga;
    
    public PlayState(int id, Game ga) {
        this.id = id;
        this.ga = ga;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, container.getWidth(), container.getHeight());
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        ga.inputReceiver.reactToInput(container, delta);
    }

}
