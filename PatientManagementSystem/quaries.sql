Create table Patient(
Patient_Id number(10) PRIMARY KEY,
patient_name varchar2(20),
age number(3),
phone varchar2(10),
description varchar2(80),
consultation_date date
);

create sequence patient_id_seq start with 1000;

desc Patient;
select * from patient;

select * from product;