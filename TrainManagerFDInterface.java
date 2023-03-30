// --== CS400 Project two File Header ==--
// Name: Ziqi Liao
// CSL Username: zliao
// Email: zliao47@wisc.edu
// Lecture #: Section 3: MoWeFr 1:20PM - 2:10PM, Florian Heimerl
// Notes to Grader: FrontendDeveloper interface

import java.util.List;

public interface TrainManagerFDInterface {
    //public TrainManagerFDXX(Scanner userInput, TrainManagerBDInterface backend);
    public void runCommandLoop();
    public char mainMenuPrompt();
    public void loadDataCommand();
    public List<String> chooseSearchWordsPrompt();
    public void searchDestination(List<String> words);
    public void searchCargo(List<String> words);
    public void searchDeparturetime (List<String> words);
    public void searchArrivaltime(List<String> words);
    public void displayStatsCommand();

}
