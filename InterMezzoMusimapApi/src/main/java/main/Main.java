package main;

import model.Model;
import presenter.Presenter;
import test.Test;
import view.ConsoleView;
import view.View;

public class Main {

	public static void main(String[] args) {
		
		Model m = new Model();
		View v = new ConsoleView();
		Presenter p = new Presenter(v, m);
		p.run();
	}
	
	

}
