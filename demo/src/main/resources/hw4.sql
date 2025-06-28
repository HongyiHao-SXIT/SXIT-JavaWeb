SELECT COUNT(*) AS 员工总数
FROM tb_emp;

SELECT AVG(id) AS 平均ID
FROM tb_emp;

SELECT *
FROM tb_emp
ORDER BY entrydate ASC
LIMIT 1;

SELECT MIN(entrydate) AS 最早入职时间
FROM tb_emp;

SELECT SUM(id) AS ID总和
FROM tb_emp;

SELECT gender,
       CASE gender
           WHEN 1 THEN '男'
           WHEN 2 THEN '女'
       END AS 性别,
       COUNT(*) AS 人数
FROM tb_emp
GROUP BY gender;

SELECT job,
       COUNT(*) AS 员工数
FROM tb_emp
WHERE entrydate < '2015-01-01'
GROUP BY job
HAVING COUNT(*) >= 2;
