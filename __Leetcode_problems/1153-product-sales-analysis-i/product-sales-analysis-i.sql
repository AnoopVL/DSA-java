# Write your MySQL query statement below
Select P.product_name, S.year , S.price From Sales S
LEFT JOIN Product P ON S.product_id = P.product_id