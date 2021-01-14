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
	//constants
	private final String EmployeeName;
	//variables
	private ArrayList<Integer> dailyWage = new ArrayList<Integer>();
	private int totalWage = 0;
	
	Employee(String EmployeeName )
	{
	this.EmployeeName = EmployeeName;
	}
	
	//fucntions
	String getEmpName()
	{
	return EmployeeName;
	}
	
	void setTotalWage(int totalWage)
	{
	this.totalWage = totalWage;
	}
	
	void setDailyWage(int dailyWage){
	this.dailyWage.add(dailyWage);
	}
	void getDailyWage(){
	int i = 1;
	for (Integer daily_Wage : dailyWage){
	System.out.println("Day "+i+"		wage: "+daily_Wage);
	i++;
	}
	System.out.println("\ntotal wage: "+totalWage);
	}
	void getTotalWage()
	{
	System.out.println("\ntotal wage: "+totalWage);

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
	//get daily wage
	void getDailyWage()
	{
	int empIndex = 0;
	System.out.println("Enter employee name: ");
	String empName = sc.nextLine();
	try{
	while(!empList.get(empIndex).getEmpName().equalsIgnoreCase(empName))
		empIndex++;
		empList.get(empIndex).getDailyWage();
		}catch(Exception e)
	{System.out.println("Data not found");
	}
	}
	
	void getTotalWage(){
	int empIndex = 0;
	System.out.println("Enter employee name: ");
	String empName = sc.nextLine();
	try{
	while(!empList.get(empIndex).getEmpName().equalsIgnoreCase(empName))
		empIndex++;
		empList.get(empIndex).getTotalWage();
	
	}catch(Exception e)
	{System.out.println("Data not found");
	}
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
			empList.get(empIndex).setDailyWage(empWage);
			totalEmpWage += empWage;
			System.out.println("Day: "+workingDay+" Emp wage: " + empWage );			
		}	
		
		empList.get(empIndex).setTotalWage(totalEmpWage);
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

		while(choice != 6){
		
			System.out.println("\n*******Employee wage builder*******");
			System.out.println("1. add company 	  2. add employee");
			System.out.println("3. Calcualte wage 4. get daily wage ");
			System.out.println("5. get total wage 6. exit");

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
					empWageBuilder.getDailyWage();
					break;		
				case 5:
					empWageBuilder.getTotalWage();
					break;
				case 6:
					break;		
				default:
					System.out.println("wrong choice");	
			}
		}
	}
}
