package controller;


public interface IPanelComponent {
	
	
	public PlayingFieldController getPlayingFieldController();
	public void setField(IButtonPlayingfield[] field);
	public IButtonPlayingfield[] getField();
}
