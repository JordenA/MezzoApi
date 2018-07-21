package main;

import model.Model;
import presenter.Presenter;
import test.Test;
import textReader.MoodReader;
import view.ConsoleView;
import view.MyGui;
import view.View;
import view.ViewTest;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		Model m = new Model();
		try {
		View v = new ConsoleView();
			Presenter p = new Presenter(v, m);
			p.run();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		 **/
		//MoodReader mr = new MoodReader();
		//mr.readChunk(strToRead);
		
		ViewTest vv = new ViewTest();
		vv.createWindow();
		Thread.sleep(4000);
		vv.getPickedArtists();
	}
	
	

}
