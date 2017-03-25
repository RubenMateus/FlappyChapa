package org.academiadecodigo.bootcamp.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.FlappyChapa;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyChapa.WIDTH;
		config.height = FlappyChapa.HEIGHT;
		config.title = FlappyChapa.TITLE;
		new LwjglApplication(new FlappyChapa(), config);
	}
}
