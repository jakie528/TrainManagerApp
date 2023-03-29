import java.io.FileNotFoundException;
import java.util.List;

public interface TrainManagerBDInterface {
	// public TrainManagerBDInterface(TrainReaderInterface tr, RedBlackTreeInterface<Train> rbt);
	public void loadData(String filename) throws FileNotFoundException;
	public void addTrain(Train train);
	public Train removeTrain(Train train);
	public Train nextTrainAfterTime(String time);
	public Train nextTrainBeforeTime(String time);
	public Train nextTrainByCargo(String cargo);
	public Train nextTrainToDestination(String dest); 
	public List<Train>  allTrainsDuringTime(String start, String end);
//	public String getStatisticsString();
//	public List<Train> searchTrains(List<String> searchWords);
}
