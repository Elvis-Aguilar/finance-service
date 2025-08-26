CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA finance;

CREATE TABLE finance.bill (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    reservation_id UUID,
    order_id UUID,
    amount NUMERIC(10,2) NOT NULL,
    payment_method varchar(20) NOT NULL default 'TARJETA',
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE finance.payment_employee (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    employee_id UUID,
    amount NUMERIC(10,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);
