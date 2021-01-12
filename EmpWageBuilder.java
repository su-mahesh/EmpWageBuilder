class Company
{	
	private int EMP_RATE_PER_HOUR = 0;
	private int NUM_WORKING_DAYS = 0;
	private int MAX_WORKING_HOURS = 0;
	private String companyName = null;

	Company(	String companyName, int EMP_RATE_PER_HOUR, int MAX_WORKING_HOURS, int NUM_WORKING_DAYS	)
	{
//	System.out.println("c " + companyName );
	this.companyName = companyName;
	this.EMP_RATE_PER_HOUR =	EMP_RATE_PER_HOUR;
	this.NUM_WORKING_DAYS = NUM_WORKING_DAYS;
	this.MAX_WORKING_HOURS = MAX_WORKING_HOURS;
	}
	
	String getCompanyNmae()
	{
	return companyName;
	}
	int getEMP_RATE_PER_HOUR()
	{
	return EMP_RATE_PER_HOUR;
	}
	int getNUM_WORKING_DAYS()
	{
	return NUM_WORKING_DAYS;
	}
	int getMAX_WORKING_HOURS()
	{
	return MAX_WORKING_HOURS;
	}
	
}

class EmpWageBuilder
{

	//constants
	final	int IS_FULL_TIME = 1;
	final int IS_PART_TIME = 2;

public void calculateEmpWage(Company company)
{
	//variable
	int empHrs = 0;
	int empWage = 0;
	int totalEmpWorkingHrs = 0;
	int totalEmpWage = 0;	
	int totalEmpWorkingDays = 0;
	

	int EMP_RATE_PER_HOUR = company.getEMP_RATE_PER_HOUR();
	int NUM_WORKING_DAYS = company.getNUM_WORKING_DAYS();
	int MAX_WORKING_HOURS = company.getNUM_WORKING_DAYS();
	String companyName	=	company.getCompanyNmae();
	
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

}	System.out.println("Company Name: "	+	companyName	);
	System.out.println("Total working days: "+ totalEmpWorkingDays +" Total Working Hours: " + totalEmpWorkingHrs + " Total Wage: " + totalEmpWage +"\n");
}	

	public static void main(String[] args)
{
	EmpWageBuilder EmpWage = new EmpWageBuilder();
	
	
	Company BMW = new Company("BMW", 20, 20, 100);
	Company Maruti = new Company("Maruti", 10, 15, 80);
	Company TATA = new Company("TATA", 22, 30, 120);
	//computation
	EmpWage.calculateEmpWage(	BMW	);
	
	EmpWage.calculateEmpWage(	Maruti	);

	EmpWage.calculateEmpWage(	TATA	);
	
	
}

}
