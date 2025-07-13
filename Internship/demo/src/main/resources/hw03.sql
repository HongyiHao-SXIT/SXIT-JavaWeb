SELECT *
FROM tb_emp
WHERE name = '杨逍';

SELECT *
FROM tb_emp
WHERE id <= 5;

SELECT *
FROM tb_emp
WHERE job IS NULL;

SELECT *
FROM tb_emp
WHERE job IS NOT NULL;

SELECT *
FROM tb_emp
WHERE password != '123456';

SELECT *
FROM tb_emp
WHERE entrydate BETWEEN '2000-01-01' AND '2010-01-01';

SELECT *
FROM tb_emp
WHERE entrydate BETWEEN '2000-01-01' AND '2010-01-01'
  AND gender = 2;

SELECT *
FROM tb_emp
WHERE job IN (2, 3, 4);

SELECT *
FROM tb_emp
WHERE CHAR_LENGTH(name) = 2;

SELECT *
FROM tb_emp
WHERE name LIKE '张%';
