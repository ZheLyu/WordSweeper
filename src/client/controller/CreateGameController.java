package client.controller;


import xml.Message;
import client.model.Model;
import client.view.Application;

public class CreateGameController {

	Application app;
	Model model;

	public CreateGameController(Application app , Model model) {
<<<<<<< Upstream, based on branch 'master' of https://bzhao@fusion.wpi.edu/git/wordsweepvirgo/wordsweepvirgo.git
		this.app =app;
=======
		this.app = app;
>>>>>>> 252d0a7 each cell contains a random letter or "qu" as a pair
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<createGameRequest name='samplePlayer'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
				app.getServerAccess().sendRequest(m);
	}
}
