package org.academiadecodigo.bootcamp.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.FlappyChapa;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyChapa.WIDTH;
		config.height = FlappyChapa.HEIGHT;
		config.title = FlappyChapa.TITLE;
		config.addIcon("icons/chapaicon.png", Files.FileType.Internal);
		config.addIcon("icons/chapaicon1.png", Files.FileType.Internal);
        config.addIcon("icons/chapaicon2.png", Files.FileType.Internal);
		new LwjglApplication(new FlappyChapa(), config);
	}
}
