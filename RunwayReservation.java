import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
		BST tree = new BST();
		
		for (i = 0; i < reqs.length; i++) {
			if (reqs[i].getCommand().equals("r")) {
				int tReq = reqs[i].getTime();
				if (tree.root == null) {
					tree.insert(tReq, i);
				}
				
				if (tree.valid(tReq, i) == true) {
					tree.insert(tReq, i);
				}
			}
			else if (reqs[i].getCommand().equals("t")) {
				curtime += reqs[i].getTime();
				System.out.println("Current time = " + curtime + " units");
				
				Node min = tree.min();
				if (min.getTime() < curtime ) {
					System.out.println(reqs[min.getReq_index()].getAirline());	
					if (min != null) {
						tree.delete(min.getTime());
						min = tree.min();
					}

				}

			}
		}
		Node max = tree.max();
		System.out.println("Current time = " + max.getTime() + " units.");
		Node min = null;
		while (tree.root != null) {
			min = tree.min();
			System.out.println(reqs[min.getReq_index()].getAirline());	
			tree.delete(min.getTime());
		}


		//tree.print();
	}
	
}
