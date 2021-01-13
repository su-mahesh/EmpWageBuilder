class Company
{	
	final private int EMP_RATE_PER_HOUR;
	final private int NUM_WORKING_DAYS;
	final private int MAX_WORKING_HOURS;
	final private String companyName;

	public Company(	String companyName, int EMP_RATE_PER_HOUR, int MAX_WORKING_HOURS, int NUM_WORKING_DAYS	){
		this.companyName = companyName;
		this.EMP_RATE_PER_HOUR =	EMP_RATE_PER_HOUR;
		this.NUM_WORKING_DAYS = NUM_WORKING_DAYS;
		this.MAX_WORKING_HOURS = MAX_WORKING_HOURS;
	}
	
	String getCompanyName(){
		return companyName;
	}
	int getEMP_RATE_PER_HOUR(){
		return EMP_RATE_PER_HOUR;
	}
	int getNUM_WORKING_DAYS(){
		return NUM_WORKING_DAYS;
	}
	int getMAX_WORKING_HOURS(){
		return MAX_WORKING_HOURS;
	}	
}

class Employee{
	private final String EmployeeName;
	private int wage = 0;
	
	Employee(String EmployeeName )
	{
	this.EmployeeName = EmployeeName;
	}
	
	String getEmpName()
	{
	return EmployeeName;	
	}
	
	void setWage(int wage)
	{
	this.wage = wage;
	}
	
	int getWage()
	{
	return wage;
	}	
}

class EmpWageBuilder
{
	//constants
	final	int IS_FULL_TIME = 1;
	final int IS_PART_TIME = 2;

	//variable
	static private int companyNo = 0;
	static private int empNo = 0;

	//objects
	private Company companyWageArray[];
	private Employee employeeArray[];
	
	EmpWageBuilder(int arraySize){
	companyWageArray = new Company[arraySize];
	employeeArray = new Employee[arraySize];
	}
	
	//add company
	public void addCompany(String companyName, int EMP_RATE_PER_HOUR, int MAX_WORKING_HOURS, int NUM_WORKING_DAYS){
		companyWageArray[companyNo] = new Company(companyName, EMP_RATE_PER_HOUR, MAX_WORKING_HOURS, NUM_WORKING_DAYS);
		companyNo++;
	}
	
	//add employee
	void addEmployee(String empName){
		employeeArray[empNo] = new Employee(empName);
		empNo++;
	}
	
	//calculate wage
	public void calculateEmpWage(String companyName, String empName){
		//variable
		int empIndex = 0;
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWorkingHrs = 0;
		int totalEmpWage = 0;	
		int totalEmpWorkingDays = 0;
		int workingDay = 0;
		int companyIndex = 0;
		int i = 0;
		try{
		while(!employeeArray[empIndex].getEmpName().equalsIgnoreCase(empName)){
		empIndex++;
		}
		
		while(!companyWageArray[companyIndex].getCompanyName().equalsIgnoreCase(companyName)){
		companyIndex++;
		}	
		final int EMP_RATE_PER_HOUR = companyWageArray[companyIndex].getEMP_RATE_PER_HOUR();
		final int NUM_WORKING_DAYS = companyWageArray[companyIndex].getNUM_WORKING_DAYS();
		final int MAX_WORKING_HOURS = companyWageArray[companyIndex].getMAX_WORKING_HOURS();
		companyName	=	companyWageArray[companyIndex].getCompanyName();

		System.out.println("Company Name: "	+	companyName	);

		while ( totalEmpWorkingDays < NUM_WORKING_DAYS && totalEmpWorkingHrs < MAX_WORKING_HOURS ){
			int empCheck = (int)(Math.random() * 10) % 3;
			workingDay++;

			switch ( empCheck ){
			case IS_FULL_TIME:
				empHrs = 8;
				totalEmpWorkingDays++;
				if(totalEmpWorkingHrs + empHrs > MAX_WORKING_HOURS)
					empHrs = MAX_WORKING_HOURS - totalEmpWorkingHrs;
				break;
			case IS_PART_TIME:
				empHrs = 4;
				if(totalEmpWorkingHrs + empHrs > MAX_WORKING_HOURS)
					empHrs = MAX_WORKING_HOURS - totalEmpWorkingHrs;
				totalEmpWorkingDays++;
				break;
			default:
				empHrs = 0;
			}
			
			totalEmpWorkingHrs += empHrs;			
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totalEmpWage += empWage;
			System.out.println("Day: "+workingDay+" Emp wage: " + empWage );			
		}	
		
		employeeArray[empIndex].setWage(totalEmpWage);
		System.out.println("\nCompany Name: "+ companyName +"  Employee name: "+ employeeArray[empIndex].getEmpName() +"  Total working days: "+ totalEmpWorkingDays  );
		System.out.println("Total Working Hours: " + totalEmpWorkingHrs +"  Total Wage: " + totalEmpWage +"\n");

		}catch(Exception e){
		System.out.println("Data Not Found");
		}
	}	

	public static void main(String[] args){
		EmpWageBuilder EmpWageBuilderArray = new EmpWageBuilder(5);
	
		EmpWageBuilderArray.addCompany("BMW", 20, 200, 20);
		EmpWageBuilderArray.addCompany("TATA", 20, 90, 20);
		EmpWageBuilderArray.addCompany("infosys", 30, 150, 20);
		
		EmpWageBuilderArray.addEmployee("Ram");
		EmpWageBuilderArray.addEmployee("Sahil");
		
		//computation
		EmpWageBuilderArray.calculateEmpWage("BMW", "Ram");
		EmpWageBuilderArray.calculateEmpWage("tata", "Sahil");
		EmpWageBuilderArray.calculateEmpWage("infosys", "Sahil");
	

	}

}
