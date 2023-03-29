
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provide a text-based user interface to the searching capaibilities of the
 * TrainManagerApp.
 * 
 * @author Ziqi Laio FrontendDeveloper
 */
public class TrainManagerFD implements TrainManagerFDInterface {

	    private Scanner userInput;
	    private TrainManagerBDInterface backend;

	    public TrainManagerFD(Scanner userInput, TrainManagerBDInterface backend) {
	        this.userInput = userInput;
	        this.backend = backend;
	    }

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
	    private void removeTrainPrompt() {
			// TODO Auto-generated method stub
//		    System.out.print("Enter train ID to remove: ");
//	        String input = userInput.nextLine().trim().toLowerCase();
//		    input = chooseSearchWordsPrompt();
//
//		    Train removedTrain = backend.removeTrain(id);
//		    if (removedTrain != null) {
//		        System.out.println("Train removed from schedule.");
//		    } else {
//		        System.out.println("Train with ID " + id + " not found in schedule.");
//		    }

			
		}

		private void addTrainPrompt() {

		}

		public void searchCommand() {
	        List<String> words = chooseSearchWordsPrompt();
	        if (words.isEmpty()) {
	            System.out.println("Please enter at least one search word.");
	        } else {
	            char searchType = words.remove(0).toLowerCase().charAt(0);
	            switch (searchType) {
	            //search for the latest train on the schedule.
	                case 't':
	                	words = chooseSearchWordsPrompt();
	                    searchLatestTrain(words);
	                    break;
	                    //search for the train by its destination	                
	                case 'd':
	                    searchDestination(words);
	                    break;
	                    //search for the train by its cargo.
	                case 'c':
	                    searchCargo(words);
	                    break;
	                    //search for the train by its arrival time.
	                case 'a':
	                    searchArrivaltime(words);
	                    break;
	                    //search for the train by its departure time.
	                case 'p':
	                    searchDeparturetime(words);
	                    break;
	                default:
	                    System.out.println("Invalid search type. Please try again.");
	            }
	        }
	    }
	    

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
		 * This method gives user the ability to interactively add or remove individual
		 * words from their query, before performing any kind of search.
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

//nextTrainAfterTime
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
	    


	    //nextTrainBeforeTime

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
		
		//nextTrainToDestination
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
	    
//nextTrainByCargo		

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
	    
	   
//nextTrainAfterTime
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


//allTrainsDuringTime
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
