
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class FrontendDeveloperTests {
	/**
	 * 
	 * Tests the main menu prompt by creating a new instance of TextUITester and
	 * providing input "Q" to simulate quitting the application. It checks whether the output
	 * contains
	 * 
	 * the welcome message.
	 */
	@Test
	public void test1() {
		// filename:test
		TextUITester tester = new TextUITester("Q\n");

		try (Scanner scan = new Scanner(System.in)) {

			TrainManagerBDInterface backend = new TrainManagerBD();
			TrainManagerFD frontend = new TrainManagerFD(scan, backend);
			frontend.runCommandLoop();
			String output = tester.checkOutput();
			assertTrue(output.contains("Welcome to the Train Schedule Application:"));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	/**
	 * 
	 * Tests the load data command by creating a new instance of TextUITester and
	 * providing input "S\ntest\nt\n5:30\nQ\n". It checks whether the output contains the
	 * success message.
	 * 
	 */
	@Test
	public void test2() {
		TextUITester tester = new TextUITester("S\ntest\nt\n5:30\nQ\n");

		try (Scanner scan = new Scanner(System.in)) {

			TrainManagerBDInterface backend = new TrainManagerBD();
			TrainManagerFD frontend = new TrainManagerFD(scan, backend);
			frontend.runCommandLoop();

			String output = tester.checkOutput();
			assertTrue(output.contains("Train schedule loaded successfully."));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * 
	 * Tests the search command by creating a new instance of TextUITester and
	 * providing input "S\ntest\nt\n5:30\nQ\n". It checks whether the output contains the
	 * expected search result.
	 * 
	 */
	@Test
	public void test3() {
		TextUITester tester = new TextUITester("S\ntest\nt\n5:30\nQ\n");

		try (Scanner scan = new Scanner(System.in)) {

			TrainManagerBDInterface backend = new TrainManagerBD();
			TrainManagerFD frontend = new TrainManagerFD(scan, backend);
			frontend.runCommandLoop();

			String output = tester.checkOutput();
			assertTrue(output.contains("Found Results:\r\n"
					+ "[1] Train from Madison to chicago, departing at 5:50pm and arriving at 6:50pm"));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * 
	 * Tests the remove train command by creating a new instance of TextUITester and
	 * providing input "R\ntrain1\nQ\n". It checks whether the output contains the delete
	 * message.
	 * 
	 */
	@Test
	public void test4() {
		TextUITester tester = new TextUITester("R\ntrain1\nQ\n");

		try (Scanner scan = new Scanner(System.in)) {

			TrainManagerBDInterface backend = new TrainManagerBD();
			TrainManagerFD frontend = new TrainManagerFD(scan, backend);
			frontend.runCommandLoop();

			String output = tester.checkOutput();
			assertTrue(output.contains("Train removed from schedule."));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * This method tests adding a train to the schedule using the "A" command. It
	 * creates a new TextUITester object to simulate user input of adding a train
	 * from Madison to Chicago departing at 4:50pm and arriving at 5:30pm. It then
	 * creates a TrainManagerBD object to store the train schedule in memory, and a
	 * TrainManagerFD object to handle user commands and interact with the
	 * TrainManagerBD object. The method runs the "A" command to add the train to
	 * the schedule, and checks if the output contains the string "Train added to
	 * schedule.". If the output contains the expected string, the method passes the
	 * test. Otherwise, it fails the test.
	 */
	@Test
	public void test5() {
		TextUITester tester = new TextUITester("A\nMadison\nChicago\n4:50\n5:30\nQ\n");

		try (Scanner scan = new Scanner(System.in)) {

			TrainManagerBDInterface backend = new TrainManagerBD();
			TrainManagerFD frontend = new TrainManagerFD(scan, backend);
			frontend.runCommandLoop();

			String output = tester.checkOutput();
			assertTrue(output.contains("Train added to schedule."));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

}
