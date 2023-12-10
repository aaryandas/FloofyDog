create database CarDealershipDatabase;

create table Dealerships(
	dealership_id int primary key auto_increment,
    name varchar(50),
    address varchar(50),
    phone varchar(12)
);

create table Vehicles(
	VIN varchar(50) primary key,
    yearMade int, 
    make varchar(100),
    model varchar(100),
    color varchar(50),
    vehicleType varchar(50),
    odometer int,
    price float,
    sold bit
);
    
create table Inventory(
	dealership_id int,
    VIN varchar(50),
    foreign key (dealership_id) references Dealerships(dealership_id),
    foreign key (VIN) references Vehicles(VIN)
);

create table Sales_Contracts(
	contractId int primary key auto_increment,
    dealership_id int,
	customerDate date,
    customerName varchar(100),
    customerEmail varchar(100),
    VIN varchar(50),
    totalPrice float,
    monthlyPayment float,
	salesTaxAmount float,
    recordingFee float,
    processingFee float,
    totalAmount float,
    isFinance bit,
    interestRate float,
    foreign key (VIN) references Vehicles(VIN),
    foreign key (dealership_id) references Dealerships(dealership_id)
);

create table Lease_Contracts(
	contractId int primary key auto_increment,
    dealership_id int,
	customerDate date,
    customerName varchar(100),
    customerEmail varchar(100),
    VIN varchar(50),
    totalPrice float,
    monthlyPayment float,
    leaseFee float,
	foreign key (VIN) references Vehicles(VIN),
    foreign key (dealership_id) references Dealerships(dealership_id)
);
