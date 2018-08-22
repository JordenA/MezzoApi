package main;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import musicData.Song;
import presenter.Presenter;
import test.Test;
import textReader.MoodReader;
import view.ConsoleView;
import view.MyGui;
import view.View;
import view.NewGui;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		
		Model m = new Model();
		try {
		View v = new ConsoleView();
			Presenter p = new Presenter(v, m);
			p.run();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
	
		/**
		Song[]test=new Song[3]; //song Example
		test[0]=new Song("a","a3","a2",true,false);
		test[1]=new Song("b","b2","b3",true,false);
		test[2]=new Song("c","c2","c3",true,false);
		
		Song[]test1=new Song[3]; //song Example
		test1[0]=new Song("a11","a113","a112",true,false);
		test1[1]=new Song("b11","b112","b113",true,false);
		test1[2]=new Song("c11","c211","c311",true,false);
		
		List<Song> l1=new ArrayList<Song>(); //res example for playsongs
		List<Song> l2=new ArrayList<Song>(); //res example for playsongs
	**/
		
		/**
		//MoodReader mr = new MoodReader();
		//mr.readChunk(strToRead);
		NewGui vv = new NewGui();
		vv.createWindow();
		vv.getPickedArtists();
		//l1=vv.playSongs(test);
		//l2=vv.playSongs(test1);
		**/

	
		
		
//		Thread.sleep(4000);
//		vv.getPickedArtists();
	}
	
	

}
