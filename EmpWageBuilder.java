class EmpWageBuilder
{
		public static void main(String[] args)
{
	//constants
	final	int IS_FULL_TIME = 1;
	final int IS_PART_TIME=2;
	final int EMP_RATE_PER_HOUR = 20;
	final int NUM_WORKING_DAYS = 20;
	//variable
	int empHrs = 0;
	int empWage = 0;
	int totalEmpWage = 0;
	//computation
for( int Day = 1; Day <= NUM_WORKING_DAYS; Day++)
{	int empCheck = (int)(Math.random() * 10) % 3;

	switch ( empCheck ){
		case IS_FULL_TIME:
			empHrs=8;
			break;
		case IS_PART_TIME:
			empHrs = 4;
			break;
		default:
			empHrs=0;
}
	empWage = empHrs * EMP_RATE_PER_HOUR;
	totalEmpWage += empWage;
	System.out.println("Emp wage: " + empWage );
}
	System.out.println("Total Wage: " + totalEmpWage );
}

}
