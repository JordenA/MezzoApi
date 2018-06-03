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

import javax.imageio.ImageIO;
import javax.swing.*;

import org.json.JSONObject;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;

import api.Api;
import api.Main;
import api.YoutubeApi;
import musicData.Song;




public class MyGui extends JFrame {  
/**	
	public static int countChoices=0;
	public static boolean youtubePlay=false;
	public static int likeCount=0;
	public static String[] likedSongsUID=new String[100]; // an array of strings containing the uid's of the songs the user liked
	public static int LikedSongsUIDcounter=0;

	//static int countChoices=0; // IF 10 - STOP
	public MyGui() throws IOException {	
	
		for(int arrcell=0;arrcell<100;arrcell++) // initialize the LikedSongsUID to null
		{
			likedSongsUID[arrcell]="-1";
		}
		
		//DESIGN//
		final JFrame f=new JFrame("InterMezzo"); //title
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); // begin with full screen 
		//background//   
		BufferedImage myImage;
		try {
			myImage=ImageIO.read(new File("C:/Users/Asnat/git/FinalInterMezzoafterMERGE/MezzoApi/InterMezzoMusimapApi/images/newBackground.png")); // CHANGE to get pic from the package
			f.setContentPane(new ImagePanel(myImage));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//end of background//
	    final JLabel l1; //choose an artist text 
	    l1=new JLabel("STEP 1: Please choose 20 artists");
	    l1.setBounds(585,250,500,80);  
	    l1.setFont(new Font("", Font.BOLD, 20));
	    l1.setForeground(Color.WHITE);
	    f.add(l1);  	  
	   
	    final JLabel l2; //like or dislike for song
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
	    
	    final JLabel l4; //when done choosing
	    l4=new JLabel("Press if you don't know this song");
	    l4.setBounds(300,210,600,300);  
	    l4.setFont(new Font("", Font.BOLD, 14));
	    l4.setForeground(Color.BLACK);
	    f.add(l4);  
	    l4.setVisible(false);
	    
	    
	    final Song s= api.Main.getSong(); //get song from Class Song

	    final JLabel DisplaySong; //choose an artist text 
	    DisplaySong=new JLabel(s.getSongName()+ " by " +s.getArtistName());
	    DisplaySong.setBounds(560,300,500,80);   
	    DisplaySong.setFont(new Font("", Font.BOLD, 20));
	    DisplaySong.setForeground(Color.BLACK);
	    f.add(DisplaySong);
	    DisplaySong.setVisible(false);
	    
	    final JLabel FitnessMessage;
	    FitnessMessage=new JLabel(Fitness.getFitnessAnswer());
	    FitnessMessage.setBounds(560,300,500,80);   
	    FitnessMessage.setFont(new Font("", Font.BOLD, 20));
	    FitnessMessage.setForeground(Color.BLACK);
	    f.add(FitnessMessage);
	    FitnessMessage.setVisible(false);

	 	
		//VARIABLES//
		final String[] arr1 = {"britney", "pink floyd", "david bowie", "katy perry", "bob marley", "the beatles", "bjork", "barry white", "edith piaf", "nirvana", "jimi hendrix", "justin bieber", "rihanna", "adele", "eminem", "cia", "shakira", "aqua", "prince", "taylor swift"};
		final String[] arr2= {"beyonce", "led zeppelin", "the rolling stones", "madonna", "michael jackson", "elton john", "frank sinatra", "louis armstrong", "ella fitzgerald", "aerosmith", "bob dylan", "justin timberlake", "lady gaga", "nicki minaj", "miley cyrus", "amy winehouse", "enrique iglesias", "spice girls", "elvis presley", "drake"};

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
		
	//PLAY SONG FROM YOUTUBE BUTTON//
		
		final JButton playSong=new JButton("Play on YOUTUBE");
		playSong.setBackground(Color.cyan);
		playSong.setBounds(350,380,150,80);
		f.add(playSong);
		playSong.setVisible(false);


		
		
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
						click.click(s);
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
						click.click(s);
					
    	            }  
    	        	});
				}
		
		//LAST BUTTONS//
		
		jbarr1[19].addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				String s=arr1[19];
				jbarr1[19].setVisible(false);
				jbarr2[19].setVisible(false);
				click.click(s); 
				l1.setVisible(false);//remove First step
				l2.setVisible(true); //show 2nd Step
				DisplaySong.setVisible(true);
				like.setVisible(true); dislike.setVisible(true); //show like and dislike buttons
				playSong.setVisible(true); 
				l4.setVisible(true);
			}
			
		});
		
		jbarr2[19].addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				String s=arr2[19];
				jbarr1[19].setVisible(false);
				jbarr2[19].setVisible(false);
				click.click(s);
				l1.setVisible(false);//remove First step
				l2.setVisible(true);//show 2nd Step
				DisplaySong.setVisible(true);
				like.setVisible(true); dislike.setVisible(true); //show like and dislike buttons
				playSong.setVisible(true);
				l4.setVisible(true);
				
				
			}
		});
		
		//LIKE&DISLIKE LISTENERS//
		//Song is initially LIKE - change it if the user press dislike
		
		dislike.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				
				Main.updatelike(false);	// update DISLIKE to this song
				Song s= Main.getSong(); ////get next song
				if (countChoices==9) // if we got to end of the song list
				{
					l3.setVisible(true);
					DONE.setVisible(true);
				}
				DisplaySong.setText(s.getSongName()+ " by " +s.getArtistName()); //show the song you got				
			}
		});
		
		like.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				
				Main.updatelike(true);	// update LIKE to this song
				Song s= Main.getSong(); ////get next song + do
				if (countChoices==9) // if we got to end of the song list
				{
					l3.setVisible(true);
					DONE.setVisible(true);

				}
				DisplaySong.setText(s.getSongName()+ " by " +s.getArtistName()); //show the song you got			
			}
		});
		
		DONE.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 			
				dislike.setVisible(false);
				like.setVisible(false);
				DisplaySong.setVisible(false);
				l2.setVisible(false);
				FitnessMessage.setText("Fitness result is: "+Fitness.getFitnessAnswer());
				FitnessMessage.setVisible(true);
				DONE.setVisible(false);
				l3.setVisible(false);
				playSong.setVisible(false);
				l4.setVisible(false);
				
			}
		});
		

		
		
		playSong.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 			
				try {
					api.YoutubePlay.playYoutube(Main.getSong().getSongName(),Main.getSong().getArtistName());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	
		
	

		}
		
		 **/

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












