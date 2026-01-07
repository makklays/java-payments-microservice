-- V4__create_payment_methods_table.sql
-- Migration #4: create table payment_methods

-- Creating table 'payment_methods' for saving main data of payment_methods
CREATE TABLE IF NOT EXISTS payment_methods (
    id              BIGSERIAL PRIMARY KEY,
    payment_id      BIGINT NOT NULL,          -- Foreign key на платеж
    method_type     VARCHAR(50) NOT NULL,     -- Тип метода (CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER, etc.)
    reference_id    VARCHAR(255)              -- Внешний идентификатор метода
);

-- Setting up foreign key constraint
CREATE INDEX idx_payment_methods_payment_id ON payment_methods(payment_id);
CREATE INDEX idx_payment_methods_method_type ON payment_methods(method_type);

