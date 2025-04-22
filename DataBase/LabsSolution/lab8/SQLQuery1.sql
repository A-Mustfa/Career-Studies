use iti


----------Create a view that displays student full name, course name
-----------if the student has a grade more than 50

create view myView
as
	select st_fname + ' ' + st_lname as fullname, crs_name
	from student s inner join stud_course sc
	on s.St_Id = sc.St_Id
	inner join course c
	on c.crs_id = sc.Crs_Id
	where grade > 50

select * from myView

-----------------------------------
---Create an Encrypted view that displays manager names and the topics they teach. 

create view vmgr
with encryption
as
	select distinct ins_name, top_name
	from Instructor i inner join Department d
	on i.Ins_Id = d.Dept_Manager
	inner join Ins_Course ic
	on i.Ins_Id = ic.Ins_Id
	inner join course c
	on c.crs_id = ic.Crs_Id
	inner join topic t 
	on t.Top_Id = c.top_id

select * from vmgr
----------------------------------
-----3.	Create a view that will display Instructor Name, Department Name for the ‘SD’ or ‘Java’ Department 

create view insDep
with encryption
as
	select ins_name, dept_name
	from instructor i inner join department d
	on d.Dept_Id = i.Dept_Id and d.Dept_name in ('java' , 'sd')

select * from insDep
---------------------
--Create a view “V1” that displays student data for student who lives in Alex or Cairo. 
--Note: Prevent the users to run the following query 
--Update V1 set st_address=’tanta’
--Where st_address=’alex’;
create view v1
as
	select *
	from student
	where St_Address in ('alex','cairo')
	with check option

select * from v1
where st_address = 'cairo'

Update V1 set st_address='tanta'
Where st_address='alex'

---------------------------------
----5.	Create a view that will display the project name and the number of employees work on it. “Use Company DB”
USE Company_SD


CREATE view pro
as
	select pname,count(ESSN) as coun
	from project p inner join Works_for wf
	on p.Pnumber = wf.Pno
	group by pname

select * from pro
-----------------------------
--6.	Create index on column (Hiredate) that allow u to cluster the data in table Department. What will happen?
use iti

create clustered index myindexx
on Department(manager_hiredate)
------------------------------
--7.	Create index that allow u to enter unique ages in student table. What will happen? 

create unique index my_in
on student(st_age)
----------------------
------8	Using Merge statement between the following two tables [User ID, Transaction Amount]
use iti
create table dialy_transaction(id int primary key,
								quantity int)
go
create table las_transaction(id int not null,
								quantity int,
								)

insert into dialy_transaction
values(1,1000),(2,2000),(3,1000)
go
insert into las_transaction
values(1,4000),(4,2000),(2,10000)

merge into las_transaction t
using dialy_transaction s
on s.id = t.id
when matched
then
	update
	set t.quantity = s.quantity
when not matched
then
	insert
	values(s.id,s.quantity)
when not matched by source
then
	delete;
----------------------------------------
use sd
------
---1)	Create view named   “v_clerk” that will display employee#,project#,
---the date of hiring of all the jobs of the type 'Clerk'.

alter view v_clerk
as 
	select empfname +' ' + emplname as 'fullname', d.deptname, p.projectname,p.ProjectNo, wo.enter_date
	from employee e inner join company.department d
	on  d.DeptNo = e.DeptNo
	inner join works_on wo
	on e.EmpNo = wo.EmpNo
	inner join company.project p
	on p.ProjectNo = wo.ProjectNo
	and wo.Job = 'clerk'

select * from v_clerk
-------------------------------------------
-----2 Create view named  “v_without_budget” that will display all the projects data 
-----without budget

create view v_without_budget
as
	select projectNo, projectname
	from company.project

select * from v_without_budget
-------------------------
----3)	Create view named  “v_count “ that will display the project name and the # of jobs in it
create view v_count
as
	select p.projectname,count(job) as num_of_jobs
	from company.project p inner join works_on wo
	on p.ProjectNo = wo.ProjectNo
	group by(p.ProjectName)

------------------------
---4) Create view named ” v_project_p2” that will display the emp# s for the project# ‘p2’
----use the previously created view  “v_clerk”

create view v_project_p2
as
	select * from v_clerk
	where projectno = 'p2'
-------------------------
-----5 	modifey the view named  “v_without_budget”  to display all DATA in project p1 and p2 
alter view v_without_budget
as
	select * from company.project 
	where projectno in ('p1','p2')

select * from v_without_budget
------------------------
---6)	Delete the views  “v_ clerk” and “v_count”


drop view v_clerk,v_count
