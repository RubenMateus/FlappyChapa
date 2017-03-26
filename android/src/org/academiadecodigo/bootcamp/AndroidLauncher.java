package org.academiadecodigo.bootcamp;

import android.os.Bundle;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
//        config.addIcon("chapaicon.png", Files.FileType.Internal);
		initialize(new FlappyChapa(), config);
	}
}
