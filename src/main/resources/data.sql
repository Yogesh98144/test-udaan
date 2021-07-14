CREATE TABLE IF NOT EXISTS pid(
	user_id INT,
	name varchar(16),
	mobile_number varchar(16),
	pin_code varchar(16),
	primary key (user_id)
);

CREATE TABLE IF NOT EXISTS health_workers(
	worker_id INT,
	name varchar(16),
	mobile_number varchar(16),
	pin_code varchar(16),
	primary key (worker_id)
);

CREATE TABLE IF NOT EXISTS covid_results(
	result_id INT,
	worker_id INT,
	user_id INT,
	is_positive boolean,
	primary key (result_id)
);