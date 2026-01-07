-- V3__create_payment_events_table.sql
-- Migration #3: create table payment_events

-- Creating table 'payment_events' for saving main data of payment_events
CREATE TABLE IF NOT EXISTS payment_events (
    id              BIGSERIAL PRIMARY KEY,
    payment_id      BIGINT NOT NULL,
    event_type      VARCHAR(50) NOT NULL,              -- PaymentMethodType (CREATED, UPDATED, FAILED, etc.)
    details         TEXT,                              -- Дополнительная информация, JSON или plain text
    created_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Setting up indexes for faster queries
CREATE INDEX idx_payment_events_payment_id ON payment_events(payment_id);
CREATE INDEX idx_payment_events_event_type ON payment_events(event_type);

