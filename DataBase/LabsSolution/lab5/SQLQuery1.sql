
--1.	Retrieve number of students who have a value in their age. 
select count(st_id) 
from student
where st_age is not null


--2.	Get all instructors Names without repetition
select distinct ins_name
from Instructor


--3.	Display student with the following Format (use isNull function)
select d.Dept_Id as 'department id', isnull(s.st_fname+ ' ' + s.st_lname, 'no name') as 'full name' , isnull(d.dept_name, 'no dept name') as 'department name'
from student s inner join Department d
on s.Dept_Id = d.Dept_Id


--4.	Display instructor Name and Department Name 
--Note: display all the instructors if they are attached to a department or not

select ins.ins_name, dep.dept_name
from instructor ins left join department dep
on dep.Dept_Id = ins.Ins_Id


--5.	Display student full name and the name of the course he is taking
--For only courses which have a grade  
select st_fname+' '+st_lname , crs_name
from student inner join Stud_Course
on student.st_id = Stud_Course.St_Id
inner join course
on course.Crs_Id = Stud_Course.Crs_Id
where Stud_Course.Crs_Id is not null


--6.	Display number of courses for each topic name
select count(crs_id), top_name
from topic t inner join course
on t.Top_Id = course.Top_Id
group by top_name


---7.	Display max and min salary for instructors
select max(salary)as 'max salary', min(salary)as  'min salary'
from instructor


---8.	Display instructors who have salaries less than the average salary of all instructors.
select ins_name
from instructor
where salary < (select avg(salary)
				from instructor)


--9.	Display the Department name that contains the instructor who receives the minimum salary.
select dept_name
from instructor inner join Department
on Department.Dept_Id =  Instructor.Dept_Id
where salary = (select min(salary) from instructor)


--10  Select max two salaries in instructor table. 
select top(2) salary 
from Instructor
order by salary desc



--11.	 Select instructor name and his salary but if there is no salary display instructor bonus keyword. “use coalesce Function”
select ins_name , coalesce(convert(varchar(20),salary),'instructor bonus')
from instructor

--12.	Select Average Salary for instructors 
select avg(salary)
from instructor


--13.	Select Student first name and the data of his supervisor 
select s.st_fname,super.*
from student s inner join Student super
on super.St_id = s.St_super


--14.	Write a query to select the highest two salaries in Each Department for instructors who have salaries. “using one of Ranking Functions”
select *
from ( select salary,dept_id, row_number() over(partition by dept_id order by salary desc) as rn
		from instructor
		where salary is not null) as virtual
where rn <=2

--15.	 Write a query to select a random  student from each department.  “using one of Ranking Functions”
select *
from ( select salary,dept_id, row_number() over(partition by dept_id order by newid() desc) as rn
		from instructor
		where salary is not null) as virtual
where rn =1
---------------------------
use AdventureWorksLT2012
--1.	Display the SalesOrderID, ShipDate of the SalesOrderHeader table (Sales schema) to show SalesOrders that occurred
--within the period ‘7/28/2002’ and ‘7/29/2014’

select SalesOrderID, ShipDate
from SalesLT.SalesOrderHeader
where OrderDate between '7-28-2002' and '7-29-2014'


--2.	Display only Products(Production schema) with a StandardCost below $110.00 (show ProductID, Name only)
select ProductID, Name
from SalesLT.Product 
where StandardCost < 110

--3.	Display ProductID, Name if its weight is unknown
select ProductID
from SalesLT.Product 
where Weight is null

--4 Display all Products with a Silver, Black, or Red Color
select *
from SalesLT.Product
where Color in ('Silver', 'Black','Red')


--5.	 Display any Product with a Name starting with the letter B
select *
from SalesLT.Product
where name like 'B%'


--6 6.	Run the following Query
UPDATE SalesLT.ProductDescription
SET Description = 'Chromoly steel_High of defects'
WHERE ProductDescriptionID = 3
--Then write a query that displays any Product description with underscore value in its description.
select * 
from SalesLT.ProductDescription
where Description like '%[_]%'


--7.	Calculate sum of TotalDue for each OrderDate in Sales.SalesOrderHeader table for the period between  '7/1/2001' and '7/31/2014'
select sum(TotalDue), OrderDate
from SalesLT.SalesOrderHeader
where OrderDate between '7/1/2001' and '7/31/2014'
group by OrderDate

--8.	 Display the Employees HireDate (note no repeated values are allowed)

-- no such table but anyway you can do it by select distinct

--9.	 Calculate the average of the unique ListPrices in the Product table
select avg(distinct(ListPrice))
from SalesLT.Product


--10.	Display the Product Name and its ListPrice within the values of 100 and 120 the list should has the following format "The [product name] is only! [List price]" (the list will be sorted according to its ListPrice value)

select 'The ' + product.Name +' is only! '+ convert(varchar(20),ListPrice)  
from SalesLT.Product
where ListPrice between 100.0000 and 120.0000
order by ListPrice


--11.
--a)	 Transfer the rowguid ,Name, SalesPersonID, Demographics from Sales.Store table  in a newly created table named [store_Archive]
--Note: Check your database to see the new table and how many rows in it?
--الجدول ده مش موجود هنا ف هنجرب اي جدول تاني بقى
select * into SalesLT.store_Archive
from SalesLT.Customer

--b)	Try the previous query but without transferring the data? 
-- هنحط اي شرط مبيتحققش
select * into SalesLT.store_Archive2
from SalesLT.Customer
where 1=2


--12.	Using union statement, retrieve the today’s date in different styles using convert or format funtion.
select format(getdate(),'dd-MM-yyyy')
union all
select format(getdate(),'ddd-MMM-yyyy')
union all
select format(getdate(),'dddd-MMMM-yyyy')
union all
select format(getdate(),'MM-yyyy')
union all
select format(getdate(),'d-M-y')
union all

