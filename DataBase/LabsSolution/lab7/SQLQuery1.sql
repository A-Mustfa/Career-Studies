use iti
------------
--1.	Create a scalar function that takes date 
--and returns Month name of that date.
create function getMonth(@x date)returns varchar(20)
as
	begin
		declare @y varChar(20)
		set @y = format(@x,'MMMM')
		return @y
	end

select dbo.getMonth(getdate())
-------------------------
--2 Create a multi-statements table-valued function that takes 2 integers
--and returns the values between them.
create function bet(@x int, @y int) returns @t table(valu int) 
begin
	while(@x+1 < @y)
		begin
			set @x+=1;
			insert into @t
			select @x
		end
	return
end

select * from bet(1,9)
-------------------------------
--3 Create inline function that takes Student No 
--and returns Department Name with Student full name.

create function studinf(@x int) returns table
as return 
(	
	select dept_id , st_fname + ' ' + st_lname as 'full name'
	from users.student
	where st_id = @x
)

select * from studinf(2)
----------------------------------
--4.	Create a scalar function that takes Student ID and returns a message to user 
--a.	If first name and Last name are null then display 'First name & last name are null'
--b.	If First name is null then display 'first name is null'
--c.	If Last name is null then display 'last name is null'
--d.	Else display 'First name & last name are not null'

ALTER function sDate(@id int) returns varchar(20)
begin
	declare @y varchar(20)  ,@w varchar(20), @s varchar(20)
	select @w= st_fname ,  @s=st_lname
	from student
	where st_id = @id
	if @w  is null and @s  is null
		select  @y = 'f name and last name is null'
	else if @w  is null
		select @y = 'f name and last name is null'
	else if @s  is null
		select @y=  'f name and last name is null'
	else 
	select @y= 'f name &last are not null'
	return @y;
end
select dbo.sdate(4)
----------------------------
--5.Create inline function that takes integer which 
--represents manager ID and displays department name, Manager Name and hiring date 
create function mdate(@id int)returns table
as return
(
	select d.Dept_Manager,d.dept_name, m.ins_name, d.manager_hiredate
	from Instructor m inner join department d
	on m.Ins_Id = d.Dept_Manager
	where d.Dept_Manager = @id
)


select * from mdate(4)

-----------------------------------
---6.	Create multi-statements table-valued function that takes a string
If string='first name' returns student first name
If string='last name' returns student last name 
If string='full name' returns Full Name from student table 
Note: Use “ISNULL” function

alter function stname(@y varchar(20)) returns @t table(name varchar(20))
begin
	if(@y = 'first name')
		insert into @t
		select isnull(st_fname,'haha') from student
	if(@y = 'last name')
		insert into @t
		select isnull(st_lname,'haha') from student
	if(@y = 'full name')
		insert into @t
		select isnull(st_fname,'ha' + ' ' + isnull(st_lname,'ha')) from student
	return
end

select * from stname('first name')
------------------------------------
---7.	Write a query that returns the Student No
--and Student first name without the last char
select st_id , substring(st_fname,1,len(st_fname)-1)
from student

--------------------
--8.	Wirte query to delete all grades for the students Located in SD Department 

update Stud_Course
	set grade = NULL
from stud_course sc inner join student s
on s.st_id = sc.st_id
inner join department d
on d.Dept_Id = s.dept_id
where d.Dept_Name = 'SD'
select * from Stud_Course
---------------------------------
----
use Company_SD
go
declare @x int =0
while (@x < 3000)
	begin
		insert into Employee(ssn,lname,Fname,Dno) values(@x,'jane','smith',10)
		set @x+=1
	end

