class EmpWageBuilder
{
	public static void main(String[] args)
{
	//constants
	final	int IS_FULL_TIME = 1;
	final int EMP_RATE_PER_HOUR = 20;
	//variable
	int empHrs = 0;
	int empWage = 0;
	//computation
	int empCheck = (int)(Math.random() * 10) % 2;

	if ( empCheck == IS_FULL_TIME )
		empHrs=8;

	empWage = empHrs * EMP_RATE_PER_HOUR;
	System.out.println("Employee Wage: " +empWage);

}
}
