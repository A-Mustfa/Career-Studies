create table Department(DeptNo varchar(10) primary key,
				Deptname varchar(20),
				Location varchar(2))

		sp_addtype ndt , 'nchar(2)'

		create default d1 as 'NY'
		create rule r1 as @x in('NY','DS','KW')
		sp_bindrule r1,ndt
		go
		sp_bindefault d1,ndt

alter table Department alter column Location ndt


insert into Department 
values('d1','Research','NY'),('d2','Accounting','DS'),('d3','Markiting','KW')


---------

create table Employee(emp_number int ,
					emp_fname varchar(20) not NULL,
					emp_lname varchar(20) not NULL,
					dept_no varchar(10),
					salary int,
					constraint c1 primary key (emp_number),
					constraint c2 foreign key (dept_no) references Department(DeptNo),
					constraint c3 unique(salary)
					)
create rule r2 as @x<6000
sp_bindrule r2,'Employee.salary'


insert into Employee 
values (25348,'Mathew','Smith','d3',2500),
(10102,'Ann','Jones','d3',3000)
,(18316,'John','Barrimore','d1',2400)
,(29346,'James','James','d2',2800)
,(9031,'Lisa','Bertoni','d2',4000)
,(2581,'Elisa','Hansel','d2',3600)
,(28559,'Sybl','Moser','d1',2900)
-----------------------------
update employee
	set emp_number = 2222	where emp_number = 10102

Delete from employee 
where emp_number = 10102
--------
alter table employee add TelephoneNumber int

alter table employee drop column TelephoneNumber
----------------------
--2
--a
create schema company
go
alter schema company transfer Department

--b
create schema HumanResources
go
alter schema HumanResources transfer Employee
---------------------------
--3
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
From INFORMATION_SCHEMA.TABLE_CONSTRAINTS
Where TABLE_NAME = 'employee'
----------------------------
--4
create synonym emp
for HumanResources.Employee

--a
select * from employee
--b
select * from HumanResources.employee
--c
select * from emp
--d
select * from HumanResources.emp
---------------------------------
-------5
update p
	set p.budget *= 1.10
from works_on inner join company.project p
on p.projectNo = works_on.projectNo  
where job = 'manager' and empno = 10102

-----------------------------
---------6
update d
	set d.deptname = 'Sales'
from Humanresources.employee e inner join company.department d
on d.deptno = e.dept_no
where e.emp_fname = 'james' 
---------------------------
-------7
update works_on
	set enter_date = '12.2.2007'
from company.project p inner join works_on w
on p.projectNo = w.projectNo
inner join emp
on emp.emp_number = w.empNO
inner join company.department
on department.deptno = emp.dept_no
where p.projectNo = 'p1' and deptName = 'sales'


-----------------------------
---------8
delete from works_on
where empno in (select emp_number
					from company.department d inner join emp
					on d.deptno = emp.dept_no and location ='KW'
					)

---------------------------
------9
use iti

create schema users
go
alter schema users transfer student
go
alter schema users transfer  course