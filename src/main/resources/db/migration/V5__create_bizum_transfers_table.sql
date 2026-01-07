-- V5__create_bizum_transfers_table.sql
-- Migration #5: create table bizum_transfers

-- Creating table 'bizum_transfers' for saving main data of bizum_transfers
CREATE TABLE IF NOT EXISTS bizum_transfers (
    id              BIGSERIAL PRIMARY KEY,
    payment_id      BIGINT NOT NULL,            -- Foreign key на платеж
    sender_phone    VARCHAR(20) NOT NULL,       -- Телефон отправителя
    receiver_phone  VARCHAR(20) NOT NULL,       -- Телефон получателя
    concept         TEXT                        -- Назначение перевода
);

-- Search indexes for optimization
CREATE INDEX idx_bizum_transfers_payment_id ON bizum_transfers(payment_id);
CREATE INDEX idx_bizum_transfers_sender_phone ON bizum_transfers(sender_phone);
CREATE INDEX idx_bizum_transfers_receiver_phone ON bizum_transfers(receiver_phone);

