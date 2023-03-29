import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TrainReader {
	
    public List<TrainInterface> readTrainsFromFile(String filename) throws FileNotFoundException {
        // Placeholder implementation to return empty list
    	List<TrainInterface> trainList = new ArrayList<>();
    	
    	Train train1 = new Train(filename, filename, filename, filename);
    	trainList.add(train1);
    	
    	
        return trainList;
    }

}
