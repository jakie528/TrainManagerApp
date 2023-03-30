// --== CS400 Project two File Header ==--
// Name: Ziqi Liao
// CSL Username: zliao
// Email: zliao47@wisc.edu
// Lecture #: Section 3: MoWeFr 1:20PM - 2:10PM, Florian Heimerl
// Notes to Grader: FrontendDeveloper implementations

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provide a text-based user interface to the searching capaibilities of the
 * TrainManagerApp.
 * 
 * @author Ziqi Liao 
 */
public class TrainManagerFD implements TrainManagerFDInterface {

	private Scanner userInput;
	private TrainManagerBDInterface backend;

	public TrainManagerFD(Scanner userInput, TrainManagerBDInterface backend) {
		this.userInput = userInput;
		this.backend = backend;
	}

	/**
	 * This method is responsible for running the main command loop of the Train
	 * Schedule Application. It uses a while loop to repeatedly prompt the user for
	 * a command, and then uses a switch statement to execute the corresponding
	 * method based on the user's input. If an invalid command is entered, the
	 * method displays an error message and prompts the user again.
	 */
	@Override
	public void runCommandLoop() {
		while (true) {
			char command = mainMenuPrompt();
			switch (command) {
			case 'S':
				loadDataCommand();
				searchCommand();
				break;
			case 'A':
				addTrainPrompt();
				break;
			case 'R':
				removeTrainPrompt();
				break;
			case 'T':
				displayStatsCommand();
				break;
			case 'Q':
				return;
			default:
				System.out.println("Invalid command. Please try again.");
			}
		}
	}

	/**
	 * This method is called when the user chooses to add a train to the schedule.
	 * It prompts the user for the cargo, destination, departure time, and arrival
	 * time of the train, creates a new Train object with this information, and adds
	 * it to the backend object (which represents the backend data store).
	 */
	private void addTrainPrompt() {
		System.out.print("Enter train cargo: ");
		String cargo = userInput.nextLine().trim();
		System.out.print("Enter train destination: ");
		String destination = userInput.nextLine().trim();
		System.out.print("Enter train departure time: ");
		String departureTime = userInput.nextLine().trim();
		System.out.print("Enter train arrival time: ");
		String arrivalTime = userInput.nextLine().trim();

		Train train = new Train(cargo, destination, departureTime, arrivalTime);
		backend.addTrain(train);
		System.out.println("Train added to schedule.");

	}

	/**
	 * This method is called when the user chooses to search for a train. It prompts
	 * the user for one or more search words, and then uses a switch statement to
	 * determine what type of search to perform (based on the first search word
	 * entered). It then calls the appropriate search method (e.g.
	 * searchDestination() if the user entered "d" as the first search word).
	 */
	public void searchCommand() {
		List<String> words = chooseSearchWordsPrompt();
		if (words.isEmpty()) {
			System.out.println("Please enter at least one search word.");
		} else {
			char searchType = words.remove(0).toLowerCase().charAt(0);
			switch (searchType) {
			// search for the latest train on the schedule.
			case 't':
				words = chooseSearchWordsPrompt();
				searchLatestTrain(words);
				break;
			// search for the train by its destination
			case 'd':
				words = chooseSearchWordsPrompt();
				searchDestination(words);
				break;
			// search for the train by its cargo.
			case 'c':
				words = chooseSearchWordsPrompt();
				searchCargo(words);
				break;
			// search for the train by its arrival time.
			case 'a':
				words = chooseSearchWordsPrompt();
				searchArrivaltime(words);
				break;
			// search for the train by its departure time.
			case 'p':
				words = chooseSearchWordsPrompt();
				searchDeparturetime(words);
				break;
			default:
				System.out.println("Invalid search type. Please try again.");
			}
		}
	}

	/**
	 * This method is responsible for displaying the main menu of the Train Schedule
	 * Application and prompting the user for a command. It uses the System.out
	 * object to display a list of commands (including a brief description of each),
	 * and then reads the user's input using the userInput.nextLine() method. It
	 * returns the first character of the user's input (converted to uppercase).
	 */
	public char mainMenuPrompt() {
		System.out.println("Welcome to the Train Schedule Application:");
		System.out.println("Choose a command from the list below:");
		System.out.println("\"S\"- search for trains:");
		System.out.println("> -t search for the latest train on the schedule.");
		System.out.println("> -d search for the train by its destination.");
		System.out.println("> -c search for the train by its cargo.");
		System.out.println("> -a search for the train by its arrival time.");
		System.out.println("> -p search for the train by its departure time.");
		System.out.println("\"A\"- add Train to the schedule.");
		System.out.println("\"R\"- remove Train from the schedule.");
		System.out.println("\"T\"- show the Train schedule.");
		System.out.println("\"Q\"- exits the application.");
		System.out.print("Enter your choice: ");
		return userInput.nextLine().toUpperCase().charAt(0);
	}

	/**
	 * reads a filename from user input, attempts to load the data from the backend
	 * using that filename, and then prints a success or error message depending on
	 * the outcome.
	 */
	@Override
	public void loadDataCommand() {
		String filename = userInput.nextLine().trim();
		try {
			backend.loadData(filename);
			System.out.println("Train schedule loaded successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not find train schedule file.");
		} catch (Exception e) {
			System.out.println("Error: Could not load train schedule.");
		}
	}

	/**
	 * prompts the user to enter search words, reads the input, splits it into
	 * individual words, adds non-empty words to a list, and returns the list of
	 * search words.
	 */
	@Override
	public List<String> chooseSearchWordsPrompt() {
		System.out.println("Please enter search words:");
		String input = userInput.nextLine().trim().toLowerCase();
		String[] words = input.split("\\s+");
		List<String> searchWords = new ArrayList<>();
		for (String word : words) {
			if (!word.isEmpty()) {
				searchWords.add(word);
			}
		}
		return searchWords;
	}

	/**
	 * prompts the user to enter a train ID, creates a Train object with that ID,
	 * attempts to remove it from the backend, and then prints a success or error
	 * message depending on the outcome. It uses the removeTrain() method of the
	 * backend to remove the train.
	 */
	private void removeTrainPrompt() {

		System.out.print("Enter train ID to remove: ");
		String id = userInput.nextLine().trim().toLowerCase();
		Train train = new Train(id, id, id, id);
		Train removedTrain = backend.removeTrain(train);
		if (removedTrain != null) {
			System.out.println("Train removed from schedule.");
		} else {
			System.out.println("Train with ID " + id + " not found in schedule.");
		}
	}

	/**
	 * takes a list of search words, passes them to the backend's
	 * nextTrainAfterTime() method, which returns a list of Train objects
	 * representing the latest trains departing after the current time. The method
	 * prints the results or a "no matches found" message if the list is empty.
	 * 
	 * @param words
	 */
	public void searchLatestTrain(List<String> words) {
		List<Train> ls = new ArrayList<Train>();
		ls.add(backend.nextTrainAfterTime(words.toString()));

		int resultIndex = 1;
		if (ls.size() > 0)
			System.out.println("Found Results:");
		else
			System.out.println("No matches found.");
		for (Train result : ls)
			System.out.println("[" + (resultIndex++) + "] " + result.toString());
	}

	/**
	 * The searchArrivaltime() method takes a list of search words, passes them to
	 * the backend's nextTrainBeforeTime() method, which returns a list of Train
	 * objects representing the trains arriving before the current time. The method
	 * prints the results or a "no matches found" message if the list is empty.
	 */

	public void searchArrivaltime(List<String> words) {
		List<Train> ls = new ArrayList<Train>();
		ls.add(backend.nextTrainBeforeTime(words.toString()));

		int resultIndex = 1;
		if (ls.size() > 0)
			System.out.println("Found Results:");
		else
			System.out.println("No matches found.");
		for (Train result : ls)
			System.out.println("[" + (resultIndex++) + "] " + result.toString());

	}

	/**
	 * The searchDestination() method takes a list of search words, passes them to
	 * the backend's nextTrainToDestination() method, which returns a list of Train
	 * objects representing the trains going to the specified destination. The
	 * method prints the results or a "no matches found" message if the list is
	 * empty.
	 */
	public void searchDestination(List<String> words) {
		List<Train> ls = new ArrayList<Train>();
		ls.add(backend.nextTrainToDestination(words.toString()));

		int resultIndex = 1;
		if (ls.size() > 0)
			System.out.println("Found Results:");
		else
			System.out.println("No matches found.");
		for (Train result : ls)
			System.out.println("[" + (resultIndex++) + "] " + result.toString());
	}

	/**
	 * The searchCargo() method takes a list of search words, passes them to the
	 * backend's nextTrainByCargo() method, which returns a list of Train objects
	 * representing the trains carrying the specified cargo. The method prints the
	 * results or a "no matches found" message if the list is empty.
	 */

	public void searchCargo(List<String> words) {
		List<Train> ls = new ArrayList<Train>();
		ls.add(backend.nextTrainByCargo(words.toString()));

		int resultIndex = 1;
		if (ls.size() > 0)
			System.out.println("Found Results:");
		else
			System.out.println("No matches found.");
		for (Train result : ls)
			System.out.println("[" + (resultIndex++) + "] " + result.toString());

	}

	/**
	 * The searchDeparturetime() method takes a list of search words, passes them to
	 * the backend's nextTrainAfterTime() method, which returns a list of Train
	 * objects representing the trains departing after the current time. The method
	 * prints the results or a "no matches found" message if the list is empty.
	 */
	public void searchDeparturetime(List<String> words) {
		List<Train> ls = new ArrayList<Train>();
		ls.add(backend.nextTrainAfterTime(words.toString()));

		int resultIndex = 1;
		if (ls.size() > 0)
			System.out.println("Found Results:");
		else
			System.out.println("No matches found.");
		for (Train result : ls)
			System.out.println("[" + (resultIndex++) + "] " + result.toString());

	}

	/**
	 * The displayStatsCommand() method prints the entire train schedule using the
	 * backend's allTrainsDuringTime() method, which returns a list of Train objects
	 * representing all trains in the schedule. If the list is empty, the method
	 * prints a "no trains in schedule" message instead.
	 */
	public void displayStatsCommand() {
		// TODO Auto-generated method stub
		System.out.println("Train schedule:");
		List<Train> schedule = backend.allTrainsDuringTime(null, null);

		if (schedule.isEmpty()) {
			System.out.println("No trains in schedule.");
			return;
		}

		for (Train train : schedule) {
			System.out.println(train.toString());
		}

	}

}
