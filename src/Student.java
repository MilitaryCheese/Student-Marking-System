import java.util.ArrayList;

import javax.activity.InvalidActivityException;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
/*
 * Student class is created to imitate a real life student, with instance attributes and instance methods.
 * This class has all the information required to deal with student marks and calculations.
 */
public class Student implements Comparable<Student> {
	//all the instance attribuets of the student are decalred here
	//personal inforamtion of student
	private String fName;
	private String lName;
	private String regNo;
	
	//variables for project one
	private int totalpOne;
	private int pOne;
	private int ict1;
	private int ap1;
	
	//variables for coding assingmet
	private int totalcAssingment;
	private int cAssingment;
	private int ict2;
	private int ap2;
	
	//variables for project two
	private int totalpTwo;
	private int ict3;
	private int pTwo;
	private int ap3;
	
	//other variabels for overall makr, qualifying set one and an enum for grade
	private int overallMark;
	private int qualifyingSet1;
	private Grade grade;
	

	/*
	 * This is the constructor used to create the student object by automatically initializing tthe vairables with the 
	 * arguments.
	 */
	public Student(String fName, String lName, String regNo,
			int pOne, int ict1, int ap1,
			int cAssingment, int ict2, int ap2,
			int ict3, int pTwo, int ap3) {
		super();
		//assinging teh values to the attribute vairables
		this.fName = fName;
		this.lName = lName;
		this.regNo = regNo;
		
		//using the set methods to validate and calculate the marks
		settotalpOne(pOne, ict1, ap1);
		settotalcAssingment(cAssingment, ict2, ap2);
		settotalpTwo(ict3, pTwo, ap3);
		
		//using the set overall mark to calculate the overall mark accodring to the given marks
		setOverallMark();
		//setting the grade according to the overall mark
		setGrade();
		
	}

	/*
	 * set method for total project one includes teh validation of all related sub compoennets
	 * It also calautes the total project one basedo n the percentage weighting of the sub compoenents
	 */

	private void settotalpOne(int pOne, int ict1, int ap1) {
		//validating whether the given information is between 0 and 100
		
		if(pOne>=0 && pOne<=100){
			this.pOne = pOne;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(ict1>=0 && ict1<=100){
			this.ict1 = ict1;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(ap1>=0 && ap1<=100){
			this.ap1 = ap1;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		//calculating the total according to the weighetd average
		double temp = ((this.pOne*0.2)+(this.ict1*0.7)+(this.ap1*0.1));
	//rouding off the value to the nearest integer
		totalpOne = (int) (Math.round (temp));
		
	}


	/*
	 * set method for total coding assingmntent includes teh validation of all related sub compoennets
	 * It also calculates the total coding assingmntent based on the percentage weighting of the sub compoenents
	 */

	private void settotalcAssingment(int cAssingment, int ict2, int ap2) {
		//validating whether the given information is between 0 and 100
		
		if(cAssingment>=0 && cAssingment<=100){
			this.cAssingment = cAssingment;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(ict2>=0 && ict2<=100){
			this.ict2 = ict2;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(ap2>=0 && ap2<=100){
			this.ap2 = ap2;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		//calculating the total according to the weighetd average
		double temp = ((this.cAssingment*0.5)+(this.ict2*0.4)+(this.ap2*0.1));
		//rouding off the value to the nearest integer
		totalcAssingment = (int) (Math.round(temp));
			
	}
	/*
	 * set method for total project two includes teh validation of all related sub compoennets
	 * It also calautes the total project two basedo n the percentage weighting of the sub compoenents
	 */


	private void settotalpTwo(int ict3, int pTwo, int ap3) {
		//validating whether the given information is between 0 and 100
		
		if(ict3>=0 && ict3<=100){
			this.ict3 = ict3;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(pTwo>=0 && pTwo<=100){
			this.pTwo = pTwo;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		
		if(ap3>=0 && ap3<=100){
			this.ap3 = ap3;
		}else{
			throw new IllegalArgumentException("Enter a value between"
					+ "0 and 100");
		}
		//calculating the total according to the weighetd average
		double temp = ((this.ict3*0.6)+(this.pTwo*0.3)+(this.ict3*0.1));
		//rouding off the value to the nearest integer
		totalpTwo = (int) (Math.round(temp));
		
	}
	/*
	 * this simple method is used to calucate the overall mark based on teh given weighting average
	 */

	private  void setOverallMark() {
		//the total value of each major compoennt is used and the given weighted percentage of each component is used to 
		//calculate the overall mark
		overallMark = (int) (totalpOne * 0.3 + totalcAssingment * 0.35 + totalpTwo * 0.35);		
	}
	
	/*
	 * The setgrade method checks the overall method and assingns a grade accoridn to the overall mark
	 */
	
	private void setGrade() {
		//calculating the qualifynig set one using the first two compoennets
		qualifyingSet1 = (int) ((totalpOne*0.3 + totalcAssingment*0.35));
		//checkign whether the QS1 is greater than 40 and overall mark is greater than 50
		if((qualifyingSet1>=40)&&(overallMark>=50)){
			//if the overall mark us greater than 80
			if(overallMark>=80){
				grade = Grade.HIGHERDISTINCTION;
			}else if(overallMark>=70){ //if the overall mark us greater than 70
				grade = Grade.DISTINCTION;
			}else if(overallMark>=60){ //if the overall mark us greater than 60
				grade = Grade.CREDIT;
			}else{//otherwise
				grade = Grade.PASS;
			}
			//if the overall mark is less than 50 
		}else if((overallMark<50)){
			grade = Grade.RETAKE;
		}else if(qualifyingSet1<40){ //if the qualifying set is less than 40
			grade = Grade.RESIT;
		}
		
	}

	public Grade getGrade(){
		return grade;
	}
	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getRegNo() {
		return regNo;
	}


	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	public int gettotalpOne() {
		return totalpOne;
	}


	public int getctotalcAssingment() {
		return totalcAssingment;
	}

	public int gettotalpTwo() {
		return totalpTwo;
	}

	public int getpOne() {
		return pOne;
	}

	public int getIct1() {
		return ict1;
	}

	public int getAp1() {
		return ap1;
	}

	public int getcAssingment() {
		return cAssingment;
	}


	public int getIct2() {
		return ict2;
	}


	public int getAp2() {
		return ap2;
	}

	public int getIct3() {
		return ict3;
	}

	public int getpTwo() {
		return pTwo;
	}

	public int getAp3() {
		return ap3;
	}


	public int getoverallMark(){
		return overallMark;
	}




	
	

	@Override
	public String toString() {
		return "[fName=" + fName + ", lName=" + lName + ", regNo=" + regNo + ", pOne=" + totalpOne + ", cAssingment="
				+ totalcAssingment + ", pTwo=" + totalpTwo + ", overallMark=" + overallMark + ", grade=" + grade + "]";
	}


//COMPARATOR
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.overallMark - o.overallMark;
	}


	
	
	

	
	
	
}
