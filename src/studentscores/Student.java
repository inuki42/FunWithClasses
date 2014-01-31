/*
 * Student class to be used inside Student Scores.
 */
package studentscores;

public class Student 
{
	//declare variables
	private String LastName;
	private double average;
	private char grade;
	
	//_______CONSTRUCTOR_________
	Student()
	{
		LastName = null;
		average = 0;
		grade = 'Z';
	} //end constructor
	
	//_______METHODS___________
	
	//gets and sets for name
	String getName()
	{
		return LastName;
	}//end getName
	void setName(String lName)
	{
		LastName = lName;
	}//end setName
	
	//gets and calcs for average and grade
	double getAvg()
	{
		return average;
	}//end getAvg
	
	//calculate average and letter grade
	void calcAvg(double calctotal, int calctests)
	{
		average = (calctotal / calctests);
		
		//if-else ladder to determine letter grade
		if(average >= 90)
		grade = 'A';
		else if(average >= 80)
		grade = 'B';
		else if (average >= 70)
		grade = 'C';
		else if (average >= 60)
		grade = 'D';
		else 
		grade = 'F';
	} //end calcAvg
	
	char getGrade()
	{
		return grade;
	} //end getGrade
			  
} // end class Student
