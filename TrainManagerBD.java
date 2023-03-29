import java.io.FileNotFoundException;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class TrainManagerBD implements TrainManagerBDInterface {
	   private TrainReaderInterface trainReader;
	    private RedBlackTreeInterface<TrainInterface> redBlackTree;

	    public TrainManagerBD(TrainReaderInterface trainReader, RedBlackTreeInterface<TrainInterface> redBlackTree) {
	        this.trainReader = trainReader;
	        this.redBlackTree = redBlackTree;
	    }

	    public TrainManagerBD() {
			// TODO Auto-generated constructor stub
		}

//		@Override
//	    public void addTrain() {
//	        // Placeholder implementation to do nothing
//	    }
//
//	    @Override
//	    public Train removeTrain() {
//	        // Placeholder implementation to return null
//	        return null;
//	    }

	    @Override
	    public Train nextTrainAfterTime(String time) {
	        // Placeholder implementation to return null
	    	String t = time;
	    	Train tr = null;
	    	if(t == time ) {
	    	tr = new Train("chicago", "Madison", "5:50pm", "6:50pm");
	    	}
	        return tr;
	    }

	    @Override
	    public Train nextTrainBeforeTime(String time) {
	        // Placeholder implementation to return null
	    	String t = time;
	    	Train tr = null;
	    	if(t == time ) {
	    	tr = new Train("chicago", "milwaukee", "5:50pm", "6:50pm");
	    	}
	        return tr;
	    }

	    @Override
	    public Train nextTrainByCargo(String cargo) {
	        // Placeholder implementation to return null
	        return null;
	    }

	    @Override
	    public Train nextTrainToDestination(String dest) {
	        // Placeholder implementation to return null
	        return null;
	    }

	    @Override
	    public List<Train> allTrainsDuringTime(String start, String end) {
	        // Placeholder implementation to return empty list
	        return new ArrayList<>();
	    }

	


		@Override
		public void loadData(String filename) throws FileNotFoundException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTrain(Train train) {
			// TODO Auto-generated method stub
			
		}

		public Train removeTrain(Train id) {
			// TODO Auto-generated method stub
		
			Train tr =  new Train("chicago", "milwaukee", "5:50pm", "6:50pm");

			return tr;
		}

//		@Override
//		public Train removeTrain(Train train) {
//			// TODO Auto-generated method stub
//	    	String trainId = id;
//	    	Train tr = null;
//
//	        return tr;
//		}

//		@Override
//		public List<Train> searchTrains(List<String> searchWords) {
//			// TODO Auto-generated method stub
//			return null;
//		}
}
