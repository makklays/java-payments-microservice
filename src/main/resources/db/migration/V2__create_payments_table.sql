-- V2__create_payments_table.sql
-- Migration #2: create table payments

-- Creating table 'payments' for saving main data of payments
CREATE TABLE IF NOT EXISTS payments (
    id              BIGSERIAL PRIMARY KEY,
    external_id     VARCHAR(255) UNIQUE,
    user_id         BIGINT NOT NULL,
    type            VARCHAR(20) NOT NULL,        -- PaymentType (например, CREDIT, DEBIT)
    status          VARCHAR(20) NOT NULL,        -- PaymentStatus (например, PENDING, COMPLETED)
    amount          NUMERIC(20,2) NOT NULL,
    currency_code   CHAR(3) NOT NULL,            -- USD, EUR, etc.
    exchange_rate   NUMERIC(20,6) DEFAULT 1.0,   -- Курс обмена
    fee_amount      NUMERIC(20,2) DEFAULT 0,
    total_amount    NUMERIC(20,2) NOT NULL,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    executed_at     TIMESTAMP
);

-- Creating indexes for optimizing queries
CREATE INDEX idx_payments_user_id ON payments(user_id);
CREATE INDEX idx_payments_status ON payments(status);
CREATE INDEX idx_payments_type ON payments(type);

