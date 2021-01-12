class EmpWageBuilder
{

	//constants
	final	int IS_FULL_TIME = 1;
	final int IS_PART_TIME = 2;
	final int EMP_RATE_PER_HOUR = 20;
	final int NUM_WORKING_DAYS = 20;
	final int MAX_WORKING_HOURS = 100;

	//variable
	int empHrs = 0;
	int empWage = 0;
	int totalEmpWage = 0;
	int totalEmpWorkingHrs = 0;
	int totalEmpWorkingDays = 0;
	
public void calculateEmpWage()
{
	while ( totalEmpWorkingDays <= NUM_WORKING_DAYS && totalEmpWorkingHrs < MAX_WORKING_HOURS )
{	int empCheck = (int)(Math.random() * 10) % 3;

	switch ( empCheck ){
		case IS_FULL_TIME:
			empHrs=8;
			totalEmpWorkingDays++;
			break;
		case IS_PART_TIME:
			empHrs = 4;
			totalEmpWorkingDays++;
			break;
		default:
			empHrs=0;
}
	totalEmpWorkingHrs += empHrs;
	empWage = empHrs * EMP_RATE_PER_HOUR;
	totalEmpWage += empWage;
	System.out.println("Emp wage: " + empWage );

}
	System.out.println("Total working days: "+ totalEmpWorkingDays +" Total Working Hours: " + totalEmpWorkingHrs + " Total Wage: " + totalEmpWage );

}	
	public static void main(String[] args)
{
	EmpWageBuilder EmpWage = new EmpWageBuilder();
	
	//computation
	EmpWage.calculateEmpWage();
	
}

}
