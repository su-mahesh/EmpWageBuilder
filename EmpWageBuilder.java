class EmpWageBuilder
{
	public static void main(String[] args)
{
	//constants
	int IS_FULL_TIME = 1;

	//computation
	int empCheck = (int)(Math.random() * 10) % 2;

	if ( empCheck == IS_FULL_TIME )
	System.out.println("Employee is present");

	else
	System.out.println("Employee is absent");

}

}
