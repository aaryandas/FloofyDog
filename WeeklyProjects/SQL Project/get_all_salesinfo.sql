#6 Get all sales information for a specific dealer for a specific date range 
select * 
from sales_contracts
join dealerships on sales_contracts.dealership_id = dealerships.dealership_id
where dealerships.dealership_id = 1 and sales_contracts.customerDate between '2023-01-01' and '2023-12-31';