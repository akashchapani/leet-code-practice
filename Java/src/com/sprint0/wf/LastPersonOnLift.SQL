# Write your MySQL query statement below
SELECT q2.person_name
FROM Queue q1, Queue q2
WHERE q1.turn <= q2.turn
GROUP BY q2.turn
HAVING SUM(q1.weight) <= 1000
ORDER BY q2.turn DESC
LIMIT 1