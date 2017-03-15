package org.academiadecodigo.bootcamp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.FlappyBird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyBird.WIDTH;
		config.height = FlappyBird.HEIGHT;
		config.title = FlappyBird.TITLE;
		new LwjglApplication(new FlappyBird(), config);
	}
}
