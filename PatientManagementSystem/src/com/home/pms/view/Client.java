package com.home.pms.view;



import java.util.Scanner;

import com.home.pms.dto.Patient;
import com.home.pms.exception.PatientManagementSystemException;
import com.home.pms.service.IPatientService;
import com.home.pms.service.PatientServiceImpl;



public class Client {
	
	public IPatientService patientService=null;
	
	Client(){
		
		patientService=new PatientServiceImpl();
	}
	
	public void menu(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("1)Add patient");
		System.out.println("2)view patient");
		System.out.println("3)Exit");
		
		int choice=sc.nextInt();
		
		operation(choice);
		
	}
	
	private void operation(int choice) {
		switch(choice){
	case 1: addPatient(); break;
	case 2: viewPatient(); break;
	case 3: System.exit(0); break;
	default:
			System.out.println("Please provide valid input");

			break;
	}
	}
	
	
	
	

	private void viewPatient() {
		
		System.out.println("Enter id");
		Scanner console = new Scanner(System.in);
		int id = console.nextInt();
		try {
			Patient patient = patientService.getPatient(id);

			System.out.println(patient.getPatientName());
			
			System.out.println(patient.getAge());
			System.out.println(patient.getPhone());

		} catch (PatientManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addPatient()
	{
		System.out.println("Add product details");
		System.out.println("Enter patient name:");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		
		System.out.println("Enter age");
		int age=sc.nextInt();
		
		System.out.println("Enter ph no");
		String ph=sc.next();
		
		System.out.println("enter descriptiion");
		String des=sc.next();
		
		Patient patient=new Patient(name,age,ph,des);
		
		try{
			int patientId=patientService.addPatient(patient);
			System.out.println("id = "+patientId);
		}
		catch(PatientManagementSystemException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Client client = new Client();
		while (true)
			client.menu();

	}

}
