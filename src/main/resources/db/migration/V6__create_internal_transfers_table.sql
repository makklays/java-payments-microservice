-- V6__create_internal_transfers_table.sql
-- Migration #6: create table internal_transfers

-- Creating table 'internal_transfers' for saving main data of internal_transfers
CREATE TABLE internal_transfers (
    id                  BIGSERIAL PRIMARY KEY,
    payment_id          BIGINT NOT NULL,        -- Foreign key на платеж
    from_account_id     BIGINT NOT NULL,        -- Отправитель
    to_account_id       BIGINT NOT NULL         -- Получатель
);

-- Setting up foreign key constraints
CREATE INDEX idx_internal_transfers_payment_id ON internal_transfers(payment_id);
CREATE INDEX idx_internal_transfers_from_account ON internal_transfers(from_account_id);
CREATE INDEX idx_internal_transfers_to_account ON internal_transfers(to_account_id);

