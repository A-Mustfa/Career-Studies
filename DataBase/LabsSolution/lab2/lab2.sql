
--1
select * from Employee

--2
select fname, lname, Address, Dno
from employee

--3
select pname, plocation, Dnum
from project

--4
select fname + ' ' + lname , (salary*12) * 0.10 as [annual commision]
from employee

--5
select *
from employee
where salary > 1000

--6
select *
from employee
where (salary*12) * 0.10 > 10000


--7
select *
from Employee
where sex = 'f'


---8
select *
from departments
where mgrssn = 968574

--9
select *
from project
where Dnum = 10