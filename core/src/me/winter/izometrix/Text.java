package me.winter.izometrix;

public enum Text
{
	MENU_PLAY("Play", "Jouer"),
	MENU_RESUME("Resume", "Reprendre"),
	MENU_CREDIT("Credits", "Crédits"),
	MENU_SETTINGS("Settings", "Options"),
	MENU_QUIT("Quit Game", "Quitter"),
	
	DIRECTION_NORTH("North", "Nord"),
	DIRECTION_EAST("East", "Est"),
	DIRECTION_WEST("West", "Ouest"),
	DIRECTION_SOUTH("South", "Sud")
	;
	
	public static final int LANG_ENGLISH = 0;
	public static final int LANG_FRENCH = 1;
	public static final int LANG_JAPAN = 2;
	public static final int LANG_SPANISH = 3;
	
	private static int lang = 1;
	
	private String[] content;
	
	private Text(String... langs)
	{
		this.content = new String[4];
		
		for(int i = 0; i < content.length; i++)
		{
			if(langs == null)
			{
				this.content[i] = name().toLowerCase();
				continue;
			}
			
			if(langs.length <= i)
				this.content[i] = langs[0];
			else
				this.content[i] = langs[i];
		}
	}
	
	public String toString()
	{
		return this.content[lang];
	}
	
	public static void setLang(int lang)
	{
		if(lang < 0 || lang > 4)
			return;
		
		Text.lang = lang;
	}
	
	public static int getLang()
	{
		return lang;
	}
}
