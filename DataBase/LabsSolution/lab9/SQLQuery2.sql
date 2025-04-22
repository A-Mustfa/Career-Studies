--1.Create a stored procedure without parameters to show the number of students per department name.[use ITI DB]

use iti
create proc nOfS
as
	select d.dept_name , count(st_id) as number
	from student s inner join department d
	on d.Dept_Id = s.Dept_Id
	group by d.Dept_Name

nOfS
------------------------------------------------
--2. Create a stored procedure that will check for the # of employees in the project p1
--if they are more than 3 print message to the user 
--“'The number of employees in the project p1 is 3 or more'”
--if they are less display a message to the user “'The following employees work for the project p1'”
--in addition to the first name and last name of each one. [Company DB] 

use Company_SD
go

create function nuOfEmp() returns int
begin
	declare @x int
	set @x=(
	select count(wf.pno)
	from project p inner join works_for wf
	on p.pnumber = wf.pno and wf.pno= '100')
	return @x
end

alter proc empInfo
as 
	declare @x int = dbo.nuOfEmp()
	if(@x >= 3)
		select 'The number of employees in the project p1 is 3 or more'
	else
		begin
			select 'The following employees work for the project p1' 
			union all
			select concat(emp.fname, ' ' , emp.lname) as full_name
			from employee emp inner join works_for wf
			on emp.ssn = wf.essn and wf.pno = 100
		end

empInfo

------------------------
alter table project add budget int

create table audit(pnumber int,userName varchar(50),modifiedDate date,BudgetOld int, Budget_New int)

create trigger au_tr
on project
after update
as
	if update(budget)
	declare @old int , @new int, @pn int
	begin
		select @old = (select budget from deleted),
		@new = (select budget from inserted)
		insert into audit
		values((select pnumber from deleted), SUSER_NAME(), getdate(),@old, @new)
	end

update project
	set budget = 50000
where pnumber = 100
------------------------
--5.Create a trigger to prevent anyone from inserting a new record in the Department table [ITI DB]
--“Print a message for user to tell him that he can’t insert a new record in that table”
use iti
go
alter table department drop trigger t6
go
create trigger prev
on department
instead of insert
as
	select 'you can''t insert data'

---------------------
--6 Create a trigger that prevents the insertion Process for Employee table in March [Company DB].
use Company_SD
create trigger march
on employee
after insert
as
	if format(getdate(),'MMMM') = 'march'
		begin
			delete from employee where ssn=(select ssn from inserted)
		end


-- or
create trigger march2
on employee
instead of insert
as
	if format(getdate(),'MMMM') != 'march'
		begin
			insert into employee
			select * from inserted
		end
-----------------------
--8.Create a trigger on student table instead of delete to add Row in
--Student Audit table (Server User Name, Date, Note)
--where note will be“ try to delete Row with Key=[Key Value]”

use iti

create table student_audit(server_user_name varchar(50), date date,Note varchar(80))


create trigger stu
on student 
instead of delete
as
	declare @x int=( select st_id from deleted)
	insert into student_audit
	values(@@SERVERNAME , GETDATE(), concat('try to delete Row with Key=',@x))

delete from Student
where st_id = 5
---------------------------9
select * from student
for xml raw

select * from student
for xml raw('student')

select * from student
for xml raw('student'),elements


