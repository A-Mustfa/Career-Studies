/* Try to create the following Queries:

1.	Display the Department id, name and id and the name of its manager.
2.	Display the name of the departments and the name of the projects under its control.
3.	Display the full data about all the dependence associated with the name of the employee they depend on him/her.
4.	Display the Id, name and location of the projects in Cairo or Alex city.
5.	Display the Projects full data of the projects with a name starts with "a" letter.
6.	display all the employees in department 30 whose salary from 1000 to 2000 LE monthly
7.	Retrieve the names of all employees in department 10 who works more than or equal10 hours per week on "AL Rabwah" project.
8.	Find the names of the employees who directly supervised with Kamel Mohamed.
9.	Retrieve the names of all employees and the names of the projects they are working on, sorted by the project name.
10.	For each project located in Cairo City , find the project number, the controlling department name ,the department manager last name ,address and birthdate.
11.	Display All Data of the mangers
12.	Display All Employees data and the data of their dependents even if they have no dependents

Data Manipulating Language:

1.	Insert your personal data to the employee table as a new employee in department number 30, SSN = 102672, Superssn = 112233, salary=3000.

2.	Insert another employee with personal data your friend as new employee in department number 30, SSN = 102660, but don’t enter any value for salary or manager number to him.

3.	Upgrade your salary by 20 % of its last value.
*/
---------------
---1. Display the Department id, name and id and the name of its manager.
select D.Dnum as 'department_id' , d.Dname as 'department_name', d.MGRSSN as 'manager id', e.fname + ' ' + e.lname as 'manager name'
from Employee e inner join Departments d
on e.SSN = d.MGRSSN

--or 
select D.Dnum as 'department_id' , d.Dname as 'department_name', d.MGRSSN as 'manager id', e.fname + ' ' + e.lname as 'manager name'
from Employee e , Departments d
where e.SSN = d.MGRSSN
----------------
------2.	Display the name of the departments and the name of the projects under its control.
select  d.Dname as 'department_name', p.pname  as 'project name'
from project p inner join Departments d
on d.Dnum = p.Dnum
----------------
----3.	Display the full data about all the dependence associated with the name of the employee they depend on him/her.
select  d.*, e.fname
from Employee e inner join Dependent d
on e.SSN = d.ESSN

-----------------
-----4.	Display the Id, name and location of the projects in Cairo or Alex city.
select pnumber, pname, plocation
from project
where city = 'cairo'

---------------
------5.	Display the Projects full data of the projects with a name starts with "a" letter.
select *
from project
where pname like 'a%'


--------------
----6.	display all the employees in department 30 whose salary from 1000 to 2000 LE monthly
select *
from employee
where dno = 30 and salary between 1000 and 2000



-------------
------7.	Retrieve the names of all employees in department 10 who works more than or equal10 hours per week on "AL Rabwah" project.
select e.* 
from employee e inner join works_for wf
on e.ssn = wf.essn and e.dno = 10
   inner join
   project p
on p.pnumber = wf.pno and hours >= 10 and p.pname = 'AL Rabwah'




-----------
-----8.	Find the names of the employees who directly supervised with Kamel Mohamed.
select e.*
from employee e , employee s
where s.ssn = e.superssn and s.fname+ ' ' +s.lname = 'kamel mohamed' 


---------
------9.	Retrieve the names of all employees and the names of the projects they are working on, sorted by the project name.
select e.* , p.pname
from employee e inner join works_for wf
on e.ssn = wf.essn
   inner join
   project p
on p.pnumber = wf.pno
order by pname



----------
-----10.	For each project located in Cairo City , find the project number, the controlling department name ,the department manager last name ,address and birthdate.
select p.pname, p.pnumber, d.dname, e.lname, e.address, e.bdate
from project p inner join Departments d
on d.Dnum = p.Dnum and p.city='cairo'
	inner join employee e
	on e.SSN = d.MGRSSN


--------
----11.	Display All Data of the mangers
select  e.*
from Departments d inner join employee e
on e.SSN = d.MGRSSN


-------------
-----12.	Display All Employees data and the data of their dependents even if they have no dependents
select  e.*, d.*
from Dependent d right outer join employee e
on e.SSN = d.ESSN
------------------------------------------------------------------
--Data Manipulating Language:

----1.	Insert your personal data to the employee table as a new employee in department number 30, SSN = 102672, Superssn = 112233, salary=3000.
insert into employee
values('ahmed','mostafa',102672,16-12-1999,'sharqia','m',3000,112233,30)


---------
----2.	Insert another employee with personal data your friend as new employee in department number 30, SSN = 102660, but don’t enter any value for salary or manager number to him.
insert into employee(fname,lname,ssn,bdate,Address,Sex,Dno)
values('mohamed','bla bla',102660,11-11-1911,'bla bla','m',30)

--------------
---3.	Upgrade your salary by 20 % of its last value.
update employee
	set Salary = salary +(salary*0.20)
where SSN = 102672