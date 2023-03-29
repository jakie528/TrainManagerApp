import java.util.Scanner;

public class FrontendDeveloperTests {
	/**
	 * test mainMenuPrompt()
	 * 
	 * @return true if all test case pass
	 */
	public static boolean test1() {
		//filename:test
		TextUITester tester = new TextUITester("Q\n");
		
		try (Scanner scan = new Scanner(System.in)) {

            TrainManagerBDInterface backend = new TrainManagerBD();
            TrainManagerFD frontend = new TrainManagerFD(scan, backend);
            frontend.runCommandLoop();           
            String output = tester.checkOutput();
            if(output.contains("Welcome to the Train Schedule Application:")) {
            	System.out.println("Test PASSED.");
            } else {
            	System.out.println("Test FAILED.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

	}
	
	
	//test loadDataCommand()
	public static boolean test2() {
		TextUITester tester = new TextUITester("S\ntest\nt\n5:30\nQ\n");
		
		try (Scanner scan = new Scanner(System.in)) {

            TrainManagerBDInterface backend = new TrainManagerBD();
            TrainManagerFD frontend = new TrainManagerFD(scan, backend);
            frontend.runCommandLoop();
            
            String output = tester.checkOutput();
            if(!output.contains("Train schedule loaded successfully.")) 
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	//test searchCommand
	public static boolean test3() {
		TextUITester tester = new TextUITester("S\ntest\nt\n5:30\nQ\n");
		
		try (Scanner scan = new Scanner(System.in)) {

            TrainManagerBDInterface backend = new TrainManagerBD();
            TrainManagerFD frontend = new TrainManagerFD(scan, backend);
            frontend.runCommandLoop();
            
            String output = tester.checkOutput();
            System.out.println(output);
            if(output.contains("Found Results:\r\n"
            		+ "[1] Train from Madison to chicago, departing at 5:50pm and arriving at 6:50pm")) {
            	System.out.println("Test PASSED.");
            } else {
            	System.out.println("Test FAILED.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ROLE (FD) Test 1:" + test1());
		System.out.println("ROLE (FD) Test 2:" + test2());
		System.out.println("ROLE (FD) Test 3:" + test3());
//		System.out.println("ROLE (FD) Test 4:" + test4());
//		System.out.println("ROLE (FD) Test 5:" + test5());
		

	}

}
