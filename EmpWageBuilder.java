import java.util.*;

class Company
{	
	//constants
	final private int EMP_RATE_PER_HOUR;
	final private int MAX_WORKING_DAYS;
	final private int MAX_WORKING_HOURS;
	final private String companyName;

	public Company(	String companyName, int EMP_RATE_PER_HOUR, int MAX_WORKING_HOURS, int MAX_WORKING_DAYS	){
		this.companyName = companyName;
		this.EMP_RATE_PER_HOUR =	EMP_RATE_PER_HOUR;
		this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
		this.MAX_WORKING_HOURS = MAX_WORKING_HOURS;
	}
	
	String getCompanyName(){
		return companyName;
	}
	int getEMP_RATE_PER_HOUR(){
		return EMP_RATE_PER_HOUR;
	}
	int getMAX_WORKING_DAYS(){
		return MAX_WORKING_DAYS;
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
	Scanner sc = new Scanner(System.in);
	ArrayList<Company> companyList=new ArrayList<Company>();
	ArrayList<Employee> empList=new ArrayList<Employee>();
	
	//add company
	public void addCompany(){
	try{
		System.out.println("Enter company name: ");
		String companyName = sc.nextLine();
		
		System.out.println("Enter emp wage rate per hour: ");
		int EMP_RATE_PER_HOUR = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter max working hours: ");
		int MAX_WORKING_HOURS = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter max working days: ");
		int MAX_WORKING_DAYS = Integer.parseInt(sc.nextLine());
		
		companyList.add(new Company(companyName, EMP_RATE_PER_HOUR, MAX_WORKING_HOURS, MAX_WORKING_DAYS));
		
		
	}catch(Exception e)
	{
		System.out.println("wrong input");
	}
	}
	
	//add employee
	void addEmployee(){
		System.out.println("Enter empolyee name: ");
		String empName = sc.nextLine();
		empList.add(new Employee(empName));
	}
	
	//calculate wage
	public void calculateEmpWage(){
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
		
		System.out.println("Enter company name: ");
		String companyName = sc.nextLine();
		
		System.out.println("Enter empolyee name: ");
		String empName = sc.nextLine();
		
		try{
		while(!empList.get(empIndex).getEmpName().equalsIgnoreCase(empName)){
		empIndex++;
		}
		
		while(!companyList.get(companyIndex).getCompanyName().equalsIgnoreCase(companyName)){
		companyIndex++;
		}	
		final int EMP_RATE_PER_HOUR = companyList.get(companyIndex).getEMP_RATE_PER_HOUR();
		final int MAX_WORKING_DAYS = companyList.get(companyIndex).getMAX_WORKING_DAYS();
		final int MAX_WORKING_HOURS = companyList.get(companyIndex).getMAX_WORKING_HOURS();
		companyName	=	companyList.get(companyIndex).getCompanyName();

		System.out.println("Company Name: "	+	companyName	);

		while ( totalEmpWorkingDays < MAX_WORKING_DAYS && totalEmpWorkingHrs < MAX_WORKING_HOURS ){
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
		
		empList.get(empIndex).setWage(totalEmpWage);
		System.out.println("\nCompany Name: "+ companyName +"  Employee name: "+ empList.get(empIndex).getEmpName() +"  Total working days: "+ totalEmpWorkingDays  );
		System.out.println("Total Working Hours: " + totalEmpWorkingHrs +"  Total Wage: " + totalEmpWage +"\n");

		}catch(Exception e){
		System.out.println("Data Not Found");
		}
	}	

	public static void main(String[] args){
	
		EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);

		while(choice != 4){
		
			System.out.println("\n*******Employee wage builder*******");
			System.out.println("1. add company 2. add employee");
			System.out.println("3. Calcualte wage 4. exit");

			try{
				choice = Integer.parseInt(sc.nextLine());
				}catch(Exception e){
				System.out.println("wrong input");
				break;
				}
							
			switch(choice){
				case 1:
					empWageBuilder.addCompany();
					break;
				case 2:
					empWageBuilder.addEmployee();
					break;
				case 3:
					empWageBuilder.calculateEmpWage();
					break;
				case 4:
					break;	
				default:
					System.out.println("wrong choice");	
			}
		}
	}
}
