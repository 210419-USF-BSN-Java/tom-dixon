--join reimbursement 
select r.*, rt."expense_type", rs."status" as "status", u.first_name as resolver_first_name, u.last_name as resolver_last_name from reimbursement r 
full join reimbursement_type rt on r.reimbursement_type_id = rt.id
full join users u on r.resolver_id = u.id
full join reimbursement_status rs on r.status_id = rs.id
where r.author_id = ?;