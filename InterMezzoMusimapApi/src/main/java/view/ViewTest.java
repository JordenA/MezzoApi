package view;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.apache.http.impl.io.ChunkedOutputStream;

import DNA.Chunk;
import DNA.InfluencedByChunk;

import java.util.List;

import musicData.Song;

public class ViewTest implements View {

	JFrame frame;
	JLabel textLabel; 
	JButton rightButton;
	JButton leftButton;
	public void createWindow() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create and set up the window. 
		textLabel.setPreferredSize(new Dimension(1300, 300));
		textLabel.setFont(new Font(textLabel.getFont().getName(), textLabel.getFont().getStyle(), 70));
		frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
		//Display the window
		frame.setLocationRelativeTo(null);
		frame.pack(); 
		frame.setVisible(true);
	} 

	public ViewTest() {
		frame = new JFrame("Simple GUI"); 
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//adding image to background
		BufferedImage myImage;
		try {
			myImage=ImageIO.read(new File("C:/Users/Tuval/Downloads/newBackground.png")); // CHANGE to get pic from the package
			frame.setContentPane(new ImagePanel(myImage));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); 
		rightButton = new JButton("text of right button");
		rightButton.setBounds(830,320,150,80);
		leftButton = new JButton("text of left button");
		leftButton.setBounds(530,320,150,80);
		frame.add(rightButton);
		frame.add(leftButton);
	}
	@Override
	public String[] getPickedArtists() {
		String[] arr1 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		String[] arr2= {"maroon 5", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};
		String[] toReturn = new String[20];
		changeLabelText("Who is your favorite artist?");
		for(int i = 0; i < toReturn.length ; i++) {
			changeButtonText(arr1[i], true);
			changeButtonText(arr2[i], false);
		}
		return null;
	}

	@Override
	public List<Song> playSongs(Song[] toPlay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSongs(Song[] toAssign) {
		// TODO Auto-generated method stub

	}
	
	private void changeLabelText(String newText) {
		if(frame != null && newText != null && textLabel != null) {
			textLabel.setText(newText);
		}
	}
	
	private void changeButtonText(String newText, boolean isRight) {
		//everything is there, nothing is null
		if(frame != null && newText != null) {
			//change the right button
			if(isRight) {
				if(rightButton != null) {
					rightButton.setText(newText);
				}
			}else {
				if(leftButton != null) {
					leftButton.setText(newText);
				}
			}
		}
	}
}
