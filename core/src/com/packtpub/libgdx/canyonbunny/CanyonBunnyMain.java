package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CanyonBunnyMain extends ApplicationAdapter {
	private static final String TAG = CanyonBunnyMain.class.getName();
	
	
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;
	
	@Override
	public void create () {
		//Set Libgdx Log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		//Initialize controller and renderer
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		
		//Game world is active on start
		paused = false;
	}

	@Override
	public void render () {	
		//Do not update game world when paused
		if (!paused) {
			//Update game world by the time that has passed since the last frame
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		
		//Sets the clear screen color to: Cornflower blue
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		
		//clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Render the game world to screen
		worldRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		worldRenderer.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
		paused = true;
	}

	@Override
	public void resume() {
		super.resume();
		paused = false;
	}

	@Override
	public void dispose() {
		super.dispose();
		worldRenderer.dispose();
	}
}
