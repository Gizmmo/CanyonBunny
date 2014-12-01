package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;
	
	
	public WorldRenderer(WorldController worldController) {
		super();
		this.worldController = worldController;
	}
	
	@Override
	public void dispose() {
		
	}
	
	
}
