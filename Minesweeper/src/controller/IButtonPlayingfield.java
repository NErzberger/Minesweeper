package controller;

import javax.swing.ImageIcon;

import view.Imagetype;

public interface IButtonPlayingfield {

	public void executeButtonInController(PlayingFieldController pf);
	public void executeRightClick(PlayingFieldController pf);
	public boolean isPressed();
	public void setPressed(boolean pressed);
	public void setImage(Imagetype type, int width, int height);
	public String getValueButton();
	public void setValueButton(String valueButton);
	public boolean isFlag();
	public void setFlag(boolean isFlag);
	public void setBackground(int r, int g, int b);
	public void setText(String text);
	public int getButtonId();
	public void setButtonId(int buttonId);
	// Icon ist JavaSwing
	public void setIconMS(ImageIcon icon);
}
