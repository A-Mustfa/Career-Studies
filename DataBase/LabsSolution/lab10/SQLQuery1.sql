declare c1 cursor 
for
	select st_id,st_fname
	from student
	where St_Address = 'cairo'
for read only  --cursor behavior by defualt its 'update'
declare @id int,@name varchar(20)
open c1
fetch c1 into @id, @name
while @@FETCH_STATUS=0
	begin
		select @id , @name
		fetch c1 into @id, @name
	end
close c1
deallocate c1

----
--put variable in the same row
declare c1 cursor 
for
	select st_fname
	from student
	where St_Address = 'cairo'
for read only  --cursor behavior by defualt its 'update'
declare @name varchar(20) ,@result varchar(80)
open c1
fetch c1 into  @name
while @@FETCH_STATUS=0
	begin
		select @result = concat(@result , '', @name , ', ')
		fetch c1 into @name
	end
select @result
close c1
deallocate c1
---------
use iti
bulk insert bulkint
from 'F:\LAB\bulk.txt'
with(fieldterminator=',')

----------------------------
create database itisnap
on
(
name ='ITI',
filename='F:\LAB\itisnap.ss'
)
as snapshot of iti

use iti
go
select * from student
where st_id in(1,2,3,4,5)

use itisnap
select * from student
where st_id in(1,2,3,4,5)
--------------------------------------
--lab
--1.	Create a cursor for Employee table that increases Employee salary by 10% if Salary <3000 and increases it by 20% if Salary >=3000.
--Use company DB
use Company_SD


declare c1 cursor
for
	select salary from Employee
for update

declare @sal int
open c1
fetch c1 into @sal
while @@fetch_status = 0
	begin
		if(@sal>=3000)
			update Employee
				set Salary = salary*1.20
			where current of c1
		else
			update Employee
				set Salary = salary*1.10
				where current of c1
	fetch c1 into @sal
	end
close c1
deallocate c1
--------------------------------
--2.	Display Department name with its manager name using cursor. Use ITI DB
use iti
declare c1 cursor
for
	select d.dept_name , i.Ins_Name 
	from instructor i inner join department d
	on i.Ins_Id = d.Dept_Manager
for read only

declare @dname varchar(20), @mname varchar(20)
open c1
fetch c1 into @dname, @mname
while @@FETCH_STATUS = 0
	begin
		select @dname as 'department name', @mname as 'dept manager'
		fetch c1 into @dname, @mname
		end
close c1
deallocate c1
---------------------------------------
--3.	Try to display all students first name in one cell separated by comma. Using Cursor
declare c1 cursor
for
	select st_fname	
	from student
for read only

declare @name varchar(20), @result varchar(80)
open c1
fetch c1 into @name
while @@fetch_status = 0
	begin
		set @result = concat(@result, @name,', ')
		fetch c1 into @name
	end
select @result
close c1
deallocate c1
---------------------------------
--4.	Create full, differential Backup for SD DB.
backup database iti
to disk = 'F:\LAB\lab10\iti.bak'

backup database iti
to disk = 'F:\LAB\lab10\itidiff.bak'
with differential
-----------------------------------
--5.	Use import export wizard to display students data (ITI DB) in excel sheet
-----------------------------
---6 try to generate script from DB ITI that describes all tables and views in this DB



