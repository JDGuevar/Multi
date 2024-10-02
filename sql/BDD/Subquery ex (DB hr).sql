USE hr;

-- 1. Write a query to find the names (first_name, last_name) and salaries of the employees who have higher salary than the employee whose last_name is 'Bull'.
select first_name, last_name, salary from employees where salary > (select salary from employees where last_name = 'Bull');

-- 2. Find the names (first_name, last_name) of all employees who work in the IT department.
select first_name, last_name from employees where department_id like (select department_id from departments where department_name like 'IT');

-- 3. Find the names (first_name, last_name) of the employees who are managers and the name of the department.
select first_name, last_name, (select department_name from departments where manager_id = employee_id) from employees where employee_id in (select distinct(manager_id) from employees);

-- 4. Find the names (first_name, last_name) and salary of the employees whose salary is greater than the average salary.
select first_name, last_name, salary from employees where salary > (select avg(salary) from employees);

-- 5. Find the names (first_name, last_name) and salary of the employees who earn more than the average salary and who works in any of the IT departments.
select first_name, last_name, salary from employees where salary > (select avg(salary) from employees) and department_id in (select department_id from departments where department_name like 'IT%');

select first_name, last_name, salary from employees where salary > (select avg(salary) from employees where department_id in (select department_id from departments where department_name like 'IT%'));

-- 6. Find the names (first_name, last_name) and salary of the employees who earn more than Mr. Bell. 
select first_name, last_name, salary from employees where salary > (select salary from employees where last_name = 'Bell');

-- 7. Find the names (first_name, last_name) and salary of the employees who earn the same salary as the minimum salary for all employees.
select first_name, last_name, salary from employees where salary = (select min(salary) from employees);

-- 8. Find the names (first_name, last_name)and salary of the employees whose salary is greater than average salary of all department.


-- 9. Write a query to find the names (first_name, last_name) and salary of the employees who earn a salary that is higher than the salary of all the Shipping Clerk (JOB_ID = 'SH_CLERK'). Sort the results on salary from the lowest to highest, Fint two different solutions.

-- 10. Write a query to find the names (first_name, last_name) of the employees who are not managers.

-- 11. Write a query to find the 5th maximum salary in the employees table (pay attention to the repeated salaries).
 
-- 12. Write a query to find the 4th minimum salary in the employees table.

-- 13. Write a query to list department number, name for all the departments in which there are no employees in the department.

-- 14. Write a query to get 3 maximum salaries.

-- 15. Find the names (first_name, last_name) and salary of the employees whose salary is equal to the minimum salary for their job grade (pay attention to the predetermined minimum and maximum salary for every job).
SELECT e.first_name, e.last_name, e.salary
FROM employees e
JOIN (
	SELECT job_id, MIN(salary) AS min_salary
    FROM employees
    GROUP BY job_id
) mini ON e.job_id = mini.job_id AND e.salary = mini.min_salary;

-- 16. Write a query to display the employee ID, first name, last names, and department names of all employees.
SELECT e.employee_id, e.first_name, e.last_name, dep.department_name
FROM employees e
join departments dep on e.department_id = dep.department_id;

-- 17. Write a query to display the employee ID, first name, last names, salary of all employees whose salary is above average for their departments.
SELECT e.employee_id, e.first_name, e.last_name, e.salary
FROM employees e
JOIN (
	SELECT department_id, avg(salary) AS avg_salary
    FROM employees
    GROUP BY department_id
) aver ON e.department_id = aver.department_id AND e.salary = aver.avg_salary;
