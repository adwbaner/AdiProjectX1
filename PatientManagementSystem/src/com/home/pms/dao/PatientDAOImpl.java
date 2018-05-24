package com.home.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.home.pms.dto.Patient;
import com.home.pms.exception.PatientManagementSystemException;
import com.home.pms.util.DBUtill;



public class PatientDAOImpl implements IPatientDAO 
{

	public int generatePatientId() throws PatientManagementSystemException
	{
		int patientId=0;
		
		try(Connection con=DBUtill.getConnection())
		{
			Statement stm=con.createStatement();
			ResultSet res=stm.executeQuery("select patient_id_seq.nextVal from dual");
			
			if(res.next()==false)
					throw new PatientManagementSystemException("could not generate patient id");
			patientId=res.getInt(1);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			throw new PatientManagementSystemException(e.getMessage());
			
		} 
		
		return patientId;
		
	}
	
	@Override
	public int addPatient(Patient patient) throws PatientManagementSystemException {
		
		int patientId=0;
		
		try(Connection con=DBUtill.getConnection())
		{
			patient.setPatientId(generatePatientId());
			
			PreparedStatement pstm=con.prepareStatement("insert into patient values(?,?,?,?,?,SYSDATE+1)");
			
			pstm.setInt(1, patient.getPatientId());
			pstm.setString(2, patient.getPatientName());
			pstm.setInt(3, patient.getAge());
			pstm.setString(4, patient.getPhone());
			pstm.setString(5, patient.getDescription());
			
			//conversion of util date to sql date
		/**	long dateValue=	product.getManufactureDate().getTime();//Entire util date assigned to dateValue
			System.out.println("hi");
			java.sql.Date date=new java.sql.Date(dateValue);
			pstm.setDate(5, date);**/
			
			//product detail inserted
			pstm.execute();
			
			patientId=patient.getPatientId();
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			throw new PatientManagementSystemException(e.getMessage()); 
		
		}
		
		return patientId;
		
	}

	@Override
	public Patient getPatient(int patientId) throws PatientManagementSystemException {
		
		Patient patient=new Patient();
		
		try(Connection con=DBUtill.getConnection())
		{
			PreparedStatement pstm=con.prepareStatement("select * from patient where patient_id=?");
			
			pstm.setInt(1, patientId);
			System.out.println(patientId);
			ResultSet res=pstm.executeQuery();
			
			//res.next();
			
			
			
			patient.setPatientId(res.getInt(1));
			patient.setPatientName(res.getString(2));
			patient.setAge(res.getInt(3));
			patient.setPhone(res.getString(4));
			patient.setDescription(res.getString(5));
			patient.setConsultation_date(res.getDate(6));
		}
			catch (ClassNotFoundException | SQLException e)
			{
				throw new PatientManagementSystemException(e); 
			
			}
		
		return patient;
	}

}
