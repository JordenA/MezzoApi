package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.apache.http.impl.io.ChunkedOutputStream;

import DNA.Chunk;
import DNA.InfluencedByChunk;

import java.util.ArrayList;
import java.util.List;

import musicData.Song;

public class NewGui implements View {

	JFrame frame;
	JLabel textLabel; 
	JLabel displaySong;
	JButton rightButton;
	JButton leftButton;
	public int counter=0; // regular counter for all structures needed
	public boolean isRightButtonClicked=false; // indicates you pressed on the right button
	public boolean isLeftButtonClicked=false; // indicates you pressed on the left button
	public boolean isLiked=false; // saves whether a song was liked or disliked
	
	String []Artistshelper=new String[20]; //holds selected artists
	int helperCounter=0; // counter for the selected artists
	boolean EndOfArtist=false; // end of stage one - choosing artists
	boolean StartOfSongs=false; // start of stage two - choosing songs
	boolean EndOfSongs=false; // end of stage two - choosing songs
	List<Song> SongList; // holds a the list of songs


	public void createWindow() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create and set up the window. 
		textLabel.setPreferredSize(new Dimension(500, 300));
		textLabel.setFont(new Font(textLabel.getFont().getName(), textLabel.getFont().getStyle(), 70));
		frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
		//Display the window
		frame.setLocationRelativeTo(null);
		frame.pack(); 
		frame.setVisible(true);
	} 

	public NewGui() {
		frame = new JFrame("INTERMEZZO"); 
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//adding image to background
		BufferedImage myImage;
		try {
			myImage=ImageIO.read(new File("C:/Users/Asnat/git/FinalInterMezzoafterMERGE/MezzoApi/InterMezzoMusimapApi/images/newBackground.png")); // CHANGE to get pic from the package
			frame.setContentPane(new ImagePanel(myImage));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	

		textLabel = new JLabel("JLABEL",SwingConstants.CENTER); 
		textLabel.setBounds(585,200,300,80);  
		textLabel.setFont(new Font("",Font.PLAIN, 15));
		textLabel.setForeground(Color.WHITE);
	
		rightButton = new JButton("text of right button");
		rightButton.setBounds(830,320,150,80);
		leftButton = new JButton("text of left button");		
		leftButton.setBounds(530,320,150,80);
		
	
		rightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				isRightButtonClicked=true;
				isLeftButtonClicked=false;
				
				if(EndOfArtist==false) //bool for end of 1st stage - Artists pick
				{
				artistChosen();
				counter++;
				}
				
				if (StartOfSongs==true) { // bool for start of 2nd stage - songs pick
					isLiked=true;
					songChosen();
					counter++;
					
					
				}


				
				
			}
			
		});		
		
		leftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				isRightButtonClicked=false;
				isLeftButtonClicked=true;
				
				if(EndOfArtist==false)
				{
				artistChosen();
				counter++;
				}
				
				if (StartOfSongs==true) { // bool for start of 2nd stage - songs pick
					isLiked=false;
					songChosen();
					counter++;
					
				}
				
			}
			
		});	

		
		frame.add(rightButton);
		frame.add(leftButton);
		rightButton.setVisible(false);
		leftButton.setVisible(false);
	}
	@Override
	public String[] getPickedArtists() {
		rightButton.setVisible(true);
		leftButton.setVisible(true);
		String[] arr1= {"maroon 5", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake","end"};
		String[] arr2 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift","end"};
		String[]toReturn=new String[20];
		changeLabelText("please choose an artist:");
	
		while(counter<=20) {
			changeButtonText(arr1[counter], true); 
			changeButtonText(arr2[counter], false);	
			if (EndOfArtist==true)
				break;
			}
		
		for (int i=0;i<toReturn.length;i++)
		{
			toReturn[i]=(Artistshelper[i]);
		}
		
	
		return toReturn;
	}

	@Override
	public List<Song> playSongs(Song[] toPlay) { // returns List of songs All songs + indication field if user liked to songs or not
		StartOfSongs=true; // bool  - start this stage
		EndOfSongs=false;
		SongList=new ArrayList<Song>();
		
		setSongs(toPlay);
		
		changeLabelText("do you like the song?");
		changeButtonText("LIKE", true); 
		changeButtonText("DISLIKE", false);	
		counter=0; helperCounter=0;
		rightButton.setBounds(830,500,150,80);		
		leftButton.setBounds(530,500,150,80);
		rightButton.setVisible(true);
		leftButton.setVisible(true);
		
		displaySong = new JLabel("hey",SwingConstants.CENTER); 
		displaySong.setBounds(585,320,300,80);  
		displaySong.setFont(new Font("",Font.PLAIN, 15));
		displaySong.setForeground(Color.WHITE);
		displaySong.setVisible(true);
		
		frame.add(displaySong);
		
	
		
		while(counter<SongList.size()) {
			changeSongPick(toPlay[counter].getSongName(),toPlay[counter].getArtistName());	//show song
			if (counter==SongList.size()) //end of songs to play
			{
				// SongLise ended. Initialize variables for the next loops.
				EndOfSongs=true;
				displaySong.setVisible(false);	
				counter=0; helperCounter=0;
				rightButton.setVisible(false);
				leftButton.setVisible(false);
				displaySong.setVisible(false);
				
				
				break;
			}
		}
			

		return SongList;
		
	}

	@Override
	public void setSongs(Song[] toAssign) {
		for(int i=0;i<toAssign.length;i++) {
			SongList.add(toAssign[i]);
		}
		
	}

	
	public void artistChosen()
	{
				
		if (isRightButtonClicked==true && isLeftButtonClicked==false) {
			Artistshelper[counter]=rightButton.getText();	
		}
		if (isRightButtonClicked==false && isLeftButtonClicked==true) {
			Artistshelper[counter]=leftButton.getText();					
		}
	}
	
	public void songChosen()
	{
				
		if (isLiked==true){
			SongList.get(counter).setLike(true);		
		}
		else
			SongList.get(counter).setLike(false);
		
		
			

	}

	
	private void changeLabelText(String newText) {
		if(frame != null && newText != null && textLabel != null) {
			textLabel.setText(newText);
			textLabel.setFont(new Font("", Font.BOLD, 20));
		}
	}
	
	private void changeButtonText(String newText, boolean isRight) {
		if (newText=="end") {
			rightButton.setVisible(false);
			leftButton.setVisible(false);
			EndOfArtist=true;
	}
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
		private void changeSongPick(String song, String artist) {
		
			//everything is there, nothing is null
			if(frame != null && song != null && artist !=null) {
				displaySong.setText(song+" by "+artist);				
			}
		
		
	
	}

}
