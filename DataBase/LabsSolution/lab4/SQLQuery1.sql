/*
1.	Display (Using Union Function)
a.	 The name and the gender of the dependence that's gender is Female and depending on Female Employee.
b.	 And the male dependence that depends on Male Employee.
2.	For each project, list the project name and the total hours per week (for all employees) spent on that project.
3.	Display the data of the department which has the smallest employee ID over all employees' ID.
4.	For each department, retrieve the department name and the maximum, minimum and average salary of its employees.
5.	List the last name of all managers who have no dependents.
6.	For each department-- if its average salary is less than the average salary of all employees-- display its number, name and number of its employees.
7.	Retrieve a list of employees and the projects they are working on ordered by department and within each department, ordered alphabetically by last name, first name.
8.	Try to get the max 2 salaries using subquery
9.	Get the full name of employees that is similar to any dependent name
10.	Try to update all salaries of employees who work in Project ‘Al Rabwah’ by 30% 
11.	Display the employee number and name if at least one of them have dependents (use exists keyword) self-study.

DML

*/
----1.	Display (Using Union Function)
--a.	 The name and the gender of the dependence that's gender is Female and depending on Female Employee.
--b.	 And the male dependence that depends on Male Employee.
select d.Dependent_name , d.sex
from Dependent d inner join Employee e
on e.ssn = d.essn and e.sex = 'f' and d.sex='f'
union all
select d.Dependent_name , d.sex
from Dependent d inner join Employee e
on e.ssn = d.essn and e.sex = 'm' and d.sex='m'

-------------------------------
--2.	For each project, list the project name and the total hours per week (for all employees) spent on that project.
select p.pname,sum(hours)
from project p left join Works_for
on p.Pnumber = Works_for.pno
group by p.Pname

--------------------------------
--3.	Display the data of the department which has the smallest employee ID over all employees' ID.
select d.dname, d.dnum, d.mgrssn,min(e.ssn)
from departments d inner join employee e
on d.dnum = e.dno
group by  d.dname, d.dnum, d.mgrssn


select d.*
from departments d inner join employee e
on d.dnum = e.dno
where e.ssn in (select min(ssn)
				from employee)
-----------------------
--4.	For each department, retrieve the department name and the maximum, minimum and average salary of its employees.
select d.dname,min(e.salary), max(e.salary), avg(e.salary)
from departments d inner join employee e
on d.dnum = e.dno
group by  d.dname
------------------
--5.	List the last name of all managers who have no dependents.
select e.lname
from employee e inner join departments d
on e.ssn = d.mgrssn and d.mgrssn not in(select essn from dependent)

-----------------
--6.	For each department-- if its average salary is less than the average salary of all employees-- display its number, name and number of its employees.
select d.Dname , d.Dnum, count(E.SSN) as count
from employee e inner join departments d
on e.dno = d.Dnum
group by d.Dname, D.DNUM
having avg(Salary) <(select avg(salary)
					from employee)
------------------
---7.	Retrieve a list of employees and the projects they are working on ordered by department and within each department, ordered alphabetically by last name, first name.
select e.*, p.pname
from Employee e inner join Works_for wf
on wf.ESSn = e.SSN
inner join Project p
on p.Pnumber = wf.Pno
inner join Departments d
on d.Dnum = e.Dno
order by d.dname ,e.lname asc, fname asc

----------------
-------8 Try to get the max 2 salaries using subquery
select top(2)salary
from Employee
order by Salary desc


-------------
----9.	Get the full name of employees that is similar to any dependent name
select fname + ' ' + lname as 'fullname'
from employee
intersect
select Dependent_name
from Dependent

select distinct fname + ' ' + lname as 'fullname' 
from employee e inner join Dependent d
on e.ssn = d.ESSN
where d.Dependent_name like '%' + fname + ' ' + lname + '%'


-------------------------
---10.	Try to update all salaries of employees who work in Project ‘Al Rabwah’ by 30% 
update Employee
		set salary += (salary* 0.20)
where ssn in (select e.ssn
				from Employee e inner join Works_for wf
				on wf.ESSn = e.SSN
				inner join Project p
				on p.Pnumber = wf.Pno
				where p.pname = 'Al Rabwah')

-------------------------
--11.	Display the employee number and name if at least one of them have dependents (use exists keyword) self-study.



----------------------

--1.	In the department table insert new department called "DEPT IT" , with id 100, employee with SSN = 112233 as a manager for this department. The start date for this manager is '1-11-2006'

insert into Departments(Dname, Dnum, MGRSSN,[MGRStart Date])
values('DEPT IT',100,112233,1-11-2006)

-------------------
---2.	Do what is required if you know that : Mrs.Noha Mohamed(SSN=968574)  moved to be the manager of the new department (id = 100), and they give you(your SSN =102672) her position (Dept. 20 manager) 

/*a.	First try to update her record in the department table
b.	Update your record to be department 20 manager.
c.	Update the data of employee number=102660 to be in your teamwork (he will be supervised by you) (your SSN =102672)*/
update Departments
	set MGRSSN = 968574
	,[MGRStart Date] = GETDATE()
where Departments.Dnum = '100'

update Departments
	set MGRSSN = 102672
	,[MGRStart Date] = GETDATE()
where Departments.Dnum = '20'

update Employee
set Superssn = 102672
where SSN = 102660

--3.	Unfortunately the company ended the contract with Mr. Kamel Mohamed (SSN=223344) so try to delete his data from your database in case you know that you will be temporarily in his position.
--Hint: (Check if Mr. Kamel has dependents, works as a department manager, supervises any employees or works in any projects and handle these cases).



update Employee
set Superssn = 102672
where Superssn = 223344

delete from Dependent
where essn = 223344

update Departments
set mgrssn = 102672
where mgrssn = 223344

update Works_for
set essn = 102672
where essn = 223344








