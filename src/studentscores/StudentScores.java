/*
 * Author: Amy Roberts
 * Date: January 2014
 * Class: Intro to Programming for Business
 * Description: Calculates student averages and letter grades, as well as
 * class average and grade distribution, using a student class.
 * I pledge the AIC.
 */
package studentscores;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentScores {

	public static void main(String[] args)
	{
		try
		{
			//declare variables
			double score, total;
			int numtests;
			double runningtotal = 0;
			int Students = 0, numAs = 0, numBs = 0, numCs = 0, numDs = 0, numFs = 0;
			
			//create student object
			Student s = new Student();
			
			//create buffered input reader
			BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		
			//get number of grades that will be entered
			System.out.println("How many grades will be entered for each student?");
			numtests = Integer.parseInt(brin.readLine());
			
			//get first student's last name
			System.out.println("Please enter first student's last name, or done if finished:");
			s.setName(brin.readLine());
			
			//read multiple students until sentinel is entered
			while(!s.getName().equals("done"))
			{
				//reinitialize total to prevent errors
				total = 0;
				
				//get all test scores
				for(int i = 0; i < numtests; i++)
					{
						System.out.println("Please enter test score number " + (i + 1));
						score = Double.parseDouble(brin.readLine());
						
						//check score for validity
						while(score > 100 || score < 0)
						{
							System.out.println("Invalid score, please re-enter score number " + (i + 1));
							score = Double.parseDouble(brin.readLine());	
							
						} //end score validity check
						
						total = total + score;	//sum test scores
				
					} //end for loop; done getting test scores
			
				//find average
				s.calcAvg(total, numtests);
			
				//print average
				System.out.println(s.getName() + "'s average is " + s.getAvg());
				
				//track the number of students with each grade
				switch(s.getGrade())
				{
					case 'A':
						numAs++;
						break;
					case 'B':
						numBs++;
						break;
					case 'C':
						numCs++;
						break;
					case 'D':
						numDs++;
						break;
					case 'F':
						numFs++;
						break;
					case 'Z':
						System.out.println("Something went wrong, your student doesn't have a grade.");
						break;
					
				}//end switch
								
				//output student's letter grade
				System.out.println(s.getName() + "'s grade is " + s.getGrade());
				
				//track number of students and running total of all grades
				Students++;
				runningtotal = runningtotal + s.getAvg();
							
				//get next student's last name or sentinel
				System.out.println("Please enter next student's last name, or done if finished:");
				s.setName(brin.readLine());
			
			} //end while loop; done reading students
			
			//output class average and grade curve
			System.out.println("Class average is " + (runningtotal / Students));
			System.out.println("This is the grade curve for this class:");
			System.out.println("As: " + numAs);
			System.out.println("Bs: " + numBs);
			System.out.println("Cs: " + numCs);
			System.out.println("Ds: " + numDs);
			System.out.println("Fs: " + numFs);
			
		} //end try
		catch (Exception e)
		{
			System.out.println("Error: " + e);
			
		} //end catch
		
	} //end main
	
} //end StudentScores class
