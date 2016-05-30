package me.winter.izometrix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public enum SoundEffect
{

	DING("ding.mp3", 1),
	;
	
	private final Sound sound;
	private final float soundVolume;
	
	private static float volume = 1.0f;
	
	SoundEffect(String name, float soundVolume)
	{
		this.sound = Gdx.audio.newSound(Gdx.files.internal(name));
		
		if(soundVolume > 1)
			this.soundVolume = 1;
		else
			this.soundVolume = soundVolume;
	}

	public void play()
	{
		this.sound.play(soundVolume * volume);
	}
	
	public void stop()
	{
		this.sound.stop();
	}

	public static float getVolume()
	{
		return volume;
	}

	public static void setVolume(float volume)
	{
		if(volume > 1)
			SoundEffect.volume = 1;
		else
			SoundEffect.volume = volume;
	}
	
	public static void dispose()
	{
		for(SoundEffect effect : values())
			effect.sound.dispose();
	}
}
