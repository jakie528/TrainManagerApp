

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
