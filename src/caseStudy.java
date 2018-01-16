import java.awt.List;
import java.lang.management.PlatformManagedObject;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import javax.annotation.processing.RoundEnvironment;
import javax.management.MBeanConstructorInfo;
import javax.xml.parsers.DocumentBuilder;

import org.omg.CORBA.SystemException;
import org.omg.CosNaming.NamingContextExtPackage.URLStringHelper;

public class caseStudy {
	//defining all the public static variables that are required
	public static Scanner sc = new Scanner(System.in);
	public static String fname = "", lname = "", regNo = "";
	public static int p1 = 0,ict1=0,ap1=0, 
			cAssingment = 0, ict2=0,ap2=0,
			ict3 = 0,p2 = 0,ap3=0;
	public static float average = 0;
	public static boolean added = false;
	//programming to super type
	public static ArrayList<Student> arr = new ArrayList<Student>();

	/*
	 * This is the method to get the average of the array list size.
	 */

	
	/*
	 * Method to print all the elements of the arraylist
	 * It will go through the arraylist one my one and print each student element
	 */
	
	public static void returnAll(){
		//checks whether the added boolean variable (which is given the value true only when the students are added) is true or false.
		if(added){
			
			System.out.println("______________________________________________________________________________");
			System.out.println("                    ALL STUDENTS INFORMATION");
			System.out.println("______________________________________________________________________________");
			System.out.printf("%-15s  %-15s  %-15s %-15s %-15s  ", "Reg. No.", "First name", "Last name", "Overall marks", "Grade");
			System.out.println();
			System.out.println("______________________________________________________________________________");
			System.out.println();
			for(Student stud : arr){
				System.out.printf("%-15s  %-15s  %-15s %-15s %-15s  ", stud.getRegNo(), stud.getfName(), stud.getlName(), stud.getoverallMark(), stud.getGrade());
				System.out.println();
			}
			System.out.println();
		}else{
			//if the added variable is false, that means the students are not been added yet.
			System.out.println("Please enter students first.");
		}
	}
	/*
	 * This method counts the number of students who has scored less than 40 for each separate component.
	 */
	
	public static void countBelowAvg(){
		//checking whether any students are added yet or not.
	if(added){
		//if added, then the local variables are declared and initialized.
		int countPOne = 0, countCA = 0, countPTwo = 0;
		//a loop is used to traverse the array list
		for(Student stud : arr){
			//if any student has less than 40 for the project one
			if(stud.getpOne()<40){
				//counter for project one is increased
				countPOne++;
			}
			//if any student has less than 40 for the coding assignment
			if(stud.getcAssingment()<40){
				//counter for coding assignment is increased
				countCA++;
			}
			//if any student has less than 40 for the project two
			if(stud.getpTwo()<40){
				//counter for project two is increased
				countPTwo++;
			}
		}
		//once the loop ends, the number of students who has scored lower marks are displayed accordingly
		System.out.println("______________________________________________________________");
		System.out.println("NUMBER OF STUDENTS WHO HAS SCORED LESS THAN 40 FOR EACH MODULE");
		System.out.println("______________________________________________________________");
		System.out.printf("%-20s  %-20s", "Component", "Number of students");
		System.out.println();
		System.out.printf("%-20s  %-20s", "Project One", countPOne);
		System.out.println();
		System.out.printf("%-20s  %-20s", "Coding assignment", countCA);
		System.out.println();
		System.out.printf("%-20s  %-20s", "Project Two", countPTwo);
		System.out.println();
		System.out.println("______________________________________________________________");
		
	}else{
		System.out.println("Please enter students first.");
	}
		
	}
	
	/*
	 * This is one of the most important methods of this application.
	 * Basically, here the user input about the student information is taken.
	 * All the required information is prompted from the user. 
	 * When they are received, they are validated then stored in a variable.
	 * After all information is received, they variables are used to create a student object which is again
	 * 		added to the array list.
	 */
	
	
	public static void createStudent(){
		System.out.println("______________________________________________________________");
		System.out.println("             ENTERING STUDENT INFORMATION");
		System.out.println("______________________________________________________________");
		added = true;
		String loop = "T";
		//while the user wants to exit this function
		while(loop=="T"){
			//the user is prompted for the informtion and they are taken in
			System.out.print("Enter the first name:");
			fname = sc.next();
			System.out.print("Enter the last name:");
			lname = sc.next();
			System.out.print("Enter the registration number:");
			regNo = sc.next();
			
			System.out.println("Thank you for entering the personal informaion.");
			
			System.out.println("MAKRING INFORMATION");
			System.out.println();
			
			//receiving project 01 information
			System.out.println("Project One with In-Class Test");
			System.out.println("------------------------------");
			System.out.print("Project one:");
			//information is sent to be validated
			p1 = validateMrks();
			System.out.print("In-Class test one:");
			ict1 = validateMrks();
			System.out.print("Active participation for lectures from weeks 1 to 5 (out of 25) :");
			/*
			 * Active participation is calculated as follows.
			 * The total weekdays for the required weeks are calculated. if its 3 weeks, the weekdays are 15.
			 * Then out of this number, the user enters the participation.
			 * This participation must be between 0 and the total weekdays.
			 * Thereafter, a percentage of the actual participation  is taken.
			 */
			ap1 = validateActiveParticipation(25);
			
			//receiving coding assignment information
			System.out.println();
			System.out.println("Coding Assignment with In-class Test");
			System.out.println("------------------------------------");
			System.out.print("Coding assingment: ");
			cAssingment = validateMrks();
			System.out.print("In-Class test two:");
			ict2 = validateMrks();
			System.out.print("Active participation for lectures from weeks 6 to 9 (out of 20) :");
			ap2 = validateActiveParticipation(20);
			
			//receiving project two information
			System.out.println();
			System.out.println("Project 02 with In-class Test ");
			System.out.println("------------------------------");
			System.out.print("In-Class test three:");
			ict3 = validateMrks();
			System.out.print("Project two:");
			p2 = validateMrks();
			System.out.print("Active participation for lectures from weeks 10 to 12 (out of 15) :");
			ap3 = validateActiveParticipation(15);
			
			/*
			 * the taken variables are used to create a new student object and this object is then
			 * added to the arraylist.
			 */
			
			arr.add(new Student(fname, lname, regNo, 
					p1, ict1, ap1,
					cAssingment, ict2, ap2,
					ict3, p2, ap3));
			System.out.println();
			//get the user's decision whether to continue or not
			System.out.print("Do you want to continue? (Y/N):");
			String val = sc.next().toUpperCase();
			if(val.equals("N")){
				//if user doesnt want to continue
				break;
			}else{
				System.out.println("______________________________________________________________");
				
			}
			
		}
	}
	
	
	/*
	 * The marks that are required by the application are taken out of 100.
	 * However, the user can enter any amount to the system.
	 * In order to check whether its valid (between 0 and 100, and must be an integer) this validate marks method is used.
	 */
	
	
	private static int validateMrks() {
		//check whether any students are there
	if(added){
		int marks;
		do{
			//if an integer is not entered.
			while(!(sc.hasNextInt())){
				System.err.println("Invalid input. Enter again.");
				sc.next();
			}
			//when an integer is entered it is taken in and checked whether its between 0 and 100.
			marks = sc.nextInt();
			//if its not integer
			if(!(marks>=0 && marks<=100)){
				System.err.println("The value must be above 0 and below 100.");
			}
			
		}while(!(marks>=0 && marks<=100));
		return marks;
	}else{
		System.out.println("Please enter students first.");
		return 0;
	}
	}

	/*
	 * Active participation must also be validated. If the user enters a value that is
	 * beyond the number of total particiation dates it must be incorrect. 
	 * It also has be either 0 or larger. 
	 */
	private static int validateActiveParticipation(int limit) {
	if(added){
		double ap;
		int round = 0;
		do{
			//if the entered value is not integer
			while(!(sc.hasNextInt())){
				System.err.println("Invalid input. Enter again.");
				sc.next();
			}
			ap = sc.nextInt();
			//if the value is not between 0 and the total weekdays
			if(!(ap>=0 && ap<=limit)){
				System.err.println("The value must be above 0 and below "+limit+".");
			}
			
		}while(!(ap>=0 && ap<=limit));
		//calculating the percentage of the participation against the total participation
		ap = ap*100/limit;
		//rounding up the particiaption
		round = (int) (Math.round(ap));
		return round;
	}else{
		System.out.println("Please enter students first.");
		return 0;
	}
	}
	
	/*
	 * This method is used to display the overall marks and all information about all the students
	 */
	public static void displayOverallMarks(){
	if(added){
		System.out.println("______________________________________________________________________________");
		System.out.println("                   OVERALL MARKS");
		System.out.println("______________________________________________________________________________");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Overall marks");
		System.out.println();
		System.out.println("______________________________________________________________________________");
		System.out.println();
		//a loop is used to traverse through the array list of students
		for(Student stud : arr){
			//printing the details of each student using a printf method
			System.out.printf("%-15s  %-15s  %-15s %-15s ", stud.getRegNo(), stud.getfName(), stud.getlName(), stud.getoverallMark());
			System.out.println();
		}
		System.out.println("______________________________________________________________________________");
		
	}else{
		System.out.println("Please enter students first.");
	}
	}

	/*
	 * In this method, the overall class average is calculated
	 */
	public static void DisplayAverage(){
		//the required local variables are decalred and initialized
		int studNum = 0, total=0;
		//going trhough each and every element of the arraylist
		for(Student stud : arr){
			//adding a counter
			studNum++;
			//adding the sum of overall marks of each student
			total+=stud.getoverallMark();		
		}
		//dividing the total sum by the counter value
		average = total/studNum;
		System.out.println("Overall class average: "+average);
	}
	/*
	 * This method is used to print all the details of teh students whose 
	 * overall marks are below the class average
	 */
	
	public static void belowAverage(){
		//checking if any students exist
		if(added){
			System.out.println("______________________________________________________________________________");
			System.out.println("                   ALL STUDENTS BELOW THE AVERAGE");
			System.out.println("______________________________________________________________________________");
			System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Overall marks");
			System.out.println();
			System.out.println("______________________________________________________________________________");
			System.out.println();
			//going through each and every element of the arraylist 
		for(Student stud : arr){
			//checking if the overall mark of the current student is below the calculated average
			if(stud.getoverallMark()<average){
				//print the details if the above condition is true
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
		System.out.println("______________________________________________________________________________");
		
		}else{
			System.out.println("Enter students first!");
		}
		
	}

	/*
	 * This method is used to find and print the students who has scored high scores of overall marks, 
	 * proejct one, coding assingment and project two. 
	 */
	public static void highScores(){
	if(added){
		System.out.println("______________________________________________________________________________");
		System.out.println("                   STUDENT HIGH SCORES");
		System.out.println("______________________________________________________________________________");
		
		//System.out.println("______________________________________________________________________________");
		System.out.println();
		//declaring and initializin local variables
		String regNo = "", fname = "", lname = "";
		//assinging the initial value to the maximum variable
		int max1 = arr.get(0).getoverallMark();
		for(Student stud: arr){
			//if the current student's overall mark is greater than the maximum
			if(stud.getoverallMark()>=max1){
				//getting the student's information to the variables
				regNo = stud.getRegNo();
				fname = stud.getfName();
				lname = stud.getlName();
				//assinging the student's mark as the maximum
				max1 = stud.getoverallMark();
			}
		}
		System.out.println("Maximum Overall Marks");
		System.out.println("---------------------");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Overall marks");
		System.out.println();
		System.out.printf("%-15s  %-15s  %-15s %-15s ",regNo, fname, lname, max1);
		System.out.println();
		System.out.println();
		
		
		//assinging values to local variables
		regNo = "";
		fname = "";
		lname = "";
		//assinging the initial value to the maximum variable
		int max2 = arr.get(0).gettotalpOne();
		for(Student stud: arr){
			//if the current student's overall mark is greater than the maximum
			if(stud.gettotalpOne()>=max2){
				//getting the student's information to the variables and assinging the overall mark to the maximum
				regNo = stud.getRegNo();
				fname = stud.getfName();
				lname = stud.getlName();
				max2 = stud.gettotalpOne();
			}
		}
		System.out.println("Maximum Marks for Project One");
		System.out.println("-----------------------------------");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Project One Marks");
		System.out.println();
		System.out.printf("%-15s  %-15s  %-15s %-15s ",regNo, fname, lname, max2);
		System.out.println();
		System.out.println();

		//assinging values to local variables
		regNo = "";
		fname = "";
		lname = "";
		//assinging the initial value to the maximum variable
		int max3 = arr.get(0).getctotalcAssingment();
		for(Student stud: arr){
			//if the current student's overall mark is greater than the maximum
			if(stud.getctotalcAssingment()>=max3){
				//getting the student's information to the variables and assinging the overall mark to the maximum
				regNo = stud.getRegNo();
				fname = stud.getfName();
				lname = stud.getlName();
				max3 = stud.getctotalcAssingment();
			}
		}
		System.out.println("Maximum Marks for Coding Assingment");
		System.out.println("-----------------------------------");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Coding Assingment marks");
		System.out.println();
		System.out.printf("%-15s  %-15s  %-15s %-15s ",regNo, fname, lname, max3);
		System.out.println();
		System.out.println();
		
		//assinging values to local variables
		regNo = "";
		fname = "";
		lname = "";
		//assinging the initial value to the maximum variable
		int max4 = arr.get(0).gettotalpTwo();
		for(Student stud: arr){
			//if the current student's overall mark is greater than the maximum
			if(stud.gettotalpTwo()>=max4){
				//getting the student's information to the variables and assinging the overall mark to the maximum
				regNo = stud.getRegNo();
				fname = stud.getfName();
				lname = stud.getlName();
				max4 = stud.gettotalpTwo();
			}
		}
		System.out.println("Maximum marks for Project Two: ");
		System.out.println("-------------------------------");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Coding Assingment marks");
		System.out.println();
		System.out.printf("%-15s  %-15s  %-15s %-15s ",regNo, fname, lname, max4);
		System.out.println();
		System.out.println();
	}else{
		System.out.println("Enter students first!");
	}
		
	}
	/*
	 * This method is used to print all the retake students
	 */
	public static void retakeStudents(){
		System.out.println("______________________________________________________________________________");
		System.out.println("                          RETAKE STUDENTS");
		System.out.println("______________________________________________________________________________");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Overall marks");
		System.out.println();
		System.out.println("______________________________________________________________________________");
		System.out.println();
		for(Student stud : arr){
			//checking if the grade is retake
			if(stud.getGrade().equals(Grade.RETAKE)){
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
	}
	
	public static void resitStudents(){
		System.out.println("______________________________________________________________________________");
		System.out.println("                  ALL RE-SIT STUDENTS");
		System.out.println("______________________________________________________________________________");
		System.out.println();
		System.out.printf("%-25s %-15s ", "Name", "Resit modules");
		System.out.println();
		//using the comparator to list the according in the last name
		Collections.sort(arr, new LastNameComparator());
		for(Student stud : arr){
			//checking if the grade is resit
			if(stud.getGrade().equals(Grade.RESIT)){
				System.out.printf("%-25s", stud.getlName()+", "+stud.getfName());
				// checking if the project one is less than 40
				if(stud.getpOne()<40){
					System.out.printf(" %-15s","Project one; ");
				}
				// checking if the ict one is less than 40
				if(stud.getIct1()<40){
					System.out.print("In-Class test one; ");
				}
				// checking if the coding assingment is less than 40
				if(stud.getcAssingment()<40){
					System.out.printf(" %-15s","Coding assingment; ");
				}
				// checking if the ict  two is less than 40
				if(stud.getIct2()<40){
					System.out.printf(" %-15s","In-Class test two; ");
				}
				// checking if the ict three is less than 40
				if(stud.getIct3()<40){
					System.out.printf(" %-15s","In-Class test three; ");
				}
				// checking if the project two is less than 40
				if(stud.getpTwo()<40){
					System.out.printf(" %-15s","Project two; ");
				}
				System.out.println();
			}
		}
	}
	/*
	 * This method is used to display all the inforamtion of the students who has passed and categorized according to the grade
	 * The method also shows the results in descending order
	 */
	public static void displayResult(){
		System.out.println("______________________________________________________________________________");
		System.out.println("                          STUDENT RESULTS");
		System.out.println("______________________________________________________________________________");
		System.out.printf("%-15s  %-15s  %-15s %-15s ", "Reg. No.", "First name", "Last name", "Overall marks");
		System.out.println();
		System.out.println("______________________________________________________________________________");
		System.out.println();
		System.out.println("___________________________HIGHER DISCTINCTION________________________________");
		//going through teh araylist
		//mark comprator is used to get the marks in descending order
		Collections.sort(arr, new MarkComparator());
		for(Student stud : arr){
			//if hte grade is higher disctinction
			if(stud.getGrade().equals(Grade.HIGHERDISTINCTION)){
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
		System.out.println();
		//students with distiction grade
		Collections.sort(arr, new MarkComparator());
		System.out.println("________________________________DISCTINCTION__________________________________");
		//going through the array list
		for(Student stud : arr){
			//if the grade is distinction
			if(stud.getGrade().equals(Grade.DISTINCTION)){
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
		System.out.println();
		//students with credit grade
		System.out.println("__________________________________CREDIT_____________________________________");
		//using teh comparator to get the descending order of marks
		Collections.sort(arr, new MarkComparator());
		for(Student stud : arr){
			if(stud.getGrade().equals(Grade.CREDIT)){
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
		System.out.println();
		//students with PASS grade
		System.out.println("___________________________________PASS_____________________________________");
		Collections.sort(arr, new MarkComparator());
		for(Student stud : arr){
			if(stud.getGrade().equals(Grade.PASS)){
				System.out.printf("%-15s  %-15s  %-15s %-15s",stud.getRegNo() ,stud.getfName(),stud.getlName(),stud.getoverallMark());
				System.out.println();
			}
		}
		
	}
	/*
	 * This method is used to calculate and print all the averages of the components seperately.
	 */
	
	public static void allAverage(){
		int avgPOne = 0, avgCAssgmt = 0, avgPTwo = 0;
		int totPOne = 0, totCAssgmt = 0, totPTwo = 0;
		
		//getting the size of the array list
		int count = arr.size();
		//going through teh array list
		for(Student stud : arr){
			//colecting totals for all components
			totPOne += stud.gettotalpOne();
			totCAssgmt +=stud.getctotalcAssingment();
			totPTwo += stud.gettotalpTwo();
		}
		//claculating each compoennt average by dividing by the number of students
		avgPOne = totPOne/count;
		avgCAssgmt = totCAssgmt/count;
		avgPTwo = totPTwo/count;
		//printing the information
		System.out.println("______________________________________________________________________________");
		System.out.println("                          ALL AVERAGE MARKS");
		System.out.println("______________________________________________________________________________");
		System.out.printf("%-25s  %-25s ", "Component", "Average Mark");
		System.out.println();
		System.out.println("______________________________________________________________________________");
		System.out.println();
		System.out.printf("%-25s  %-25s","Project One" ,avgPOne);
		System.out.println();
		System.out.printf("%-25s  %-25s","Coding assingment", avgCAssgmt);
		System.out.println();
		System.out.printf("%-25s  %-25s", "Project Two", avgPTwo);
		System.out.println();
		System.out.println("______________________________________________________________________________");
		System.out.println();
	}
	
	public static void main(String[] args) {
		//main method is used as a main menu.
		boolean contin = true;
		//while loop is used to check whether user wants to run the program continuesly or not
		while(contin){
			System.out.println("====================================================");
			System.out.println("                    Student System");
			System.out.println("====================================================");
			System.out.println("Key\tFunction");
			System.out.println("1\tAdd students.");
			System.out.println("2\tDisplay all students.");
			System.out.println("3\tCount the below average students.");
			System.out.println("4\tDisplay overall marks.");
			System.out.println("5\tDisplay the overall class average.");
			System.out.println("6\tDisplay all the students below average.");
			System.out.println("7\tDisplay all high scores.");
			System.out.println("8\tDisplay all retake students.");
			System.out.println("9\tDisplay all resit students and their resit modules.");
			System.out.println("10\tDisplay all passed students' marks.");
			System.out.println("11\tDisplay all average marks.");
			System.out.println("x\tExit.");
			System.out.println("====================================================");
			///getting user information about the user decion
			System.out.print("Enter the prefered key: ");
			//using a if else confition to check the required function
				String input = sc.next();
				if(input.equals("1")){
					createStudent();
				}else if(input.equals("2")){
					returnAll();
				}else if(input.equals("3")){
					countBelowAvg();
				}else if(input.equals("4")){
					displayOverallMarks();
				}else if(input.equals("5")){
					DisplayAverage();
				}else if(input.equals("6")){
					belowAverage();
				}else if(input.equals("7")){
					highScores();
				}else if(input.equals("8")){
					retakeStudents();
				}else if(input.equals("9")){
					resitStudents();
				}else if(input.equals("10")){
					displayResult();
				}else if(input.equals("11")){
					allAverage();
				}else if(input.equals("x")){
					contin=false;
				}else{
					System.out.println("Enter valid data!");
				}
			
		}
		System.out.println("You are now exiting.");
		

	}


}
