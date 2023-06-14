--실습13
select *
FROM countries;
select *
FROM regions;

select r.region_id, r.region_name, c.country_name 
from countries c, regions r
where c.region_id = r.region_id
AND r.region_id IN (1) 
;

--실습14
select *
FROM countries;
select *
FROM regions;
select *
FROM locations;

select c.region_id, r.region_name, c.country_name, l.city
FROM countries c, regions r, locations l
where c.region_id = r.region_id
AND	c.country_id = l.country_id
and c.region_id IN (1)
;

--실습15
select * FROM countries;
select * FROM regions;
select * FROM locations;
SELECT * FROM departments;

select c.region_id ,r.region_name ,c.country_name ,l.city ,d.department_name 
FROM countries c ,regions r ,locations l ,departments d 
where c.country_id = l.country_id 
AND c.region_id = r.region_id
AND l.location_id = d.location_id
AND c.region_id = 1
;

--실습16
select * FROM countries;
select * FROM regions;
select * FROM locations;
SELECT * FROM departments;
select * FROM employees;

select r.region_id ,r.region_name ,c.country_name ,l.city ,d.department_name ,e.first_name || e.last_name NAME 
FROM countries c ,regions r ,locations l ,departments d ,employees e 
where c.region_id = r.region_id 
and c.country_id = l.country_id 
and l.location_id = d.location_id 
and d.department_id = e.department_id 
AND region_name = 'Europe'
;

--실습17
select * FROM jobs;
select * from employees;

select e.employee_id ,concat(e.first_name, e.last_name) NAME,j.job_id ,j.job_title 
from jobs j ,employees e 
where j.job_id = e.job_id 
;

--실습18
select * FROM jobs;
select * from employees;

select m.employee_id mgr_id, concat(m.first_name, m.last_name) mgr_name, e.employee_id ,concat(e.first_name,e.last_name),j.job_id ,j.job_title  
from jobs j ,employees e ,employees m
where e.job_id = j.job_id
AND m.employee_id = e.manager_id 
;

