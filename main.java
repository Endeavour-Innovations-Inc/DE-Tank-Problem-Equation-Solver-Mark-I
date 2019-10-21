package DE;

import java.util.Scanner;

class Not_pure_water_problem {
	void overall_process() {
		
	}
}

class Pure_water_problem {
	double gallons;
	int inflow_rate;
	int outflow_rate;
	int concetration;
	int rici;
	double den_con;
	void overall_process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the number of gallons in the tank: ");
		gallons = scan.nextInt();
		System.out.println("Assuming that Ri = Ro");
		System.out.print("Please enter the rate of inflow of solution in gal/min: ");
		inflow_rate = outflow_rate = scan.nextInt();
		System.out.print("Please enter a concetration of the salt in the solution in lbs/gal: ");
		concetration = scan.nextInt();
		// (dQ/dt) = rici - roco
	    rici = inflow_rate * concetration;
	    den_con = gallons/outflow_rate;
		System.out.println("thank you. DE has been constructed!");
		System.out.println("Q = (" + rici + "/" + den_con + ") + Ce^(-t/" + den_con + ")");
		System.out.print("Finding C: ");
		System.out.println("Q = (" + rici + "/" + den_con + ") + -(" + rici + "/" + den_con +")e^(-t/" + den_con + ")");
		System.out.println("If you would like to finish, please press 'f'");
		System.out.println("If you would like to continue, please press 'c'");
		String answer = scan.next();
		if (answer.equals("f")) {
			System.exit(0);
		} else if (answer.equals("c")) {
			extra_actions();
		} else {
			System.out.println("Command not recognized");
			System.exit(0);
		}
	}
	void extra_actions() {
		System.out.println("If you want to find amount of salt after indefinite amount of time (lim as t-> infinity), please press 'i'");
		System.out.println("If you want to find amount of salt after specific time, please press 's'");
		Scanner scan = new Scanner(System.in);
		String input_desicion = scan.next();
		if (input_desicion.equals("i")) {
			lim_to_inf();
		} else if (input_desicion.equals("s")) {
			time_dependent_quantity();
		} else {
			System.out.println("Command not recognized");
			System.exit(0);
		}
	}
	void lim_to_inf() {
		System.out.println("Lim as t-> infinity: (" + rici + "/" + den_con + ") lbs of salt");
	}
	void time_dependent_quantity() {
		
	}
}

class questionaire {
	void factors(String input) {
		input.toLowerCase();
		if (input.equals("yes")) {
			Pure_water_problem p = new Pure_water_problem();
			p.overall_process();
		} else if (input.equals("no")) {
			Not_pure_water_problem np = new Not_pure_water_problem();
			np.overall_process();
		} else {
			System.out.println("Command not recognized, please try again");
			System.exit(0);
		}
		
	}
}

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		questionaire q = new questionaire();
		System.out.println("Welcome to the tank problem DE solver");
		System.out.println("Please answer the following questions");
		System.out.println("Is the water in the tank pure?");
		System.out.print("Please answer yes or no: ");
		String input_info = input.nextLine();
		q.factors(input_info);
	}

}
