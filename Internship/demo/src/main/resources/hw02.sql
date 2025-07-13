SELECT name, entrydate
FROM tb_emp;

SELECT *
FROM tb_emp;

SELECT name AS '姓名', entrydate AS '入职日期'
FROM tb_emp;

SELECT DISTINCT job
FROM tb_emp
WHERE job IS NOT NULL;

SELECT DISTINCT 
    job,
    CASE job
        WHEN 1 THEN '班主任'
        WHEN 2 THEN '讲师'
        WHEN 3 THEN '学工主管'
        WHEN 4 THEN '教研主管'
    END AS job_name
FROM tb_emp
WHERE job IS NOT NULL;
