package view;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.Main;
import musicData.Song;
import textReader.SongReader;





public class MyGui implements View{ 
	final JFrame f=new JFrame("InterMezzo"); //title
	JLabel l1;
	JLabel l2;
	JLabel DisplaySong=new JLabel("display songs");
	
	public String[] PickedArtists; // Saves the favorite 20 artists from the First step
	public int PickedArtistsCounter;	
	public Song[] songArr; // plays 10 songs for the Generation
	public int songArrCounter;
	List<Song> LikedSongs; //Saves the Songs the user liked
	boolean readyToReturn;

	
	public void setSongs(Song[] toAssign) {
		for(int i = 0; i < toAssign.length ; i++ ) {
			songArr[i] = toAssign[i];
		}
		
	}
public MyGui() throws IOException {	
		
	final String[] arr1 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
	final String[] arr2= {"maroon 5", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};
	PickedArtists=new String[20];
	PickedArtistsCounter=0;
	songArr=new Song [10];
	songArrCounter=0;
	LikedSongs = new LinkedList<>();
	readyToReturn = false;
	
	
		//final String[]arr1=createArr1OfArtists();
		//final String[]arr2=createArr2OfArtists();
		//System.out.println(arr1[3]); //TEST
		
	
	
		//DESIGN//
//		final JFrame f=new JFrame("InterMezzo"); //title
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); // begin with full screen 
		//background//   
		BufferedImage myImage;
		try {
			myImage=ImageIO.read(new File("C:/Users/Tuval/Downloads/newBackground.png")); // CHANGE to get pic from the package
			f.setContentPane(new ImagePanel(myImage));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//end of background//
		
	    //choose an artist text 
	    l1=new JLabel("STEP 1: Please choose 20 artists");
	    l1.setBounds(585,250,500,80);  
	    l1.setFont(new Font("", Font.BOLD, 20));
	    l1.setForeground(Color.WHITE);
	    f.add(l1);  	  
	    f.add(DisplaySong);
	    //like or dislike for song
	    l2=new JLabel("STEP 2: What do you think about this song?");
	    l2.setBounds(555,250,500,80);  
	    l2.setFont(new Font("", Font.BOLD, 18));
	    l2.setForeground(Color.WHITE);
	    f.add(l2);  
	    l2.setVisible(false);
	    
	    final JLabel l3; //when done choosing
	    l3=new JLabel("Please choose LIKE or DISLIKE for this last song and than click DONE");
	    l3.setBounds(470,340,600,300);  
	    l3.setFont(new Font("", Font.BOLD, 18));
	    l3.setForeground(Color.BLACK);
	    f.add(l3);  
	    l3.setVisible(false);
    	    	 	
	
		final JButton like=new JButton("LIKE");
		final JButton dislike=new JButton("DISLIKE");
		like.setBackground(Color.GREEN);
		dislike.setBackground(Color.red);
		like.setBounds(530,380,150,80);
		dislike.setBounds(830,380,150,80);
		f.add(like); f.add(dislike);
		like.setVisible(false); dislike.setVisible(false);
		
		final JButton DONE=new JButton("DONE!");
		DONE.setBackground(Color.cyan);
		DONE.setBounds(670,540,150,80);
		f.add(DONE);
		DONE.setVisible(false);
		
		final JButton startOver=new JButton("Start Over!");
		startOver.setBackground(Color.cyan);
		startOver.setBounds(670,540,150,80);
		f.add(startOver);
		startOver.setVisible(false);
		
		//Create 40 buttons - 20 for arr1 and 20 for arr2
		final JButton[] jbarr1=new JButton[20]; //define 20 buttons for arr1
		for (int i=0;i<20;i++)
			{
				jbarr1[i]=new JButton(arr1[i]); //buttons name as in the arr1
				jbarr1[i].setBounds(530,320,150,80); //button size and location on screen
			}
    
		final JButton[] jbarr2=new JButton[20]; //define 20 buttons for arr2
		for (int i=0;i<20;i++)
			{
				jbarr2[i]=new JButton(arr2[i]); //buttons name as in the arr2
				jbarr2[i].setBounds(830,320,150,80);//button size and location on screen
				
			}

   
		//Before starting - add the first 2 buttons to the screen
		f.add(jbarr1[0]); 
		f.add(jbarr2[0]);
		f.setVisible(true); 
		//first buttons added to screen
		
		//LISTENERS//
		
		//create 20 listeres for JBarr1
    
		
		for (int i=0;i<19;i++)
			{
				final int x=i;
				jbarr1[i].addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
					
						String s=arr1[x]; //button holds the artist's name
						jbarr1[x].setVisible(false); //when clicked - Remove this button from the screen
						jbarr2[x].setVisible(false); //and also remove the button next to him (the artist from the other array)
						f.add(jbarr1[x+1]); //show the next button holding the next artist from THIS array
						f.add(jbarr2[x+1]); //show the next button holding the next artist from the OTHER arrat
						PickedArtists[PickedArtistsCounter]=arr1[x];
						System.out.println("the picked artist is " + PickedArtists[PickedArtistsCounter]);
						PickedArtistsCounter++;
					}  
					}); 
    	
			}
		
		for (int i=0;i<19;i++)
			{
				final int x=i;
				jbarr2[i].addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){ 
					
						String s=arr2[x];
						jbarr1[x].setVisible(false);
						jbarr2[x].setVisible(false);
						f.add(jbarr1[x+1]);
						f.add(jbarr2[x+1]);
						PickedArtists[PickedArtistsCounter]=arr2[x];
						System.out.println("the picked artist is " + PickedArtists[PickedArtistsCounter]);
						PickedArtistsCounter++;
					
    	            }  
    	        	});
				}
		
		//LAST BUTTONS//
		
		jbarr1[19].addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				String s=arr1[19];
				jbarr1[19].setVisible(false);
				jbarr2[19].setVisible(false);
				PickedArtists[PickedArtistsCounter]=arr1[19];
				PickedArtistsCounter++;
				readyToReturn = true;
				//DisplaySong(); //Start running Songs
				like.setVisible(true); dislike.setVisible(true); //show like and dislike buttons

			}
			
		});
		
		jbarr2[19].addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				String s=arr2[19];
				jbarr1[19].setVisible(false);
				jbarr2[19].setVisible(false);
				PickedArtists[PickedArtistsCounter]=arr2[19];
				PickedArtistsCounter++;
				readyToReturn = true;
				//DisplaySong();  //Start running Songs
				like.setVisible(true); dislike.setVisible(true); //show like and dislike buttons
				


				
				
				
			}
		});
		
		//LIKE&DISLIKE LISTENERS//
		//Song is initially LIKE - change it if the user press dislike
		
		dislike.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				System.out.println(songArr[songArrCounter]);
				songArr[songArrCounter].setLike(false); // UPDATE DISLIKE
				songArrCounter++;
				if (songArrCounter==9) // if we got to end of the song list
				{
					l3.setVisible(true);
					DONE.setVisible(true);
				}
				if (songArrCounter<=9)
				DisplaySong.setText(songArr[songArrCounter].getSongName()+ " by " +songArr[songArrCounter].getArtistName()); //show the song you got				
			}
		});
		
		like.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				songArr[songArrCounter].setLike(true); // UPDATE DISLIKE
				LikedSongs.add(songArr[songArrCounter]);
				songArrCounter++;				
				
				if (songArrCounter==9) // if we got to end of the song list
				{
					l3.setVisible(true);
					DONE.setVisible(true);

				}
				if (songArrCounter<=9)
				DisplaySong.setText(songArr[songArrCounter].getSongName()+ " by " +songArr[songArrCounter].getArtistName()); //show the song you got			
			}
		});
		
		DONE.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				dislike.setVisible(false);
				like.setVisible(false);
				DisplaySong.setVisible(false);
				l2.setVisible(false);
				DONE.setVisible(false);
				l3.setVisible(false);
//				startOver.setVisible(true);
				
				for (int i=0;i<LikedSongs.size();i++) //CHECK
				{
					System.out.println(LikedSongs.get(i).getSongName());
				}
				
	
				
			}
		});
		
//		startOver.addActionListener(new ActionListener(){  
//			public void actionPerformed(ActionEvent e){ 
//				newMain.stage=2;
//				DisplaySong();
//				songArrCounter=0;
//				like.setVisible(true); dislike.setVisible(true);
//	
//				
//			}
//		});
//		

	
		
	

		}	
	
	/**
	//FUNCTIONS//
	public void GetSongsFromMain() { // Main??
		newMain.sendSongsToGui();
		Song[]play=new Song[10];
		play=newMain.songsToPlay;
		playSongs(play);
	}
	
	**/
	
	@Override
	public String[] getPickedArtists() {
		String[] arr1 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		String[] arr2= {"maroon 5", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};
		
		while(!readyToReturn) {
			
		}
		return PickedArtists;
	}
	
	@Override
	public List<Song> playSongs(Song[] toPlay) { //Creates 10 songs to the user and return the a list of songs the user liked 
		songArr=toPlay;
		
		if (songArrCounter==9)		
		return LikedSongs;
		else
		return null;
	}
	
	
	public String[] createArr1OfArtists() {
		String[]arr= {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		return arr;		
	}
	public String[] createArr2OfArtists() {
		String[] arr= {"beyonce", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};

		return arr;		
	}
	
	public void DisplaySong() {
		//GetSongsFromMain(); //Create 10 songs and start func
		l1.setVisible(false);//remove First step
		l2.setVisible(true);//show 2nd Step
		System.out.println("song counter is " + songArrCounter);
		
	    DisplaySong.setText(songArr[songArrCounter].getSongName()+ " by " +songArr[songArrCounter].getArtistName());
	    DisplaySong.setBounds(560,300,500,80);   
	    DisplaySong.setFont(new Font("", Font.BOLD, 20));
	    DisplaySong.setForeground(Color.BLACK);
	    DisplaySong.setVisible(true);
		
	}
	
	
	
		
	
	


}




//FOR THE BACKGROUND//
class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    

    	
    }












